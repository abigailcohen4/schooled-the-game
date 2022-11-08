/**
 * The player
 * Here, I will assign booleans to measure how far they are in the game. 
 * For example, once they enter class 1, I know to start a mini-challenge. 
 * Inventory is also here. 
 * 
 * @author Abi Cohen
 * @version 5
 */
import java.util.ArrayList; 
public class Player
{
    private Room currentRoom; 
    private Room previousRoom;
    private ArrayList <Item> inventory = new ArrayList <Item>();
    
    String bullyGame="false"; 
    int bullyPoints;  
    
    boolean conversation; 
    Characters characterTalking; 
    String convoTopic; 
     
    String mathClass; 
    String englishClass; 
    String lunch; 
    boolean lunchSeat; 
    boolean hasLunch; 
    boolean fell; 
    boolean milkAccident; 
    String gymClass; 
    String chemistryClass; 
    
    int pQuestion; 
    int pQNum; 
    int principalsVisits; 
    boolean principal; 
    boolean sentToPrincipal; 
    
    boolean inClass; //determines whether a class is in session
    boolean outOfClass; //determines whether player is going to bathroom or vending machines during class 
    
    String clubRoom; 
    boolean inClubRoom; 
    String finalChallenge; 
    String challenge1; 
    String challenge2; 
    String challenge3; 
    String challenge4; 
    String challenge5; 

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        currentRoom=null;
        
        bullyGame="false"; 
        bullyPoints=0; 
        
        conversation=false; 
        characterTalking=null; 
        convoTopic=""; 
         
        mathClass="false"; 
        englishClass="false"; 
        lunch="false"; 
        hasLunch=false; 
        fell=false; 
        milkAccident=false; 
        gymClass="false"; 
        chemistryClass="false"; 
        
        pQuestion=0; 
        pQNum=0; 
        principalsVisits=0;
        principal=false; 
        sentToPrincipal=false; 
        
        inClass=false; //determines whether a class is in session
        outOfClass=true; //determines whether player is going to bathroom or vending machines during class 
        
        clubRoom=""; 
        inClubRoom=false; 
        finalChallenge="false"; 
        challenge1="false"; 
        challenge2="false"; 
        challenge3="false"; 
        challenge4="false"; 
        challenge5="false"; 
        
    }
    
    public String getBullyGame(){
        return bullyGame; 
    }
    
    public void setBullyGame(String s){
        bullyGame=s; 
    }
    
    public int getBullyPoints(){
        return bullyPoints; 
    }
    
    public void setBullyPoints(int n){
        bullyPoints+=n; 
    }
    
    public boolean getConversation(){
        return conversation; 
    }
    
    public void setConversation(boolean b){
        conversation=b; 
    }
    
    public Characters getCharacterTalking(){
        return characterTalking; 
    }
    
    public void setCharacterTalking(Characters c){
        characterTalking=c; 
    }
    
    public String getConvoTopic(){
        return convoTopic; 
    }
    
    public void setConvoTopic(String s){
        convoTopic=s; 
    }
    
    public String getMathClass(){
        return mathClass; 
    }
    
    public void setMathClass(String s){
        mathClass=s; 
    }
    
    public String getEnglishClass(){
        return englishClass; 
    }
    
    public void setEnglishClass(String s){
        englishClass=s; 
    }
    
    public String getLunch(){
        return lunch; 
    }
    
    public void setLunch(String s){
        lunch=s; 
    }
    
    public boolean getLunchSeat(){
        return lunchSeat; 
    }
    
    public void setLunchSeat(boolean b){
        lunchSeat=b; 
    }
    
    public boolean getHasLunch(){
        return hasLunch; 
    }
    
    public void setHasLunch(boolean b){
        hasLunch=b; 
    }
    
    public boolean getFell(){
        return fell; 
    }
    
    public void setFell(boolean b){
        fell=b; 
    }
    
    public boolean getMilkAccident(){
        return milkAccident; 
    }
    
    public void setMilkAccident(boolean b){
        milkAccident=b; 
    }
    
    public String getGymClass(){
        return gymClass; 
    }
    
    public void setGymClass(String s){
        gymClass=s; 
    }
    
    public String getClubRoom(){
        return clubRoom; 
    }
    
    public void setClubRoom(String s){
        clubRoom=s; 
    }
    
    public String getChemistryClass(){
        return chemistryClass; 
    }
    
    public void setChemistryClass(String s){
        chemistryClass=s; 
    }
    
    public boolean getInClass(){
        return inClass; 
    }
    
    public void setInClass(boolean b){
        inClass=b; 
    }
    
    public boolean getOutOfClass(){
        return outOfClass; 
    }
    
    public void setOutOfClass(boolean b){
        outOfClass=b; 
    }
    
    public String getFinalChallenge(){
        return finalChallenge; 
    }
    
    public void setFinalChallenge(String s){
        finalChallenge=s; 
    }
    
    public String getChallenge1(){
        return challenge1; 
    }
    
    public void setChallenge1(String s){
        challenge1=s; 
    }
    
    public boolean getInClubRoom(){
        return inClubRoom; 
    }
    
    public String getChallenge2(){
        return challenge2; 
    }
    
    public void setChallenge2(String s){
        challenge2=s; 
    }
    
    public String getChallenge3(){
        return challenge3; 
    }
    
    public void setChallenge3(String s){
        challenge3=s; 
    }
    
    public String getChallenge4(){
        return challenge4; 
    }
    
    public void setChallenge4(String s){
        challenge4=s; 
    }
    
    public String getChallenge5(){
        return challenge5; 
    }
    
    public void setChallenge5(String s){
        challenge5=s; 
    }
    
    public void setInClubRoom(boolean b){
        inClubRoom=b; 
    }
    
    public int getPQuestion(){
        return pQuestion; 
    }
    
    public void setPQuestion(int n){
        pQuestion=n; 
    }
    
    public int getPrincipalsVisits(){
        return principalsVisits; 
    }
    
    public void setPrincipalsVisits(int n){
        principalsVisits+=n; 
    }
    
    public int getPQNum(){
        return pQNum; 
    }
    
    public void setPQNum(int n){
        pQNum+=n; 
    }
    
    public void erasePQNum(){
        pQNum=0; 
    }
    
    public boolean getPrincipal(){
        return principal; 
    }
    
    public void setPrincipal(boolean b){
        principal=b; 
    }
    
    public boolean getSentToPrincipal(){
        return sentToPrincipal; 
    }
    
    public void setSentToPrincipal(boolean b){
        sentToPrincipal=b; 
    }
    
    public void addToInventory(Item item)
    {
        inventory.add(item); 
    }
    
    public void removeFromInventory(Item item)
    {
        inventory.remove(item); 
    }
    
    public Room getCurrentRoom(){
        return currentRoom; 
    }
    
    public void setCurrentRoom(Room room){
        currentRoom=room; 
    }
    
    public String walk(String direction, UserInterface gui){
        //direction already taken from the command in processCommand() 
        Room nextRoom = null;
        
        if(direction == null) {
            return "Go where?"  + "\n";
        }
        else{
            if(direction.equalsIgnoreCase("north")) {
              nextRoom = currentRoom.getExit("north");
                } 
            else if(direction.equalsIgnoreCase("east")) {
              nextRoom = currentRoom.getExit("east");
                } 
            else if(direction.equalsIgnoreCase("south")) {
              nextRoom = currentRoom.getExit("south");
                } 
            else if(direction.equalsIgnoreCase("west")) {
              nextRoom = currentRoom.getExit("west");
                } 
            else{
                return "Go where?"  + "\n";
            }
        }
        //moves rooms 
        if (nextRoom == null)
            gui.println("There is no door!");
        else {
            previousRoom = currentRoom; 
            currentRoom = nextRoom; 
            if(currentRoom.getImageName() != null)
                gui.showImage(currentRoom.getImageName());
        }
        return currentRoom.getLongDescription(); 
    }
    
    public String goBack(Command command, UserInterface gui){
        if(command.hasSecondWord()) {
            return "You can only return to the place you were just in--no need to specify.";
        }
        else if (previousRoom!=null){
            Room cRoom=currentRoom;
            setCurrentRoom(previousRoom); 
            previousRoom=cRoom; 
            if(currentRoom.getImageName() != null)
                gui.showImage(currentRoom.getImageName());
            return currentRoom.getLongDescription();
        }
        return "You have no place to return to.";
    }
    
    public String take(Command command){
        if (command.hasSecondWord()==false){
            return "Take what?"; 
        }
        else{
            ArrayList <Item> itemList = new ArrayList(currentRoom.getItems());
            String itemTaken = command.getSecondWord(); 
            Item itemToTake=null; 
            for(int x=0; x<itemList.size();x++){
                itemToTake = (Item)itemList.get(x);
                if(itemToTake.getItemName().equals(itemTaken)){
                    //adds item to inventory
                    addToInventory(itemToTake); 
                    //removes item from the room
                    currentRoom.getItems().remove(itemToTake);
                    //lets the user know they successfully took the item 
                    return "You’ve taken " + itemToTake.getItemDescription()+".";
                }
            }
        }
        //after the return statement, the rest of the method does not run 
        //so i do not have to specify if/else 
        return "This item isn't around to take."; 
    }
    
    public String drop(Command command){
        if (command.hasSecondWord()==false){
            return "Drop what?"; 
        }
        else{
            ArrayList <Item> itemList = new ArrayList(inventory);
            String itemDropped = command.getSecondWord(); 
            Item itemToDrop=null; 
            for(int x=0; x<itemList.size();x++){
                itemToDrop = (Item)itemList.get(x);
                if(itemToDrop.getItemName().equals(itemDropped)){
                    //removes item from inventory
                    removeFromInventory(itemToDrop);
                    //adds item to the room
                    currentRoom.getItems().add(itemToDrop);
                    //lets the user know they successfully took the item 
                    return "You’ve dropped " + itemToDrop.getItemDescription();
                }
            }
        }
        //after the return statement, the rest of the method does not run 
        //so i do not have to specify if/else 
        return "This item is not in your inventory.";
    }
    
    public String getInventoryNames(){
        String inventoryList="Inventory: \n"; 
        for (int x=0;x<inventory.size();x++){
            inventoryList+="     "+inventory.get(x).getItemName()+"\n";
        }
        if (inventoryList=="Inventory: \n"){
            return "You have nothing in your inventory."; 
        }
        return inventoryList; 
    }
    
    public ArrayList getInventory(){
        return inventory; 
    }
    
    public String getOneItemsName(int n){
        return inventory.get(n).getItemName(); 
    }
    
    public Item getInventoryItem(int n){
        return inventory.get(n); 
    }
    
    public void use(String itemUsed){
        ArrayList <Item> itemList = new ArrayList(inventory);
        
        Item itemToUse=null; 
        for(int x=0; x<itemList.size();x++){
            itemToUse = (Item)itemList.get(x);
            if(itemToUse.getItemName().equals(itemUsed)){
                //removes item from inventory
                removeFromInventory(itemToUse);
            }
        }
    }
}
