package week01;

public class MagnitudeFilter implements Filter {
	private double maximum;
	private double minimum;
	private String name;
	
	public MagnitudeFilter(double min, double max, String n){
		this.maximum = max;
		this.minimum = min;
		this.name = n;
	}
	
    public  boolean satisfies(QuakeEntry qe){
    	return qe.getMagnitude() >= this.minimum && qe.getMagnitude() <= this.maximum ;
    }
    
    public String getName(){
    	return this.name;
    }
}
