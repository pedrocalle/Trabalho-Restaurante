package br.edu.up;

import br.edu.up.modelos.Cardapio;
import br.edu.up.modelos.Cliente;
import br.edu.up.modelos.Pedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    private ArrayList<Cardapio> cardapio;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // coletar as informações do cliente para realizar o pedido
        Cliente cl = new Cliente();
        Pedido pedido = new Pedido();
        cl.cliente();
        pedido.cliente = cl;
        System.out.println("Seja bem vindo ao Guns n Grills, vamos anotar seu pedido.");
        System.out.println("Qual é seu nome: ");
        String nome = scanner.next();
        cl.nome = nome;
        System.out.println("Mesa para quantas pessoas: ");
        int mesaPessoas = scanner.nextInt();
        cl.quantPessoas = mesaPessoas;
        System.out.println(FileManager.listarFunc());
        System.out.println("Por qual garçom deseja ser atendido: ");
        pedido.adicionarFunc();
        System.out.println(FileManager.listar());
        System.out.println("Digite o ID do prato desejado");
        System.out.println("Para finalizar digite 0");
        pedido.adicionarPrato();
        pedido.calcPreco();
        etapaFinal(pedido);

    }
    private static void pesquisar(Pedido pedido) {
        // metodo para realizar a pesquisa de algum prato
        // metodo se intera sobre o cardapio
        try {
        System.out.println("Qual item do cardápio deseja pesquisar?");

        String pesquisa = scanner.next();
        // armazema os itens correspondentes à pesquisa
        ArrayList<Cardapio> output = new ArrayList<Cardapio>();

        ArrayList<Cardapio> menu = FileManager.listar();

        for(int i = 0; i < menu.size(); i++) {
            Cardapio prato = menu.get(i);
            String pesquisaString = prato.nomePrato.toLowerCase();
            if (pesquisaString.contains(pesquisa.toLowerCase())) {
                output.add(prato);
        }
    }
        if (output.size() > 0) {
            for (int i = 0; i < output.size(); i++) {
                System.out.println(output.get(i));
            }
        } else {
            System.out.println("Não foram encotrados itens que satisfaçam sua busca");
        }
        etapaFinal(pedido);
    }
        catch(Error err) {
        System.err.println(err);
    }
    }
    private static void etapaFinal(Pedido pedido) {
        // metodo para escolher o que o usuário quer fazer
        System.out.println("[1] Gerar TXT do pedido");
        System.out.println("[2] Deseja Remover algum item?");
        System.out.println("[3] Ordenar por preço");
        System.out.println("[4] Deseja Pesquisar um item específico do cardápio?");
        System.out.println("[5] Pagar " + "- " + "R$" + pedido.precoTotal);

        int opt = scanner.nextInt();

        switch(opt) {
            case 1:
                // imprime todas as informações do pedido
                FileManager.gerarTxtPedido(pedido);
                break;
            case 2:
                // remove um item do pedido
                pedido.removerItem();
                etapaFinal(pedido);
                break;
            case 3:
                // ordena do maior valor para o menor
                Collections.sort(pedido.cardapio);
                for (int i = 0; i < pedido.cardapio.size(); i++) {
                    System.out.println("ID:" + pedido.cardapio.get(i).id + ' '+ pedido.cardapio.get(i).nomePrato +
                            "; " + "valor = " + "R$" + pedido.cardapio.get(i).valor);
                }
                etapaFinal(pedido);
            case 4:
                // realiza a pesquisa por algum item
                pesquisar(pedido);
                break;
            case 5:
                // retorna o valor final do pedido
                System.out.println("Pedido pago " +  pedido.precoTotal);
                break;
            default:
                System.out.println("Opção indisponível");
                break;
        }
    }
}
