/**
 * @author  Abi Cohen
 * @version 5
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look", "take", "return", "inventory", "drop", "talkTo", "lookAt", "read", "use"
    };
    
    //I want some words to be understood, but I don't want them to show up when the user types help because 
    //they are only useful at certain points in the game; 
    private static final String[] totalValidCommands = {
        "go", "quit", "help", "look", "take", "return", "inventory", "drop", "talkTo" , "lookAt", "read", 
        "0", "1", "2", "3", ":)", ":(", ":l","Britney","Dave","Rob","Stella","Cal", "yelling", "use", "Styles","Turing",
        "Hydroflask","Fascism","Mercury","4","1961","Potassium","Potato","Verona","Mitochondria","October",
        "Conquistador","Clownfish","Corgi","India","ABBA","Iowa","Steinbeck","Arkansas"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < totalValidCommands.length; i++) {
            if(totalValidCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    public String showAll(){
        String allCommands=""; 
        for (int x=0;x<validCommands.length;x++){
            allCommands+="   "+validCommands[x]; 
        }
        return allCommands; 
    }
}
