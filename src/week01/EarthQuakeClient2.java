package week01;

import java.util.*;

public class EarthQuakeClient2
{
	
	private String source = "D:/Personal/DukeFour/data/nov20quakedata.atom.txt";
	
	public String getSource(){
		return this.source;
	}
	
	public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        ArrayList<QuakeEntry> list  = parser.read(this.source);
        ArrayList<QuakeEntry> answer1 = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> answer2 = new ArrayList<QuakeEntry>();
        System.out.println("read data for "+list.size()+" quakes");
        //Magnitude Depth Phrase
        MatchAllFilter maf1 = new MatchAllFilter();
        Filter fMag = new MagnitudeFilter(0.0, 5.0, "Magnitude");
        Filter fDepth = new DepthFilter(-180000.0, -30000.0, "Depth");
        Filter fPhrase = new PhraseFilter("any", "e", "Phrase");
        
        maf1.addFilter(fMag);
       //maf1.addFilter(fDepth);
        maf1.addFilter(fPhrase);
        
       // fMag = new MagnitudeFilter(0.0, 3.0);
        Location loc = new Location(55.7308, 9.1153);
        Filter fDistance = new DistanceFilter(3000000, loc, "Distance");
        
        MatchAllFilter maf2 = new MatchAllFilter();
        maf1.addFilter(fDistance);
        maf2.addFilter(fPhrase);
        

        for(QuakeEntry qe : list){
        	if (maf1.satisfies(qe)){
        		answer1.add(qe);
        	}
        
        }
        
        System.out.println("Criterios fitro 1");
        System.out.println("Filters used are: " + maf1.getName()+ " Founded: " + answer1.size());

        for (QuakeEntry qe : answer1) {
            System.out.println(qe); 
         }
        
//        System.out.println("__________________");  
//        
//        System.out.println("Criterios fitro 2");
//        System.out.println("Filters used are:" + maf2.getName()  + " Founded: " + answer2.size());
//        for (QuakeEntry qe : answer2) {
//            System.out.println(qe); 
//         }

    }
    
    public static void main(String args[]){
    	EarthQuakeClient2 eqc2 = new EarthQuakeClient2();
    	eqc2.quakesWithFilter();
    }

}

