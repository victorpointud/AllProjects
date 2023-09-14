
package proyectoamazon;
/**
 *
 * @author luisarismendi
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author victorpointud
 */

public class Functions {
    
    public String readText() {
        String line;
        String Text = "";
        String path = GlobalVariables.getPath();
        if (path.equals("")) {
            path = GlobalVariables.getPrepath();
        }
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        Text += line + "\n";
                    }
                }
                br.close();
                return Text;
            }
        } catch (Exception ex){
            return "";
        } 
        return Text;
    }
    
    public ListWarehouse createObjects (String Text) {
        
        if (!"".equals(Text)) {
            
            String[] TextLineSplit = Text.split("\n");

            int index = 0;
            while (!TextLineSplit[index].equals("Rutas;") && index < TextLineSplit.length) {
                index++;
            }
            int indexRoute = index;
            
            index = 0;
            String[] WarehouseStringList = new String[indexRoute-1];
            for (int i = 1; i < indexRoute; i++) {
                String result = TextLineSplit[i];
                WarehouseStringList[index] = result;
                index++;
            }
             
            index = 0;
            int lengthVertexArray = TextLineSplit.length - (indexRoute+1);
            String[] VertexStringList = new String[(lengthVertexArray)];
            for (int i = indexRoute+1; i < TextLineSplit.length; i++) {
                String result = TextLineSplit[i];
                VertexStringList[index] = result;
                index++;
            }
            
            index = 0;
            ListWarehouse warehouseList = new ListWarehouse(null);
            while (index < WarehouseStringList.length) {
                boolean isWarehouse = WarehouseStringList[index].startsWith("Almacen ");
                if (isWarehouse) {
                    String WarehouseLetter = String.valueOf(WarehouseStringList[index].charAt(8));
                    index++;
                    
                    ListProducts listProducts = new ListProducts(null);
                    
                    while (!WarehouseStringList[index].substring(WarehouseStringList[index].length()-1).equals(";")) {
                        String[] ProductArray = WarehouseStringList[index].split(",");
                        String ProductName = ProductArray[0];
                        String ProductQuantity = ProductArray[1];
                        Product product = new Product(ProductName, Integer.parseInt(ProductQuantity));
                        listProducts.insertEnd(product);
                        index++;
                    }
  
                    WarehouseStringList[index] = WarehouseStringList[index].replace(";","");
                    String[] ProductArray = WarehouseStringList[index].split(",");
                    String ProductName = ProductArray[0];
                    String ProductQuantity = ProductArray[1];
                    Product product1 = new Product(ProductName, Integer.parseInt(ProductQuantity));
                    listProducts.insertEnd(product1);
                    
                    Warehouse wa = new Warehouse(WarehouseLetter, listProducts);
                    warehouseList.insertEnd(wa);
                    index++;
                } 
            }
            
            index = 0;
            while (index < VertexStringList.length) {
                String[] VertexArray = VertexStringList[index].split(",");
                String vertexName = VertexArray[0];
                String link = VertexArray[1];
                String size = VertexArray[2];
                        
                String[] linkArray = new String[2];
                linkArray[0] = link;
                linkArray[1] = size;
                
                NodeWarehouse pointer = warehouseList.getHead();
                while (pointer.getNext() != null && !pointer.getElement().name.equals(vertexName)) {
                    pointer = pointer.getNext();
                }
                pointer.getElement().links.insertEnd(linkArray);
                index++;
                }

                return warehouseList;
            }
          return null;
        }
        
    public void writeText(ListWarehouse listWarehouse) {
        String amazonText = "Almacenes;\n";
        if (!listWarehouse.isEmpty()) {
            NodeWarehouse tempWarehouse = listWarehouse.getHead();
            for (int i = 0; i < listWarehouse.getLength(); i++) {
                amazonText += "Almacen " + tempWarehouse.getElement().getName() + ":\n";
                
                NodeProduct tempProduct = tempWarehouse.getElement().getListOfProducts().getHead();
                for (int j = 0; j < tempWarehouse.getElement().getListOfProducts().getLength(); j++) {
                    amazonText += tempProduct.getElement().getName() + "," + tempProduct.getElement().getQuantitiy();
                    tempProduct = tempProduct.getNext();
                    if (j == tempWarehouse.getElement().getListOfProducts().getLength() -1) {
                        amazonText += ";\n";
                    } else {
                        amazonText += "\n";
                    }
                }
                tempWarehouse = tempWarehouse.getNext();
            }
            
            amazonText += "Rutas;\n";
            
            tempWarehouse = listWarehouse.getHead();
            for (int i = 0; i < listWarehouse.getLength(); i++) {
                NodeOfArrays tempArray = tempWarehouse.getElement().getLinks().getHead();
                for (int j = 0; j < tempWarehouse.getElement().getLinks().getLength(); j++) {
                    amazonText += tempWarehouse.getElement().getName() + "," + tempArray.getElement()[0] + "," + tempArray.getElement()[1] + "\n";
                tempArray = tempArray.getNext();
                }
                tempWarehouse = tempWarehouse.getNext();
            }
            
        }
        try {
        String path = GlobalVariables.getPath();
        if (path.equals("")) {
            path = GlobalVariables.getPrepath();
        }
            PrintWriter pw = new PrintWriter(path);
            pw.print(amazonText);
            pw.close();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }
    
    public void addWarehouse (ListWarehouse listWarehouse, String name) {
        NodeWarehouse pointer = listWarehouse.getHead();
        boolean letterIsIn = false;
        while (pointer != null) {
            if (!pointer.getElement().name.equals(name)) {
                letterIsIn = true;
            }
        }
        
        boolean keepGoing = true;
        while (keepGoing) {
            if (!letterIsIn) {
                ListProducts lo = new ListProducts(null);
                Warehouse wa = new Warehouse(name, lo);
                String warehouseLetter1 = "r";
                String size1 = "r";
                wa.addLink(warehouseLetter1, size1);
                String warehouseLetter2 = "r";
                String size2 = "r";
                wa.addLink(warehouseLetter1, size1);
                wa.addLink(warehouseLetter2, size2);
                listWarehouse.insertEnd(wa);
                keepGoing = false;
            } else {
                System.out.println("El almacen "+ name + "ya existe. Intente de nuevo.");
            }
        }
        
    }
    
    }