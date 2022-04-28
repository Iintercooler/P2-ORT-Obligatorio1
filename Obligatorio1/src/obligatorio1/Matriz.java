package obligatorio1;

public class Matriz {

    int[][] matrizDeTrabajo;

    public void cargarMatrizEsquina(int n, int desde) {
    }

    public void cargarPuntas(int n) {
    }

    public boolean esConectada() {
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
        return true;
    }

    public void setMatriz(int[][] mat) {
    }

    public boolean tieneFilaIgual() {
        return true;
    }

}
