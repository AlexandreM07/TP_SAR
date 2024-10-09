package implementation.event;

import abstracts.Task;
import abstracts.event.QueueBroker;
import abstracts.event.QueueBroker.AcceptListener;

public class TaskAccept extends Task{
	
	private QueueBroker queueBroker;
	private int port;
	private AcceptListener acceptListener;
	
	public TaskAccept(QueueBroker queueBroker, int port, AcceptListener acceptListener) {
		this.queueBroker = queueBroker;
		this.port = port;
		this.acceptListener = acceptListener;
	}
	
	@Override
	public void run() {
		if(this.queueBroker.bind(this.port, this.acceptListener)) {
			EventPump.getInstance().post(this);
		}
	}

}
