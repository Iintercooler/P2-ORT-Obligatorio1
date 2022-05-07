package obligatorio1;

import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Matriz {

    int[][] matrizDeTrabajo;

//    public void setMatrizDeTrabajo(int[][] matrizDeTrabajo) {
//        this.matrizDeTrabajo = matrizDeTrabajo;
//    }
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

    public void cargarMatrizEsquina2(int n, int hasta) {

        int matriz[][] = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {

                matriz[i][j] = hasta;
                matriz[j][i] = hasta;
            }
            hasta--;

        }
        setMatriz(matriz);

    }

    public void cargarPuntas(int n) {
//        int matriz1[][] = new int[n / 2][n / 2];
//        int matriz2[][] = new int[n / 2][n / 2];
//        int matriz3[][] = new int[n / 2][n / 2];
//        int matriz4[][] = new int[n / 2][n / 2];
//
//        int desde = n / 2;
//        matriz1 = cargarMatrizEsquina2(n, n);
//
////        this.setMatrizDeTrabajo(matriz);
//        this.setMatriz(matriz1);
    }

    public boolean esConectada2() {
        int mat[][] = {{0, 1, 0, 0},
        {0, 0, 1, 1},
        {1, 0, 1, 1},
        {0, 0, 1, 1}};
        boolean condicion = true;

        for (int f = 0; f < mat.length; f++) {
            for (int c = 0; c < mat[0].length; c++) {
                if ((f > 0 && f < mat.length - 1) && (c > 0 && c < mat[0].length - 1)) {

                    if ((mat[f][c - 1] != 0 && mat[f][c + 1] != 0)) {

                        if ((mat[f + 1][c] != 0 && mat[f - 1][c] != 0)) {
                            condicion = false;

                        }
                    }
                }

            }

        }
        return condicion;

    }

    public boolean esConectada() {// calcua la cantidad de islas formadas por los ceros, si hay mas de una isla quiere decir que hay ceros no conectados
//        int mat[][] = {{1, 3, 2, 3},
//                       {2, 1, 1, 4},
//                       {4, 1, 5, 1},
//                       {5, 9, 8, 1}};
        int mat[][] = this.matrizDeTrabajo;
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
        if (result > 1 || result == 0) {
            System.out.println("no es conectada");
        } else {
            System.out.println("es conectada" + result);
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

//    public int calcularPerimetro() {
//        int contador = 0;
//        int mat[][] = {{0, 0, 0, 0},
//        {0, 1, 1, 1},
//        {1, 1, 0, 1},
//        {0, 1, 0, 1}};
//
////        {1,0,1,4,56,0}
////        {0,0,0,33,4,0}
////        {0,3,4,-2,0,0}
////        {0 0 0,5,0,6}
////        {7 0 0 0 0 0}
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if (mat[i][j] == 1) {
//                    contador++;
//
//                }
//
//            }
//
//        }
//
//        int perimetro = 0;
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if (mat[i][j] == 1) {
//                    // arriba
//                    if (i == 0) {
//                        perimetro++;
//                    } else {
//                        if (mat[i - 1][j] == 0) {
//                            perimetro++;
//                        }
//                    }
//                    // abajo
//                    if (i == mat.length - 1) {
//                        perimetro++;
//                    } else {
//                        if (mat[i + 1][j] == 0) {
//                            perimetro++;
//                        }
//                    }
//                    // izquierda
//                    if (j == 0) {
//                        perimetro++;
//                    } else {
//                        if (mat[i][j - 1] == 0) {
//                            perimetro++;
//                        }
//                    }
//                    // derecha
//                    if (j == mat[0].length - 1) {
//                        perimetro++;
//                    } else {
//                        if (mat[i][j + 1] == 0) {
//                            perimetro++;
//                        }
//                    }
//                }
//            }
//        }
//        if (contador * 2 + 2 != perimetro) {
//            System.out.println("no es conectada");
//
//        }
//        if (contador * 2 + 2 == perimetro) {
//            System.out.println("es conectada");
//        }
//        return perimetro;
//    }
//
//    public boolean esConectada() {
//
//        int mat[][] = {{0, 1, 0, 0},
//        {0, 0, 1, 1},
//        {1, 1, 1, 1},
//        {0, 0, 1, 1}};
//
//        boolean condicion = true;
//
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                System.out.print(" " + mat[i][j] + " ");
//
//            }
//            System.out.println("  ");
//        }
//
//        for (int f = 0; f < mat.length && condicion; f++) {
//
//            for (int c = 0; c < mat.length && condicion; c++) {
//
//                if (mat[f][c] == 0) {
//                    if (f == 0 && c == 0) {
//                        if (mat[f + 1][c] != 0 && mat[f][c + 1] != 0) {
//                            condicion = false;
////                            System.out.println(condicion + "1");
//
//                        }
//                    }
//
//                    if (f == 0 && c == mat[0].length - 1) {
//                        if (mat[f + 1][c] != 0 && mat[f][c - 1] != 0) {
//                            condicion = false;
////                            System.out.println(condicion + "2");
//
//                        }
//                    }
//
//                    if (f == mat.length - 1 && c == 0) {
//                        if (mat[f - 1][c] != 0 && mat[f][c + 1] != 0) {
//                            condicion = false;
////                            System.out.println(condicion + "3");
//
//                        }
//
//                    }
//                    if (f == mat.length - 1 && c == mat[0].length - 1) {
//                        if (mat[f - 1][c] != 0 && mat[f][c - 1] != 0) {
//                            condicion = false;
////                            System.out.println(condicion + "4");
//
//                        }
//                    }
//
//                    if ((f > 0 && f < mat.length - 1) && c == 0) {
//                        if (mat[f][c + 1] != 0 && mat[f + 1][c] != 0) {
//                            condicion = false;
////                            System.out.println(condicion + "5");
//
//                        }
//                    }
//
//                    if ((f == mat.length - 1 && c > 0) && (c < mat[0].length)) {
//                        if ((mat[f][c - 1] != 0) && (mat[f - 1][c] != 0)) {
//                            condicion = false;
////                            System.out.println(condicion + "6");
//
//                        }
//
//                    }
//                    if ((f > 0 && f < mat.length - 1) && (c == mat[0].length - 1)) {
//                        if (mat[f][c - 1] != 0 && mat[f + 1][c] != 0) {
//                            condicion = false;
////                            System.out.println(mat[f][c]);
//                        }
//                    }
//
//                    if ((f == 0 && c > 0) && (c < mat[0].length - 1)) {
//                        if (mat[f][c + 1] != 0 && mat[f + 1][c] != 0) {
//
//                            condicion = false;
////                            System.out.println(condicion + "8");
//                        }
//                    }
//
//                    if ((f > 0 && f < mat.length - 1) && (c > 0 && c < mat[0].length - 1)) {
//                        if ((mat[f][c - 1] != 0 && mat[f][c + 1] != 0) && (mat[f + 1][c] != 0 && mat[f - 1][c] != 0)) {
//                            condicion = false;
//
//                        }
//
//                    }
//                }
//            }
//        }
//        return condicion;
//
//    }

/*public static void rotar(int a[][], int N){
    // Rota la matriz 90 grados.
    for (int i = 0; i < N / 2; i++)
    {
        for (int j = i; j < N - i - 1; j++)
        {
            int temp = a[i][j];
            a[i][j] = a[N - 1 - j][i];
            a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
            a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
            a[j][N - 1 - i] = temp;
        }
    }
}

    public void generarMolino(int n) {
        int[][] mat1 = new int[n/2][n/2];
        int[][] matTrabajo = new int[n][n];
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n/2; j++){
                if(j>=i){
                    mat1[i][j] = 1;
                }
            }
        }
        //Roto cada matriz lo que corresponde, la primera no la roto, 
        //la segunda 90°, la tercera 180° y la cuarta 270°
        int[][] mat2 = mat1;
        rotar(mat2, n/2);
        int[][] mat3 = mat2;
        rotar(mat3, n/2);
        int[][] mat4 = mat3;
        rotar(mat4, n/2);


        int h = 0;
        for(int i = 0; i < n/2; i++){
            for(int j = 0; i < n/2; j++){
                matTrabajo[i][j] = mat1[i][j];
                matTrabajo[i][j + n/2] = mat2[i][j];
                matTrabajo[i + n/2][j + n/2] = mat3[i][j];
                matTrabajo[i + n/2][j] = mat4[i][j];
            }
        }
        setMatriz(matTrabajo);
}
*/
    private int[][] cuartocuadrante(int[][] matrix) {
        int newDimension = matrix.length / 2;
        int[][] toReturn = new int[newDimension][newDimension];
        for (int i = 0; i < newDimension; i++) {
            for (int j = 0; j < newDimension; j++) {
                toReturn[i][j] = matrix[i + newDimension][j + newDimension];
            }
        }
        return toReturn;
    }

    public int[][] primercuadrante(int[][] matrix) {
        int newDimension = matrix.length / 2;
        int[][] toReturn = new int[newDimension][newDimension];
        for (int i = 0; i < newDimension; i++) {
            for (int j = 0; j < newDimension; j++) {
                toReturn[i][j] = matrix[i][j];
            }
        }
        return toReturn;
    }

    public int[][] division() {
        int[][] mat = {{1, 1, 1, 1, 1, 1},
                       {1, 1, 1, 1, 1, 1},
                       {1, 1, 1, 1, 1, 1},
                       {1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1},
                       {1, 1, 1, 1, 1, 1}};
        
        int resu1[][] = new int[mat.length / 2][mat.length / 2];
        int resu2[][] = new int[mat.length / 2][mat.length / 2];
        int resu3[][] = new int[mat.length / 2][mat.length / 2];
        int resu4[][] = new int[mat.length / 2][mat.length / 2];

        for (int i = 0; i < mat.length / 2; i++) {
            for (int j = 0; j < mat.length / 2; j++) {
                resu1[i][j] = mat[i][j];
                resu2[i][j] = mat[i][j + mat.length / 2];
                resu3[i][j] = mat[i + mat.length / 2][j];
                resu4[i][j] = mat[i + mat.length / 2][j + mat.length / 2];
            }
        }

        //configurando el primer cuadrante
        for (int i = 1; i < resu1.length; i++) {
            for (int j = 0; j < resu1[0].length; j++) {
                if (j < i) {
                    resu1[i][j] = 0;
                }
            }
        }

        // configurar segundo cuadrante
        for (int i = 0; i < resu2.length; i++) {
            for (int j = 0; j < resu2[0].length; j++) {
                if (i + j >= resu2.length - 1) {
                    resu2[i][j] = 1;
                } else {
                    resu2[i][j] = 0;
                }

            }

        }

        // configuracion de ltercer cuadrante
//        int L1 = resu3.length;
//        
//        for(int i=0;i<resu3[0].length;i++){
//			for(int j=0;j<resu3.length;j++){
//				if(j<i){
//                                resu3[j][i]=0;
//                }
//			}
//		}
//
//    int aux[][]=new int [resu3.length][resu3.length];
//        for (int i = aux.length-1; i >0; i--) {
//            for (int j = aux[0].length-1; j > 0; j--) {
//               aux[i][j]=resu3[i][j];
//                
//            }
//            
//        }
    
    
    
    
    
    


        // configurar el cuarto cuadrante
        for (int j = 1; j < resu4.length; j++) {
            for (int i = 0; i < resu4.length; i++) {
                if (i < j) {
                    resu4[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < resu4.length; i++) {
            for (int j = 0; j < resu4[0].length; j++) {
                System.out.print(resu4[i][j]);

            }
            System.out.println("");

        }
        return resu2;
    }

    public void generarMolino() {
        int n = 6;
        int h = 0;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Primer cuadrante
                if (i < n / 2 && j < n / 2) {
                    if (i <= j) {
                        mat[i][j] = 1;
                    } else {
                        mat[i][j] = 0;
                    }
                }
                //Segundo cuadrante
                if (i < n / 2 && j >= n / 2) {
                    h = i + n / 2;
                    if (i <= j) {
                        mat[i][j] = 1;
                    } else {
                        mat[i][j] = 0;
                    }
                }
                //Tercer cuadrante
                if (i >= n / 2 && j < n / 2) {
                    if (i >= j) {
                        mat[i][j] = 1;
                    } else {
                        mat[i][j] = 0;
                    }
                }
                //Cuarto cuadrante
                if (i >= n / 2 && j >= n / 2) {
//                    h = i + n/2;
                    if (i >= j) {
                        mat[i][j] = 1;
                    } else {
                        mat[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");

            }
            System.out.println("");

        }
        setMatriz(mat);


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
        // matriz de prueba que esta en la letra
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
        //Primera idea de esto, esta mal pero es un inicio. Seguir pensando
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < mat.length; i++){
//            for(int j = 0; j < mat[0].length; j++){
//                //guardo la primer fila en el map
//                if (i == 0) {
//                    map.put(mat[0][j], 1);
//                }
//                //si hay un elemento de la fila actual presente en el map, sumo uno a su valor
//                if (i > 0 && map.containsKey(mat[i][j]) && map.get(mat[i][j]) == i){
//                    map.put(mat[i][j], i + 1);
//                }
//            }
//        }
//        int valorMin = MAX_VALUE;
//        int filas = 0;
//        //Creo un iterador y busco el menor 'Key' que tengo un 'Value' mayor que uno
//        Iterator it = map.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry entrada = (Map.Entry)it.next();
//            //Recorro el map hasta encontrar un elemento que se repite en alguna columna
//            if(entrada.getValue() > 1){
//                //Chequeo si es igual al menor key
//                if(valorMin <= entrada.getKey()){
//                    //Cuento la cantidad de veces que entre al minimo valor.
//                    filas++;
//                    valorMin = entrada.getKey();
//                }
//            }
//        }
//        if(filas == mat.length){
//            return Integer.toString(valorMin);
//        } else {
//            return "NO TIENE";
//        }

    }

    public boolean reacomodar(int m, int n) {
        int[][] mat = getMatriz();
//        int m,n;
//        m=1;
//        n=4;
//        
//        int[][] mat = {{1,2},
//                       {3,4}};
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

//            for (int i = 0; i < aux.length; i++) {
//                for (int j = 0; j < aux[0].length; j++) {
//                    System.out.print(aux[i][j]);
//                }
//                System.out.println();
//            }
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
//        int[][] mat = {{2,4,2},
//                       {5,1,5},
//                       {7,4,7}};

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
