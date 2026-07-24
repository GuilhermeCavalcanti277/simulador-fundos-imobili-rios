package FundosImobiliarios;

// Representa um Fundo Imobiliário (FII) e todo o estado necessário para simular a compra e o reinvestimento de dividendos ao longo do tempo.
public class FundoImobiliario {

    private final String nome;
    private double precoCota;
    private double dividendoPorCota;
    private final double taxaCrescimentoAnual; // ex: 0.05 = 5% ao ano
    private final int prazoMeses;
    private final boolean aportarMensalmente;
    private final double valorAporteMensal;

    private int cotas;
    private double troco; // dinheiro acumulado que ainda não foi utilizado para comprar uma cota inteira
    private double valorTotalInvestido;

    public FundoImobiliario(String nome, double precoCota, double valorAporte,
                            double dividendoPorCota, double taxaCrescimentoAnual,
                            int prazoMeses, boolean aportarMensalmente) {
        this.nome = nome;
        this.precoCota = precoCota;
        this.dividendoPorCota = dividendoPorCota;
        this.taxaCrescimentoAnual = taxaCrescimentoAnual;
        this.prazoMeses = prazoMeses;
        this.aportarMensalmente = aportarMensalmente;
        this.valorAporteMensal = valorAporte; // repete o mesmo valor do aporte inicial todo mês
        this.valorTotalInvestido = valorAporte;

        // Compra inicial: quantas cotas inteiras o aporte compra, sobra vira troco:
        this.cotas = (int) (valorAporte / precoCota);
        this.troco = valorAporte - (this.cotas * precoCota);
    }

    // Roda um mês da simulação: recebe o dividendo do mês e, se ativado, soma também um novo aporte mensal. Com esse total acumulado no troco, compra quantas cotas inteiras derem certo.

    public void processarMes() {
        double dividendoRecebido = cotas * dividendoPorCota;
        troco += dividendoRecebido;

        if (aportarMensalmente) {
            troco += valorAporteMensal;
            valorTotalInvestido += valorAporteMensal;
        }

        while (troco >= precoCota) {
            cotas++;
            troco -= precoCota;
        }
    }

    //Aplica a taxa de crescimento anual sobre o preço da cota e o dividendo. Chamado a cada 12 meses simulados.

    public void aplicarCrescimentoAnual() {
        precoCota *= (1 + taxaCrescimentoAnual);
        dividendoPorCota *= (1 + taxaCrescimentoAnual);
    }

    public double calcularRendaMensalAtual() {
        return cotas * dividendoPorCota;
    }

    public double calcularPatrimonioAtual() {
        return (cotas * precoCota) + troco;
    }

    // Getters usados na exibição da tabela final
    public String getNome() { return nome; }
    public int getCotas() { return cotas; }
    public int getPrazoMeses() { return prazoMeses; }
    public double getValorTotalInvestido() { return valorTotalInvestido; }
    public double getPrecoCota() { return precoCota; }
    public double getDividendoPorCota() { return dividendoPorCota; }
    public boolean isAportarMensalmente() { return aportarMensalmente; }
}