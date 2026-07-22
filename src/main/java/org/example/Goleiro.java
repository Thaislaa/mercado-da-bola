package org.example;

import java.math.BigDecimal;

public class Goleiro extends Jogador {

    private int penaltisDefendidos;

    public Goleiro(String nome,
                   int idade,
                   Clube clubeAtual,
                   int reputacaoHistorica,
                   ApetiteFinanceiro apetiteFinanceiro,
                   BigDecimal preco,
                   int penaltisDefendidos) {

        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.penaltisDefendidos = penaltisDefendidos;
    }

    @Override
    public BigDecimal getValorCompra() {

        BigDecimal valor = super.getValorCompra();

        return valor.multiply(BigDecimal.valueOf(1 + (0.04 * penaltisDefendidos)));
    }
}