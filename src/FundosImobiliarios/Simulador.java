package FundosImobiliarios;

// Roda a simulação de reinvestimento mês a mês para um ou mais FundoImobiliario, cada um pelo prazo (em meses) definido no próprio fundo.

public class Simulador {

    public void simular(java.util.List<FundoImobiliario> fundos) {
        for (FundoImobiliario fundo : fundos) {
            simular(fundo);
        }
    }

    public void simular(FundoImobiliario fundo) {
        for (int mes = 1; mes <= fundo.getPrazoMeses(); mes++) {
            fundo.processarMes();

            if (mes % 12 == 0) {
                fundo.aplicarCrescimentoAnual();
            }
        }
    }
}