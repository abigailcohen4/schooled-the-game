/**
 * 
 * @author  Abi Cohen 
 * @version 5
 */

public class Game 
{
    private UserInterface gui; 
    private GameEngine engine; 
    
    public Game(){
        engine = new GameEngine(); 
        gui = new UserInterface(engine); 
        engine.setGUI(gui); 
    }
}
