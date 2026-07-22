package org.example;

import java.math.BigDecimal;

public class Lateral extends Jogador {

    private int cruzamentosCerteiros;

    public Lateral(String nome,
                   int idade,
                   Clube clubeAtual,
                   int reputacaoHistorica,
                   ApetiteFinanceiro apetiteFinanceiro,
                   BigDecimal preco,
                   int cruzamentosCerteiros) {

        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.cruzamentosCerteiros = cruzamentosCerteiros;
    }

    @Override
    public BigDecimal getValorCompra() {

        BigDecimal valor = super.getValorCompra();

        valor = valor.multiply(
                BigDecimal.valueOf(1 + (0.02 * cruzamentosCerteiros))
        );

        if (idade > 28) {
            valor = valor.multiply(BigDecimal.valueOf(0.7));
        }

        return valor;
    }
}