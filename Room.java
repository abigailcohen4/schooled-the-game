/**
 * @author  Abi Cohen
 * @version 5
 */
import java.util.HashMap; 
import java.util.Set; 
import java.util.ArrayList; 
import java.util.Iterator; 

public class Room 
{
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    private HashMap <String, Room> exits= new HashMap <String, Room>();
    private ArrayList <Item> items = new ArrayList <Item>();
    private ArrayList <Characters> characters = new ArrayList <Characters>();
    private String name; 
    private String imageName; 

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String n, String description, String image) 
    {
        name=n; 
        this.description = description;
        imageName=image; 
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null) {
            northExit = north;
        }
        if(east != null) {
            eastExit = east;
        }
        if(south != null) {
            southExit = south;
        }
        if(west != null) {
            westExit = west;
        }
        
        if(north != null){
            exits.put("north", north); 
        }
        if(east != null){
            exits.put("east", east); 
        }
        if(south != null){
            exits.put("south", south); 
        }
        if(south != null){
            exits.put("south", south); 
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getImageName(){
        return imageName; 
    }
    
    public String getExitString(){
        String returnString="Exits:"; 
        
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public Room getExit(String direction){
        return (Room)exits.get(direction);
    }
    
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }
    
    public String getLongDescription(){
        String resultString= "You are " + description + ".\n" + getExitString()+".\n";
        if (items.size() != 0){
            resultString += "This room contains: ";
            
            Iterator iter = items.iterator();
            while (iter.hasNext())
            {
                Item nextItem = (Item) iter.next();
                resultString += "\n " + "\t" + nextItem.getItemName();
            }
        }
        if (characters.size() != 0){
            resultString += "\n " + "In this room is: ";
            
            Iterator iter = characters.iterator();
            while (iter.hasNext())
            {
                Characters nextCharacter = (Characters) iter.next();
                resultString += "\n " + "\t" + nextCharacter.getCharacterName();
            }
        }
        resultString += "\n "; 
        return resultString; 
    }
    
    public void addItem(Item item) 
    {
        items.add(item);
    } 
    
    public void addCharacter(Characters character) 
    {
        characters.add(character);
    } 
    
    public ArrayList getCharactersInRoom() 
    {
        return characters;
    } 
    
    public String getOneCharactersName(int n){
        return characters.get(n).getCharacterName(); 
    }
    
    public ArrayList getItems(){
        return items; 
    }
    
    public String getRoomName(){
        return name; 
    }
}
