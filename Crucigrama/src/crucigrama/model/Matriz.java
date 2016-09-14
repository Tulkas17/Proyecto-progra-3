package crucigrama.model;

public class Matriz {

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new char[filas][columnas];
    }

    public double getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public double getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        r.append(String.format(
                "%s; %s",
                filas, columnas));

        r.append("}");

        return r.toString();
    }

    public void llenaDeAsteriscos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = '*';
            }

        }

    }

    public void imprimirMatriz() {
        for (char[] matriz1 : matriz) {
            System.out.print("|");
            for (int y = 0; y < matriz1.length; y++) {
                System.out.print(matriz1[y]);
                if (y != matriz1.length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }

    private double filas;
    private double columnas;
    public char matriz[][];
}
