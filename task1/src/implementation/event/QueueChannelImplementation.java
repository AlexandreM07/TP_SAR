package implementation.event;

import java.nio.charset.StandardCharsets;

import abstracts.Channel;
import abstracts.threads.QueueChannel;
import implementation.ChannelDisconnectedException;
import tests.Logger;

public class QueueChannelImplementation extends QueueChannel{
	
	private Channel channel;
	
	public QueueChannelImplementation(Channel channel) {
		this.channel = channel;
	}

	/*
	 * Send fait une copie du tableau de bytes. Le tableau de bytes dont on donne la référence en paramètre
	 * peut être modifié sans risque.	
	 */
	@Override
	public void send(byte[] bytes, int offset, int length) {
		// TODO Auto-generated method stub
	}

	@Override
	public byte[] receive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean closed() {
		// TODO Auto-generated method stub
		return false;
	}

}
