
/**
 * @author Abi Cohen
 * @version 5
 */
public class Item
    {
    private String description;
    private String name; 
    private String toRead; 

    public Item(String n, String description, String read)
    {
        this.description = description;
        name=n; 
        toRead=read; 
    }

    public String getItemDescription()
    {
        return description;
    }
    
    public String getItemName()
    {
        return name;
    }
    
    public String read(){
        return toRead; 
    }
}