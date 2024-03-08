import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        Sala s=new Sala("Sala de Juntas","SAJ");
        Reserva r1=new Reserva(2023,3,7,11,39,0,3,s);
        Reserva r2=new Reserva(2023,4,1,11,39,0,3,s);
        Reserva r3=new Reserva(2023,7,2,11,39,0,3,s);

        s.mostrarReservas();
        s.anularReserva(r2);
        System.out.println();
        s.mostrarReservas();
    }
}
