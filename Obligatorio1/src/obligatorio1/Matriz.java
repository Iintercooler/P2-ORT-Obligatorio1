package obligatorio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Matriz {

    int[][] matrizDeTrabajo;

    public void cargarMatrizEsquina(int n, int desde) {

        int matriz[][] = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {

                matriz[i][j] = desde;
                matriz[j][i] = desde;
            }
            desde++;
        }
        setMatriz(matriz);
    }

// Metodo para cargar cuadrante en forma decreciente a partir de un numero n

    private int[][] cargarCuadranteEsquina(int n) {
        int aux = n;
        int matriz[][] = new int[n][n];

        for (int i = 0; i < matriz.length; i++) {
            n = aux - i;
            for (int j = 0; j < matriz[0].length; j++) {
                if (n >= 0) {
                    matriz[i][j] = n;
                    n--;
                }
            }

        }

        return matriz;

    }

    public void cargarPuntas(int n) {
        int matriz1[][] = new int[n / 2][n / 2];
        int matriz2[][] = new int[n / 2][n / 2];
        int matriz3[][] = new int[n / 2][n / 2];
        int matriz4[][] = new int[n / 2][n / 2];
        int matResu[][] = new int[n][n];

        matriz1 = cargarCuadranteEsquina(n / 2);
        matriz2 = cargarCuadranteEsquina(n / 2);
        rotar(matriz2, n / 2);

        matriz3 = cargarCuadranteEsquina(n / 2);
        rotar(matriz3, n / 2);
        rotar(matriz3, n / 2);

        matriz4 = cargarCuadranteEsquina(n / 2);
        rotar(matriz4, n / 2);
        rotar(matriz4, n / 2);
        rotar(matriz4, n / 2);

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1.length; j++) {
                matResu[i][j] = matriz1[i][j];
                matResu[i][j + n / 2] = matriz2[i][j];
                matResu[i + n / 2][j + n / 2] = matriz3[i][j];
                matResu[i + n / 2][j] = matriz4[i][j];
            }
        }

        this.setMatriz(matResu);
    }

//   
    public boolean esConectada() {// calcua la cantidad de islas formadas por los ceros, si hay mas de una isla quiere decir que hay ceros no conectados

        int original[][] = this.getMatriz();
        
        int mat[][]= new int [original.length][original[0].length];
        
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                mat[i][j]=original[i][j];
                
            }
            
        }
        
        
        
   

boolean resultado = false;
        int h = mat.length;
        if (h == 0) {
            return false;
        }
        int l = mat[0].length;
        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (mat[i][j] == 0) {
                    DFS(mat, i, j);
                    result++;
                }
            }
        }

        if (result == 1) {
            resultado = true;
        }

        if (result > 1) {
            resultado = false;
        }
        
        
                                  
        
        return resultado;

    }

    private void DFS(int[][] mat, int row, int col) {

        int H = mat.length;
        int L = mat[0].length;

        if (row < 0 || col < 0 || row >= H || col >= L || mat[row][col] != 0) {
            return;
        }// metodo recursivo 
        mat[row][col] = 1;
        DFS(mat, row + 1, col);
        DFS(mat, row - 1, col);
        DFS(mat, row, col + 1);
        DFS(mat, row, col - 1);
    }
 // Rota la matriz 90 grados.
    private static void rotar(int a[][], int N) {
       
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    public void generarMolino(int n) {

        int[][] mat1 = new int[n / 2][n / 2];
        int[][] mat2 = new int[n / 2][n / 2];
        int[][] mat3 = new int[n / 2][n / 2];
        int[][] mat4 = new int[n / 2][n / 2];
        int[][] matTrabajo = new int[n][n];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                if (j >= i) {
                    mat1[i][j] = 1;
                    mat2[i][j] = 1;
                    mat3[i][j] = 1;
                    mat4[i][j] = 1;

                }
            }
        }

        //Roto cada matriz lo que corresponde, la primera no la roto, 
        //la segunda 90°, la tercera 180° y la cuarta 270°
        rotar(mat2, n / 2);
        rotar(mat3, n / 2);
        rotar(mat3, n / 2);

        rotar(mat4, n / 2);
        rotar(mat4, n / 2);
        rotar(mat4, n / 2);

        int h = 0;

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                matTrabajo[i][j] = mat1[i][j];
                matTrabajo[i][j + n / 2] = mat2[i][j];
                matTrabajo[i + n / 2][j + n / 2] = mat3[i][j];
                matTrabajo[i + n / 2][j] = mat4[i][j];
            }
        }
        setMatriz(matTrabajo);

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

    /* Retorna el menor elemento comuno que tienen todas las filas, si no hay, retorna "no tiene" */
    public String menorComunFilas() {
        int mat[][] = this.getMatriz();

        int M = mat.length;
        int N = mat[0].length;
        String resultado = "";
        ArrayList<Integer> comunes = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int j = 0; j < N; j++) {
            mp.put(mat[0][j], 1);
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mp.get(mat[i][j]) != null && mp.get(mat[i][j]) == i) {
                    mp.put(mat[i][j], i + 1);
                    if (i == M - 1) {
                        comunes.add(mat[i][j]);

                    }
                }
            }

        }
        if (comunes.size() > 0) {
            resultado = String.valueOf(Collections.min(comunes));
        } else {
            resultado = "NO TIENE";
        }

        return resultado;

    }

    public boolean reacomodar(int m, int n) {
        int[][] mat = getMatriz();

        boolean sePuede = true;
        //Tomo la matriz de trabajo y creo un 
        //booleano para comprobar la condicion de que se pueda
        //Chequeo la condicion, 
        //misma cantidad de elementos en total
        //En caso de que se pueda, creo un indice y una matriz auxiliar
        //recorro la matriz original llenando la nueva como corresponda
        //actualizo el indice, para terminar se setea la matriz aux como
        //matriz de trabajo.
        if (mat.length * mat[0].length != m * n) {
            sePuede = false;
        } else {
            int indice = 0;
            int[][] aux = new int[m][n];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    aux[indice / n][indice % n] = mat[i][j];
                    indice++;
                }
            }
            if (sePuede) {
                setMatriz(aux);

            }

        }
        return sePuede;

    }
//Esto de aca es el set matriz de trabajo que hiciste arriba en la linea 14?? 
//Porque no hay ningun metodo en la letra del obligatorio que diga SetMatrizDe Trabajo.

    public void setMatriz(int[][] mat) {
        this.matrizDeTrabajo = mat;
    }

    public boolean tieneFilaIgual() {
        boolean iguales = true;
        boolean salir = false;
        int[][] mat = getMatriz();

        for (int i = 0; i < mat.length && !salir; i++) {
            iguales = true;
            for (int j = 0; j < mat[0].length - 1 && iguales; j++) {
                if (mat[i][j] != mat[i][j + 1]) {
                    iguales = false;
                }
                if (iguales) {
                    salir = true;
                }
            }

        }
        return iguales;
    }

}
