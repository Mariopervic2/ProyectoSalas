public void añadirSala(String nombreS, String codigoS) {
        Sala s = new Sala(nombreS, codigoS);
        salas.add(s);
        }

public void eliminarSala(String codigoS) {
        try {
        boolean salaEncontrada = false;
        for (int i = 0; i < salas.size(); i++) {
        if (salas.get(i).getCodigoS().equals(codigoS)) {
        salas.remove(salas.get(i));
        salaEncontrada = true;
        break; // Terminamos el bucle ya que la sala ha sido eliminada
        }
        }
        if (!salaEncontrada) {
        throw new IllegalArgumentException("No existe sala vinculada a ese código");
        }
        } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
        // Volver a pedir el código aquí
        }
        }

public void ListarReservas(){
        System.out.println("Lista de reservas: ");
        for(int i=0;i<salas.size();i++){
        salas.get(i).mostrarReservas();
        }
        }





        }


