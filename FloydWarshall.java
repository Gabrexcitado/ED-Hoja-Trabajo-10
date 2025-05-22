import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el algoritmo de Floyd-Warshall para encontrar
 * las distancias más cortas entre todos los pares de nodos en un grafo
 * dirigido con pesos.
 * También permite encontrar el centro del grafo.  
 * Adaptado de GeeksForGeeks
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 */
public class FloydWarshall {
    public static final int INF = 100000000;

    /**
     * Implementa el algoritmo de Floyd-Warshall para encontrar las distancias
     * @param dist matriz de distancias entre nodos
     * @param next matriz para almacenar los nodos intermedios en el camino más corto
     */
    public static void floydWarshall(int[][] dist, int[][] next) {
        int V = dist.length;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] != INF && i != j)
                    next[i][j] = j;
                else
                    next[i][j] = -1;
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }
        }
    }

    /**
     * Devuelve la ruta más corta entre dos nodos
     * @param u nodo de origen
     * @param v nodo de destino
     * @param next matriz que almacena los nodos intermedios 
     * @return lista de nodos en la ruta más corta
     */
    public static List<Integer> getPath(int u, int v, int[][] next) {
        if (next[u][v] == -1) return null;
        List<Integer> path = new ArrayList<>();
        path.add(u);
        while (u != v) {
            u = next[u][v];
            path.add(u);
        }
        return path;
    }

    /**
     * Calcula el centro del grafo
     * @param dist matriz de distancias entre nodos
     * @return nodo central
     */
    public static int calcularCentro(int[][] dist) {
        int centro = -1;
        int menorExcentricidad = INF;
        int V = dist.length;

        for (int i = 0; i < V; i++) {
            int max = 0;
            for (int j = 0; j < V; j++) {
                if (dist[i][j] < INF) {
                    max = Math.max(max, dist[i][j]);
                }
            }
            if (max < menorExcentricidad) {
                menorExcentricidad = max;
                centro = i;
            }
        }
        return centro;
    }
}