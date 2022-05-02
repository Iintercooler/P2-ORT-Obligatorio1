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

    public boolean esConectada2() {
        int mat[][] = {{0, 1, 0, 0},
                       {0, 0, 1, 1},
                       {1, 0, 1, 1},
                       {0, 0, 1, 1}};
        boolean condicion = true;

        
        for (int f = 0; f < mat.length; f++) {
            for (int c = 0; c < mat[0].length; c++) {
                if ((f > 0 && f < mat.length - 1) && (c > 0 && c < mat[0].length-1)) {
                    
                    if ((mat[f][c - 1] != 0 && mat[f][c + 1] != 0)) {
                       
                        if ((mat[f + 1][c] != 0 && mat[f - 1][c] != 0)){
                        condicion = false;

                    }
                    }
                }

            }

        }
        return condicion;
       
    }


public boolean esConectada() {

        int mat[][] = {{0, 1, 0, 0},
        {0, 0, 1, 1},
        {1, 0, 0, 1},
        {0, 0, 1, 1}};
        boolean condicion = true;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(" " + mat[i][j] + " ");

            }
            System.out.println("  ");
        }

        for (int f = 0; f < mat.length && condicion; f++) {

            for (int c = 0; c < mat.length && condicion; c++) {

                if (mat[f][c] == 0) {
                    if (f == 0 && c == 0) {
                        if (mat[f + 1][c] != 0 && mat[f][c + 1] != 0) {
                            condicion = false;
                            System.out.println(condicion + "1");

                        }
                    }

                    if (f == 0 && c == mat[0].length - 1) {
                        if (mat[f + 1][c] != 0 && mat[f][c - 1] != 0) {
                            condicion = false;
                            System.out.println(condicion + "2");

                        }
                    }

                    if (f == mat.length - 1 && c == 0) {
                        if (mat[f - 1][c] != 0 && mat[f][c + 1] != 0) {
                            condicion = false;
                            System.out.println(condicion + "3");

                        }

                    }
                    if (f == mat.length - 1 && c == mat[0].length - 1) {
                        if (mat[f - 1][c] != 0 && mat[f][c - 1] != 0) {
                            condicion = false;
                            System.out.println(condicion + "4");

                        }
                    }

                    if ((f > 0 && f < mat.length - 1) && c == 0) {
                        if (mat[f][c + 1] != 0 && mat[f + 1][c] != 0) {
                            condicion = false;
                            System.out.println(condicion + "5");

                        }
                    }

                    if ((f == mat.length - 1 && c > 0) && (c < mat[0].length)) {
                        if ((mat[f][c - 1] != 0) && (mat[f - 1][c] != 0)) {
                            condicion = false;
                            System.out.println(condicion + "6");

                        }

                    }
                    if ((f > 0 && f < mat.length - 1) && (c == mat[0].length - 1)) {
                        if (mat[f][c - 1] != 0 && mat[f + 1][c] != 0) {
                            condicion = false;
                            System.out.println(mat[f][c]);
                        }
                    }

                    if ((f == 0 && c > 0) && (c < mat[0].length - 1)) {
                        if (mat[f][c + 1] != 0 && mat[f + 1][c] != 0) {

                            condicion = false;
                            System.out.println(condicion + "8");
                        }
                    }

                    if ((f > 0 && f < mat.length - 1) && (c > 0 && c < mat[0].length-1)) {
                        if ((mat[f][c - 1] != 0 && mat[f][c + 1] != 0) && (mat[f + 1][c] != 0 && mat[f - 1][c] != 0)) {
                            condicion = false;

                        }

                    }
                }
            }
        }
        return condicion;

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
