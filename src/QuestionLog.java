

public class QuestionLog {
	protected QuestionNode header; // reference to first node of linked 
   
	protected String name;      

	public QuestionLog(String name)	{
		header = null;
		this.name = name;
	}
	
	public QuestionLog(String name, QuestionNode headerNode)	{
		header = headerNode;
		this.name = name;
	}
	
	public boolean insertAtTail(QuestionNode qn){
		add(qn);		
		return true;
	}
	
	public boolean insertAtHead(QuestionNode qn){
		if(header == null){
			header = qn;
			return true;
		} 
		
		if(header.getLink() != null){
			QuestionNode temp = header.getLink();
			header = qn;
			header.setLink(temp);
		}
		
		return true;
	}

	public void add(QuestionNode element)	
	{      		
		if(header == null){
			header = element;
			return;
		}
		QuestionNode node = header;
		
		while(node.getLink() != null){
			node = node.getLink();
		}
		
		node.setLink(element);
	
	}
	
	public TriviaQuestion getQuestion(int i){
		
		int count = 0;
		QuestionNode node;
		node = header;
		while (node != null && count < i)
		{
			count++;
			node = node.getLink();
		}
		
		return node.getTQ();
		
	}

	public int size()

	{
		int count = 0;
		QuestionNode node;
		node = header;
		while (node != null)
		{
			count++;
			node = node.getLink();
		}
		return count;
	}

	public boolean contains(TriviaQuestion element)

	{                 
		QuestionNode node;
		node = header;

		while (node != null) 
		{
			if (element.getQuestion().equalsIgnoreCase(node.getQuestion()))  
				return true;
			else
				node = node.getLink();
		}

		return false;
	}

	public void clear()
	
	{ 
		header = null;
	}

	public String getName()
	
	{
		return name;
	}
}
