import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class ClubeTest {

    @Test
    void deveCriarClubeCorretamente() {

        Clube clube = new Clube(
                "Grêmio",
                10,
                BigDecimal.valueOf(1000000)
        );

        assertEquals("Grêmio", clube.getNome());
        assertEquals(10, clube.getReputacaoHistorica());
    }

    @Test
    void deveRetornarSemClubeQuandoJogadorNaoPossuirClube() {

        Goleiro goleiro = new Goleiro(
                "Grohe",
                33,
                null,
                8,
                new Indiferente(),
                BigDecimal.valueOf(1000),
                10
        );

        assertEquals("Sem Clube", goleiro.getNomeClubeAtual());
    }

    @Test
    void deveRetornarNomeDoClubeAtual() {

        Clube gremio = new Clube(
                "Grêmio",
                10,
                BigDecimal.valueOf(1000)
        );

        Goleiro goleiro = new Goleiro(
                "Grohe",
                33,
                gremio,
                8,
                new Indiferente(),
                BigDecimal.valueOf(1000),
                10
        );

        assertEquals("Grêmio", goleiro.getNomeClubeAtual());
    }

    @Test
    void deveCalcularValorDeCompraIndiferente() {

        Goleiro goleiro = new Goleiro(
                "Grohe",
                30,
                null,
                8,
                new Indiferente(),
                BigDecimal.valueOf(1000),
                0
        );

        assertEquals(
                0,
                BigDecimal.valueOf(1000)
                        .compareTo(goleiro.getValorCompra())
        );
    }

    @Test
    void deveCalcularValorDeCompraConservador() {

        Zagueiro zagueiro = new Zagueiro(
                "Pedro",
                25,
                null,
                5,
                new Conservador(),
                BigDecimal.valueOf(1000)
        );

        assertEquals(
                0,
                BigDecimal.valueOf(1400)
                        .compareTo(zagueiro.getValorCompra())
        );
    }

    @Test
    void deveCalcularBonusPorPenaltisDefendidos() {

        Goleiro goleiro = new Goleiro(
                "Grohe",
                30,
                null,
                8,
                new Indiferente(),
                BigDecimal.valueOf(1000),
                5
        );

        assertEquals(
                0,
                BigDecimal.valueOf(1200)
                        .compareTo(goleiro.getValorCompra())
        );
    }

    @Test
    void deveAplicarDescontoParaZagueiroComMaisDeTrintaAnos() {

        Zagueiro zagueiro = new Zagueiro(
                "Pedro",
                31,
                null,
                5,
                new Indiferente(),
                BigDecimal.valueOf(1000)
        );

        assertEquals(
                0,
                BigDecimal.valueOf(800)
                        .compareTo(zagueiro.getValorCompra())
        );
    }

    @Test
    void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {

        MeioCampo meioCampo = new MeioCampo(
                "Arthur",
                25,
                null,
                8,
                new Indiferente(),
                BigDecimal.valueOf(1000)
        );

        assertEquals(
                0,
                BigDecimal.valueOf(1000)
                        .compareTo(meioCampo.getValorCompra())
        );
    }

    @Test
    void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {

        MeioCampo meioCampo = new MeioCampo(
                "Arthur",
                31,
                null,
                8,
                new Indiferente(),
                BigDecimal.valueOf(1000)
        );

        assertEquals(
                0,
                BigDecimal.valueOf(700)
                        .compareTo(meioCampo.getValorCompra())
        );
    }
    @Test
    void deveCalcularCorretamentePrecoDoLateral() {

        Lateral lateral = new Lateral(
                "Fagner",
                27,
                null,
                7,
                new Indiferente(),
                BigDecimal.valueOf(1000),
                10
        );

        assertEquals(
                0,
                BigDecimal.valueOf(1200)
                        .compareTo(lateral.getValorCompra())
        );
    }

    @Test
    void deveAplicarDescontoNoAtacanteComMaisDeTrintaAnos() {

        Atacante atacante = new Atacante(
                "Cristiano",
                35,
                null,
                10,
                new Indiferente(),
                BigDecimal.valueOf(1000),
                20
        );

        assertEquals(
                0,
                BigDecimal.valueOf(900)
                        .compareTo(atacante.getValorCompra())
        );
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {

        Negociacao negociacao = new Negociacao();

        Clube clube = new Clube(
                "Grêmio",
                10,
                BigDecimal.valueOf(1000)
        );

        Goleiro goleiro = new Goleiro(
                "Marcelo Grohe",
                33,
                null,
                8,
                new Indiferente(),
                BigDecimal.valueOf(800500),
                12
        );

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        Negociacao negociacao = new Negociacao();

        Clube clube = new Clube(
                "Internacional",
                3,
                BigDecimal.valueOf(100000000)
        );

        Atacante atacante = new Atacante(
                "Cristiano Ronaldo",
                35,
                null,
                10,
                new Conservador(),
                BigDecimal.valueOf(800500),
                20
        );

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        Negociacao negociacao = new Negociacao();

        Clube clube = new Clube(
                "Grêmio",
                10,
                BigDecimal.valueOf(100000000)
        );

        Goleiro goleiro = new Goleiro(
                "Marcelo Grohe",
                33,
                null,
                8,
                new Indiferente(),
                BigDecimal.valueOf(800500),
                12
        );

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        assertTrue(foiPossivelNegociar);
    }
}