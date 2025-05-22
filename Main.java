import java.util.List;
import java.util.Scanner;

/**
 * @author Gabriel Hidalgo 24939
 * Fecha de creacion: 22/05/2025
 * Última edicion:
 * Descripcion: Clase principal para probar el algoritmo de Floyd-Warshall
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Grafo del ejercicio
        Grafo grafo = new Grafo(5);
        grafo.agregarArco(0, 1, 3); // A a B
        grafo.agregarArco(0, 3, 7); // A a D
        grafo.agregarArco(1, 2, 1); // B a C
        grafo.agregarArco(1, 4, 8); // B a E
        grafo.agregarArco(2, 3, 2); // C a D
        grafo.agregarArco(3, 4, 3); // D a E
        grafo.agregarArco(4, 0, 4); // E a A

        int[][] dist = grafo.obtenerMatriz(); 
        int[][] next = new int[5][5]; // matriz para almacenar las rutas

        //Aplicar el algoritmo de Floyd-Warshall
        FloydWarshall.floydWarshall(dist, next);

        
        int opcion = -1;

        //Menu
        while(opcion != 0){
            System.out.print("\n\n/////////////////////-----MENU-----/////////////////////"+ 
            "\n1. Mostrar ruta más corta entre dos nodos" +
            "\n2. Mostrar centro del grafo" +
            "\n0. Salir" +
            "\n\nElija una opción: ");
    
            opcion = sc.nextInt();
    
            switch(opcion){
                case 1:
                 System.out.print("\n0. Guatemala (A) \n1. Zacapa (B)  \n2. Chiquimula (C) \n3. Quetzaltenango (D) \n4. Coban (E) \n\nIngrese el nodo de origen : ");
                    int origen = sc.nextInt();
                    System.out.print("\n0. Guatemala (A) \n1. Zacapa (B)  \n2. Chiquimula (C) \n3. Quetzaltenango (D) \n4. Coban (E) \n\nIngrese el nodo de destino : ");
                    int destino = sc.nextInt();
    
                    List<Integer> ruta = FloydWarshall.getPath(origen, destino, next);
                    if (ruta != null) {
                        System.out.print("Ruta más corta: ");
                        for (int nodo : ruta) {
                            System.out.print((char)('A' + nodo) + " ");
                        }
                    } else {
                        System.out.println("No hay ruta entre los nodos seleccionados.");
                    }
                    break;
    
                case 2: 
                    System.out.println("Centro del grafo: " + (char)('A' + FloydWarshall.calcularCentro(dist)));
                    break;
    
                case 0:
                    System.out.println("Saliendo...");
                    sc.close();
                    break;
            }
        }
        
    }
}
