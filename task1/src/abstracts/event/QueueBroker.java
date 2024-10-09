package abstracts.event;

public abstract class QueueBroker {
	
	public interface AcceptListener {
		void accepted(QueueChannel queue);
	}
	
	public interface ConnectListener {
		void connected(QueueChannel queue);
		void refused();
	}
	
	public abstract boolean bind(int port, AcceptListener listener);
	
	public abstract boolean unbind(int port);
	
	public abstract boolean connect(String name, int port, ConnectListener listener);
}
