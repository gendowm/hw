
import java.util.ArrayList;

public class TriviaQuestion 
{
  private int numAnswers;             // category of question
  private String question;             // the question
  private ArrayList<String> answers;  // acceptable answers

  public TriviaQuestion(String question, int numAnswers)
  // Precondition:  maxNumAnswers > 0 
  {
     
	 this.question = question;
	 this.numAnswers = numAnswers;
	 answers = new ArrayList<String>();
	 
  }
  
  public TriviaQuestion(String question, String answer){
	  this.question = question;
	  answers = new ArrayList<String>();
	  answers.add(answer);
  }
  
  public ArrayList<String> getAnswers(){
	  return answers;
  }

  public void setNumAnswers(int i){
	  numAnswers = i;
  }
  
  public int getNumAnswers(){
	  return numAnswers;
  }
   
  public String getQuestion()
  {
    return question;
  }

  public boolean tryAnswer(String answer)
  {
	for(int i = 0; i < answers.size(); i++)
	{
		if(answer.equalsIgnoreCase(answers.get(i))){
			return true;
		}
	}
	
    return false;
  }	 

  public void storeAnswer(String answer)
  {
    answers.add(answer);
  }
}