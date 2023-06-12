import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Entidades.*;
import Excecoes.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        System.out.print("Data de Entrada (dd/MM/yyyy): ");
        String dataEntradaStr = scanner.next();
        LocalDate dataEntrada = LocalDate.parse(dataEntradaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Data de saída (dd/MM/yyyy): ");
        String dataSaidaStr = scanner.next();
        LocalDate dataSaida = LocalDate.parse(dataSaidaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try {
            if (dataSaida.isBefore(dataEntrada)) {
                throw new ExcecaoDominio("Data de saída deve ser após a data de entrada.");
            }

            if (dataEntrada.isBefore(LocalDate.now())) {
                throw new ExcecaoDominio("A data de entrada deve ser futura.");
            }

            Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

            System.out.println("\nReserva: Quarto " + reserva.getNumeroQuarto() +
                    ", Entrada: " + reserva.getDataEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    ", Saída: " + reserva.getDataSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    ", " + reserva.getDuracaoEmDias() + " noites");

            System.out.println("\nDeseja atualizar a reserva? (S/N)");
            String opcao = scanner.next();

            if (opcao.equalsIgnoreCase("S")) {
                System.out.println("\nEntre com as novas datas para atualização da reserva");

                System.out.print("Nova Data de Entrada (dd/MM/yyyy): ");
                String novaDataEntradaStr = scanner.next();
                LocalDate novaDataEntrada = LocalDate.parse(novaDataEntradaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                System.out.print("Nova Data de saída (dd/MM/yyyy): ");
                String novaDataSaidaStr = scanner.next();
                LocalDate novaDataSaida = LocalDate.parse(novaDataSaidaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                if (novaDataSaida.isBefore(novaDataEntrada)) {
                    throw new ExcecaoDominio("Data de saída deve ser após a data de entrada.");
                }

                if (novaDataEntrada.isBefore(LocalDate.now())) {
                    throw new ExcecaoDominio("A data de entrada deve ser futura.");
                }

                reserva.atualizarReserva(novaDataEntrada, novaDataSaida);

                System.out.println("\nReserva atualizada: Quarto " + reserva.getNumeroQuarto() +
                        ", Entrada: " + reserva.getDataEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                        ", Saída: " + reserva.getDataSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                        ", " + reserva.getDuracaoEmDias() + " noites");
            }
        } catch (ExcecaoDominio e) {
            System.out.println("\nErro na Reserva: " + e.getMessage());
        }
    }
}
