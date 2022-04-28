package obligatorio1;


public class prueba {


    public static void main(String[] args) {
       Matriz matriz= new Matriz();
        for (int i = 0; i < matriz.getMatriz().length; i++) {
            for (int j = 0; j < matriz.getMatriz()[0].length; j++) {
                System.out.print(" "+matriz.getMatriz()[i][j]+ " ");
                
            }
            System.out.println("  ");
            
        }
    }
    
}
