import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas Unitarias para la clase grafo
 */
public class GrafoTest {

    //Prueba de creacion de grafo
    @Test
    public void testCrearGrafo() {
        Grafo grafo = new Grafo(5);

        int[][] matriz = grafo.obtenerMatriz();

        for (int i = 0; i < 5; i++) {
            assertEquals(0, matriz[i][i]); // Diagonal debe ser 0 (distancia a sí mismo)
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != j) {
                    assertEquals(Grafo.INF, matriz[i][j]); // Todos los demás deben ser infinitos
                }
            }
        }
    }

    @Test  

    public void testAgregarArco() {
        Grafo grafo = new Grafo(5);
        grafo.agregarArco(0, 1, 10);

        int[][] matriz = grafo.obtenerMatriz();

        assertEquals(10, matriz[0][1]); // Distancia entre 0 y 1 debe ser 10
    }
    
     @Test
    public void testEliminarArco() {
        Grafo grafo = new Grafo(5);
        grafo.agregarArco(0, 1, 10);
        grafo.eliminarArco(0, 1);

        int[][] matriz = grafo.obtenerMatriz();

        assertEquals(Grafo.INF, matriz[0][1]); //ya no debe tener nada el grafo
    }

}
