
package metromendeley;

import javax.swing.JOptionPane;


/**
 *
 * @author victorpointud
 */

public class HashTable {
    Nodo[] table; 
    int size;
    
    public HashTable(int size){
        this.size = size; 
        this.table = new Nodo[size]; 
        for (int i = 0; i < size; i++) {
            this.table[i] = null; 
        }
    }
    
    /**
     *
     * @param title hashing
     * @return the index
     */
    public int hashing(String title){
        
        int value = 0;  
        int position = 1; 
        for (int i = 0; i < title.length(); i++) {
            
            if (title.codePointAt(i) == 32){
                
                value += 0;          
            } 
            else if (title.codePointAt(i) >= 48 && title.codePointAt(i) <= 57){
                
                value += ((title.codePointAt(i) - 47) * position);
                
            } 
            else if (title.codePointAt(i) >= 65 && title.codePointAt(i)<= 90){
                
                value += ((title.codePointAt(i) - 54) * position);
                
            } 
            else if (title.codePointAt(i) >= 97 && title.codePointAt(i) <= 122){
                
                value += ((title.codePointAt(i) - 60) * position);
                
            }
            position++; 
        }
        int index = value % size;
        return index; 
    }
    
    /**
     *
     * @param summary the insert
     */
    public void insert(InfoObject summary){
        
        int position = hashing(summary.getTitle()); 
        boolean exist = false; 
        if (this.table[position] != null){  
            
            Nodo temp = this.table[position];
            if (temp.getData().getTitle().equals(summary.getTitle())){
                
                exist = true; 
                JOptionPane.showMessageDialog(null, "El resumen ya ha sido agregado anteriormente."); 
            }
            while (temp.getNext() != null){
                
                temp = temp.getNext(); 
                if (temp.getData().equals(summary)){
                    
                    exist = true;
                    JOptionPane.showMessageDialog(null, "El resumen ya ha sido agregado anteriormente");
                }
            }            
            if (!exist){
                
                Nodo nuevo = new Nodo(summary); 
                temp.setNext(nuevo); 
                System.out.println("Se ha añadido el resumen: " + summary);
                System.out.println("En la posición: " + position);
            }
            
        } 
        else {
            
            Nodo nuevo = new Nodo(summary); 
            this.table[position] = nuevo;  
            System.out.println("Se ha añadido el resumen: " + summary);
            System.out.println("En la posición: " + position);
        }
    }
    
    /**
     *
     * @param summary the search
     * @return the temp
     */
    public Nodo search(InfoObject summary){
        
        boolean exist = false; 
        int position = hashing(summary.getTitle()); 
        if (this.table[position] == null){
            
            return null;
        }
        Nodo temp = this.table[position];
        if (temp.getData().equals(summary)){
            exist = true; 
        } 
        else {
            
            while (temp.getNext() != null && !exist){
                
                if (temp.getData().equals(summary)){
                    
                    exist = true; 
                } 
                else {
                    
                    temp = temp.getNext(); 
                }
            }
        }
        if (exist){
            
            return temp; 
        } 
        else {
            
            return null; 
        }
    }
    
    /**
     *
     * @param summary the search 2
     * @return the exist
     */
    public boolean search2(InfoObject summary){
        
        boolean exist = false; 
        int position = hashing(summary.getTitle()); 
        if (this.table[position] == null){
            
            return false;
        }
        Nodo temp = this.table[position];
        if (temp.getData().getTitle().equals(summary.getTitle())){
            
            exist = true; 
        } 
        else {
            
            while (temp.getNext() != null && !exist){
                
                if (temp.getData().getTitle().equals(summary.getTitle())){
                    
                    exist = true; 
                } 
                else {
                    
                    temp = temp.getNext(); 
                }
            }
        }
        return exist;
    }     
    
    /**
     *
     * @param title the object searched
     * @return the data of temp
     */
    public InfoObject searchObject(String title){ 
        
        int cont = 0;
        Nodo temp = this.table[cont];
        while (temp == null || !temp.getData().getTitle().equals(title)){
            
            cont++;
            temp = this.table[cont];  
        }
        return temp.getData();
    }   
    
    /**
     * empty
     */
    public void empty(){
        
        for (int i = 0; i < size; i++) {
            
            this.table[i] = null; 
        }
    }
}
