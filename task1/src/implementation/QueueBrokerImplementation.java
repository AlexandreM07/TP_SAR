package implementation;

import abstracts.Broker;
import abstracts.Channel;
import abstracts.QueueBroker;
import abstracts.QueueChannel;

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
    	Channel serverChannel = this.broker.accept(port);
    	return new QueueChannelImplementation(serverChannel);
    }

	@Override
    public QueueChannel connect(String name, int port) {
    	Channel clientChannel = this.broker.connect(name, port);
    	return new QueueChannelImplementation(clientChannel);
    }
    
	@Override
    public String getName() {
    	return this.name;
    }
}
