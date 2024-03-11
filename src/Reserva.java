import java.util.Date;

public class Reserva {
    private Sala sala;
    private Departamento departamento;
    private Date fecha;
    private int horaInicio;
    private int duracionHoras;

    //El constructor de reserva contiene una fecha,una hora de inicio(que es un número entero) y una duración(en horas enteras)
    public Reserva(Date fecha, int horaInicio, int duracionHoras) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;
    }


    public Date getFecha() {
        return fecha;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public Sala getSala() {
        return this.sala;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


}
