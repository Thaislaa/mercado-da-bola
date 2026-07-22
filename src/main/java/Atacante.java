import java.math.BigDecimal;

public class Atacante extends Jogador {

    private int gols;

    public Atacante(String nome,
                    int idade,
                    Clube clubeAtual,
                    int reputacaoHistorica,
                    ApetiteFinanceiro apetiteFinanceiro,
                    BigDecimal preco,
                    int gols) {

        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.gols = gols;
    }

    @Override
    public boolean temInteresseEm(Clube clube) {
        return clube.getReputacaoHistorica() > reputacaoHistorica;
    }

    @Override
    public BigDecimal getValorCompra() {

        BigDecimal valor = super.getValorCompra();

        valor = valor.multiply(
                BigDecimal.valueOf(1 + (0.01 * gols))
        );

        if (idade > 30) {
            valor = valor.multiply(BigDecimal.valueOf(0.75));
        }

        return valor;
    }
}