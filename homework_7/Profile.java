package homework_7;
/**
 * Homework 7 - Channel
 * <p>
 * The Profile class represents details about a content viewer.
 * This includes their username, array of Channel objects representing
 * content creators they've subscribed to, and the number of channels
 * subscribed to.
 * 
 * @author Arnav Patel L12
 * @version October 9, 2021
 */
public class Profile {
	//fields
	private int numSubscribed;
	private Channel[] subscribed;
	private final java.lang.String username;
	
	//constructor
	public Profile(java.lang.String username) { 
		this.username = username;
		numSubscribed = 0;
		subscribed = new Channel[100];
	}
	
	//getters and setters
	public java.lang.String getUsername() { 
		return username;
	}
	
	public Channel[] getSubscribed() { 
		return subscribed;
	}
	
	public void setSubscribed(Channel[] subscribed, int numSubscribed) { 
		this.subscribed = subscribed;
		this.numSubscribed = numSubscribed;
	}
	
	//methods
	public boolean subscribeToChannel(Channel channel) {
		if (numSubscribed == 100 || !(findChannel(channel.getChannelName()) == null) ) 
			return false;
		subscribed [numSubscribed] = channel;
		channel.addChannelSubscriber();
		numSubscribed++;
		
		return true;
	}
	
	public Channel findChannel(String channelName) { 
		for (int i = 0; i < subscribed.length; i++) { 
			if(subscribed[i] != null)
				if (subscribed[i].getChannelName().equals(channelName)) 
					return subscribed[i];
		}
		return null;
	}
	
	public String toString() { 
		return String.format("Profile[%s]", username);
	}
	
}
