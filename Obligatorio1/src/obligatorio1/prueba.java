//Fernando Gavello
//Gonzalo Loureiro
package obligatorio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import java.util.InputMismatchException;
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            menuPrincipal();

        } catch (java.util.NoSuchElementException e) {
            System.out.println("Error en el archivo de datos.txt");

        }

    }

    public static void menuPrincipal() throws FileNotFoundException, IOException {
       
        Matriz matrizObj = new Matriz();
        Scanner input;
        input = new Scanner(System.in);
       
        boolean salida_consola = true;
        boolean entrada_consola = true;

        String fileSep = System.getProperty("file.separator");
        PrintStream consola = System.out;
        System.setOut(consola);
        PrintStream archivo = new PrintStream(new FileOutputStream("." + fileSep + "test" + fileSep + "salida.txt"));

        String opcion = " ";

        do {
            System.out.println("");

            System.out.println("Ingrese la opcion del menu que desee:\n"
                    + "A: cambiar la entrada\t\t" + "B: cambiar la salida\t" + "C: cargar datos\t" + "\tD: mostrar reborde\t" + "E: mostrat tabulacion\t" + "F: esquina\n"
                    + "G: puntas\t\t" + "        H: ver conectada\t" + "I: molino\t" + "\tJ: ver menor comun\t" + "K: reacomodar\t" + "\tL: ver iguales\n"
                    + "X: terminar");

            opcion = input.nextLine();
            opcion = opcion.toLowerCase();

            switch (opcion) {
                case "a": {

                    if (!entrada_consola) {
                        input = new Scanner(System.in);
                        entrada_consola = true;
                        break;
                    }

                    if (entrada_consola) {
                        input = new Scanner(new File("." + fileSep + "test" + fileSep + "datos.txt"));
                        entrada_consola = false;
                        break;
                    }
                }

                case "b":

                    if (!salida_consola) {

                        System.setOut(consola);
                        salida_consola = true;
                        break;
                    }
                    if (salida_consola) {
                        System.setOut(archivo);
                        salida_consola = false;
                        break;
                    }

                case "c":
                    //  cargar matriz numérica para trabajo
                    int filas = leerEntero("Ingrese un cantidad de filas", 0, 99999999, "Debe ingresar un numero valido", input);
                    int columnas = leerEntero("Ingrese un cantidad de columnas", 0, 99999999, "Debe ingresar un numero valido", input);
                    matrizObj.setMatriz(generarMat(filas, columnas, input));
                    break;
                case "d":
                    mostrarConReborde(matrizObj.getMatriz());
                    break;

                case "e":
                    for (int i = 0; i < matrizObj.getMatriz().length; i++) {
                        for (int j = 0; j < matrizObj.getMatriz()[0].length; j++) {
                            System.out.printf("%9d", matrizObj.getMatriz()[i][j]);

                        }
                        System.out.println();
                    }
                    break;

                case "f":
                    int n = leerEntero("Ingrese el tamaño", 0, MAX_VALUE, "Debe ingresar un numero valido", input);
                    int desde = leerEntero("Ingrese desde que numero quiere cargar", MIN_VALUE, MAX_VALUE, "Debe ingresar un numero valido", input);
                    matrizObj.cargarMatrizEsquina(n, desde);
                    break;

                case "g":
                    int punta = leerEnteroPar("Ingrese el tamaño de la matriz para cargar puntas,debe ser par", MIN_VALUE, MAX_VALUE, "Debe ingresar un numero valido", input);
                    matrizObj.cargarPuntas(punta);
                    break;

                case "h":
                    if (matrizObj.esConectada()) {
                        System.out.println("La matriz Es conectada");

                    } else {
                        System.out.println("No es conectada");

                    }

                    break;

                case "i":
                    int molino = leerEnteroPar("Ingrese un numero par", 0, MAX_VALUE, "Debe ingresar un numero valido", input);
                    matrizObj.generarMolino(molino);

                    break;

                case "j":
                    System.out.println(matrizObj.menorComunFilas());
                    break;

                case "k":

                    int reacomodoFilas = leerEntero("Ingrese cantidad de filas", 0, MAX_VALUE, "Debe ingresar un numero valido", input);
                    int reacomodoColumnas = leerEntero("Ingrese cantidad de columnas", 0, MAX_VALUE, "Debe ingresar un numero valido", input);

                    if (matrizObj.reacomodar(reacomodoFilas, reacomodoColumnas)) {
                        System.out.println("SE PUDO REACOMODAR");
                        matrizObj.reacomodar(reacomodoFilas, reacomodoColumnas);
                    } else {
                        System.out.println("NO SE PUEDE REACOMODAR");
                    }
                    break;

                case "l":
                    if (matrizObj.tieneFilaIgual()) {
                        System.out.println("Tiene fila igual.");
                    } else {
                        System.out.println("No tiene fila igual.");
                    }
                    break;

                case "x":
                    System.out.println("Gracias por usar nuestro programa");
                    break;

            }

        } while (!opcion.equalsIgnoreCase("X"));

    }
    // mostrar matriz de trabajo con reborde

    private static void mostrarConReborde(int m[][]) {
        int original[][] = m;
        int mat[][] = new int[original.length][original[0].length];

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                mat[i][j] = original[i][j];

            }

        }

        for (int i = 0; i < mat.length; i++) {
            for (int k = 0; k < mat[0].length - 1; k++) {
                System.out.print("+----------");
            }

            System.out.println("+----------+");

            for (int j = 0; j < mat[0].length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.printf("%9d", mat[i][j]);
                if (j < mat[0].length) {
                    System.out.print("| ");
                } else {
                    System.out.print("| ");
                }
            }

            System.out.println();
        }

        for (int k = 0; k < mat[0].length - 1; k++) {
            System.out.print("+----------");
        }

        System.out.println("+----------+");

    }

    private static int[][] generarMat(int filas, int columnas, Scanner input) {
        int mat[][] = new int[filas][columnas];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = leerEntero("Ingrese valor", MIN_VALUE, MAX_VALUE, "Ingrese un valor valido numerico", input);

            }

        }

        return mat;
    }

    private static int leerEntero(String txt, int min, int max, String txtError, Scanner input) {

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

    private static int leerEnteroPar(String txt, int min, int max, String txtError, Scanner input) {

        boolean ok = false;
        int dato = 0;
        System.out.println(txt);
        while (!ok) {
            try {
                dato = input.nextInt();
                if ((dato <= max && dato >= min) && dato % 2 == 0) {
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
