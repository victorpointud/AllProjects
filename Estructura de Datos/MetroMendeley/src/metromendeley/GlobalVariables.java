
package metromendeley;

/**
 *
 * @author victorpointud
 */

public class GlobalVariables {
    
    private static HashTable table = new HashTable(1000);
    private static List list = new List(null);
    private static ListObject objects = new ListObject(null);

    /**
     * @return the table
     */
    public static HashTable getTable() {
        
        return table;
    }

    /**
     * @param aTable the table to set
     */
    public static void setTable(HashTable aTable) {
        
        table = aTable;
    }

    /**
     * @return the list
     */
    public static List getList() {
        
        return list;
    }

    /**
     * @param aLista the list to set
     */
    public static void setList(List aList) {
        
        list = aList;
    }

    /**
     * @return the objects
     */
    public static ListObject getObjects() {
        
        return objects;
    }

    /**
     * @param aObjetos the objects to set
     */
    public static void setObjects(ListObject aObjects) {
        
        objects = aObjects;;
    }
    
}
