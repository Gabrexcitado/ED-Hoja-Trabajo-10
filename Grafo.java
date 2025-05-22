import java.util.Arrays;

/**
 * Clase que representa un grafo dirigido con pesos en los arcos.
 * Utiliza una matriz de adyacencia
 * Adaptado de GeekForGeeks
 * https://www.geeksforgeeks.org/adjacency-matrix-of-directed-graph/
 */

public class Grafo {
    public static final int INF = 100000000; // "valor de infinito"
    private int[][] matriz;
    private int size;

    /**
     * Constructor de la clase Grafo
     * @param size tamaño del grafo
     */
    public Grafo(int size) {
        this.size = size;
        matriz = new int[size][size];
        for (int i = 0; i < size; i++)
            Arrays.fill(matriz[i], INF);
        for (int i = 0; i < size; i++)
            matriz[i][i] = 0;
    }

    /**
     * Agrega un arco al grafo
     * @param origen nodo de origen
     * @param destino nodo de destino
     * @param peso peso del arco
     */
    public void agregarArco(int origen, int destino, int peso) {
        matriz[origen][destino] = peso;
    }

    /**
     * Elimina un arco del grafo
     * @param origen nodo de origen
     * @param destino nodo de destino
     */
    public void eliminarArco(int origen, int destino) {
        matriz[origen][destino] = INF;
    }

    /**
     * Devuelve la matriz de adyacencia del grafo
     * @return matriz de adyacencia
     */
    public int[][] obtenerMatriz() {
        return matriz;
    }
}
