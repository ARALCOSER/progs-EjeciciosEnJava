/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana12apecine3x4;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author AR.ALCOSER
 */
public class Semana12APEcine3X4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try ( // try para el control del ingreso # entero dentro del rango y NO caracteres
                Scanner leer = new Scanner(System.in)) {
            // Declaramos la Matriz llamada asientos 3 Filas x 4Columnas
            int[][] asientos = new int[3][4];
            int filaUsuario = 0, colUsuario = 0;
            boolean entradaValida = false;
            System.out.println("---            BIENVENIDO AL CINE DE NUESTRO CONJUNTO, POR EL MOMENTO          ---");
            System.out.println("---     USTED DISPONE 12 ASIENTOS A ELEGIR POR  NUMERO DE FILAS Y COLUMNAS.    ---\n\n");

            // Validación de entrada (Rango 1-3 y 1-4)
            while (!entradaValida) {
                try {
                    System.out.print("Seleccione la Fila (De 1 a 3): ");
                    filaUsuario = leer.nextInt();
                    System.out.print("Seleccione la Columna (De 1 a 4): ");
                    colUsuario = leer.nextInt();

                    // Validacion, el usuario ve 1-3 lo natural, la dimension de la matriz es 0 a 2
                    if (filaUsuario >= 1 && filaUsuario <= 3 && colUsuario >= 1 && colUsuario <= 4) {
                        entradaValida = true;
                    } else {
                        System.out.println(">> Error !!: Ese asiento NO existe. Intente de nuevo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(">> Error !!: Ingrese solo numeros enteros.");
                    leer.next(); // Limpia error del scanner
                }
            }   // Señalar la reserva (Ajustando el índice que el usuario - 1)
            asientos[filaUsuario - 1][colUsuario - 1] = 1;
            // Mostrar la matriz y confirmacion del usuario
            System.out.println("\n   ===     ESTADO DE LA SALA:     ===\n");
            System.out.println("      Col 1  Col 2  Col 3  Col 4");
            for (int i = 0; i < 3; i++) {
                System.out.print(" Fila " + (i + 1) + ":  ");
                for (int j = 0; j < 4; j++) {
                    System.out.print(asientos[i][j] + "      ");
                }
                System.out.println();
            }
            System.out.println("\n\nConfirmacion: Usted a reservado con EXITO su asiento en la Fila " + filaUsuario + " y la Columna " + colUsuario + ".");
            System.out.println("             1 = Asiento Reservado y 0 = Asiento Libre");
            System.out.println();
        }
    }
}