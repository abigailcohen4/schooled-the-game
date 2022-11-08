/**
 * 
 * @author  Abi Cohen 
 * @version 5
 */

import java.util.InputMismatchException; 
import java.io.IOException; 
import java.util.Random; 
import java.util.ArrayList; 

public class GameEngine 
{
    
    private Parser parser;
    private Player player;
    private GameEngine game; 
    private Characters[] characters; 
    private Quiz[] qList; 
    private UserInterface gui; 
    
    public GameEngine(){
        parser = new Parser();
        player = new Player();
        characters = new Characters[5]; 
        qList=new Quiz[20]; 
        
        createCharacters(characters);
        createQuestions(qList); 
        createRooms(characters, player);
    }
    
    public void setGUI(UserInterface userInterface){
        gui =userInterface; 
        printWelcome(player); 
    }
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms(Characters[] charList, Player player)
    {
        Room bedroom, hallway, kitchen, outsideHome, bus; 
        Room outsideSchool, schoolEntrance, northHallway, eastHallway, zimmerHall, springHall; 
        Room office, cafeteria, gym, principalOffice, bathroom, vendingMachines, auditorium;
        Room room101, room102, room103, room104; 
        
        
        // create the rooms
        //house 
        bedroom = new Room("bedroom","in your bedroom","bedroom.jpg"); 
        hallway = new Room("hallway","in the hallway","hallway.jpg"); 
        kitchen = new Room("kitchen","in the kitchen","kitchen.jpg"); 
        outsideHome = new Room("yard","on the front yard of your house, right near the bus \n stop","frontYard.jpg"); 
        bus = new Room("bus","on the schoolbus","bus.jpg");
         
        //school hallways 
        outsideSchool=new Room("schoolyard","outside the school","schoolyard.jpg");
        schoolEntrance = new Room("schoolEntrance", "in the entrance of the school","schoolEntrance.jpg");
        northHallway= new Room("northHallway","in the north hallway","northHall.jpg"); 
        eastHallway=new Room("eastHallway","in the east hallway","eastHall.jpg"); 
        zimmerHall=new Room("zimmerHall","in Zimmer hall","zimmerHall.jpg"); 
        springHall=new Room("springHall","in spring hall","springHall.jpg"); 
        
        //school general spaces 
        bathroom=new Room("bathroom","in the school bathroom","bathroom.jpg");
        office = new Room("office","in the main office of the school","office.jpg"); 
        cafeteria = new Room("cafeteria","in the cafeteria","cafeteria.jpg"); 
        gym = new Room("gym","in the high school gym","gym.jpg");
        principalOffice = new Room("principalsOffice","in the principal's office","pOffice.jpg");
        auditorium=new Room("auditorium", "in the auditorium","auditorium.jpg"); 
        vendingMachines=new Room("vendingMachines","by the vending machines","vendingMachines.jpg"); 
        
        //classrooms 
        room101= new Room("room101","in room 101, the history classroom","room101.jpg"); 
        room102=new Room("room102","in room 102, the English classroom","room102.jpg"); 
        room103=new Room("room103","in room 103, the math classroom","room103.jpg"); 
        room104=new Room("room104","in room 104, the science classroom","room104.jpg"); 
        
        // initialise room exits 
        //house 
        bedroom.setExit("north",hallway); 
        hallway.setExit("east",kitchen); 
        hallway.setExit("south",bedroom); 
        kitchen.setExit("north",outsideHome); 
        kitchen.setExit("west",hallway); 
        outsideHome.setExit("north",bus); 
        outsideHome.setExit("south",kitchen); 
        bus.setExit("north",outsideSchool); 
        bus.setExit("south",outsideSchool); 
        
        //school hallways 
        outsideSchool.setExit("north",schoolEntrance); 
        schoolEntrance.setExit("east",office); 
        schoolEntrance.setExit("south",outsideSchool); 
        schoolEntrance.setExit("west",auditorium); 
        schoolEntrance.setExit("north",northHallway); 
        northHallway.setExit("north",bathroom); 
        northHallway.setExit("east",eastHallway); 
        northHallway.setExit("south",schoolEntrance); 
        northHallway.setExit("west",cafeteria); 
        eastHallway.setExit("north",room102); 
        eastHallway.setExit("east",zimmerHall); 
        eastHallway.setExit("south",room101); 
        eastHallway.setExit("west",northHallway); 
        zimmerHall.setExit("north",room104); 
        zimmerHall.setExit("east",springHall); 
        zimmerHall.setExit("west",eastHallway); 
        zimmerHall.setExit("south",room103); 
        springHall.setExit("east",gym); 
        springHall.setExit("south",vendingMachines); 
        springHall.setExit("west",zimmerHall); 
        
        
        //school general spaces 
        bathroom.setExit("south",northHallway); 
        cafeteria.setExit("east",northHallway); 
        auditorium.setExit("east",schoolEntrance); 
        office.setExit("east",principalOffice); 
        office.setExit("west",schoolEntrance); 
        principalOffice.setExit("west",office); 
        vendingMachines.setExit("north",springHall); 
        gym.setExit("west",springHall); 
        
        //classrooms 
        room101.setExit("north",eastHallway); 
        room102.setExit("south",eastHallway); 
        room103.setExit("north",zimmerHall); 
        room104.setExit("south",zimmerHall); 
        
        
        bedroom.addItem(new Item ("phone", "your phone", "Text from Mom: Hi love! \n Good luck at school this morning. \n I want to hear that you made three friends by the \n end of the day! \n Talk to other students, go to club meetings, and be good \n in school. \n When you get to school, be sure to pick up your schedule \n from the office. \n Love you! You got this :) \n"));
        kitchen.addItem(new Item ("lunch", "the lunch your mom packed you this morning", ""));
        vendingMachines.addItem(new Item ("note", "a note", "if you ever feel like you're falling, try 'yelling'")); //if the user enters "yelling" when they're tripping on milk, they're won't fall 
        cafeteria.addItem(new Item ("Band-Aid", "a plain beige Band-Aid", ""));
        schoolEntrance.addItem(new Item ("hat", "a hat with the mascot of the local minor league \n baseball team", ""));
        //the diary reveals the likes of characters which help in conversations 
        zimmerHall.addItem(new Item ("diary", "a green diary", "Crazy stuff happened at the freshman end-of-year field trip! \n We visited the planetarium, which Stella would NOT stop talking \n about—that girl really loves astronomy. As Stella was talking about \n this one constellation, Britney (wearing her cheerleading uniform \n for some reason) walked up to Cal and asked what he thought \n about the beach. Of course, Cal went off, talking about how much \n the beach brings him peace. Meanwhile, Rob was sitting in the corner \n watching them talk, sipping on some grape juice. WHAT A SCANDAL!!! \n"));
        office.addItem(new Item("succulent","a small cactus in a pink pot","")); 
        northHallway.addItem(new Item("lipstick","a pink glossy lipstick","")); 
        bathroom.addItem(new Item("dinosaurPen", "a pen with a soft dinosaur caricature on top", "")); 
        office.addItem(new Item("schedule", "your class schedule", "1st Period: algebra - Room 103"+"\n"+"2nd Period: English - Room 102"+"\n"+"Lunch"+"\n"+"4th Period: Gym - gym"+"\n"+"5th Period: Chemistry - Room 104"+"\n")); 
        
        //0=britney;1=dave;2=rob;3=stella;4=cal
        bus.addCharacter(charList[0]);
        bus.addCharacter(charList[1]);
        bus.addCharacter(charList[2]);
        bus.addCharacter(charList[3]);
        bus.addCharacter(charList[4]);
        
        cafeteria.addCharacter(charList[0]);
        cafeteria.addCharacter(charList[1]);
        cafeteria.addCharacter(charList[2]);
        cafeteria.addCharacter(charList[3]);
        cafeteria.addCharacter(charList[4]);
        
        office.addCharacter(charList[0]);
        
        room102.addCharacter(charList[1]);
        auditorium.addCharacter(charList[3]);
        gym.addCharacter(charList[2]);
        
        vendingMachines.addCharacter(charList[4]);
        
        // start game in the bedroom 
        player.setCurrentRoom(bedroom);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome(Player player)
    {
        gui.println(""); 
        gui.println("Welcome to Schooled!");
        gui.println("In this game, it's the first day of school at your new "); 
        gui.println("high school."); 
        gui.println("You just moved here and don't know anyone."); 
        gui.println("If you need help at any point, type 'help.'");
        gui.println("Read your phone messages to learn the game's objective.");
        gui.println(""); 
        gui.println(player.getCurrentRoom().getLongDescription());
        gui.showImage(player.getCurrentRoom().getImageName());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean interpretCommand(String commandLine)
    {
        boolean wantToQuit = false;
        
        Command command = parser.getCommand(commandLine);
        
        String commandWord = command.getCommandWord();
        if(command.isUnknown()) {
            if(player.getPrincipal()==true){
                gui.println("Incorrect."); 
                return false; 
            }
            else{
                gui.println("I don't know what you mean...");
                return false;
            }
        }
        else if(player.getPrincipal()==true){
            String answer=qList[player.getPQuestion()].getAnswer(); 
            if (commandWord.equals(answer)){
                gui.println("Correct! "); 
                player.setPQNum(1);
            }
            else{
                gui.println("Incorrect. "); 
                return false; 
            }
            if(player.getPQNum()<5){
                makePQuestion(player, qList); 
            }
            else{
                player.setPrincipal(false); 
                gui.println("You did it! You can now return to class. \n "); 
                return false; 
            }
        }
        
        if (commandWord.equals("help")) {
            printHelp(parser);
        }
        else if (commandWord.equals("go")){
            //i made a checkRoom method because throughout the game, 
            //I want different things to happen when someone is in a specific room checkRoom(); 
            if(checkRoom(player)==true){ 
                String direction = command.getSecondWord();
                String print = player.walk(direction, gui);
                gui.print(print); 
            }
            //for when I want something to happen after someone enters a room 
            checkRoomAfter(player, characters, qList); 
        }
        else if (commandWord.equals("quit")) {
            endGame(); 
        }
        else if(commandWord.equals("return")){
            String print=player.goBack(command, gui); 
            gui.println(print); 
        }
        else if(commandWord.equals("look")){
            look(player); 
        }
        else if(commandWord.equals("take")){
            String print=player.take(command); 
            gui.println(print); 
        }
        else if(commandWord.equals("inventory")){
            gui.print(player.getInventoryNames()); 
        }
        else if(commandWord.equals("drop")){
            String print=player.drop(command); 
            gui.println(print); 
        }
        else if(commandWord.equals("talkTo")){
            boolean inRoom=checkCharacter(command, player); 
            if (inRoom==false){
                gui.println("This person is not in the same room as you right now.");
            }
            else{
                player.setConversation(true); 
                if(!command.hasSecondWord()) {
                    gui.println("Talk to who?");
                }
                else{
                    int num=0; 
                    for (int x=0;x<characters.length;x++){
                        if (characters[x].getCharacterName().equals(command.getSecondWord())){
                            num=x; 
                        }
                    }
                    player.setCharacterTalking(characters[num]); 
                    player.setConvoTopic(player.getCharacterTalking().talkTo()); 
                    gui.println("How do you feel about " +player.getConvoTopic()+"?");
                    gui.println("Enter :), :(, or :l to signify how you feel about this topic."); 
                }
            }
        }
        else if(player.getConversation()==true){
            String print=player.getCharacterTalking().talkResponse(commandWord, player.getConvoTopic()); 
            if (print.equals("I don't know what you mean")){
                gui.println(print);
            }
            else{
                gui.println(print);
                gui.println("Your current friendship points with " +player.getCharacterTalking().getCharacterName()+": "+player.getCharacterTalking().getFriendshipPoints());
                player.setConversation(false); 
            }
        }
        else if(player.getBullyGame().equals("true")){
            bullyGame(commandWord, player); 
        }
        else if(commandWord.equals("lookAt")){
            gui.println(lookAt(command, player)); 
        }
        else if(commandWord.equals("read")){
            gui.println(read(command, player)); 
        }
        else if(commandWord.equals("use")){
            if (command.hasSecondWord()==false){
                gui.println("Use what?"); 
            }
            else if ((player.getFinalChallenge().equals("true"))&&(player.getInClubRoom()==true)){
                 challengeUse(player, command, characters); 
            }
            else{
                gui.println("You can't use this object right now."); 
            }
        }
        else if((player.getMathClass().equals("true"))&&(player.getOutOfClass()==false)){
            mathClass(commandWord, player); 
        }
        else if((player.getEnglishClass().equals("true"))&&(player.getCurrentRoom().getRoomName().equals("room102"))){
            englishClass(commandWord, player, qList, characters); 
        }
        else if (player.getMilkAccident()==true){
            String[] numbers= new String[4]; 
            numbers[0]="0"; 
            numbers[1]="1"; 
            numbers[2]="2"; 
            numbers[3]="3"; 
            
            int min=0; 
            int max=3; 
            Random randomGenerator = new Random(); 
            int randomInt = randomGenerator.nextInt(max - min + 1) + min;
            
            if ((commandWord.equals(numbers[randomInt]))||commandWord.equals("yelling")){
                gui.println("You were able to find your footing again and "); 
                gui.println("balance yourself."); 
                gui.println("You and your lunch are safe! Very graceful!");  
                player.setFell(false); 
                player.setMilkAccident(false); 
                lunchSeat(player); 
            }
            else if ((commandWord.equals(":)"))||(commandWord.equals(":("))||(commandWord.equals(":l"))){
                gui.println("I don't know what you mean..."); 
            }
            else{
                gui.println("You fell onto your butt."); 
                gui.println("Your hot soup fell right onto your t-shirt, leaving a "); 
                gui.println("big red stain."); 
                gui.println("Not the best first impression you could've made on "); 
                gui.println("your new classmates...."); 
                player.setFell(true); 
                player.setMilkAccident(false); 
                lunchSeat(player); 
            }
        }
        else if(player.getLunchSeat()==true){ 
            String lunchCharacter=""; 
            for (int x=0;x<characters.length;x++){
                if (characters[x].getCharacterName().equals(commandWord)){
                    lunchCharacter=characters[x].getCharacterName(); 
                }
            }
            if (lunchCharacter!=""){
                lunchSeatChoice(player, characters, lunchCharacter); 
            }
            else{
                gui.println("I don't know what you mean..."); 
            }
        }
        else if ((player.getGymClass().equals("true"))&&(player.getCurrentRoom().getRoomName().equals("gym"))){
            gymClass(commandWord, characters, player); 
        }
        else if((player.getChemistryClass().equals("true"))&&(player.getCurrentRoom().getRoomName().equals("room104"))){
            chemistryClass(commandWord, player); 
        }
        else if(player.getPrincipal()==false){
            gui.println("I don't know what you mean..."); 
            //this runs when something that is a command word but is not appropriate for now is entered 
            //for example, if someone enters ":)" if they're not in a conversation 
        }
        
        
        return wantToQuit;
    }
    

    // implementations of user commands: 
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp(Parser parser) 
    {
        gui.println("It's your first day at a new school.");
        gui.println("Your parents want you to make at least three friends "); 
        gui.println("before you go home at the end of the day.");
        gui.println("With every interaction you have with one of the six "); 
        gui.println("characters, you can gain or lose friendship points with"); 
        gui.println("with them. To be considered friends, you must have at "); 
        gui.println("least six friendship points with someone."); 
        gui.println(""); 
        gui.println("Your command words are:");
        gui.println("   "+parser.showCommands());
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            gui.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void createCharacters(Characters[] charList){
        //first line of each "paragraph" adds the character. The next four set their interests. 
        charList[0]=new Characters("Britney");
        charList[0].setInterests(0, "skateboarding",":l"); 
        charList[0].setInterests(1, "Taylor Swift",":)"); 
        charList[0].setInterests(2, "cheerleading",":)"); 
        charList[0].setInterests(3, "sweatpants",":("); 
        
        charList[1]=new Characters("Dave"); 
        charList[1].setInterests(0, "sailing",":("); 
        charList[1].setInterests(1, "Arbor Day",":l"); 
        charList[1].setInterests(2, "video games",":)"); 
        charList[1].setInterests(3, "vegetarianism",":("); 
        
        charList[2]=new Characters("Rob"); 
        charList[2].setInterests(0, "the Green Bay Packers",":)"); 
        charList[2].setInterests(1, "parking lots",":l"); 
        charList[2].setInterests(2, "grape juice",":)"); 
        charList[2].setInterests(3, "Shakespeare's Hamlet",":("); 
        
        charList[3]=new Characters("Stella"); 
        charList[3].setInterests(0, "Picasso",":)"); 
        charList[3].setInterests(1, "knitting",":l"); 
        charList[3].setInterests(2, "eating meat",":("); 
        charList[3].setInterests(3, "planetariums",":)"); 
        
        charList[4]=new Characters("Cal"); 
        charList[4].setInterests(0, "collared shirts",":("); 
        charList[4].setInterests(1, "magnets",":l"); 
        charList[4].setInterests(2, "long division",":("); 
        charList[4].setInterests(3, "the beach",":)"); 
    }
    
    private void createQuestions(Quiz[] qList){
        qList[0]=new Quiz("What is the last name of the musical artist who recently \n came out with an album titled Fine Line? \n","Styles"); 
        qList[1]=new Quiz("What is the last name of the person whose life inspired \n the movie The Imitation Game? \n ","Turing"); 
        qList[2]=new Quiz("VSCO girls are known to have this kind of waterbottle. \n","Hydroflask"); 
        qList[3]=new Quiz("What style of government rose in Europe in the 1930s?","Fascism"); 
        qList[4]=new Quiz("What is the first planet in our solar system? \n","Mercury"); 
        qList[5]=new Quiz("How many US presidents were assassinated?","4"); 
        qList[6]=new Quiz("What year was the Berlin Wall built?","1961"); 
        qList[7]=new Quiz("Bananas are known to contain high levels of which \n nutrient? \n","Potassium"); 
        qList[8]=new Quiz("The Spanish word for Pope and this vegetable are \n the same. \n","Potato"); 
        qList[9]=new Quiz("In what Italian city does Romeo and Juliet take place?","Verona"); 
        qList[10]=new Quiz("This organelle is known as 'the powerhouse of the cell. \n'","Mitochondria"); 
        qList[11]=new Quiz("Canadian Thanksgiving is celebrated at the end of \n this month. \n","October"); 
        qList[12]=new Quiz("What is the word for a Spanish conquerer from the Age \n of Exploration? \n","Conquistador"); 
        qList[13]=new Quiz("What kind of fish is the main character of Finding Nemo? \n ","Clownfish"); 
        qList[14]=new Quiz("What is Queen Elizabeth's favorite breed of dog? \n ","Corgi"); 
        qList[15]=new Quiz("Which country was known as the 'Crown Jewel of the  \n British Empire?' \n ","India"); 
        qList[16]=new Quiz("Mamma Mia! is based off of which Swedish pop band's music? \n ","ABBA"); 
        qList[17]=new Quiz("Which state's capital is Des Moines?","Iowa"); 
        qList[18]=new Quiz("What is the last name of the writer of Of Mice and Men? \n ","Steinbeck"); 
        qList[19]=new Quiz("What US state includes the telephone area code 501? \n ","Arkansas"); 
    }
    
    private void look(Player player){
        gui.println(player.getCurrentRoom().getLongDescription());
    }
    
    /**
     * checks if character is in the currentRoom
     */
    private boolean checkCharacter(Command command, Player player){
        for (int x=0;x<player.getCurrentRoom().getCharactersInRoom().size();x++){
            //the commented line below doesn't work for some reason! Created method getOneCharacatersName() 
            //in the Room class to get around it 
            //String c =player.getCurrentRoom().getCharactersInRoom().get(x).getCharacterName();
            
            String c = player.getCurrentRoom().getOneCharactersName(x); 
            if (c.equals(command.getSecondWord())){
                boolean inRoom=true;
                return inRoom; 
            }
        }
        boolean inRoom=false;
        return inRoom; 
    }
    
    private boolean checkRoom(Player player){
        if (player.getConversation()==true){
            gui.println("You can't leave right now!"); 
            gui.println("You're in a conversation."); 
            return false; 
        }
        else if (player.getPrincipal()==true){
            gui.println("You can't leave right now!"); 
            gui.println("You're in the principal's office."); 
            return false; 
        }
        else if (player.getCurrentRoom().getRoomName().equals("bus")){
            if (player.getBullyGame().equals("false")){
                player.setBullyGame("true"); 
                gui.println("As you tried to walk off the bus, a bully stands in "); 
                gui.println("front of you!"); 
                gui.println("He yells, 'Pay up.'"); 
                gui.println("What do you do?"); 
                gui.println("Enter 0 to talk to him, 1 to try and fight him, 2 to "); 
                gui.println("give him your lunch, or 3 to cry."); 
                return false; 
            }
            else if (player.getBullyGame().equals("true")){
                gui.println("Enter 0 to talk to him, 1 to try and fight him, 2 to "); 
                gui.println("give him your lunch, or 3 to cry."); 
                return false;
                }
            else{
                return true; 
            }
        }
        else if ((player.getInClass()==true)&&(player.getOutOfClass()==false)){
            gui.println("You can't leave right now!"); 
            if(player.getMilkAccident()==true){
                gui.println("You are tripping on milk."); 
            }
            else if(player.getLunchSeat()==true){
                gui.println("You have to choose a person to sit next to."); 
            }
            else{
                gui.println("You're in class.");
            }
            return false; 
        } 
        else if ((player.getMathClass().equals("true"))&&(player.getCurrentRoom().getRoomName().equals("room103"))){
            if (player.getOutOfClass()==false){
                gui.println("Enter 0 to go to the bathroom, 1 to go to the vending"); 
                gui.println("machine, 2 to skip class, or 3 just stay in class."); 
                return false; 
            }
            else{
                return true; 
            }
        }
        else if ((player.getEnglishClass().equals("true"))&&(player.getCurrentRoom().getRoomName().equals("room102"))){
            if (player.getOutOfClass()==false){ 
                gui.println("Enter 0 to bubble in random answers, 1 to cheat using "); 
                gui.println("your seatmate, 2 to try your best, or 3 to ditch the "); 
                gui.println("class entirely."); 
                return false;
            }
            else{
                return true; 
            }
        }
        else if ((player.getGymClass().equals("true"))&&(player.getCurrentRoom().getRoomName().equals("gym"))){
            if (player.getOutOfClass()==false){ 
                gui.println("Enter 0 to run the three miles, 1 to hide in the locker "); 
                gui.println("room hallway, 2 to skip class and go home, or 3 to fake "); 
                gui.println("a sick stomach."); 
                return false;
            }
            else{
                return true; 
            }
        }
        else if ((player.getChemistryClass().equals("true"))&&(player.getCurrentRoom().getRoomName().equals("room104"))){
            if (player.getOutOfClass()==false){
                gui.println("Enter 0 to go to the bathroom, 1 to go to the vending "); 
                gui.println("machine, 2 to skip class, or 3 just stay in class."); 
                return false; 
            }
            else{
                return true; 
            }
        }
        return true;
    }
    
    //this method offers more description of an item instead of just its name 
    private String lookAt(Command command, Player player){
        if (command.hasSecondWord()==false){
            return "Look at what?"; 
        }
        else{
            ArrayList <Item> itemList = new ArrayList(player.getCurrentRoom().getItems());
            String itemLooked = command.getSecondWord(); 
            Item itemToLook=null; 
            for(int x=0; x<itemList.size();x++){
                itemToLook = (Item)itemList.get(x);
                if(itemToLook.getItemName().equals(itemLooked)){
                    return itemToLook.getItemDescription();
                }
            }
        }
        return "This item isn't around to look at."; 
    }
    
    private String read(Command command, Player player){
        if (command.hasSecondWord()==false){
            return "Read what?"; 
        }
        else{
            ArrayList <Item> itemList = new ArrayList(player.getCurrentRoom().getItems()); 
            String itemRead = command.getSecondWord(); 
            Item itemToRead=null; 
            for(int x=0; x<itemList.size();x++){
                itemToRead = (Item)itemList.get(x);
                if((itemToRead.getItemName().equals(itemRead))&&(itemToRead.read()!="")){
                    return itemToRead.read(); 
                }
            }
            for(int x=0; x<player.getInventory().size();x++){
                itemToRead = (Item)player.getInventory().get(x); 
                if((itemToRead.getItemName().equals(itemRead))&&(itemToRead.read()!="")){
                    return itemToRead.read(); 
                }
            }
        }
        return "This item can't be read."; 
    }
    
    private void checkRoomAfter(Player player, Characters[] characters, Quiz[] qList){
        if(player.getSentToPrincipal()==true){
            if((player.getCurrentRoom().getRoomName().equals("office"))||(player.getCurrentRoom().getRoomName().equals("schoolEntrance"))||(player.getCurrentRoom().getRoomName().equals("northHallway"))||((player.getCurrentRoom().getRoomName().equals("eastHallway"))||(player.getCurrentRoom().getRoomName().equals("zimmerHall"))||(player.getCurrentRoom().getRoomName().equals("springHall")))){
                gui.println("You are walking to the principal's office."); 
            }
            else if((player.getCurrentRoom().getRoomName().equals("principalsOffice"))){
                player.setSentToPrincipal(false); 
                principalsOffice(player, qList, characters); 
            }
            else{
                gui.println("Go to the principal's office."); 
            }
        }
        else if (player.getMathClass().equals("false")){
            if (player.getCurrentRoom().getRoomName().equals("room103")){
                player.setInClass(true);
                player.setOutOfClass(false); 
                player.setMathClass("true"); 
                gui.println("You enter your first class of the day, Algebra II."); 
                gui.println("You can go to the bathroom, get a drink of water, "); 
                gui.println("skip class and go home, or stay for the whole class."); 
                gui.println("What do you do?"); 
                gui.println("Enter 0 to go to the bathroom, 1 to go to the vending"); 
                gui.println("machine, 2 to skip class, or 3 just stay in class."); 
            }
            else if ((player.getCurrentRoom().getRoomName().equals("room101"))||(player.getCurrentRoom().getRoomName().equals("room102"))||(player.getCurrentRoom().getRoomName().equals("room104"))){
                gui.println("This isn't your classroom."); 
            }
        }
        else if ((player.getMathClass().equals("true"))&&(player.getOutOfClass()==true)){
            if (player.getCurrentRoom().getRoomName().equals("room103")){
                player.setOutOfClass(false); 
                gui.println("You are back in class."); 
                gui.println("Enter 0 to go to the bathroom, 1 to go to the vending "); 
                gui.println("machine, 2 to skip class, or 3 just stay in class."); 
            }
        }
        else if ((player.getMathClass().equals("passed"))&&(player.getEnglishClass().equals("false"))){
            if (player.getCurrentRoom().getRoomName().equals("room102")){
                player.setInClass(true); 
                player.setEnglishClass("true"); 
                gui.println("You enter your English class and sit down in the chair "); 
                gui.println("closest to the door. Your teacher, a mean-faced old man "); 
                gui.println("with thick gray hair, begins to pass out papers."); 
                gui.println("\"Alright,\" he says,\"This is your first quiz of the "); 
                gui.println("year. Don't flunk it.\""); 
                gui.println("Oh no! A pop quiz! What do you do?"); 
                gui.println("Enter 0 to bubble in random answers, 1 to cheat using "); 
                gui.println("your seatmate, 2 to try your best, or 3 to ditch the "); 
                gui.println("class entirely."); 
            }
            else if((player.getCurrentRoom().getRoomName().equals("room101"))||(player.getCurrentRoom().getRoomName().equals("room103"))||(player.getCurrentRoom().getRoomName().equals("room104"))){
                gui.println("This isn't your classroom."); 
            }
        }
        else if ((player.getEnglishClass().equals("true"))&&(player.getOutOfClass()==true)){
            if (player.getCurrentRoom().getRoomName().equals("room102")){
                player.setOutOfClass(false); 
                gui.println("You are back in class."); 
                gui.println("Enter 0 to bubble in random answers, 1 to cheat using "); 
                gui.println("your seatmate, 2 to try your best, or 3 to ditch the "); 
                gui.println("class entirely."); 
            }
        }
        else if ((player.getEnglishClass().equals("passed"))&&(player.getLunch().equals("false"))){
            if (player.getCurrentRoom().getRoomName().equals("cafeteria")){
                player.setInClass(true);
                player.setOutOfClass(false); 
                player.setLunch("true"); 
                gui.println("It's lunchtime!"); 
                if(player.getHasLunch()==false){
                     milkAccident(player);
                }
                else{
                    lunchSeat(player); 
                }
            }
        }
        else if ((player.getLunch().equals("passed"))&&(player.getGymClass().equals("false"))){
            if (player.getCurrentRoom().getRoomName().equals("gym")){
                player.setInClass(true);
                player.setOutOfClass(false); 
                player.setGymClass("true");  
                gui.println("You enter the large, sterile-smelling gym."); 
                gui.println("After everyone changes in the locker room, you"); 
                gui.println("all gather on the bleachers. The short, sturdy"); 
                gui.println("gym teacher announces that today is mile day!: "); 
                gui.println("Everyone has to run three miles around the gym by the "); 
                gui.println("end of the period."); 
                gui.println("What do you do?"); 
                gui.println("Enter 0 to run the three miles, 1 to hide in the locker "); 
                gui.println("room hallway, 2 to skip class and go home, or 3 to fake "); 
                gui.println("a sick stomach."); 
            }
            else if((player.getCurrentRoom().getRoomName().equals("room101"))||(player.getCurrentRoom().getRoomName().equals("room102"))||(player.getCurrentRoom().getRoomName().equals("room103"))||(player.getCurrentRoom().getRoomName().equals("room104"))){
                gui.println("This isn't your classroom."); 
            }
        }
        else if ((player.getGymClass().equals("true"))&&(player.getOutOfClass()==true)){
            if (player.getCurrentRoom().getRoomName().equals("gym")){
                player.setOutOfClass(false); 
                gui.println("You are back in class."); 
                gui.println("Enter 0 to run the three miles, 1 to hide in the locker "); 
                gui.println("room hallway,2 to skip class and go home, or 3 to fake "); 
                gui.println("a sick stomach."); 
            }
        }
        else if ((player.getGymClass().equals("passed"))&&(player.getChemistryClass().equals("false"))){
            if (player.getCurrentRoom().getRoomName().equals("room104")){
                player.setInClass(true);
                player.setOutOfClass(false); 
                player.setChemistryClass("true");  
                gui.println("You enter your last class of the day, Chemistry."); 
                gui.println("You can go to the bathroom, get a drink of water, "); 
                gui.println("skip class and go home, or stay for the whole class."); 
                gui.println("What do you do?"); 
                gui.println("Enter 0 to go to the bathroom, 1 to go to the vending "); 
                gui.println("machine, 2 to skip class, or 3 just stay in class."); 
            }
            else if((player.getCurrentRoom().getRoomName().equals("room101"))||(player.getCurrentRoom().getRoomName().equals("room102"))||(player.getCurrentRoom().getRoomName().equals("room103"))){
                gui.println("This isn't your classroom."); 
            }
        }
        else if ((player.getChemistryClass().equals("true"))&&(player.getOutOfClass()==true)){
            if (player.getCurrentRoom().getRoomName().equals("room104")){
                player.setOutOfClass(false); 
                gui.println("You are back in class."); 
                gui.println("Enter 0 to go to the bathroom, 1 to go to the vending "); 
                gui.println("machine, 2 to skip class, or 3 just stay in class."); 
            }
        }
        else if ((player.getChemistryClass().equals("passed"))&&(player.getFinalChallenge().equals("false"))){
            if (player.getCurrentRoom().getRoomName().equals("room102")){
                player.setClubRoom("room102"); 
                player.setInClubRoom(true); 
                dnd();
                finalChallenge(player); 
            }
            else if (player.getCurrentRoom().getRoomName().equals("auditorium")){
                player.setClubRoom("auditorium"); 
                player.setInClubRoom(true); 
                dramaClub(); 
                finalChallenge(player); 
            }
            else if (player.getCurrentRoom().getRoomName().equals("gym")){
                player.setClubRoom("gym"); 
                player.setInClubRoom(true); 
                basketball(); 
                finalChallenge(player); 
            }
            else if (player.getCurrentRoom().getRoomName().equals("outsideSchool")){
                theEnd(player, characters); 
            }
        }
        else if(player.getFinalChallenge().equals("true")){
            if(player.getClubRoom().equals("room102")){
                if ((player.getCurrentRoom().getRoomName().equals("auditorium"))||(player.getCurrentRoom().getRoomName().equals("gym"))){
                    gui.println("You can't be in here! Another club is going on."); 
                }
            }
            else if(player.getClubRoom().equals("auditorium")){
                if ((player.getCurrentRoom().getRoomName().equals("room102"))||(player.getCurrentRoom().getRoomName().equals("gym"))){
                    gui.println("You can't be in here! Another club is going on."); 
                }
            }
            else if(player.getClubRoom().equals("gym")){
                if ((player.getCurrentRoom().getRoomName().equals("auditorium"))||(player.getCurrentRoom().getRoomName().equals("room102"))){
                    gui.println("You can't be in here! Another club is going on."); 
                }
            }
            if (player.getCurrentRoom().getRoomName().equals(player.getClubRoom())){
                player.setInClubRoom(true); 
            }
            else{
                player.setInClubRoom(false); 
            }
        }
    }
    
    private void milkAccident(Player player){
        player.setMilkAccident(true); 
        player.setInClass(true); 
        gui.println("You don't have your lunch, so you go through the line"); 
        gui.println("to pick up some hot, fresh tomato soup for lunch."); 
        gui.println("As you walk towards the cafeteria tables, your foot ");  
        gui.println("glides over a puddle of milk on the linoleum."); 
        gui.println("Enter a number 0, 1, 2, or 3 to find out what happens "); 
        gui.println("next.");  
    }
    
    private void lunchSeat(Player player){
        gui.println("Now you have to choose where to sit..."); 
        gui.println("Enter the name of the character you would like to sit "); 
        gui.println("next to."); 
        player.setLunchSeat(true); 
    }
    
    private void lunchSeatChoice(Player player, Characters[] characters, String character){
        //0=britney;1=dave;2=rob;3=stella;4=cal
        if (character.equals("Britney")){
            if (player.getFell()==true){
                gui.println("Britney: EW! What's that stain on your pants? Get away "); 
                gui.println("from me."); 
                characters[0].setFriendshipPoints(-2); 
                gui.println("Your current friendship points with " +characters[0].getCharacterName()+": "+characters[0].getFriendshipPoints());
                gui.println("Find another seat."); 
            }
            else{
                gui.println("Britney: Hey, I like your pants."); 
                gui.println("You sit next to Britney and talk to her for the rest "); 
                gui.println("of lunch."); 
                characters[0].setFriendshipPoints(+1); 
                gui.println("Your current friendship points with " +characters[0].getCharacterName()+": "+characters[0].getFriendshipPoints());
                player.setLunch("passed"); 
                player.setLunchSeat(false); 
                player.setInClass(false); 
                gui.println("Now it's time for the next thing on your schedule."); 
            }
        }
        else if(character.equals("Dave")){
            gui.println("Dave: Do I know you..."); 
            characters[1].setFriendshipPoints(-1); 
            gui.println("Your current friendship points with " +characters[1].getCharacterName()+": "+characters[1].getFriendshipPoints());
            gui.println("Find another seat."); 
        }
        else if(character.equals("Rob")){
            gui.println("Rob: Yo! How's it hanging, new kid?"); 
            characters[2].setFriendshipPoints(+2); 
            gui.println("You sit next to Rob and talk to him for the rest of "); 
            gui.println("lunch."); 
            gui.println("Your current friendship points with " +characters[2].getCharacterName()+": "+characters[2].getFriendshipPoints());
            player.setLunch("passed"); 
            player.setLunchSeat(false); 
            player.setInClass(false); 
            gui.println("Now it's time for the next thing on your schedule."); 
        }
        else if(character.equals("Stella")){
            if(player.getFell()==true){
                gui.println("Stella: Hey, I saw you fall-it looks like it hurt. Are "); 
                gui.println("you okay?"); 
            }
            else{
                gui.println("Stella: Hey, how's it going?"); 
            }
            characters[3].setFriendshipPoints(+2);
            gui.println("You sit next to Stella and talk to her for the rest of "); 
            gui.println("lunch."); 
            gui.println("Your current friendship points with " +characters[3].getCharacterName()+": "+characters[3].getFriendshipPoints());
            player.setLunch("passed"); 
            player.setLunchSeat(false); 
            player.setInClass(false); 
            gui.println("Now it's time for the next thing on your schedule."); 
        }
        else if(character.equals("Cal")){
            gui.println("Cal: Hey, new kid. 'Sup?"); 
            characters[4].setFriendshipPoints(+1);
            gui.println("You sit next to Cal and talk to him for the rest of "); 
            gui.println("lunch."); 
            gui.println("Your current friendship points with " +characters[4].getCharacterName()+": "+characters[4].getFriendshipPoints());
            player.setLunch("passed");
            player.setLunchSeat(false); 
            player.setInClass(false); 
            gui.println("Now it's time for the next thing on your schedule."); 
        }
    }
    
    private void bullyGame(String commandWord, Player player){
        int min=0; 
        int max=1; 
        Random randomGenerator = new Random(); 
        int randomInt = randomGenerator.nextInt(max - min + 1) + min;
        
        int num=0; 
        ArrayList inventory=player.getInventory(); 
        for (int x=0;x<inventory.size();x++){
            if (player.getOneItemsName(x).equals("lunch")){
                player.setHasLunch(true); 
                num=x; 
            }
        }
        
        switch(commandWord){
            case "0": 
                if (randomInt==0){ 
                    gui.println("You try to calm the bully down through words, but that "); 
                    gui.println("only makes him angrier.");
                    player.setBullyPoints(-1); 
                }
                else{ 
                    gui.println("You try to calm the bully down through words,and it "); 
                    gui.println("surprisingly works!");
                    player.setBullyPoints(1); 
                }
                break; 
            case "1":
                if (randomInt==0){ 
                    gui.println("You swing your arm towards his face, but completely "); 
                    gui.println("miss. The bully is growing angrier"); 
                    player.setBullyPoints(-1); 
                }
                else{ 
                    gui.println("You punch your fist in his chest and the bully is "); 
                    gui.println("caught off guard."); 
                    player.setBullyPoints(1); 
                }
                break; 
            case "2": 
                if (player.getHasLunch()==true){
                    gui.println("You understand now.");  
                    gui.println("You pass over your lunch to the bully and he walks off "); 
                    gui.println("the bus."); 
                    player.removeFromInventory(player.getInventoryItem(num)); 
                    player.setBullyGame("passed"); 
                    player.setHasLunch(false); 
                }
                else{
                    gui.println("You do not have your lunch to give."); 
                }
                break; 
            case "3": 
                gui.println("The bully is shocked. "); 
                gui.println("He doesn't know what to do, but he definitely doesn't "); 
                gui.println("respect you.");  
                player.setBullyPoints(-1); 
                break; 
            //do i even need a default? 
            default: 
                gui.println("Please enter a number 0-3."); 
                break; 
        }
        if ((player.getBullyPoints()==8)||(player.getBullyPoints()==-16)){
            gui.println(""); 
            gui.println("The bully is incredibly frustrated with you and gives ");  
            gui.println("up. He walks off the bus, leaving you terrified."); 
            player.setBullyGame("passed"); 
        }
    }
    
    private void mathClass(String commandWord,Player player){
        switch(commandWord){
            case "0": 
                gui.println("You are free to use the bathroom."); 
                player.setOutOfClass(true); 
                break; 
            case "1":
                gui.println("You are free to go to the vending machines."); 
                player.setOutOfClass(true);
                break; 
            case "2": 
                int min=0; 
                int max=2; 
                Random randomGenerator = new Random(); 
                int randomInt = randomGenerator.nextInt(max - min + 1) + min; 
                if(randomInt>0){ 
                    gui.println("You walk out of class and are immediately caught by "); 
                    gui.println("the principal. Go to the principal's office."); 
                    player.setOutOfClass(true);
                    player.setSentToPrincipal(true); 
                }
                else{ 
                    gui.println("You walk out of class and return with one minute left "); 
                    gui.println("in the period. It's time for the next class.");  
                    player.setInClass(false);
                    player.setMathClass("passed"); 
                }
                break; 
            case "3": 
                gui.println("You stay in class the rest of the period. Now it's "); 
                gui.println("time for the next thing on your schedule."); 
                player.setInClass(false);
                player.setMathClass("passed"); 
                break; 
            default: 
                gui.println("Please enter a number 0-3."); 
                break; 
        }
    }
    
    private void englishClass(String commandWord, Player player, Quiz[] qList, Characters[] characters){
        int min=0; 
        int max=10; 
        Random randomGenerator = new Random(); 
        int randomInt = randomGenerator.nextInt(max - min + 1) + min; 
        
        switch(commandWord){
            case "0": 
                gui.println("You don't care about the outcome of this pop quiz."); 
                gui.println("You fill in random answers for every single "); 
                gui.println("question and finish within two minutes. When you "); 
                gui.println("hand it in, the teacher takes one look at the "); 
                gui.println("paper and fails you. You sit there in your chair "); 
                gui.println("doing nothing until the end of the period."); 
                gui.println("Now it's time for the next thing on your schedule."); 
                player.setInClass(false);
                player.setEnglishClass("passed"); 
                break; 
            case "1":
                gui.println("You decide to cheat, at the risk of being caught."); 
                if (randomInt<=5){
                    gui.println("The teacher catches you and automatically fails you."); 
                    gui.println("You get sent to the principal's office."); 
                    gui.println("Go to the principal's office."); 
                    player.setOutOfClass(true);
                    player.setSentToPrincipal(true); 
                }
                else if(randomInt<8){
                    gui.println("You cheat off your classmate and ace the pop quiz!");
                    gui.println("Now it's time for the next thing on your schedule."); 
                }
                else{
                    gui.println("You cheat off your classmate and get a 70%. You can do "); 
                    gui.println("better next time."); 
                    gui.println("Now it's time for the next thing on your schedule."); 
                }
                player.setInClass(false);
                player.setEnglishClass("passed"); 
                break; 
            case "2": 
                gui.println("You decide to use your own knowledge on this pop quiz "); 
                gui.println("and try your best. After about 45 very stressful "); 
                gui.println("minutes, you hand in your quiz."); 
                gui.println("You recieved a "+randomInt+"0%."); 
                gui.println("Now it's time for the next thing on your schedule."); 
                player.setInClass(false);
                player.setEnglishClass("passed"); 
                break; 
            case "3": 
                if (randomInt<=5){
                    gui.println("You walk out of class and are immediately caught by "); 
                    gui.println("the principal. Go to the principal's office."); 
                    player.setOutOfClass(true);
                    player.setSentToPrincipal(true); 
                }
                else{
                    gui.println("You walk out of class and return with one minute left "); 
                    gui.println("in the period."); 
                    gui.println("It's time for the next thing on your schedule");  
                    player.setInClass(false);
                    player.setEnglishClass("passed"); 
                }
                break; 
            default: 
                gui.println("Please enter a number 0-3."); 
                break; 
        }
    } 
    
    private void gymClass(String commandWord, Characters[] characters, Player player){
        int min=0; 
        int max=5; 
        Random randomGenerator = new Random(); 
        int randomInt = randomGenerator.nextInt(max - min + 1) + min;
        
        switch(commandWord){
            //0 to run the three miles, 1 to hide in the locker room hallway 
            //2 to skip class, or 3 to fake a sick stomach 
            case "0": 
                gui.println("You choose to run the three miles."); 
                if(randomInt<4){
                    gui.println("By the end of class, you have huge sweat stains."); 
                    gui.println("When you go to the locker room, you can't find your "); 
                    gui.println("shirt from earlier. You're stuck wearing your smelly"); 
                    gui.println("gym shirt for the rest of the day."); 
                }
                else{
                    gui.println("You run the three miles within 40 minutes."); 
                    gui.println("Record time!"); 
                }
                gui.println("Now it's time for the next class."); 
                player.setInClass(false);
                player.setGymClass("passed"); 
                break; 
            case "1":
                gui.println("You decide to hide in the locker room."); 
                gui.println("Stella is there too."); 
                gui.println("You and her stay in there the rest of the period."); 
                if (randomInt<5){
                    gui.println("The two of you bond over your hatred for gym class and"); 
                    gui.println("become friends by the end of the period."); 
                    characters[3].setFriendshipPoints(+2);
                }
                else{ 
                    gui.println("At one point, you make an awkward, self-deprecating "); 
                    gui.println("joke. She doesn't laugh."); 
                    gui.println("the rest of the period is spent in silence."); 
                }
                gui.println("Your current friendship points with " +characters[3].getCharacterName()+": "+characters[3].getFriendshipPoints());
                gui.println("Now it's time for the next thing on your schedule."); 
                player.setInClass(false); 
                player.setGymClass("passed"); 
                break; 
            case "2":
                if(randomInt>3){ 
                    gui.println("You walk out of class and are immediately caught by ");  
                    gui.println("the principal. Go to the principal's office."); 
                    player.setOutOfClass(true);
                    player.setSentToPrincipal(true); 
                }
                else{
                    gui.println("You walk out of class and return with one minute left "); 
                    gui.println("in the period. It's time for the next class.");  
                    player.setInClass(false);
                    player.setGymClass("passed"); 
                }
                break; 
            case "3": 
                gui.println("You fake a sick stomach."); 
                gui.println("You sit on the sidelines along with Dave."); 
                if (randomInt>3){
                    gui.println("The two of you bond over your hatred for gym class and"); 
                    gui.println("become friends by the end of the period."); 
                    characters[1].setFriendshipPoints(+2);
                }
                else{
                    gui.println("At one point, you make an awkward, self-deprecating joke."); 
                    gui.println("He doesn't laugh."); 
                    gui.println("the rest of the period is spent in silence."); 
                }
                gui.println("Your current friendship points with " +characters[1].getCharacterName()+": "+characters[1].getFriendshipPoints());
                gui.println("Now it's time for the next class.");  
                player.setInClass(false);
                player.setGymClass("passed"); 
                break; 
            default: 
                gui.println("Please enter a number 0-3."); 
                break; 
        }
    }
    
    private void chemistryClass(String commandWord, Player player){
        switch(commandWord){
            case "0": 
                gui.println("You are free to use the bathroom."); 
                player.setOutOfClass(true); 
                break; 
            case "1":
                gui.println("You are free to go to the vending machines."); 
                player.setOutOfClass(true); 
                break; 
            case "2": 
                int min=0; 
                int max=2; 
                Random randomGenerator = new Random(); 
                int randomInt = randomGenerator.nextInt(max - min + 1) + min; 
                if(randomInt>0){ 
                    gui.println("You walk out of class and are immediately caught by the");  
                    gui.println("principal. Go to the principal's office."); 
                    player.setOutOfClass(true);
                    player.setSentToPrincipal(true); 
                }
                else{
                    gui.println("You walk out of class and return with one minute left"); 
                    gui.println("in the period. It's the end of the school day.");  
                    player.setInClass(false);
                    player.setChemistryClass("passed"); 
                    clubMeeting(); 
                }
                break; 
            case "3": 
                gui.println("You stay in class the rest of the period. "); 
                gui.println("It's the end of the school day."); 
                clubMeeting(); 
                player.setInClass(false);
                player.setChemistryClass("passed"); 
                break; 
            default: 
                gui.println("Please enter a number 0-3."); 
                break; 
        }
    }
    
    private void clubMeeting(){
        gui.println("There are three clubs going on after school today."); 
        gui.println("   - Drama Club in the Auditorium"); 
        gui.println("   - Basketball in the gym"); 
        gui.println("   - Dungeons and Dragons in Room 102"); 
        gui.println("Go to the room of the club you want to attend.");  
        gui.println("If you don't want to go to a club meeting, go to the "); 
        gui.println("school's entrance outside."); 
    }
    
    public void dnd(){
        gui.println("In the far corner of the room is Dave, scrolling "); 
        gui.println("through a Dungeons and Dragons Players' Handbook."); 
        gui.println("You go to talk to Dave, but someone walks in front of "); 
        gui.println("you..."); 
    }
    
    public void dramaClub(){
        gui.println("On the stage stands Stella, reading "); 
        gui.println("through a script of The Crucible."); 
        gui.println("You go to talk to Stella, but someone walks in front "); 
        gui.println("of you..."); 
    }
    
    public void basketball(){
        gui.println("Near the far hoop stands Rob, "); 
        gui.println("dribbling a basketball. You go to talk to "); 
        gui.println("Rob, but someone walks in front of you..."); 
    }
    
    public void finalChallenge(Player player){
        player.setFinalChallenge("true"); 
        gui.println(""); 
        gui.println("To talk to the character, you have to deal with "); 
        gui.println("side characters who get in your way. Use stuff you"); 
        gui.println("picked up around school to help you. If you can't"); 
        gui.println("find something, feel free to look around the school."); 
        gui.println("Side characters will not let you move on until you help "); 
        gui.println("them."); 
        gui.println("");  
        
        player.setChallenge1("true"); 
        gui.println("A freshman named Pat comes up to you crying about a "); 
        gui.println("paper cut on her thumb. "); 
    }
    
    public void challengeUse(Player player, Command command, Characters[] characters){
        boolean hasItem=false; 
        int num=0; 
        ArrayList inventory=player.getInventory(); 
        for (int x=0;x<inventory.size();x++){
            if (player.getOneItemsName(x).equals(command.getSecondWord())){
                hasItem=true; 
                num=x; 
            }
        }
        if(hasItem==false){
            gui.println("You don't have this item to use."); 
        }
        else{
            if ((player.getChallenge1().equals("true"))&&(command.getSecondWord().equals("Band-Aid"))){
                player.use(player.getOneItemsName(num)); 
                gui.println("Pat thanks you and walks away."); 
                player.setChallenge1("passed"); 
                player.setChallenge2("true"); 
                gui.println("Another freshman named Tick comes up to you and starts"); 
                gui.println("asking about the weather. "); 
                gui.println("Tick: I want to go outside, but I'm afraid it might be "); 
                gui.println("too sunny."); 
            }
            else if ((player.getChallenge2().equals("true"))&&(command.getSecondWord().equals("hat"))){
                player.use(player.getOneItemsName(num)); 
                gui.println("Tick thanks you and walks away."); 
                player.setChallenge2("passed"); 
                player.setChallenge3("true"); 
                gui.println("A sophomore named Cat comes up to you complaining "); 
                gui.println("about the lack of. decorations in her locker."); 
                gui.println("Cat: I know it's only the first day, but my locker "); 
                gui.println("needs something cool!"); 
            }
            else if ((player.getChallenge3().equals("true"))&&(command.getSecondWord().equals("succulent"))){
                player.use(player.getOneItemsName(num)); 
                gui.println("Cat thanks you and walks away."); 
                player.setChallenge3("passed"); 
                player.setChallenge4("true"); 
                gui.println("Another sophomore named Lily comes up to you in a "); 
                gui.println("panic."); 
                gui.println("Lily: I lost my lucky pen! I have a history test "); 
                gui.println("tomorrow–I NEED my lucky pen."); 
            }
            else if ((player.getChallenge4().equals("true"))&&(command.getSecondWord().equals("dinosaurPen"))){
                player.use(player.getOneItemsName(num)); 
                gui.println("Lily thanks you and walks away."); 
                player.setChallenge4("passed"); 
                player.setChallenge5("true"); 
                gui.println("A junior named Momo comes up to you."); 
                gui.println("Momo: I'm going on a date tonight and I don't have any "); 
                gui.println("make-up. What am I gonna do?"); 
            }
            else if ((player.getChallenge5().equals("true"))&&(command.getSecondWord().equals("lipstick"))){
                player.use(player.getOneItemsName(num)); 
                gui.println("Momo thanks you and walks away."); 
                player.setChallenge5("passed"); 
                player.setFinalChallenge("passed"); 
                theEnd(player, characters); 
            }
            else{
                gui.println("This isn't the right item to use."); 
            }
        }
    }
    
    public void principalsOffice(Player player, Quiz[] qList, Characters[] characters){
        player.erasePQNum(); 
        player.setPrincipalsVisits(1); 
        if(player.getPrincipalsVisits()>=3){
            gui.println("You've been sent to the principal's office too many "); 
            gui.println("times."); 
            gui.println("You are being sent home."); 
            theEnd(player, characters); 
        }
        else{
            player.setPrincipal(true); 
            gui.println("Welcome to the principal's office."); 
            gui.println("Once you are sent to the principal's office a third "); 
            gui.println("time, you lose the game. You must answer five "); 
            gui.println("questions correctly in order to continue with the game."); 
            makePQuestion(player, qList); 
        }
    }
    
    public void makePQuestion(Player player, Quiz[] qList){
        int min=0; 
        int max=19; 
        Random randomGenerator = new Random(); 
        int randomInt = randomGenerator.nextInt(max - min + 1) + min; 
        
        player.setPQuestion(randomInt); 
        gui.print(qList[randomInt].getQuestion()); 
    }
    
    public void theEnd(Player player, Characters[] characters){
        //0=britney;1=dave;2=rob;3=stella;4=cal
        if(player.getClubRoom().equals("room102")){
            gui.println("You walk up to Dave."); 
            gui.println("He shows you how to play D&D."); 
            characters[1].setFriendshipPoints(3); 
        }
        else if(player.getClubRoom().equals("auditorium")){
            gui.println("You walk up to Stella."); 
            gui.println("She shows you how to cry on demand."); 
            characters[3].setFriendshipPoints(3); 
        }
        else if(player.getClubRoom().equals("gym")){
            gui.println("You walk up to Rob."); 
            gui.println("He shows you how to properly dribble a basketball."); 
            characters[2].setFriendshipPoints(3); 
        }
        if(player.getClubRoom()!=""){
            gui.println("The two of you hit it off!"); 
            gui.println("Afterwards, you're invited to go to their house, but "); 
            gui.println("you have to decline."); 
        }
        gui.println("You walk out of school and go home to tell your Mom "); 
        gui.println("about your day."); 
        gui.println("");  
        int friendCounter=0; 
        gui.println("--Your Total Friendship Points--"); 
        for(int x=0;x<characters.length;x++){
            gui.println(characters[x].getCharacterName()+": "+characters[x].getFriendshipPoints()); 
            if(characters[x].getFriendshipPoints()>=6){
                friendCounter+=1; 
            }
        }
        gui.println("");  
        gui.println("To be considered friends, you must have at least six "); 
        gui.println("friendship points with someone."); 
        if(friendCounter==1){
            gui.println("You made "+friendCounter+ " friend."); 
        }
        else{
            gui.println("You made "+friendCounter+ " friends."); 
        }
        if(friendCounter>=3){
            gui.println("Yay! You made your mom proud and made friends on the "); 
            gui.println("first day of school. Even though you came into "); 
            gui.println("challenges, you didn't give up!"); 
        }
        else{
            gui.println("Your mom is slightly worried about your new school "); 
            gui.println("because you didn't make any friends."); 
            gui.println("Maybe tomorrow?"); 
        }
        gui.println("Thanks for playing! Till the next school year..."); 
        gui.enable(false);
    }
    private void endGame()
    {
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
}
