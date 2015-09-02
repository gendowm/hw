import java.util.ArrayList;




//----------------------------------------------------------------------------
// TriviaGame.java             by Dale/Joyce/Weems                   Chapter 2
//
// Provides trivia game objects.
//----------------------------------------------------------------------------

public class TriviaGame
{
  private String quizName;
  private int numChances;
  private int remainingChances;
  private int numCorrect = 0;
  private int numIncorrect = 0;
  private QuestionLog questions;  // the set of questions
  private ArrayList<Boolean> correct;           // true if corresponding question answered
  private int currNumQuestions = 0;    // current number of questions
  private TQAdmin admin;

  public TriviaGame(String quizName, int numChances)
  // Precondition:  maxNumQuestions > 0 and numChances > 0
  {
    this.quizName = quizName;
    this.numChances = numChances;
    admin = new TQAdmin(this.quizName, this.numChances);
    remainingChances = numChances;
    questions = admin.getQuestions();
    correct = new ArrayList<Boolean>();
  }
  
  public void setQuestions(QuestionLog questions){
	  this.questions = questions;
  }
  public TQAdmin getAdmin(){
	  return admin;
  }

  public String getQuizName()
  {
    return quizName;
  }

  public int getNumChances()
  {
    return numChances;
  }

  public int getRemainingChances()
  {
    return remainingChances;
  }

  public int getNumCorrect()
  {
    return numCorrect;
  }

  public int getNumIncorrect()
  {
    return numIncorrect;
  }

  public int getCurrNumQuestions()
  {
    return currNumQuestions;
  }
  
  public TriviaQuestion getTriviaQuestion(int questionNumber)
  {
	if(questions.size() < questionNumber)
    	return null;
	
	return questions.getQuestion(questionNumber);	
	
	
  }

  public boolean isAnswered(int questionNumber)
  // Precondition:   0 < questionNumber <= currNumQuestions
  {
	  if(correct.size() < questionNumber)
		  return false;
	  
	 return correct.get(questionNumber);
    
  }
  
  public boolean isOver()
  // Returns true if this game is over, false otherwise.
  {
    return (remainingChances <= 0);
  }

  public void insertQuestion(TriviaQuestion question)
   // Adds question to this TriviaGame.
  {
      
	  questions.add(new QuestionNode(question));
	  correct.add(false);
	  currNumQuestions++;
  }
  
  public void correctAnswer(int questionNumber)
  // Preconditions: 0 < questionNumber < maxNumQuestions
  //
  // Updates game status to indicate that question number 
  // "questionNumber" was answered correctly.
  {
	correct.set(questionNumber, true);
    numCorrect = numCorrect + 1;
    remainingChances = remainingChances - 1;
  }

  public void incorrectAnswer()
  // Updates game status to indicate that a question 
  // was answered incorrectly
  {
    numIncorrect = numIncorrect + 1;
    remainingChances = remainingChances - 1;
  } 
}