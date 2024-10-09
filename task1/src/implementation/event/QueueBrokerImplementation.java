package implementation.event;

import abstracts.Broker;
import abstracts.Channel;
import abstracts.threads.QueueBroker;
import abstracts.threads.QueueChannel;
import implementation.BrokerImplementation;
import implementation.BrokerManager;

public class QueueBrokerImplementation extends QueueBroker{
	private String name;
	private BrokerManager brokerManager;
	private Broker broker;
	
	public QueueBrokerImplementation(String name, BrokerManager brokerManager) {
		this.name = name;
		this.brokerManager = brokerManager;
		this.broker = new BrokerImplementation(name, brokerManager);
	}

	@Override
	public QueueChannel accept(int port) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueueChannel connect(String name, int port) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
