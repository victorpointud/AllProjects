
package proyectoamazon;

/**
 *
 * @author luisarismendi
 */

public class Cola<T> {
    private NodoCola<T> primero;
    private NodoCola<T> ultimo;
    private int tamaño;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;       
    }

    public T getCabeza() {
        if (this.primero != null){
            return this.primero.getElemento();
        }     
        return null;
    }

    public void setCabeza(NodoCola primero) {
        this.primero = primero;
    }

    public NodoCola getFin() {
        return ultimo;
    }

    public void setFin(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public void encolar(T info) {
        NodoCola<T> nodo = new NodoCola(info);
        if (this.primero == null) {
            this.primero = nodo;
        }else{
            this.ultimo.setSiguiente(nodo);
        }
        this.ultimo = nodo;
        this.tamaño++;
        }

    
    public void desencolar() {
        if (this.primero != null) {
            this.primero = this.primero.getSiguiente();
            this.tamaño--;
        }
    }
    
    public boolean existe(T info){
        NodoCola<T> aux = this.primero;
        while(aux!=null){
            if (aux.getElemento() == info) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    public boolean estaVacio() {
        return getCabeza() == null;
    }
    
    public void printCola(){
        NodoCola<T> nodo = this.primero;
        if (this.primero == null) {
            System.out.println("La cola esta vacia");;
        }else{
            while(nodo.getSiguiente() != null){
                System.out.println(nodo.getElemento());
                nodo = nodo.getSiguiente();
            }
            System.out.println(nodo.getElemento());
            
        }
        this.ultimo = nodo;
        this.tamaño++;
        }


    
    
    }
