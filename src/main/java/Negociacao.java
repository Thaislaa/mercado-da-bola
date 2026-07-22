import java.math.BigDecimal;

public class Negociacao {

    public boolean negociar(Clube clubeInteressado,
                            Jogador jogadorDeInteresse) {

        if (!jogadorDeInteresse.temInteresseEm(clubeInteressado)) {
            return false;
        }

        BigDecimal valorCompra = jogadorDeInteresse.getValorCompra();

        if (clubeInteressado.getSaldoDisponivelEmCaixa().compareTo(valorCompra) < 0) {
            return false;
        }

        jogadorDeInteresse.transferir(clubeInteressado);

        clubeInteressado.debitar(valorCompra);

        return true;
    }
}