import java.util.ArrayList;
public class Sala{
    public String nombreS;
    public String codigoS;
    ArrayList <Reserva> reservas=new ArrayList<>();

    public void mostrarReservas(){
        for(int i=0;i<reservas.size();i++){
            reservas.get(i).mostrarReserva();
        }
    }

    public String getCodigoS(){
        return codigoS;
    }

    public String getNombreS() {
        return nombreS;
    }

    //Añadimos la sala (RF 7)
    public Sala(String nombreS,String codigoS){
        this.nombreS=nombreS;
        this.codigoS=codigoS;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void anularReserva(Reserva reserva){
        reservas.remove(reserva);
    }


}
