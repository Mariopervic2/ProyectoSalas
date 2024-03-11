import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Aplicacion {
    private Scanner scanner;
    private ArrayList<Departamento> departamentos;
    private ArrayList<Sala> salas;
    private ArrayList<Reserva> reservas;

    public Aplicacion() {
        scanner = new Scanner(System.in);
        departamentos = new ArrayList<>();
        salas = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    //Menú Inicial completo
    public void iniciar() {
        int respuesta;
        do {
            System.out.println("Menú inicial");
            System.out.println("1. Login de Administrador");
            System.out.println("2. Login de Departamento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                respuesta = scanner.nextInt();
                scanner.nextLine();
                switch (respuesta) {
                    case 1:
                        loginAdministrador();
                        break;
                    case 2:
                        loginDepartamento();
                        break;
                    case 3:
                        System.out.println("Saliendo de la aplicación...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        break;
                }
            } catch (Exception e) {//si no ingresamos un numero , nos salta la excepcion y recordamos al usuario que se pide un numero
                System.out.println("El valor ingresado debe ser un numero");
                scanner.nextLine(); // Limpiar el buffer del scanner
                respuesta = 0; // volvemos respuesta un valor dentro del bucle que no afecte a ninguna de las otras opciones
            }
        } while (respuesta != 3);
    }

    //Menú Administrador Completo
    private void menuAdministrador() {
        int respuesta;
        do {
            System.out.println("Menú de Administrador");
            System.out.println("1. Listar departamentos");
            System.out.println("2. Añadir departamento");
            System.out.println("3. Eliminar departamento");
            System.out.println("4. Listar salas");
            System.out.println("5. Añadir sala");
            System.out.println("6. Eliminar sala");
            System.out.println("7. Listar todas las reservas");
            System.out.println("8. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            try {
                respuesta = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                switch (respuesta) {
                    case 1:
                        listarDepartamentos();
                        break;
                    case 2:
                        agregarDepartamento();
                        break;
                    case 3:
                        eliminarDepartamento();
                        break;
                    case 4:
                        listarSalas();
                        break;
                    case 5:
                        agregarSala();
                        break;
                    case 6:
                        eliminarSala();
                        break;
                    case 7:
                        listarReservas();
                        break;
                    case 8:
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Esa opción no es válida, inténtalo de nuevo");
                        break;
                }
            } catch (Exception e) {
                System.out.println("El valor ingresado debe ser un numero"); //nos recuerda que debe ser un numero
                scanner.nextLine();
                respuesta = 0; //volvemos respuesta un valor dentro del bucle que no afecte a ninguna de las otras opciones, como en departamento
            }
        } while (respuesta != 8);
    }

    //Menú Departamento completo
    private void menuDepartamento() {
        int respuesta;
        do {
            System.out.println("Menú de Departamento");
            System.out.println("1. Añadir reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Listar todas las reservas");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            try {
                String eleccion = scanner.nextLine();
                respuesta = Integer.parseInt(eleccion); // Convertimos la eleccion a un numero y evaluamos posteriormente cual ha elegido
                switch (respuesta) {
                    case 1:
                        añadirReserva();
                        break;
                    case 2:

                        break;
                    case 3:
                        listarTodasLasReservas();
                        break;
                    case 4:
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Ese número no es válido, inténtalo de nuevo");
                        break;
                }
            } catch (NumberFormatException e) { //si no se ingresa un numero , nos saltará un aviso con el siguiente mensaje
                System.out.println("El valor ingresado debe ser un numero");
                respuesta = 0; //volvemos respuesta un valor dentro del bucle que no afecte a ninguna de las otras opciones
            }
        } while (respuesta != 4);
    }

    //Login en Administrador completo
    private void loginAdministrador() {
        System.out.print("Ingrese la contraseña de administrador: ");
        String contraseña = scanner.nextLine();
        //La contraseña es Herrera2024
        //Si la acierta llamamos al método menuAdministrador() para que nos lo muestre
        if (contraseña.equals("Herrera2024")) {
            System.out.println("Inicio de sesión exitoso como administrador.");
            menuAdministrador();
        }
        //Si la contraseña es incorrecta da error
        else {
            System.out.println("La contraseña es incorrecta");
        }
    }

    //Login en Departamentos completo
    public void loginDepartamento() {
        System.out.print("Ingrese la clave de departamento: ");
        String clave = scanner.nextLine();

        // Comprobamos si ya existe un departamento que tenga esa clave recorriendo el array de departamentos
        Departamento departamentoEncontrado = null;
        for (Departamento depto : departamentos) {
            if (depto.getCodigo().equals(clave)) {
                departamentoEncontrado = depto;
                break;
            }
        }

        //Si sale que no es null lo hemos encontrado
        if (departamentoEncontrado != null) {
            System.out.println("Inicio de sesión exitoso como departamento.");
            menuDepartamento();
        }
        //Si sigue saliendo null (el valor que le dimos de base) significa que no tenemos un departamento con esa clave
        else {
            System.out.println("No se encontró un departamento con esa clave.");
        }
    }

    //Listar departamentos funciona sin problemas
    private void listarDepartamentos() {
        //Creamos esta opción si todavía no hemos introducido ningún departamento
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        }
        //Si ya tenemos introducido algun departamento, recorremos el array y los mostramos por pantalla
        else {
            System.out.println("Lista de departamentos:");
            for (Departamento depto : departamentos) {
                System.out.println("CódigoDepartamento: "+depto.getCodigo() + " NombreDepartamento: " + depto.getNombre());
            }
        }
    }

    //Agregar Departamentos funciona correctamente
    private void agregarDepartamento() {
        // Pedimos el código del departamento
        String codigo;
        do {
            System.out.print("Ingrese el código del departamento: ");
            codigo = scanner.nextLine();
            //Vamos a utilizar una expresión regular como dijiste en clase ya que vemos que es lo más fácil y nos servirá en otras validaciones
            if (!codigo.matches("[a-zA-Z]+")) {
                System.out.println("Recuerda que solo puede haber letras en el código");
            }
        }
        //No saldremos de aquí hasta que el usuario introduzca una opción correcta
        while (!codigo.matches("[a-zA-Z]+"));

        // Pedimos el nombre del departamento
        String nombre;
        do {
            System.out.print("Ingrese el nombre del departamento: ");
            nombre = scanner.nextLine();
            if (!nombre.matches("[a-zA-Z ]+")) {
                System.out.println("Recuerda que solo puede haber letras en el nombre");
            }
        }
        while (!nombre.matches("[a-zA-Z ]+"));

        //Aquí ya hemos hecho toda la validación necesaria
        // Llamando al constructor de Departamento podemos crear un nuevo departamento
        Departamento nuevoDepartamento = new Departamento(codigo, nombre);

        // Añadimos el departamento nuevo al array de departamentos con add
        departamentos.add(nuevoDepartamento);

        // Ponemos un mensaje al usuario para que sepa que no ha habido problemas
        System.out.println("Departamento agregado correctamente.");
    }


    //Eliminar departamentos funciona correctamente
    private void eliminarDepartamento() {
        String codigo;
        do {
            System.out.print("Ingrese el código del departamento a eliminar: ");
            codigo = scanner.nextLine();

            //Volvemos a utilizar la misma validación con la expresión regular de antes
            if (!codigo.matches("[a-zA-Z]+")) {
                System.out.println("Recuerda que el código del departamento solo puede contener letras.");
            }
        } while (!codigo.matches("[a-zA-Z]+"));

        //Ponemos el valor falso de predeterminado
        boolean encontrado = false;
        // Recorremos el array para saber si está creado un departamento con ese código
        for (Departamento depto : departamentos) {
            // Si lo encontramos, avisamos al usuario de que lo hemos eliminado
            if (depto.getCodigo().equals(codigo)) {
                departamentos.remove(depto);
                System.out.println("Departamento eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
        // Si no lo encuentra avisamos al usuario de que no hay ningún departamento con ese código
        if (!encontrado) {
            System.out.println("No se encontró un departamento con ese código.");
        }
    }


    //Listar salas funciona correctamente
    private void listarSalas() {
        //Como hicimos en departamentos, si el array está vacío se lo especificamos al usuario
        if (salas.isEmpty()) {
            System.out.println("No hay salas registradas.");
        }
        //En caso de que sí existan salas,las mostramos
        else {
            System.out.println("Lista de salas:");
            for (Sala sala : salas) {
                System.out.println("CódigoSala: "+sala.getCodigo() + " NombreSala: " + sala.getNombre());
            }
        }
    }


    //Agregar salas funciona correctamente
    private void agregarSala() {
        String codigo;
        //Pedimos el codigo de la sala al usuario y lo validamos
        do {
            System.out.print("Ingrese el código de la sala: ");
            codigo = scanner.nextLine();

            if (!codigo.matches("[a-zA-Z]+")) {
                System.out.println("Recuerda que el código de la sala solo puede contener letras.");
            }
        } while (!codigo.matches("[a-zA-Z]+"));

        String nombre;
        //Pedimos el nombre de la sala al usuario y lo validamos
        do {
            System.out.print("Ingrese el nombre de la sala: ");
            nombre = scanner.nextLine();

            if (!nombre.matches("[a-zA-Z ]+")) {
                System.out.println("Recuerda que el nombre de la sala solo puede contener letras y espacios.");
            }
        } while (!nombre.matches("[a-zA-Z ]+"));

        // Gracias al constructor de sala creamos la nueva sala con esos datos
        Sala nuevaSala = new Sala(codigo, nombre);
        // La introducimos al array de salas con add
        salas.add(nuevaSala);
        // Avisamos al usuario de que ha funcionado
        System.out.println("Sala agregada correctamente.");
    }



    //Eliminar sala funciona correctamente
    private void eliminarSala() {
        String codigo;
        do {
            // Pedimos al usuario el código de la sala que quiere eliminar
            System.out.print("Ingrese el código de la sala a eliminar: ");
            codigo = scanner.nextLine();

            // Verificamos si el código contiene solo letras con la misma expresión regular que antes
            if (!codigo.matches("[a-zA-Z]+")) {
                System.out.println("Recuerda que el código de la sala solo puede contener letras.");
            }
        } while (!codigo.matches("[a-zA-Z]+"));

        boolean encontrado = false;
        // Recorremos el bucle para ver si existe una sala con ese código
        for (Sala sala : salas) {
            // Si está en el array de Salas, eliminamos la sala con remove e informamos al usuario
            if (sala.getCodigo().equals(codigo)) {
                salas.remove(sala);
                System.out.println("Sala eliminada correctamente.");
                encontrado = true;
                break;
            }
        }
        // Si no lo ha encontrado, informamos al usuario de que no existe una sala con ese código
        if (!encontrado) {
            System.out.println("No se encontró una sala con ese código.");
        }
    }


    //Listar Reservas funciona correctamente
    private void listarReservas() {
        //Si el array de reservas está vacío avisamos al usuario
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
        }
        //Si ya existen reservas, mostramos la lista al usuario
        else {
            System.out.println("Lista de reservas:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    public void añadirReserva() {
        try {
            // Pedir la fecha de la reserva
            System.out.print("Ingrese la fecha de la reserva (en formato dd/MM/yyyy): ");
            String fechaString = scanner.nextLine();
            //Creamos el patrón de la fecha
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);

            // Pedir la hora de inicio de la reserva
            System.out.print("Ingrese la hora de inicio de la reserva (solo se puede reservar de 9:00 a 14:00): ");
            int horaInicio = scanner.nextInt();
            scanner.nextLine(); // Limpiamos el buffer del scanner

            // Verificar que la hora de inicio esté dentro del horario permitido
            if (horaInicio < 9 || horaInicio > 14) {
                System.out.println("Recuerda que la reserva solo se puede hacer de 9:00 a 14:00.");
                return;
            }

            // Pedir la duración de la reserva
            System.out.print("Ingrese la duración de la reserva en horas (deben ser enteras): ");
            int duracionHoras = scanner.nextInt();
            scanner.nextLine(); // Limpiamos scanner

            // Verificar que la duración sea mayor que cero
            if (duracionHoras <= 0) {
                System.out.println("La duración de la reserva no puede ser menor a cero.");
                return;
            }

            // Solicitar el código de la sala para la reserva
            System.out.print("Ingrese el código de la sala para la reserva: ");
            String codigoSala = scanner.nextLine();

            // Buscar la sala correspondiente en la lista de salas
            Sala salaReserva = null;
            for (Sala sala : salas) {
                if (sala.getCodigo().equals(codigoSala)) {
                    salaReserva = sala;
                    break;
                }
            }

            // Verificar si se encontró la sala
            if (salaReserva == null) {
                System.out.println("No se encontró la sala especificada.");
                return;
            }

            // Verificar si hay alguna reserva en ese horario
            for (Reserva reserva : salaReserva.getReservas()) {
                if (reserva.getFecha().equals(fecha) &&
                        horaInicio >= reserva.getHoraInicio() &&
                        horaInicio < (reserva.getHoraInicio() + reserva.getDuracionHoras())) {
                    System.out.println("La sala ya está reservada para ese período.");
                    return;
                }
            }

            // Obtener el departamento asociado al código de departamento del usuario
            Departamento departamentoReserva = null;
            for (Departamento depto : departamentos) {
                // Supongamos que aquí deberías solicitar el código del departamento al usuario.
                // Por simplicidad, lo omitimos por ahora y lo dejamos como una variable predefinida.
                String codigoDepartamento = "CODIGO_DEPARTAMENTO"; // Aquí deberías solicitarlo al usuario
                if (depto.getCodigo().equals(codigoDepartamento)) {
                    departamentoReserva = depto;
                    break;
                }
            }

            // Crear la nueva reserva y agregarla a la sala
            Reserva nuevaReserva = new Reserva(fecha, horaInicio, duracionHoras);
            nuevaReserva.setSala(salaReserva);
            nuevaReserva.setDepartamento(departamentoReserva);
            salaReserva.agregarReserva(nuevaReserva);
            reservas.add(nuevaReserva);

            System.out.println("Reserva realizada correctamente.");
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto.");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al agregar la reserva.");
        }
    }


/* No nos funciona cancelarReserva hemos probado muchas cosas y no sale nada
    public void cancelarReserva() {
        try {
            // Pedimos al usuario el código del departamento
            System.out.print("Ingrese el código de su departamento: ");
            String codigoDepartamento = scanner.nextLine();

            // Pedimos la fecha de la reserva
            System.out.print("Ingrese la fecha de la reserva a cancelar (en formato dd/MM/yyyy): ");
            String fechaString = scanner.nextLine();
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);

            // Pedimos la hora de inicio de la reserva
            System.out.print("Ingrese la hora de inicio de la reserva a cancelar: ");
            int horaInicio = scanner.nextInt();
            scanner.nextLine(); // Limpiamos el buffer del scanner

            // Buscamos la reserva para cancelar
            Reserva reservaEncontrada = null;
            for (Reserva reserva : reservas) {
                if (reserva.getDepartamento().getCodigo().equals(codigoDepartamento) &&
                        reserva.getFecha().equals(fecha) &&
                        reserva.getHoraInicio() == horaInicio) {
                    reservaEncontrada = reserva;
                    break;
                }
            }

            if (reservaEncontrada != null) {
                // Eliminar la reserva de la lista de reservas y de la lista de reservas de la sala correspondiente
                reservas.remove(reservaEncontrada);
                reservaEncontrada.getSala().getReservas().remove(reservaEncontrada);
                System.out.println("Reserva cancelada correctamente.");
            } else {
                System.out.println("No se encontró una reserva para cancelar con los datos proporcionados.");
            }
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto.");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al cancelar la reserva.");
        }
    }
*/

    //ListarReservasFuncionacorrectamente
    private void listarTodasLasReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
        } else {
            System.out.println("Lista de todas las reservas:");
            for (Reserva reserva : reservas) {
                String salaCodigo = (reserva.getSala() != null) ? reserva.getSala().getCodigo() : "Sala no especificada";
                String departamentoCodigo = (reserva.getDepartamento() != null) ? reserva.getDepartamento().getCodigo() : "Departamento no especificado";
                System.out.println("Fecha: " + reserva.getFecha() +
                        ", Hora de inicio: " + reserva.getHoraInicio() +
                        ", Duración: " + reserva.getDuracionHoras() + " horas" +
                        ", Sala: " + salaCodigo);
            }
        }
    }
}
