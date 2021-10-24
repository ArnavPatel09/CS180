package homework_7;
/**
 * Homework 7 - Channel
 * <p>
 * The Channel class represents details about a content uploader.
 * This includes their channel name, subscribers, an array of Video
 * objects created by them, and the number of uploads.
 * 
 * @author Arnav Patel L12
 * @version October 9, 2021
 */
public class Channel {
	//fields
    /**
     * Name of the channel
     */
    private final java.lang.String channelName;
    /**
     * Number of subscribers of this channel
     */
    private int channelSubscribers;
    /**
     * Number of videos uploaded by this channel. This may be of use when iterating through the videos array.
     */
    private int numUploads;
    /**
     * An array containing videos uploaded by this creator.
     */
    private Video[] videos;
    
    //constructors
    public Channel(java.lang.String channelName) { 
    	this.channelName = channelName;
    	this.numUploads = 0;
    	this.channelSubscribers = 0;
    	this.videos = new Video[100];
    }
    
    public Channel(java.lang.String channelName, int channelSubscribers, int numUploads, Video[] videos) { 
    	this.channelName = channelName;
    	this.channelSubscribers = channelSubscribers;
    	this.numUploads = numUploads;
    	this.videos = videos;
    }
    
    //getters and setters
    public java.lang.String getChannelName() {
		return channelName;
	}
	public int getChannelSubscribers() {
		return channelSubscribers;
	}

	public void setChannelSubscribers(int channelSubscribers) {
		this.channelSubscribers = channelSubscribers;
	}

	public int getNumUploads() {
		return numUploads;
	}
	
	public Video[] getVideos() {
		return videos;
	}
	
	public void setVideos(Video[] videos, int numUploads) {
		this.videos = videos;
		this.numUploads = numUploads;
	}

	
	
	//methods
	public Video findVideo(String videoName) {
		if (videos != null && videoName != null) { 
			for (int i = 0; i < videos.length; i++) { 
				if (videos[i] != null) 
				 if (videos[i].getVideoName().equals(videoName)) 
					 return videos[i];
			}
		}
		return null;
	}
	
	public int getTotalViews() { 
		int total = 0;
		
		for (int i = 0; i < numUploads; i++) { 
			if(videos[i] != null)
				total += videos[i].getViews();
		}
		return total;
	}
	public void addChannelSubscriber() {
		this.channelSubscribers += 1;
	}
	
	public String toString() { 
		String s = "Channel[" + channelName + "" + channelSubscribers + "" + numUploads + "]" ;
		return s;
	}
	
	public boolean uploadVideo(Video video) { 
		if (numUploads == 100 || !(findVideo(video.getVideoName()) == null) ) 
			return false;
		videos[numUploads] = video;
		numUploads++;
		return true;
	}
}
