
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class GlobalVariables {
    
    // Métodos.
    
    private static ListWarehouse listWarehouse = new ListWarehouse(null);
    private static ListProducts tempListProducts = new ListProducts(null);
    private static String LetterOfWarehouseBuy = null;
    private static Cart cart = new Cart(null);
    private static String bfs = null;
    private static String dfs = null;
    private static String[] info = new String[5];
    private static String path = "";
    private static String prepath = "test\\amazon.txt";

    
    // Getters y Setters.
    
    public static String getPrepath() {
        return prepath;
    }

    public static void setPrepath(String prepath) {
        GlobalVariables.prepath = prepath;
    }
    
    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        GlobalVariables.path = path;
    }

    public static Cart getCart() {
        return cart;
    }

    public static void setCart(Cart cart) {
        GlobalVariables.cart = cart;
    }

    public static String getLetterOfWarehouseBuy() {
        return LetterOfWarehouseBuy;
    }

    public static void setLetterOfWarehouseBuy(String LetterOfWarehouseBuy) {
        GlobalVariables.LetterOfWarehouseBuy = LetterOfWarehouseBuy;
    }

    public static ListWarehouse getListWarehouse() {
        return listWarehouse;
    }

    public static void setListWarehouse(ListWarehouse listWarehouse) {
        GlobalVariables.listWarehouse = listWarehouse;
    }

    public static ListProducts getTempListProducts() {
        return tempListProducts;
    }

    public static void setTempListProducts(ListProducts tempListProducts) {
        GlobalVariables.tempListProducts = tempListProducts;
    }

    public static String getBfs() {
        return bfs;
    }

    public static void setBfs(String Bfs) {
        GlobalVariables.bfs = Bfs;
    }

    public static String getDfs() {
        return dfs;
    }

    public static void setDfs(String Dfs) {
        GlobalVariables.dfs = Dfs;
    }

    public static String[] getInfo() {
        return info;
    }

    public static void setInfo(String[] Info) {
        GlobalVariables.info = Info;
    }

    
}
