import java.util.ArrayList;

public class Departamento {
    ArrayList <Sala> Salas=new ArrayList<>();
    public String tipoMenu="Departamento";
    public String codigoD;
    public String nombreD;

    public Departamento(String nombreD,String codigoD){
        this.nombreD=nombreD;
        this.codigoD=codigoD;
    }
    public void añadirReserva(int año, int mes, int dia, int hora, int minuto, int segundo,int duracion,Sala sala,String codigoD){
        Salas.add(sala);
        Reserva r=new Reserva(año,mes,dia,hora,minuto,segundo,duracion,sala);
        sala.agregarReserva(r);
        this.codigoD=codigoD;
    }
    public String getCodigoD(){
        return codigoD;
    }


}
