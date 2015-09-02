

import java.io.*;
import java.util.Scanner;


public class TriviaConsole 
{
  public static void main(String[] args) throws IOException
  {
     Scanner conIn = new Scanner(System.in);
	 
	 TriviaGame game;    // the trivia game
	 
    int questNum;       // current question number
    TriviaQuestion tq;  // current question
    String answer;      // answer provided by user

    // Initialze the game
	 game = new TriviaGame("Super Quiz", 10); //GetTriviaGame.useTextFile("game.txt");
	 
	 String loadCode = "Load";
	 String saveCode = "Save";
	 String insertAtHeadCode = "insertH";
	 String insertAtTailCode = "insertT";
	 String exitCode = "Exit";
	 String input = "";
	 
	 do{
		 System.out.println("Welcome to the Pre-Trivia Game Admin Commands.");
		 System.out.println("Enter: " + loadCode + " : to load questions from a file");
		 System.out.println("Enter: " + saveCode + " : to save questions to a file");
		 System.out.println("Enter: " + insertAtHeadCode + " : to set a question to the head of the list");
		 System.out.println("Enter: " + insertAtTailCode + " : to set a question to the end of the list");
		 
		 input = conIn.nextLine();
		 
		 if(input.equalsIgnoreCase(exitCode)){
			 System.out.println("Enjoy The Game!");
			 break;
		 } else if(input.equalsIgnoreCase(loadCode)){
			 System.out.println("You have selected Load: To load from a file, please input the file name");
			 input = conIn.nextLine();
			 game.getAdmin().loadFromFile(input);
		 } else if(input.equalsIgnoreCase(saveCode)){
			 System.out.println("You have selected Save: To save to a file, please input the file name");
			 input = conIn.nextLine();
			 game.getAdmin().saveToFile(input);
			 
		 }else if(input.equalsIgnoreCase(insertAtHeadCode)){
			 System.out.println("You have selected to insert a question to the head of the list: please input the question.");
			 input = conIn.nextLine();
			 String q = input;
			 System.out.println("Please input 1 acceptable answer");
			 input = conIn.nextLine();
			 String a = input;
			 
			 game.getAdmin().insertAtHead(new TriviaQuestion(q, a));
			 
		 } else if(input.equalsIgnoreCase(insertAtTailCode)){
			 System.out.println("You have selected to insert a question to the tail of the list: please input the question.");
			 input = conIn.nextLine();
			 String q = input;
			 System.out.println("Please input 1 acceptable answer");
			 input = conIn.nextLine();
			 String a = input;
			 
			 game.getAdmin().insertAtTail(new TriviaQuestion(q, a));
		 
		 	}
	 }
	 
	 while(input.equalsIgnoreCase(exitCode));
	 
	game.setQuestions(game.getAdmin().getQuestions());
    // Greet the user.
    System.out.println("Welcome to the " + game.getQuizName() + " trivia quiz.");
    System.out.print("You will have " + game.getNumChances() + " chances ");
    System.out.println("to answer " + game.getCurrNumQuestions() + " questions.\n");

    questNum = 0;
    while (!game.isOver())
    {
	   // Get number of next unanswered question.
		do
		  if (questNum == game.getCurrNumQuestions())
		    questNum = 1;
		  else
		    questNum = questNum + 1;
		while (game.isAnswered(questNum));
				  
      // Ask question and handle user's response.
      tq = game.getTriviaQuestion(questNum);
      System.out.println(tq.getQuestion());
      answer = conIn.nextLine();
      if (tq.tryAnswer(answer))
      {
        System.out.println("Correct!\n");
        game.correctAnswer(questNum);
      }
      else
      {
        System.out.println("Incorrect\n");
        game.incorrectAnswer();
      }
    }
   
    System.out.println("\nGame Over");
    System.out.println("\nResults:");
    System.out.print("   Chances used: " + (game.getNumChances() - game.getRemainingChances()));
    System.out.println("   Number Correct: " + game.getNumCorrect());
    System.out.println("\nThank you.\n");
  }
}