package task1.implementation;

import task1.Broker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrokerManager {
	private List<Broker> brokerList;
	
	public BrokerManager() {
		this.brokerList = new ArrayList<Broker>();
	}
	
	public synchronized Broker createBroker(String name) {
		Broker newBroker = new BrokerImplementation(name, this);
		this.brokerList.add(newBroker);
		return newBroker;
	}
	
	public synchronized Broker getBroker(String name) {
		Iterator<Broker> iterator = brokerList.iterator();
		while(iterator.hasNext()) {
			Broker currentBroker = iterator.next();
			if (currentBroker.name == name) {
				return currentBroker;
			}
		}
		return null;
	}
}
