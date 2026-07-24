package FundosImobiliarios;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Locale.setDefault(Locale.US); // evita problema de vírgula/ponto ao ler double

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        EntradaSaida entradaSaida = new EntradaSaida(scanner);
        Simulador simulador = new Simulador();

        List<FundoImobiliario> fundos = entradaSaida.lerFundos();
        simulador.simular(fundos);
        entradaSaida.imprimirTabelaFinal(fundos);

        scanner.close();
    }
}