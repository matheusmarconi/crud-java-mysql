package br.com.loja.application;

import br.com.loja.dao.LojaDAO;
import br.com.loja.models.Produtos;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // The class responsible for saving a new info is the DAO Class, so, firstly, we must instantiate a new object

        LojaDAO produtoDAO = new LojaDAO();

        Produtos produto = new Produtos();
        produto.setProduto("Desodorante");
        produto.setMarca("Nivea");
        produto.setDataCadastrada(new Date());
        produtoDAO.save(produto);
        System.out.println("Produto Cadastrado com sucesso!");
    }
}
