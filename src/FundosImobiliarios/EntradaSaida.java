package FundosImobiliarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Cuida de toda a entrada (leitura dos fundos via console) e saída (impressão da tabela final de resultados).

public class EntradaSaida {

    private final Scanner scanner;

    public EntradaSaida(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<FundoImobiliario> lerFundos() {
        System.out.print("Quantos fundos imobiliários você quer simular? ");
        int quantidadeFundos = Integer.parseInt(scanner.nextLine().trim());

        List<FundoImobiliario> fundos = new ArrayList<>();

        for (int i = 1; i <= quantidadeFundos; i++) {
            System.out.println("\n--- Fundo " + i + " ---");

            System.out.print("Nome do fundo (ex: MXRF11): ");
            String nome = scanner.nextLine().trim();

            System.out.print("Preço da cota (R$): ");
            double precoCota = lerDouble(scanner.nextLine());

            System.out.print("Quanto pretende investir nesse fundo (R$): ");
            double valorAporte = lerDouble(scanner.nextLine());

            int cotasIniciais = (int) (valorAporte / precoCota);
            double trocoInicial = valorAporte - (cotasIniciais * precoCota);
            System.out.printf("=> Isso compra %d cotas (troco de R$ %.2f)%n", cotasIniciais, trocoInicial);

            System.out.print("Quer continuar investindo esse mesmo valor todo mês? (S/N): ");
            boolean aportarMensalmente = scanner.nextLine().trim().equalsIgnoreCase("S");

            System.out.print("Dividendo pago por cota, ao mês (R$): ");
            double dividendoPorCota = lerDouble(scanner.nextLine());

            System.out.print("Taxa de crescimento anual do preço/dividendo, em %% (0 se não quiser): ");
            double taxaCrescimentoAnual = lerDouble(scanner.nextLine()) / 100.0;

            System.out.print("Prazo da simulação em meses (ex: 24 para 2 anos): ");
            int prazoMeses = Integer.parseInt(scanner.nextLine().trim());

            fundos.add(new FundoImobiliario(
                    nome, precoCota, valorAporte, dividendoPorCota, taxaCrescimentoAnual,
                    prazoMeses, aportarMensalmente
            ));
        }

        return fundos;
    }

    public void imprimirTabelaFinal(List<FundoImobiliario> fundos) {
        System.out.println("\n=============================== RESULTADO DA SIMULAÇÃO ===============================");
        System.out.printf("%-10s %-8s %-8s %-10s %-14s %-16s %-16s%n",
                "Fundo", "Aporte", "Prazo", "Cotas", "Investido", "Renda mensal", "Patrimônio");

        for (FundoImobiliario fundo : fundos) {
            System.out.printf("%-10s %-8s %-8s %-10d R$ %-11.2f R$ %-13.2f R$ %-13.2f%n",
                    fundo.getNome(),
                    fundo.isAportarMensalmente() ? "Mensal" : "Único",
                    fundo.getPrazoMeses() + "m",
                    fundo.getCotas(),
                    fundo.getValorTotalInvestido(),
                    fundo.calcularRendaMensalAtual(),
                    fundo.calcularPatrimonioAtual());
        }
        System.out.println("========================================================================================"); // Foram necessarios 68(=)
    }

    private double lerDouble(String texto) {
        // ele pode aceitar tanto "," quanto "."
        return Double.parseDouble(texto.trim().replace(",", "."));
    }
}