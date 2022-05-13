package obligatorio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) throws FileNotFoundException {

        menuPrincipal();

    }

    public static void menuPrincipal() throws FileNotFoundException {
        Matriz matrizObj = new Matriz();

        PrintStream consola = System.out;
        PrintStream archivo = new PrintStream(new FileOutputStream("./P2-ORT-Obligatorio1/Obligatorio1/test/salidas.txt"));
        System.setOut(consola);
        String opcion = " ";
        Scanner dato;
        dato = new Scanner(System.in);
        do {
            System.out.println("");
            System.out.println("Ingrese la opcion del menu que desee:\n"
                    + "A: cambiar la entrada \t"
                    + "B: cambiar la salida\t"
                    + "C: cargar datos\t"
                    + "D: mostrar reborde\t"
                    + "E: mostrat tabulacion\t"
                    + "F: esquina\n"
                    + "G: puntas\t"
                    + "H: ver conectada\t"
                    + "I: molino\t"
                    + "J: ver menor comun\t"
                    + "K: reacomodar\t"
                    + "L: ver iguales\t"
                    + "X: terminarx");
            opcion = dato.nextLine();
            opcion = opcion.toLowerCase();

            switch (opcion) {
                case "a": {

                    System.setOut(archivo);
                }

                break;

                case "b":
                    dato = new Scanner(new File("/Users/fgavello/NetBeansProjects/P2-ORT-Obligatorio1/Obligatorio1/test/entradas.txt"));
                    System.out.println(dato);
                    break;
                case "c":
//                    cargar matriz numérica para trabajo
                    int filas = leerEntero("Ingrese un cantidad de filas", 0, 99999999, "Debe ingresar un numero valido");
                    int columnas = leerEntero("Ingrese un cantidad de columnas", 0, 99999999, "Debe ingresar un numero valido");
                    matrizObj.setMatriz(generarMat(filas, columnas));

                    break;
                // mostrar matriz de trabajo con reborde
                case "d":

                for (int i = 0; i < matrizObj.getMatriz().length; i++) {
                      for (int j = 0; j < matrizObj.getMatriz()[0].length; j++) {
                          System.out.println("+-----------");
                          System.out.printf("%6d", gameboard[i][j]);
                          if (j < matrizObj.getMatriz()[0].length - 1) {
                              System.out.print("| ");
                          }
                      }
                      System.out.println();
                  }
                //    for (int i = 0; i < matrizObj.getMatriz().length; i++) {
                // for (int j = 0; j < matrizObj.getMatriz()[0].length; j++) {
                //     System.out.print(matrizObj.getMatriz()[i][j]);
                // }
                //        System.out.println("");
            // }
            

            


                    break;

                case "e":
                    break;

                case "f":
                    int n=leerEntero("Ingrese el tamaño", 0, 99999999, "Debe ingresar un numero valido");
                    int desde=leerEntero("Ingrese desde que numero quiere cargar", 0, 99999999, "Debe ingresar un numero valido");
                    matrizObj.cargarMatrizEsquina(n,desde);
                    break;

                case "g":
                    break;

                case "h":
                    break;

                case "i":
                    break;

                case "j":
                    break;

                case "k":
                    break;

                case "l":
                    break;

                case "x":
                    break;

            }

        } while (!opcion.equalsIgnoreCase("X"));

    }

    private void mostrarMatriz(int[][] mat) {

    }

    private static int[][] generarMat(int filas, int columnas) {
        int mat[][] = new int[filas][columnas];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = leerEntero("Ingrese valor", -999999, 99999, "Ingrese un valor valido numerico");

            }

        }

        return mat;
    }

    private static int leerEntero(String txt, int min, int max, String txtError) {
        Scanner input = new Scanner(System.in);
        boolean ok = false;
        int dato = 0;
        System.out.println(txt);
        while (!ok) {
            try {
                dato = input.nextInt();
                if (dato <= max && dato >= min) {
                    ok = true;
                } else {
                    System.out.println(txtError);
                }

            } catch (InputMismatchException e) {
                System.out.println("Solo se admite numeros, por favor reingrese");
                input.nextLine();
            }
        }
        return dato;

    }
    
    
    

}
