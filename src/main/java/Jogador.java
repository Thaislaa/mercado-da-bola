import java.math.BigDecimal;

public abstract class Jogador {

    protected String nome;
    protected int idade;
    protected Clube clubeAtual;
    protected int reputacaoHistorica;
    protected ApetiteFinanceiro apetiteFinanceiro;
    protected BigDecimal preco;

    protected Jogador(String nome,
                   int idade,
                   Clube clubeAtual,
                   int reputacaoHistorica,
                   ApetiteFinanceiro apetiteFinanceiro,
                   BigDecimal preco) {

        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        this.reputacaoHistorica = reputacaoHistorica;
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public String getNomeClubeAtual() {
        if (clubeAtual == null) {
            return "Sem Clube";
        }
        return clubeAtual.getNome();
    }

    public boolean temInteresseEm(Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }

    public BigDecimal getValorCompra() {
        return preco.multiply(
                BigDecimal.valueOf(1 + apetiteFinanceiro.getPercentual())
        );
    }

    public void transferir(Clube clube) {
        this.clubeAtual = clube;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }
}