package obligatorio1;

import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

                    if ((f > 0 && f < mat.length - 1) && (c > 0 && c < mat[0].length - 1)) {
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

    /* Retorna el menor elemento comuno que tienen todas las filas, si no hay, retorna "no tiene" */
    public String menorComunFilas() {
       // matriz de prueba que esta en la letra
        int mat[][] = {{1, 5, 8, 4, 2},
                       {5, 2, 0, 7, 9},
                       {-3, 8, 5, -2, 2},};

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
        resultado = String.valueOf(Collections.min(comunes));
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

    public boolean reacomodar(/*int m, int n*/) {
//        int[][] mat = getMatriz(); 
        int m,n;
        m=1;
        n=6;
        
        int[][] mat = {{1,2},
                       {3,4}};
        boolean sePuede = true;
        //Tomo la matriz de trabajo y creo un 
        //booleano para comprobar la condicion de que se pueda
        //Chequeo la condicion, 
        //misma cantidad de elementos en total
        //En caso de que se pueda, creo un indice y una matriz auxiliar
        //recorro la matriz original llenando la nueva como corresponda
        //actualizo el indice, para terminar se setea la matriz aux como
        //matriz de trabajo.
        if(mat.length * mat[0].length != m * n){ 
            sePuede = false;
        } else {
            int indice = 0;
            int[][] aux = new int[m][n];
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[0].length; j++ ){
                    aux[indice / n][indice % n] = mat[i][j];
                    indice++;
                }
            }
            setMatriz(aux);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
            
        }
        
        return sePuede;
    }
//Esto de aca es el set matriz de trabajo que hiciste arriba en la linea 14?? 
//Porque no hay ningun metodo en la letra del obligatorio que diga SetMatrizDe Trabajo.
    public void setMatriz(int[][] mat) {
    }

    public boolean tieneFilaIgual() {
        boolean iguales = true;
//        int[][] mat = getMatriz();
        int[][] mat = {{2,2,2},
                       {4,5,6},
                       {7,8,9}};
        

        
        
        
        for(int i = 0; i < mat.length; i++){
            
            for(int j = 0; j < mat[0].length - 1 && iguales; j++){
                if (mat[i][j] != mat[i][j + 1]){
                    iguales = false;
                }else iguales=true;
            }
           
        }
        return iguales;
    }

}
