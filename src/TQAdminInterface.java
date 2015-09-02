
public interface TQAdminInterface {
	public void loadFromFile(String filename);

    public boolean insertAtHead(TriviaQuestion tqNew);

    public boolean insertAtTail(TriviaQuestion tqNew);

    public void saveToFile(String fileName);
}
