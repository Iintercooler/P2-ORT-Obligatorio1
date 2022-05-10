package obligatorio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class prueba {


    public static void main(String[] args) throws FileNotFoundException {
        Matriz matrizObj = new Matriz();
        Scanner input = new Scanner(System.in);
//        input = new Scanner(new File(".\\Test\\datos.txt"));
//matrizObj.cargarPuntas(9);
matrizObj.cargarPuntas(10);
        PrintStream consola = System.out;
//        PrintStream archivo = new PrintStream(new FileOutputStream("/Users/fgavello/NetBeansProjects/P2-ORT-Obligatorio1/Obligatorio1/test/salidas.txt"));
//        
//    matrizObj.generarMolino(200);
        System.setOut(consola);
//         System.setOut(archivo);

//        int matriz[][] = matrizObj.getMatriz();
//        matrizObj.cargarMatrizEsquina(5, 10);
//        matrizObj.cargarPuntas(8);
//        System.out.println(matrizObj.esConectada());
//        System.out.println(matrizObj.menorComunFilas());
//        int matriz[][] = matrizObj.getMatriz();
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[0].length; j++) {
//                System.out.print(" " + matriz[i][j] + " ");
//
//            }
//            System.out.println("  ");
//        }
    }

    public static int leerEntero(String txt, int min, int max, String txtError) {
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

    public static void menuPrincipal() {
        String opcion = "";
        while (opcion != "X") {
            String txt = "Ingrese la opcion del menu que desee:\n"
                    + "1 - Ingresar cliente\n"
                    + "2 - Ingresar compra\n"
                    + "3 - Terminar";
//            opcion = leerEntero(txt, 1, 3, "Debe ingresar un numero entre 1 y 3");
            switch (opcion) {
                case "A":

                    break;
                case "B":

                    break;
                case "C":
                    break;
            }

        }
    }

}
//
//        for (int i = 0; i < matriz.getMatriz().length; i++) {
//            for (int j = 0; j < matriz.getMatriz()[0].length; j++) {
//                System.out.print(" "+matriz.getMatriz()[i][j]+ " ");
//                
//            }
//            System.out.println("  ");
//        }
//    }
    
//}
