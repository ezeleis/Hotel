import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
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

    }
}