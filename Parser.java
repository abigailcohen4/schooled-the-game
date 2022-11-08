import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author  Abi Cohen
 * @version 5
 */
public class Parser 
{
    private CommandWords commands;  // holds all valid command words
    //private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commands = new CommandWords();
        //reader = new Scanner(System.in);
    }

    // /**
     // * @return The next command from the user.
     // */
    // public Command getCommand() 
    // {
        // String inputLine;   // will hold the full input line
        // String word1 = null;
        // String word2 = null;

        // System.out.print("> ");     // print prompt

        // inputLine = reader.nextLine();

        // // Find up to two words on the line.
        // Scanner tokenizer = new Scanner(inputLine);
        // if(tokenizer.hasNext()) {
            // word1 = tokenizer.next();      // get first word
            // if(tokenizer.hasNext()) {
                // word2 = tokenizer.next();      // get second word
                // // note: we just ignore the rest of the input line.
            // }
        // }

        // // Now check whether this word is known. If so, create a command
        // // with it. If not, create a "null" command (for unknown command).
        // if(commands.isCommand(word1)) {
            // return new Command(word1, word2);
        // }
        // else {
            // return new Command(null, word2); 
        // }
    // }
    
    /**
     * This method uses String.split to get each word from the
     * textfield input.
     */
    public Command getCommand(String inputLine) 
    {
        //String inputLine = "";   // will hold the full input line
        String word1 = null;
        String word2 = null;
        
        String [] arrOfStr = inputLine.split(" ");
        
        if (arrOfStr.length == 1){
            word1 = arrOfStr[0];
            word2 = null;
        }
        else{
            word1 = arrOfStr[0];
            word2 = arrOfStr[1];
        }

        if(commands.isCommand(word1))
            return new Command(word1, word2);
        else
            return new Command(null, word2);
    }
    
    public String showCommands(){
        return commands.showAll(); 
    }
}
