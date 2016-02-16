package week01;

public class DistanceFilter implements Filter{
	private double distMax;
	private Location from;
	private String name;
	
	public DistanceFilter(double max, Location from, String n){
		this.distMax = max;
		this.from = from;
		this.name = n;
	}
	
    public  boolean satisfies(QuakeEntry qe){
    	return qe.getLocation().distanceTo(this.from) < distMax;
    }
    
    public String getName(){
    	return this.name;
    }
}
