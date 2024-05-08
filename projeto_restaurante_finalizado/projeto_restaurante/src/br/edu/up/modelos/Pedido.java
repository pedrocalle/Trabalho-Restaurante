package br.edu.up.modelos;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import br.edu.up.FileManager;

public class Pedido {
    public ArrayList<Cardapio> cardapio = new ArrayList<Cardapio>();
    public Funcionario funcionario;
    public Cliente cliente;
    public String precoTotal;
    static Scanner scanner = new Scanner(System.in);
    private DecimalFormat f = new DecimalFormat("##.00");
    // limitar as casas decimais para 2


    public void calcPreco() {
        // metodo que realiza a soma do pedido final + 10% da comissão
        double soma = 0;
        for(int i = 0; i < this.cardapio.size(); i++) {
            Cardapio prato = this.cardapio.get(i);
            soma = soma + prato.valor;
        }

        double valorTotal = soma * 1.10;
        this.precoTotal = f.format(valorTotal);
    }

    public void adicionarPrato() {
        // metodo para adicionar um prato no pedido
        int opt = scanner.nextInt();
        ArrayList<Cardapio> menu = FileManager.listar();

        do {
            System.out.println(menu);
            System.out.println("Digite o ID do prato desejado");
            System.out.println("Para finalizar digite 0");
            this.cardapio.add(menu.get(opt - 1));
            opt = scanner.nextInt();
        }
        while(opt != 0);
    }
    
    public void adicionarFunc() {
        // adiciona um funcionario para atender o pedido
        int opt = scanner.nextInt();
        ArrayList<Funcionario> listFunc = FileManager.listarFunc();

        switch(opt) {
            case 1:
                // (opt - 1) para que possa subtrair do ID e acessar o index corretamente
                this.funcionario = listFunc.get(opt - 1);
                break;
            case 2:
                this.funcionario = listFunc.get(opt - 1);
                break;
            case 3:
                this.funcionario = listFunc.get(opt - 1);
                break;
            case 4:
                this.funcionario = listFunc.get(opt - 1);
                break;
            default:
                System.out.println("Opção não existente");
                break;
        }
    }

    public void removerItem() {
        // metodo para remover algum item do pedido
        System.out.println(this.cardapio);
        System.out.println("Digite o ID do prato desejado");
        int tamanhoInicial = this.cardapio.size();
        int opt = scanner.nextInt();
        for (int i = 0; i < this.cardapio.size(); i++) {
            if (opt == this.cardapio.get(i).id) {
                this.cardapio.remove(i);
                System.out.println("Item removido");
            }
        }

        if (this.cardapio.size() == tamanhoInicial) {
            System.out.println("Item com esse ID não consta no pedido");
        }

        this.calcPreco();
    }

    @Override
    public String toString() {
        return "\nCliente: " + cliente +
                "\nPratos pedidos:" + cardapio +
                 "\nFuncionario: " +funcionario  +
                "\nPreço total: " + precoTotal;
    }
}