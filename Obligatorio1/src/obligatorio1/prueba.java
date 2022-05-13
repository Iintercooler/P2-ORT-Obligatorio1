package obligatorio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) throws FileNotFoundException {

        menuPrincipal();

    }

    public static void menuPrincipal() throws FileNotFoundException {
        Matriz matrizObj = new Matriz();
        String fileSep = System.getProperty("file.separator");

        PrintStream consola = System.out;
        PrintStream archivo = new PrintStream(new FileOutputStream("." + fileSep + "test" + fileSep + "salida.txt"));
        System.setOut(consola);
        String opcion = " ";
        Scanner dato;
        dato = new Scanner(System.in);
        do {
            System.out.println("");

            System.out.println("Ingrese la opcion del menu que desee:\n"
                    + "A: cambiar la entrada\t\t" + "B: cambiar la salida\t"+ "C: cargar datos\t" + "\tD: mostrar reborde\t"  + "E: mostrat tabulacion\t" + "F: esquina\n"
        
                    + "G: puntas\t\t"+ "        H: ver conectada\t"  + "I: molino\t" + "\tJ: ver menor comun\t" + "K: reacomodar\t" + "\tL: ver iguales\n"
 
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
                    break;
                case "c":
//                    cargar matriz numérica para trabajo
                    int filas = leerEntero("Ingrese un cantidad de filas", 0, 99999999, "Debe ingresar un numero valido");
                    int columnas = leerEntero("Ingrese un cantidad de columnas", 0, 99999999, "Debe ingresar un numero valido");
                    matrizObj.setMatriz(generarMat(filas, columnas));
                    System.out.println(matrizObj.getMatriz().length);
                    break;
                // mostrar matriz de trabajo con reborde
                case "d":

                    for (int i = 0; i < matrizObj.getMatriz().length; i++) {
                        for (int k = 0; k < matrizObj.getMatriz().length; k++) {
                            System.out.print("+----------");
                        }
                        System.out.println("+----------+");
                        for (int j = 0; j < matrizObj.getMatriz()[0].length; j++) {
                            if (j == 0) {
                                System.out.print("| ");
                            }
                            System.out.printf("%9d", matrizObj.getMatriz()[i][j]);
                            if (j < matrizObj.getMatriz()[0].length) {
                                System.out.print("| ");
                            } else {
                                System.out.print("| ");
                            }
                        }
                        System.out.println();
                    }
                    for (int k = 0; k < matrizObj.getMatriz()[0].length - 1; k++) {
                        System.out.print("+----------");
                    }
                    System.out.println("+----------+");

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
                    int n = leerEntero("Ingrese el tamaño", 0, 99999999, "Debe ingresar un numero valido");
                    int desde = leerEntero("Ingrese desde que numero quiere cargar", MIN_VALUE, MAX_VALUE, "Debe ingresar un numero valido");
                    matrizObj.cargarMatrizEsquina(n, desde);
                    break;

                case "g":
                    int punta = leerEnteroPar("Ingrese el tamaño de la matriz para cargar puntas,debe ser par", MIN_VALUE, MAX_VALUE, "Debe ingresar un numero valido");
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
                    int molino = leerEnteroPar("Ingrese un numero par", 0, 99999999, "Debe ingresar un numero valido");
                    matrizObj.generarMolino(molino);

                    break;

                case "j":
                    System.out.println(matrizObj.menorComunFilas());
                    break;

                case "k":

                    int reacomodoFilas = leerEntero("Ingrese cantidad de filas", 0, 99999999, "Debe ingresar un numero valido");
                    int reacomodoColumnas = leerEntero("Ingrese cantidad de columnas", 0, 99999999, "Debe ingresar un numero valido");

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

    private static int leerEnteroPar(String txt, int min, int max, String txtError) {
        Scanner input = new Scanner(System.in);
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
