package abstracts.event;

import implementation.event.Message;

public abstract class QueueChannel {
	
	public interface Listener {
		void received(byte[] msg);
		void sent(Message msg);
		void closed();
	}
	
	public abstract void setListener(Listener l);
	
	public abstract boolean send(Message mst);
	
	public abstract void close();
	
	public abstract boolean closed();

}
