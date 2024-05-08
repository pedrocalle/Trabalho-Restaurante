package br.edu.up.modelos;

import java.text.DecimalFormat;

public class Funcionario {
    // criando um id, nome e função para funcionario
    private int id;
    private String nome;
    private String funcao;
    private DecimalFormat f = new DecimalFormat("##.00");

    public Funcionario(int id, String nome, String funcao) {
        // construtores de funcionario
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "\nID:" + id +
                 "\nNome: " +nome  +
                "\nFunção: " + funcao;
    }
}