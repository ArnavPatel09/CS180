package homework_7;
/**
 * Homework 7 - Video
 * <p>
 * The Video class represents details common details about a video uploaded
 * to a video sharing platform.
 * This includes their channel name, video name, 
 * duration, and number of views.
 * 
 * 
 * @author Arnav Patel L12
 * @version October 9, 2021
 */
public class Video {
	private Channel channel;
	private int duration;
	private int numViews;
	private java.lang.String videoName;
	
	//constructor
	public Video(java.lang.String videoName, Channel channel, int minutes, int seconds) { 
		numViews = 0;
		this.channel = channel;
		this.duration = (minutes * 60) + seconds;
		this.videoName = videoName;
	}
	
	
	//getters and setters
	
	public java.lang.String getVideoName() { 
		return videoName;
	}
	
	public Channel getChannel() { 
		return channel;
	}
	
	public String getDuration() { 
		java.lang.String s = "";
		int minutes = duration / 60;
		int seconds = duration % 60;
		s = String.format("%d:%d", minutes, seconds);
		return s;
	}
	
	public int getViews() { 
		return numViews;
	}
	
	public void setViews(int numViews) { 
		this.numViews = numViews;
	}
	
	//methods
	public void addView() { 
		numViews++;
	}
	
	public String toString() { 
		int minutes = duration / 60;
		int seconds = duration % 60;
		String s = String.format("Video[%s, %s, %d:%d,%d]",
				   videoName, channel.getChannelName(), minutes, seconds, numViews );
		return s;
	}
	
}
