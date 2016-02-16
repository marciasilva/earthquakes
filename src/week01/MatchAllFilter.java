package week01;

import java.util.*;

public class MatchAllFilter implements Filter {
	
	private ArrayList<Filter> filters;
	
	public MatchAllFilter(){
		filters = new ArrayList<Filter>();
	}
	
	public void addFilter(Filter f){
		filters.add(f);
	}
	
    public  boolean satisfies(QuakeEntry qe){
    	for(Filter f : filters){
    		if(!f.satisfies(qe)){
    			return false;
    		}
    	}
    	return true;
    }
    
    public String getName(){
    	String filtersUsed = new String();
    	for (Filter f : filters){
    		 filtersUsed += " " + f.getName();
    	}
    	return filtersUsed;
    }

}
