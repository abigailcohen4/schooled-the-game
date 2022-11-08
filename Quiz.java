
/**
 * class for trivia questions in principal's office 
 * 
 * @author Abi Cohen 
 * @version 5
 */
public class Quiz
{
    // instance variables - replace the example below with your own
    private String question;
    private String answer;

    /**
     * Constructor for objects of class Quiz
     */
    public Quiz(String q, String a)
    {
        question=q;
        answer=a; 
    }

    public String getQuestion(){
        return question; 
    }
    
    public String getAnswer(){
        return answer; 
    }
}
