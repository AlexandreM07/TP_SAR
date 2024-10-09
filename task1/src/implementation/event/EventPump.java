package implementation.event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import abstracts.Task;

public class EventPump extends Thread{
	
	private static final EventPump instance;
	
	static {
        instance = new EventPump();
    }

	/*
	public enum TasksCategories {
		CONNECT,
		ACCEPT,
		WRITE,
		READ,
		UNDEFINED
	}*/
	
	private final BlockingQueue<Task> tasksQueue;
	private boolean isActive;
	
	private EventPump() {
		this.tasksQueue = new LinkedBlockingQueue<Task>();
		this.isActive = true;
	}
	
	@Override
	public synchronized void run() {
		Task task;
		while(this.isActive) {
			task = instance.tasksQueue.poll();
			while(task != null) {
				task.start();
			}
		}
	}
	
	public boolean remove(Task task) {
		synchronized(this.tasksQueue) {
			return this.tasksQueue.remove(task);
		}
    }

    public synchronized void post(Task task) {
    	if(this.isActive) {
    		synchronized(this.tasksQueue) {
    			this.tasksQueue.offer(task);
    		}
            notify();
    	}
    }
	
	public static synchronized EventPump getInstance() {
        return instance;
    }
	
	public void stopPump() {
    	this.isActive = false;
    }
}
