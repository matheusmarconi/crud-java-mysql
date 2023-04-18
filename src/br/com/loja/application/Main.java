package br.com.loja.application;

import br.com.loja.dao.LojaDAO;
import br.com.loja.models.Produtos;

import java.util.Date;
import java.util.Scanner;

public class Main
{

    public static LojaDAO produtoDAO = new LojaDAO();

    public static Produtos produto = new Produtos();

    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args)
    {

        //create();
        read();
        //update();
        //delete();
        // The class responsible for saving a new info is the DAO Class, so, firstly, we must instantiate a new object

    }
    public static void create()
    {
        produto.setProduto(entrada.next());
        produto.setMarca(entrada.next());
        produto.setDataCadastrada(new Date());
        produtoDAO.save(produto);
        System.out.println("Produto Cadastrado com sucesso!");
    }

    public static void read()
    {
        for(Produtos p: produtoDAO.listar()){
            System.out.println("Id: "+ p.getId());
            System.out.println("Produto: "+ p.getProduto());
            System.out.println("Marca: "+ p.getMarca());
            System.out.println("Data de Cadastro: "+ p.getDataCadastrada());
        }
    }

    public static void delete()
    {
        Scanner delete_id = new Scanner(System.in);
        System.out.println("Digite o id que deseja deletar");
        produtoDAO.delete(delete_id.nextInt());
    }

    public static void update(){

        Produtos p = new Produtos();
        System.out.println("Qual o nome do produto: ");
        p.setProduto(entrada.nextLine());
        System.out.println("Qual a marca do produto: ");
        p.setMarca(entrada.nextLine());
        p.setDataCadastrada(new Date());

        // Use o read para encontrar o numero que quer atualizar
        p.setId(1);
        produtoDAO.updateProducts(p);
        System.out.println("Produto atualizado com sucesso!");
    }

}
