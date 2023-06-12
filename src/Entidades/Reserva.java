import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
class Reserva {
    private int numeroQuarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva(int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public void atualizarReserva(LocalDate novaDataEntrada, LocalDate novaDataSaida) throws ExcecaoDominio {
        if (novaDataEntrada.isBefore(LocalDate.now())) {
            throw new ExcecaoDominio("Datas da Reserva devem ser atualizadas para datas futuras");
        }
        if (novaDataSaida.isBefore(novaDataEntrada)) {
            throw new ExcecaoDominio("Data de Saída deve ser após a Data de Entrada");
        }

        this.dataEntrada = novaDataEntrada;
        this.dataSaida = novaDataSaida;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public long getDuracaoEmDias() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }

    @Override
    public String toString() {
        return "Reserva: Quarto " + numeroQuarto + ", Entrada: " + dataEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", Saída: " + dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", " +
                getDuracaoEmDias() + " noites";
    }
}