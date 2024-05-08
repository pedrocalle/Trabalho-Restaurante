package br.edu.up;
import br.edu.up.modelos.Cardapio;
import br.edu.up.modelos.Funcionario;
import br.edu.up.modelos.Pedido;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {


    public static ArrayList<Cardapio> listar() {
        // uma lista dos pratos dísponiveis
        ArrayList<Cardapio> cardapio = new ArrayList<Cardapio>();
        cardapio.add(new Cardapio(1, "Macarrão Alho e Óleo", 50.00));
        cardapio.add(new Cardapio(2, "Lasanha Quatro Queijos", 65.00));
        cardapio.add(new Cardapio(3, "Gnocchi Molho Fungi", 100.00));
        cardapio.add(new Cardapio(4,"Costela Assada com Batatas", 130.00));
        cardapio.add(new Cardapio(5, "Prato kid", 35.00));
        cardapio.add(new Cardapio(6, "Torta de Limão", 16.00));
        cardapio.add(new Cardapio(7, "Gelato de Nutella", 20.00));
        cardapio.add(new Cardapio(8, "Limonada Suiça 1,5L", 23.00));
        cardapio.add(new Cardapio(9, "Heineken 600mL", 18.00));
        return cardapio;
    }

    public static ArrayList<Funcionario> listarFunc() {
        // lista dos funcionarios
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios.add(new Funcionario(1, "Eloy Casagrande", "Garçom"));
        listaFuncionarios.add(new Funcionario(2, "Ozzy Osbourne", "Garçom"));
        listaFuncionarios.add(new Funcionario(3, "Rodrigo Amarante", "Garçom"));
        listaFuncionarios.add(new Funcionario(4, "Marcelo Camelo", "Garçom"));
        return listaFuncionarios;
    }

    public static void gerarTxtPedido(Pedido pedido) {
        // cria o arquivo txt do pedido
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("pedido.txt"))) {
            writer.write(pedido.toString());
            System.out.println("TXT criado");
        } catch (IOException e) {
            System.err.println("Erro");
            e.printStackTrace();
            // ajuda a visualização do erro
        }
    }
}
