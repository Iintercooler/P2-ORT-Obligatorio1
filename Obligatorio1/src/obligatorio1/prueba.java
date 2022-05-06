package obligatorio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class prueba {

    public static void main(String[] args) throws FileNotFoundException {
        Matriz matrizObj = new Matriz();
        Scanner input=new Scanner(System.in);
//        input = new Scanner(new File(".\\Test\\datos.txt"));
//        System.out.println(matrizObj.menorComunFilas());
//        PrintStream consola = System.out;
//        PrintStream archivo = new PrintStream(new FileOutputStream(".\\Test\\salida.txt"));
//        
//        
//         System.setOut(consola);
//         System.setOut(archivo);
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        int matriz[][] = matrizObj.getMatriz();
        matrizObj.cargarMatrizEsquina(5, 10);
        matrizObj.cargarPuntas(8);
   
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
