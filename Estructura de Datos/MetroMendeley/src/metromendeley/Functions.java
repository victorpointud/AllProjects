
package metromendeley;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author victorpointud
 */

public class Functions {
    
    /**
     *
     * @param path the text read
     * @return the text
     */
    public String readText(String path) {
        
        String line;
        String Text = "";
        File file = new File(path);
        try {
            
            if (!file.exists()) {
                
                file.createNewFile();
            } 
            else {
                
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
        } 
        catch (Exception ex){
            
            return "";
        } 
        return Text;
    }
    
    /**
     *
     * @param Text the objects created
     * @return the info
     */
    public InfoObject createObjects(String Text){  
        
        
        InfoObject info = new InfoObject();
        String title = "";
        String author = "";
        String summary = "";
        String keyword = "";
        int aux = 0;
        if (!"".equals(Text)){   
            String[] textLineSplit = Text.split("\n");           
            for (int i = 0; i < textLineSplit.length; i++) {
                if (textLineSplit[i].equals("Autores")) {
                    break;
                }   
                aux += 1;
                title += " "+textLineSplit[i];  // se crea el titulo
            }
            title = title.replace("\n", " ").trim();
            
            for (int i = aux + 1; i < textLineSplit.length; i++) { 
                if (textLineSplit[i].equals("Resumen")) {
                    break;
                }  
                aux += 1;
                author += textLineSplit[i].replace("-", " ") + ",";   // se crean los autores string                      
               } 
 
            for (int i = aux + 1 ; i < textLineSplit.length; i++) { // pendiente con el +1 del aux
                if (textLineSplit[i].contains("Palabras claves:") || textLineSplit[i].contains("Palabras Claves:")) {
                    break;
                }  
                aux += 1;
                summary += " "+textLineSplit[i];     //  se crea el resumen               
               }
            summary = summary.replace("Resumen", "").trim();
            
            
            for (int i = aux + 1; i < textLineSplit.length; i++){ 
                keyword += textLineSplit[i];
                }
            }
            if (keyword.contains("Palabras claves:") || keyword.contains("Palabras Claves:")) {
                    keyword = keyword.replace("Palabras claves: ", "").replace("y", ",").replace(".", "").replace(", ", ",");
                    keyword = keyword.replace("Palabras Claves: ", "").replace("y", ",").replace(".", "").replace(", ", ",");
                }  
            String[] keywords = keyword.split(","); // se crean palabras claves string[]
           
               
        String[] authors = author.split(",");
        
        info.setTitle(title);
        info.setAuthors(authors);
        info.setSummary(summary);
        info.setKeywords(keywords);
        
        return info;
    }
    
    /**
     *
     * @param summary the text wrote
     */
    public void writeText(String summary){
        
        try {
            
            String path = "test\\total.txt";
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("test\\total.txt"), true ));
            pw.append("\n" + summary);
            pw.close();
        } 
        catch (Exception err) {
            
            JOptionPane.showMessageDialog(null, err);
        }      
    }
    
    /**
     *
     * @param summary the summary
     * @param word the word
     * @return the counter
     */
    public int countWords(String summary, String word){
        int counter = 0;
        summary = summary.toLowerCase();
        word = word.toLowerCase();

        while (summary.contains(word)) {
            summary = summary.substring(summary.indexOf(
            word) + word.length(), summary.length());
            counter++;
        }
        return counter;
    }
     
}
