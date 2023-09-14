package proyectoislas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.graphstream.graph.Graph;   
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author CarlosEGonR & Juan2808
 */

/**
* Esta clase corresponde a la representación de un grafo ponderado no dirigido, y contiene una lista enlazada
* de los nodos insertados (los usuarios) y una lista de adyacencia que representa los arcos entre nodos.
* Cada elemento de la lista de adyacencia es una lista de arcos que contienen una referencia a los nodos
* que conecta dicho nodo y sus respectivos años de amistad (pesos). 
*/
public class UndirectedGraph {
    public LinkedList<User> nodes;
    public LinkedList<LinkedList<Edge>> adjList;

    /**
    * Obtiene los Nodos.
    */
    public LinkedList<User> getNodes() {
        return nodes;
    }

    /**
    * Setea los Nodos.
    */
    public void setNodes(LinkedList<User> nodes) {
        this.nodes = nodes;
    }

    /**
    * Obtiene la Lista de Adjacencia.
    */
    public LinkedList<LinkedList<Edge>> getAdjList() {
        return adjList;
    }

    /**
    * Setea la Lista de Adjacencia.
    */
    public void setAdjList(LinkedList<LinkedList<Edge>> adjList) {
        this.adjList = adjList;
    }
      
    /**
    * Crea el grafo dado el archivo de texto en la dirección 'pathname'.
    */
    public UndirectedGraph(String pathname){
        nodes = new LinkedList<>();
        try {
            File inFile = new File(pathname);
            Scanner reader = new Scanner(inFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.equals("Usuarios")){
                    data = reader.nextLine();
                    while (!data.equals("Relaciones") ) { 
                        String[] nodeInfo= data.split(", ");
                        int id = Integer.parseInt(nodeInfo[0]);
                        String name = nodeInfo[1];
                        User newUser = new User(id, name);
                        this.nodes.append(newUser);
                        data = reader.nextLine();
                    }
                    if(data.equals("Relaciones")){
                        initAdjList();
                        while (reader.hasNextLine()) {
                            data = reader.nextLine();
                            String[] edgeInfo = data.split(", ");
                            int id1 = Integer.parseInt(edgeInfo[0]);
                            int id2 = Integer.parseInt(edgeInfo[1]);
                            int years = Integer.parseInt(edgeInfo[2]); 
                            addEdge(id1, id2, years);
                        }
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir el archivo");
        }
    }
    
    /**
    * Inicializa la lista de adyacencia según el número de nodos insertados.
    */
    public void initAdjList(){
        this.adjList = new LinkedList<>();
        int n = getNodes().getSize();
        for (int i = 0; i < n; i++){
            this.adjList.append(new LinkedList<>());
        }
    }
    
    /**
    * Añade un nuevo nodo al grafo.
    */
    public void addNode(int id, String user) {
        User newUser = new User(id, user);
        getNodes().append(newUser);
        getAdjList().append(new LinkedList<>());
    }
    
    /**
    * Añade un nuevo arco al grafo.
    */
    public void addEdge(int id1, int id2, int weight){
        int i = indexOf(id1);
        int j = indexOf(id2);                  
        getAdjList().get(i).getData().append(new Edge(j, weight));
        getAdjList().get(j).getData().append(new Edge(i, weight));
    }
    
    /**
    * Eliminar un nodo del grafo.
    */
    public void deleteNode(int userID){
        int userIndex = indexOf(userID);
        for(int i=0; i < this.nodes.getSize(); i++){
            LinkedList<Edge> iEdges = this.adjList.get(i).getData();
            for(int j=0; j < iEdges.getSize(); j++){
                Edge e =  iEdges.get(j).getData();
                if(e.getVertex() == userIndex)
                    iEdges.delete(e);
            }
        }
        for(int i=0; i < this.nodes.getSize(); i++){
            LinkedList<Edge> iEdges = this.adjList.get(i).getData();
            for(int j=0; j < iEdges.getSize(); j++){
                Edge e =  iEdges.get(j).getData();             
                if(e.getVertex() > userIndex)
                    e.vertex--;
            }
        }
        User u = this.nodes.get(userIndex).getData();
        this.nodes.delete(u);
        LinkedList<Edge> edges = this.adjList.get(userIndex).getData();
        this.adjList.delete(edges);
    }
    
    /**
    * Obtiene el índice dentro de la lista del usuario con este id.
    * Retorna -1 si no existe un usuario con dicho id.
    */
    public int indexOf(int id){
        Node<User> head = this.nodes.getHead();
        if(head == null) 
            return -1;
        if(head.getData().getId() == id)
            return 0;
        int index = 1;
        Node<User> current = head;
        while(current.getNext() != null){
            if(current.getNext().getData().getId() == id)
                return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }
    
    /**
    * Verifica que el ID del nodo a insertar no se encuentre en uso.
    */
    public boolean checkExistsID(int id){
        for(int i=0; i < this.nodes.getSize(); i++){
            User user = this.nodes.get(i).getData();
            if (user.getId() == id)
                return true;
        }
        return false;
    }
    
    /**
    * Verifica que el arco a insertar no exista previamente en el grafo.
    */
    public boolean checkExistsEdge(int id1, int id2){
        int i = indexOf(id1);
        int j = indexOf(id2);
        Node<Edge> edge = this.adjList.get(i).getData().get(j);
        if(edge == null){
            return false;
        } else {
            return true;
        }
    }
    
    /**
    * Dada un arreglo booleano de nodos visitados, y un nodo de comienzo
    * realiza el recorrido BFS iterativa através del grafo y lo retorna en un string.
    */
    public String BFS(int start, boolean[] visited){
        String component = ""; 
        LinkedList<Integer> list = new LinkedList<>();
        list.append(start);
        visited[start] = true;
        while (list.getSize() > 0){
            int v = list.get(0).getData();
            int userId = this.nodes.get(v).getData().getId();
            component =  component.concat(Integer.toString(userId) + " ");
            list.delete(v);
            int n = this.adjList.get(v).getData().getSize();
            for(int i = 0; i < n; i++){
                Edge e = this.adjList.get(v).getData().get(i).getData();
                if (!visited[e.getVertex()]){
                    list.append(e.getVertex());
                    visited[e.getVertex()] = true;
                }
            }
        }
        return component;
    }

    /**
    * Dada un arreglo booleano de nodos visitados, y un nodo de comienzo
    * realiza el recorrido DFS de manera recursiva através del grafo y lo retorna en un string.
    */
    public String DFS(int start, boolean[] visited){
        String component = (this.nodes.get(start).getData().getId() + " ");
        visited[start] = true; 
        int n = this.adjList.get(start).getData().getSize();
        for(int i = 0; i < n; i++){
            Edge e = this.adjList.get(start).getData().get(i).getData();
            if (!visited[e.getVertex()] && e.getWeight() > 0)
                component += DFS(e.getVertex(), visited);
        }
        return component;
    }

    /**
    * Determina el número de componentes conectadas (islas) que hay en el grafo.
    */
    public int connectedComponents(){
        int components = 0;
        int n = this.nodes.getSize();
        boolean[] visited = new boolean[n];
        for(int i=0; i < n; i++)
            visited[i] = false;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                DFS(i, visited);
                components++;
            }
        }
        return components;
    }
    
    /**
    * Determina los arcos puente presentes en el grafo al calcular el número de islas 
    * (componentes conectadas) antes y después de retirar cada arco del grafo, si el número
    * de islas aumenta, entonces ese arco es un puente.
    */
    public String getBridges(){
        String bridges = "";
        int n = nodes.getSize();
        for(int i=0; i < n; i++){
            LinkedList<Edge> iEdges = this.adjList.get(i).getData();
            for(int j=0; j < iEdges.getSize(); j++){
                Edge e =  iEdges.get(j).getData();
                int temp = e.getWeight();
                int islandsBefore = connectedComponents();
                e.weight = -1;
                int islandsAfter = connectedComponents();
                e.weight = temp;
                if(islandsAfter > islandsBefore){
                    int idUserI = this.nodes.get(i).getData().getId();
                    int idUserJ = this.nodes.get(e.getVertex()).getData().getId();
                    bridges += ("(" + idUserI + ", " + idUserJ + ", " + e.getWeight() + ")\n");
                }
            }
        }
        return bridges;
    }
    
    /**
    * Da el número de nodos en el grafo.
    */
    public int nodesLength(){
        return this.nodes.getSize();
    }
    
    /**
    * Data una etiqueta para la interfaz correspondiente al nodo en la posición 'index'.
    */
    public String getUserLabel(int index){
        User u = this.nodes.get(index).getData();
        String label = Integer.toString(u.getId()) + " - " + u.getUser();
        return label;
    }
    
    /**
    * Dibuja en la interfaz el grafo.
    */
    public Graph draw(){
        System.setProperty("org.graphstream.ui", "swing");
        Graph drawGraph = new SingleGraph("Grafo");
        drawGraph.setAttribute("ui.antialias");
        drawGraph.setAttribute("ui.stylesheet", "node{\n" +
                "    fill-color: #8E44AD;\n" + 
                "    text-size: 15; " +
                "}" + 
                "edge {  text-size: 15; }" );
        for(int i=0; i < this.nodes.getSize(); i++){
            int id = this.nodes.get(i).getData().getId();
            drawGraph.addNode(Integer.toString(id)).setAttribute("ui.label", Integer.toString(id));
        }
        for(int i=0; i <  nodes.getSize(); i++){
            LinkedList<Edge> iEdges = adjList.get(i).getData();
            for(int j=0; j < iEdges.getSize(); j++){
                Edge e =  iEdges.get(j).getData();
                String id1 = Integer.toString(nodes.get(i).getData().getId());
                String id2 = Integer.toString(nodes.get(e.getVertex()).getData().getId());
                String weight = Integer.toString(e.getWeight());
                try{
                    drawGraph.addEdge(id1 + id2, id1, id2).setAttribute("ui.label",weight);
                } catch(Exception ex) {
                    continue;
                }
            }
        }
        return drawGraph;
    }
    
    /**
    * Escribe los nodos del grafo en el archivo.
    */
    public void writeNodes(FileWriter myWriter){
        for(int i=0; i < this.nodes.getSize(); i++){
            User user = this.nodes.get(i).getData();
            try {
                myWriter.write(user.getId() + ", " + user.getUser() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
    * Escribe los arcos del grafo en el archivo.
    */
    public void writeEdges(FileWriter myWriter){
        for(int i=0; i < this.nodes.getSize(); i++){
            LinkedList<Edge> iEdges = this.adjList.get(i).getData();
            for(int j=0; j < iEdges.getSize(); j++){
                Edge e =  iEdges.get(j).getData();
                int userID1 = this.nodes.get(i).getData().getId();
                int userID2 = this.nodes.get(e.getVertex()).getData().getId();
                int weight = e.getWeight();
                if(userID1 > userID2){
                    try {
                        myWriter.write(userID1 + ", " + userID2 + ", " + weight + "\n");
                    } catch (IOException f) {
                        f.printStackTrace();
                    } 
                }
            }
        }
    }
}
