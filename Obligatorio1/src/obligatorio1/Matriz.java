package obligatorio1;

public class Matriz {

    int[][] matrizDeTrabajo;

    public void setMatrizDeTrabajo(int[][] matrizDeTrabajo) {
        this.matrizDeTrabajo = matrizDeTrabajo;
    }

    public void cargarMatrizEsquina(int n, int desde) {

        int matriz[][] = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {

                matriz[i][j] = desde;
                matriz[j][i] = desde;
            }
            desde++;

        }
        this.setMatrizDeTrabajo(matriz);

    }

    public int[][] cargarMatrizEsquina2(int n, int hasta) {

        int matriz[][] = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {

                matriz[i][j] = hasta;
                matriz[j][i] = hasta;
            }
            hasta--;

        }
        return matriz;

    }

    public void cargarPuntas(int n) {
        int matriz1[][] = new int[n / 2][n / 2];
        int matriz2[][] = new int[n / 2][n / 2];
        int matriz3[][] = new int[n / 2][n / 2];
        int matriz4[][] = new int[n / 2][n / 2];

        int desde = n / 2;
        matriz1 = cargarMatrizEsquina2(n, n);

//        this.setMatrizDeTrabajo(matriz);
        this.setMatrizDeTrabajo(matriz1);
    }

    public boolean esConectada() {

        int matriz1[][] = {{1, 2, 3}, 
                           {4, 0, 0}, 
                           {7, 8, 9}};
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
               if (matriz1[i][j]==0){
                   if((i<matriz1.length)&&(j<matriz1[0].length)){
                   
                   if((matriz1[i][j+1]==0)||(matriz1[i-1][j]==0)||(matriz1[i][j-1]==0)||(matriz1[i+1][j]==0)){
                   
                       System.out.println("conectada");
                   }else
                       System.out.println("no conectada");
                   
                   }
                   
               
               
               
               }
                
            }
            
        }

        return true;
    }

    public void generarMolino(int n) {
    }

    public int[][] getMatriz() {
        return this.matrizDeTrabajo;
    }

    public Matriz() {
        this.matrizDeTrabajo = new int[4][5];
        for (int x = 0; x < this.matrizDeTrabajo.length; x++) {
            for (int y = 0; y < this.matrizDeTrabajo[x].length; y++) {
                this.matrizDeTrabajo[x][y] = (int) (Math.random() * 11);
            }
        }
    }

    public String menorComunFilas() {
        return "hola";
    }

    public boolean reacomodar(int m, int n) {
        //Si escribo esto aca lo podes ver
//        djasiodhaiospdhasipdhapos
        return true;
    }

    public void setMatriz(int[][] mat) {
    }

    public boolean tieneFilaIgual() {
        return true;
    }

}
