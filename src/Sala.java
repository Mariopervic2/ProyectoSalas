import java.util.ArrayList;
import java.util.List;
public class Sala {
    private String codigo;
    private String nombre;

    //Cada sala tendrá un array de reservas
    private List<Reserva> reservas;

    public Sala(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.reservas = new ArrayList<>(); // Inicializamos la lista de reservas
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Sala() {
        this.reservas = new ArrayList<>();
    }

    // Método para obtener la lista de reservas de la sala
    public List<Reserva> getReservas() {
        return reservas;
    }

    // Método para agregar una reserva a la sala
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }


}
