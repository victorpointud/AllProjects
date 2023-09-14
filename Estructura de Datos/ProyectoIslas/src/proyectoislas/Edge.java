package proyectoislas;

/**
 *
 * @author victorpointud
 */

/**
* Representa un arco en el grafo ponderado, tiene el índice correspondiente 
* al nodo que conecta 'vertex' y un peso 'weight'.
*/
public class Edge {
    int vertex;
    int weight;
    
    public Edge(int vertex, int w) {
        this.vertex = vertex; 
        this.weight = w;
    }
    
    /**
    * Obtiene el Vértice.
    */
    public int getVertex() {
        return vertex;
    }

    /**
    * Setea el Vértice.
    */
    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    /**
    * Obtiene el Peso.
    */
    public int getWeight() {
        return weight;
    }

    /**
    * Setea el Peso.
    */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}