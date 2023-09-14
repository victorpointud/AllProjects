
package metromendeley;

import javax.swing.JOptionPane;

/**
 *
 * @author victorpointud
 */
public class InfoObject {
    
    private String title;
    private String[] authors;
    private String summary;
    private String[] keywords;
    
    public InfoObject(){
        
        title = null;
        authors = null;
        summary = null;
        keywords = null;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the authors
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * @param autores the authors to set
     */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the keywords
     */
    public String[] getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
    
    /**
     *
     * @return the info
     */
    public String createInfo(){
        
        Functions v = new Functions();
        String p = "";
        p += "\n Titulo:\n" + "    " + getTitle() + "\n\n" + "Autores:" + "\n";
        for (int i = 0; i < getAuthors().length; i++) {
            
            p += "    " + getAuthors()[i] + "\n";
        }
        p += "\n Palabras claves: \n";
        for (int i = 0; i < getKeywords().length; i++) {
            
            p += "    " +  getKeywords()[i] + ": " + v.countWords(getSummary(), getKeywords()[i]) + "\n";
        }
        return p;
    }

}
    

