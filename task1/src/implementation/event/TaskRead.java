package implementation.event;

import abstracts.Task;
import abstracts.event.QueueChannel;

public class TaskRead extends Task{
	
	private QueueChannel queueChannel;
	private Message msg;
	
	public TaskRead(QueueChannel queueChannel, Message msg) {
		this.queueChannel = queueChannel;
		this.msg = msg;
	}
	
	@Override
	public void run() {
		/* TODO
		if(this.queueChannel.send(msg)) {
			EventPump.getInstance().post(this);
		}*/
	}

}
