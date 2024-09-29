package task1.tests;
import java.util.ArrayList;
import java.util.List;

import task1.Broker;
import task1.BrokerManager;
import task1.ConcreateBroker;
import task1.ConcreateTask;
import task1.Task;
import task1.tests.Logger.LoggerLevel;

public class TestEchoServer {
	public static final LoggerLevel LOG_LEVEL = LoggerLevel.INFO;
	public static final int MESSAGES_TO_TEST = 5; 
	public static final int MAX_BROKER_TEST = 100;
	public static final String MESSAGE_TO_ECHO = "LA TERRE EST PLATE ET UN PLUS UN EGAL ONZE!";
	public static void main(String[] args) {
		testEchoServer();
	}
	
	public static void testEchoServer() {
		BrokerManager brokerManager = new BrokerManager();
		Broker brokerServer = new ConcreateBroker("BrokerServer");
		brokerManager.add(brokerServer);
		Broker brokerClient = new ConcreateBroker("BrokerClient");
		brokerManager.add(brokerClient);
		int port = 8080;
		simpleEchoServer(brokerServer, brokerClient, port);
	}
	
	public static void testEchoSameBroker() {
		BrokerManager brokerManager = new BrokerManager();
		Broker broker = new ConcreateBroker("Broker");
		brokerManager.add(broker);
		int port = 8088;
		simpleEchoServer(broker, broker, port);
	}
	
	public static void testEchoMultipleBroker() {
		BrokerManager brokerManager = new BrokerManager();
		Broker brokerServer = new ConcreateBroker("BrokerServer");
		brokerManager.add(brokerServer);
		List<Task> tasks = new ArrayList<Task>();
		for(int i = 0; i < MAX_BROKER_TEST; i++) {
			Broker brokerClient = new ConcreateBroker("BrokerClient_" + i);
			brokerManager.add(brokerClient);
			
			Task taskServer = new ConcreateTask(brokerServer, new ServerTask(brokerServer, i));
			Task taskClient = new ConcreateTask(brokerClient, new ClientTask(brokerClient, i));
			taskServer.start();
			taskClient.start();
		}
		
		for (Task task : tasks) {
			try {
				task.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
		
	public static void simpleEchoServer(Broker brokerServer, Broker brokerClient, int port) {
		
		Task taskServer = new ConcreateTask(brokerServer, new ServerTask(brokerServer, port));
		
		Task taskClient = new ConcreateTask(brokerClient, new ClientTask(brokerClient, port));
		
		taskServer.start();
		taskClient.start();
		
		try {
			taskServer.join();
			taskClient.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
