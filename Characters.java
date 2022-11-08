
/**
 * class for the six characters you can be friends with 
 *
 * @author Abi Cohen 
 * @version 5
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Random; 

public class Characters
{
    private String name;
    private int fPoints;
    private HashMap <String, String> interests = new HashMap <String, String>();
    private String[] interestNames=new String[4]; 

    /**
     * Constructor for objects of class Characters
     */
    public Characters(String n)
    {
        name=n;
        fPoints=0;
    }
    
    public void setFriendshipPoints(int f)
    {
        fPoints+=f;
    }
    
    public int getFriendshipPoints(){
        return fPoints;
    }
    
    public void setInterests(int n, String interest, String feeling){
        interestNames[n]=interest; 
        interests.put(interest, feeling); 
    }
    
    public String getInterestsKey(int n){
        return interestNames[n]; 
    }
    
    public String getInterestsValue(String interestName){
        return interests.get(interestName); 
    }
    
    public String getCharacterName(){
        return name; 
    }
    
    //chooses a random topic conversation to ask the user 
    public String talkTo(){
        int min=0; 
        int max=3; 
        Random randomGenerator = new Random(); 
        int randomInt = randomGenerator.nextInt(max - min + 1) + min;
        
        String topic=getInterestsKey(randomInt); 
        return topic; 
    }
    
    //compares user's convo answer to the character's feeling 
    public String talkResponse(String reaction, String topic){
        String characterReaction=getInterestsValue(topic); 
        if (characterReaction.equals(":l")){
            setFriendshipPoints(0); 
        }
        else if (reaction.equals(characterReaction)){
            setFriendshipPoints(1); 
        }
        else if((reaction.equals("0"))||(reaction.equals("1"))||(reaction.equals("2"))||(reaction.equals("3"))){
            return "I don't know what you mean"; 
        }
        else{
            setFriendshipPoints(-1); 
        }
        return getCharacterName() +" feels " +characterReaction+" about " +topic+".";
    }
}
