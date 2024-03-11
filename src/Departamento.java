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
    public void añadirReserva(int año, int mes, int dia, int hora, int minuto, int segundo,int duracion,Sala sala){
        Salas.add(sala);
        Reserva r=new Reserva(año,mes,dia,hora,minuto,segundo,duracion,sala,this.codigoD);
        sala.agregarReserva(r);
        this.codigoD=codigoD;
    }
    public String getCodigoD(){
        return codigoD;
    }

    //Listamos los Departamentos (Complementará al RF 3)
    public void mostrarDepartamento(){
        for(int i=0;i<Salas.size();i++){
            System.out.println("codigo :"+codigoD+", nombre: "+nombreD);
        }
    }


}
