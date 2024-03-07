import java.util.ArrayList;
public class Salas {
    public String nombreS;
    public String codigoS;
    ArrayList <Reserva> reservas=new ArrayList<>();

    public void mostrarReservas(){
        for(int i=0;i<reservas.size();i++){
            reservas.get(i).mostrarReserva();
        }
    }
    public Salas(String nombreS,String codigoS){
        this.nombreS=nombreS;
        this.codigoS=codigoS;
    }
}
