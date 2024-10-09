package implementation.event;

import abstracts.Task;
import abstracts.event.QueueChannel;

public class TaskWriter extends Task{
	
	private QueueChannel queueChannel;
	private Message msg;
	
	public TaskWriter(QueueChannel queueChannel, Message msg) {
		this.queueChannel = queueChannel;
		this.msg = msg;
	}
	
	@Override
	public void run() {
		if(this.queueChannel.send(msg)) {
			EventPump.getInstance().post(this);
		}
	}

}
