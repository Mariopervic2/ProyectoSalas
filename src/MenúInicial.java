import java.util.Scanner;

public class MenúInicial {
    public void mostrarMenu() {
        Scanner in = new Scanner(System.in);
        int opcion = 0;

        do {
            try {
                System.out.println("------ Menú ------");
                System.out.println("1. Login de Administrador");
                System.out.println("2. Login de Departamento");

                opcion = Integer.parseInt(in.nextLine());

                //Si el usuario mete un número pero no es ni 1 ni 2
                if (opcion != 1 && opcion != 2) {
                    System.out.println("Por favor, introduce una opción válida (1 o 2)");
                }
            }
            //Si el usuario mete algo que no sea números como por ejemplo texto
            catch (NumberFormatException e) {
                System.out.println("Solo puedes introducir números");
            }
        } while (opcion != 1 && opcion != 2); //No saldremos del bucle hasta que haya elegido 1 o 2 como opciones

        //Si la opcion es 1 entramos al Login de Administrador
        if (opcion == 1) {
            System.out.println("Has seleccionado Login de Administrador");
        }
        //Si la opción es 2 entramos al Login de Departamento
        if (opcion == 2) {
            System.out.println("Has seleccionado Login de Departamento");
        }
        in.close();
    }
}
