import java.math.BigDecimal;

public class Zagueiro extends Jogador {

    public Zagueiro(String nome,
                    int idade,
                    Clube clubeAtual,
                    int reputacaoHistorica,
                    ApetiteFinanceiro apetiteFinanceiro,
                    BigDecimal preco) {

        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public BigDecimal getValorCompra() {

        BigDecimal valor = super.getValorCompra();

        if (idade > 30) {
            valor = valor.multiply(BigDecimal.valueOf(0.8));
        }

        return valor;
    }
}