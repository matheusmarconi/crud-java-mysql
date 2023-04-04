package br.com.loja.application;

import br.com.loja.dao.LojaDAO;
import br.com.loja.models.Produtos;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static LojaDAO produtoDAO = new LojaDAO();

    public static Produtos produto = new Produtos();

    public static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {

        cadastro();
        retorno();
        // The class responsible for saving a new info is the DAO Class, so, firstly, we must instantiate a new object

    }
    public static void cadastro(){

        produto.setProduto(entrada.next());
        produto.setMarca(entrada.next());
        produto.setDataCadastrada(new Date());
        produtoDAO.save(produto);
        System.out.println("Produto Cadastrado com sucesso!");
    }

    public static void retorno(){
        for(Produtos p: produtoDAO.listar()){
            System.out.println("Id: "+ p.getId());
            System.out.println("Produto: "+ p.getProduto());
            System.out.println("Marca: "+ p.getMarca());
            System.out.println("Data de Cadastro: "+ p.getDataCadastrada());
        }
    }
}
