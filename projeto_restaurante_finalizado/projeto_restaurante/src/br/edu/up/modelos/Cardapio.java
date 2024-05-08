package br.edu.up.modelos;

public class Cardapio implements Comparable<Cardapio> {
// utilizando a interface Comparable para ordenar a lista de pedidos
    public int id;
    public Double valor;
    public String nomePrato;

    public Cardapio(int id, String nomePrato, Double valor) {
        this.id = id;
        this.nomePrato = nomePrato;
        this.valor = valor;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Cardapio cardapio) {
        return Double.compare(this.valor, cardapio.valor);
    }

    @Override
    public String toString() {
        return "\nID:" + id +
                 " " +nomePrato  +
                "; valor = R$" + valor;
    }
}

