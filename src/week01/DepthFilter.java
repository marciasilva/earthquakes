/**
 * 
 */
package week01;

/**
 * @author masilva
 *
 */
public class DepthFilter implements Filter{
	
	private double maximum;
	private double minimum;
	private String name;
	
	public DepthFilter(double min, double max, String n){
		this.maximum = max;
		this.minimum = min;
		this.name = n;
	}
	
    public  boolean satisfies(QuakeEntry qe){
    	return qe.getDepth()>= this.minimum && qe.getDepth() <= this.maximum;
    }
	
    public String getName(){
    	return this.name;
    }

}
