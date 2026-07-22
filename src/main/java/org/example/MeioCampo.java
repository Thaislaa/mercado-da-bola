package org.example;

import java.math.BigDecimal;

public class MeioCampo extends Jogador {

    public MeioCampo(String nome,
                     int idade,
                     Clube clubeAtual,
                     int reputacaoHistorica,
                     ApetiteFinanceiro apetiteFinanceiro,
                     BigDecimal preco) {

        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public boolean temInteresseEm(Clube clube) {

        return clube.getReputacaoHistorica()
                <= (reputacaoHistorica - 2);
    }

    @Override
    public BigDecimal getValorCompra() {

        BigDecimal valor = super.getValorCompra();

        if (idade > 30) {
            valor = valor.multiply(BigDecimal.valueOf(0.7));
        }

        return valor;
    }
}