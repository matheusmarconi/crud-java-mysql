package br.com.loja.dao;

import br.com.loja.factory.ConnectionFactory;
import br.com.loja.models.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;

// Java is an object oriented language but mysql isn't.
// We use DAO to adapt our language to Mysql paradigm. That's why this package is so important.

//import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;

// CREATING A CRUD -> CREATE/READ/UPDATE/DELETE
public class LojaDAO {
    public void save(Produtos produto)
    {
        String sql = "INSERT INTO produtos(produto,marca,dataCadastro) " +
                "VALUES (?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            // To create a new connection to the database
            conn = ConnectionFactory.createConnectionToMySql();

            //Creating a PreparedStatment to execute a query
            // pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            // Adding values expected by our query
            pstm.setString(1,produto.getProduto());
            pstm.setString(2, produto.getMarca());
            pstm.setDate(3, new Date(produto.getDataCadastrada().getTime()));

            // Executing ou query
            //pstm.executeQuery(); Codigo anterior que estava dando erro
            //Achei no stack para usar executeUpdate ou execute
            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
