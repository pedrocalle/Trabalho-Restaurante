package br.edu.up.modelos;

public class Cliente {
    public String nome;
    public int quantPessoas;

    public String cliente() {
        

        return null;
    }

    @Override
    public String toString() {
        return "\nNome:" + nome +
                "\nQuantidade de pessoas na mesa: " + quantPessoas;
    }

}
