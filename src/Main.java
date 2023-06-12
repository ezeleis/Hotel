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
            Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);

            System.out.println("\nReserva: Quarto " + reserva.getNumeroQuarto() +
                    ", Entrada: " + reserva.getDataEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    ", Saída: " + reserva.getDataSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    ", " + reserva.getDuracaoEmDias() + " noites");

            System.out.println("\nEntre com as datas para atualização da reserva");

            System.out.print("Nova Data de Entrada (dd/MM/yyyy): ");
            String novaDataEntradaStr = scanner.next();
            LocalDate novaDataEntrada = LocalDate.parse(novaDataEntradaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Nova Data de saída (dd/MM/yyyy): ");
            String novaDataSaidaStr = scanner.next();
            LocalDate novaDataSaida = LocalDate.parse(novaDataSaidaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            reserva.atualizarReserva(novaDataEntrada, novaDataSaida);

            System.out.println("\nReserva atualizada: Quarto " + reserva.getNumeroQuarto() +
                    ", Entrada: " + reserva.getDataEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    ", Saída: " + reserva.getDataSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    ", " + reserva.getDuracaoEmDias() + " noites");
        } catch (ExcecaoDominio e) {
            System.out.println("\nErro na Reserva: " + e.getMessage());
        }
    }
}