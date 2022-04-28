package obligatorio1;

public class prueba {

    public static void main(String[] args) {
        Matriz matrizObj = new Matriz();
//        int matriz[][] = matrizObj.getMatriz();
        matrizObj.cargarMatrizEsquina(5, 10);
        matrizObj.cargarPuntas(8);
matrizObj.esConectada();
        
        int matriz[][] = matrizObj.getMatriz();
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(" " + matriz[i][j] + " ");

            }
            System.out.println("  ");
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
