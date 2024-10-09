package abstracts.threads;

public abstract class QueueBroker {
	
	public abstract QueueChannel accept(int port);
	
    public abstract QueueChannel connect(String name, int port);
    
    public abstract String getName();
}
