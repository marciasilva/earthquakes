package week01;


public class QuakeEntry implements Comparable<QuakeEntry>{
	
	private Location myLocation;
	private String title;
	private double depth;
	private double magnitude;

	public QuakeEntry(double lat, double lon, double mag, 
	                  String t, double d) {
		myLocation = new Location(lat,lon);
		
		magnitude = mag;
		title = t;
		depth = d;
	}
	
	public Location getLocation(){
		return myLocation;
	}
	
	public double getMagnitude(){
		return magnitude;
	}
	
	public String getInfo(){
		return title;
	}
	
	public double getDepth(){
		return depth;
	}

	@Override
	//Compare based on magnitude first, and then by depth
	public int compareTo(QuakeEntry qe) {
		int diffQuake = 0;
		
		if(magnitude > qe.getMagnitude()){
			return 1;
		}
		else if(magnitude < qe.getMagnitude()){
			return -1;
		}
		else if(depth < qe.getDepth()){
			return -1;
		}
		else if(depth > qe.getDepth()){
			return 1;
		}
		return diffQuake;
		
	}
	
	public String toString(){
		return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s", myLocation.getLatitude(),myLocation.getLongitude(),magnitude,depth,title);
	}
	
}
