import java.util.Scanner;

public class MenuAdmin {
    public int eleccion;

    public void mostrarMenú() {
        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("------ Menú ------");
                System.out.println("1. Listar departamentos");
                System.out.println("2. Añadir departamentos");
                System.out.println("3. Eliminar departamentos");
                System.out.println("4. Listar salas");
                System.out.println("5. Añadir salas");
                System.out.println("6. Eliminar salas");
                System.out.println("7. Listar todas las reservas");
                System.out.println("8. Cerrar sesión");
                System.out.print("Seleccione una opción: ");
                eleccion = in.nextInt();
                in.close();
                switch (eleccion) {
                    case 1:
                        System.out.println("Listar departamentos");

                        break;
                    case 2:
                        System.out.println("Añadir departamentos");

                        break;
                    case 3:
                        System.out.println("Eliminar departamentos");

                        break;
                    case 4:
                        System.out.println("Listar salas");

                        break;
                    case 5:
                        System.out.println("Añadir salas");

                        break;
                    case 6:
                        System.out.println("Eliminar salas");

                        break;
                    case 7:
                        System.out.println("Listar todas las reservas");

                        break;
                    case 8:
                        System.out.println("Cerrando sesión");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
            //Si no mete un número el usuario
            catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número del 1 al 8");
            }
        } while (eleccion != 8);
    }
}

