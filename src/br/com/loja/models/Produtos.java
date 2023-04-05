package br.com.loja.models;

import java.util.Date;

public class Produtos
{
    private int id;
    private String produto;
    private String marca;
    private Date dataCadastrada;

    // Inserindo getters and setters
    // Intellij Alt + Insert -> getters and setters
    // Select all options, it's done.

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProduto()
    {
        return produto;
    }

    public void setProduto(String produto)
    {
        this.produto = produto;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public Date getDataCadastrada()
    {
        return dataCadastrada;
    }

    public void setDataCadastrada(Date dataCadastrada)
    {
        this.dataCadastrada = dataCadastrada;
    }

}
