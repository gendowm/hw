import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TQAdmin implements TQAdminInterface {
	//private String currFileName = "";
	//private TriviaQuestion currTQ;
	private QuestionLog questions;
	private int numChance;
	public TQAdmin(String name, int numChances){
		questions = new QuestionLog(name);
		numChance = numChances;
	}
	
	public QuestionLog getQuestions(){
		return questions;
	}
	
	public boolean useTextFile(String textfile)throws IOException
	  // Precondition:  The textfile exists and contains a correctly formatted game.
	  {
	    ArrayList<TriviaQuestion> questionList = new ArrayList<TriviaQuestion>();
	    
	    int numQuestions;
	    int numChances;

	    // for a specific trivia question
	    TriviaQuestion tq;
	    String question;
	    Scanner triviaIn = new Scanner(textfile);
	    int numAnswers;
	    String skip; // skip end of line after reading integer
		 
	    // Scan in basic trivia quiz information and set variable
	    numQuestions = triviaIn.nextInt();
	    numChances = triviaIn.nextInt();
	    skip = triviaIn.nextLine();
   
	    // Scan in and set up the questions and answers.
	    for (int i = 1; i <= numQuestions; i++)
	    {
	      question = triviaIn.nextLine();
	      numAnswers = triviaIn.nextInt();
	      skip = triviaIn.nextLine();
	      tq = new TriviaQuestion(question, numAnswers);
	      for (int j = 1; j <= numAnswers; j++)
	      {
	        String answer = triviaIn.nextLine();
	        tq.storeAnswer(answer);
	      }
	      questionList.add(tq);	      
	    }
	    
	    questions.clear();
	    
	    for(int i = 0; i < questionList.size(); i++){
	    	questions.add(new QuestionNode(questionList.get(i)));
	    }
	    
	    return true;
		
	    
	  }
	
	public void addQuestion(TriviaQuestion tq){
		questions.add(new QuestionNode(tq));
	}

	@Override
	public void loadFromFile(String filename) {
		try {
			useTextFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertAtHead(TriviaQuestion tqNew) {
		return questions.insertAtHead(new QuestionNode(tqNew));
	}

	@Override
	public boolean insertAtTail(TriviaQuestion tqNew) {
		return questions.insertAtTail(new QuestionNode(tqNew));
	}

	@Override
	public void saveToFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(questions.size());
			bw.write(numChance);
			bw.write("");
			
						
			QuestionNode temp = questions.header;
			while(temp.getLink() != null){
				bw.write(temp.getTQ().getQuestion());
				bw.write(temp.getTQ().getAnswers().size());
				bw.write("");
				
				for(int i = 0; i < temp.getTQ().getAnswers().size(); i++){
					bw.write(temp.getTQ().getAnswers().get(i)); 
				}
			}
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
