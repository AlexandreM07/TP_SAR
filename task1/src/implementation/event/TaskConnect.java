package implementation.event;

import abstracts.Task;
import abstracts.event.QueueBroker;
import abstracts.event.QueueChannel;
import abstracts.event.QueueBroker.ConnectListener;

public class TaskConnect extends Task{
	
	private QueueBroker queueBroker;
	private String name;
	private int port;
	private ConnectListener connectListener;
	
	public TaskConnect(QueueBroker queueBroker, String name, int port, ConnectListener connectListener) {
		this.queueBroker = queueBroker;
		this.name = name;
		this.port = port;
		this.connectListener = connectListener;
	}
	
	@Override
	public void run() {
		if(this.queueBroker.connect(this.name, this.port, this.connectListener)) {
			EventPump.getInstance().post(this);
		}
	}

}
