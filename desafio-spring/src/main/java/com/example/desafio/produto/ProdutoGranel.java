package com.example.desafio.produto;

public class ProdutoGranel extends Produto{

    Integer peso;
    Integer precoPorquilograma;

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getPrecoPorquilograma() {
        return precoPorquilograma;
    }

    public void setPrecoPorquilograma(Integer precoPorquilograma) {
        this.precoPorquilograma = precoPorquilograma;
    }
}
