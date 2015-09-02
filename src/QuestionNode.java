
public class QuestionNode {
	
	  private TriviaQuestion question;
	  private QuestionNode link;
	  
	  public QuestionNode(TriviaQuestion question)
	  {
	    this.question = question;
	    link = null;
	  }
	 
	  public void setInfo(TriviaQuestion question)
	  
	  {
	    this.question = question;
	  }

	  public String getQuestion()
	  
	  {
	    return question.getQuestion();
	  }
	  
	  public TriviaQuestion getTQ(){
		  return question;
	  }
	 
	  public void setLink(QuestionNode link)
	 
	  {
	    this.link = link;
	  }

	  public QuestionNode getLink()
	 
	  {
	    return link;
	  }
}
