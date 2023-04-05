package br.com.loja.dao;

import br.com.loja.factory.ConnectionFactory;
import br.com.loja.models.Produtos;

import java.sql.*;

// Java is an object oriented language but mysql isn't.
// We use DAO to adapt our language to Mysql paradigm. That's why this package is so important.


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


// CREATING A CRUD -> CREATE/READ/UPDATE/DELETE
public class LojaDAO
{
    public void save(Produtos produto)
    {
        String sql = "INSERT INTO produtos(produto,marca,dataCadastro) " +
                "VALUES (?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try
        {
            // To create a new connection to the database
            conn = ConnectionFactory.createConnectionToMySql();
            //Creating a PreparedStatment to execute a query
            // pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            // Adding values expected by our query
            pstm.setString(1, produto.getProduto());
            pstm.setString(2, produto.getMarca());
            pstm.setDate(3, new Date(produto.getDataCadastrada().getTime()));

            // Executing ou query
            //pstm.executeQuery(); Codigo anterior que estava dando erro
            //Achei no stack para usar executeUpdate ou execute
            pstm.execute();

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (pstm != null)
                {
                    pstm.close();
                }
                if (conn != null)
                {
                    conn.close();
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public List<Produtos> listar()
    {
        String sql = "SELECT * FROM produtos";
        List<Produtos> produtos = new ArrayList<>();
        Connection conn = null;

        PreparedStatement pstm = null;
        ResultSet rset = null;

        try
        {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next())
            {
                Produtos produto = new Produtos();

                //Pegando o id
                produto.setId(rset.getInt("Id"));

                produto.setProduto(rset.getString("produto"));

                produto.setMarca(rset.getString("marca"));

                produto.setDataCadastrada(rset.getDate("dataCadastro"));

                produtos.add(produto);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (rset != null)
                {
                    rset.close();
                }
                if (pstm != null)
                {
                    pstm.close();
                }
                if (rset != null)
                {
                    rset.close();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return produtos;
    }

    public void delete(int ID)
    {

        String sql = "DELETE FROM produtos WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try
        {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID);
            pstm.execute();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (conn!=null)
                {
                    conn.close();
                }
                if (pstm!=null)
                {
                    pstm.close();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

