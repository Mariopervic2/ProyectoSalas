import java.util.Date;
import java.util.Locale;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Reserva {
    LocalDateTime momentoReserva;
    int duracion;

    DateTimeFormatter f1= DateTimeFormatter.ofPattern("yyyy'-'MM'-'dd'-'kk:mm");
    DateTimeFormatter f2=DateTimeFormatter.ofPattern("kk:mm");

    public Reserva(int año, int mes, int dia, int hora, int minuto, int segundo,int duracion){
        LocalDateTime horaReserva=LocalDateTime.of(año,mes,dia,hora,minuto,segundo);
        this.momentoReserva=horaReserva;
        this.duracion=duracion;

    }
    public void mostrarReserva(){
        System.out.println(momentoReserva.format(f1)+">"+(momentoReserva.plusHours(duracion)).format(f2));
    }

}
