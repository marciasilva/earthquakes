package week01;


import java.util.*;

public class EarthQuakeClient {
	
	private String source = "D:/Personal/DukeFour/data/nov20quakedata.atom.txt";
	
	public String getSource(){
		return this.source;
	}
	
	
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;              
    }
    
    private ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
           if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        } 
        return answer;
    }
    
    private ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
        	if(qe.getDepth() > minDepth && qe.getDepth() < maxDepth){
        		answer.add(qe);
        	}
        } 
        return answer;
    }
    
    private ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        String searchTitle = new String();
        for (QuakeEntry qe : quakeData){
             switch(where){
             //“start” means the phrase must start the title, “end” means the phrase must end the title and “any” means the phrase is a substring anywhere in the title.
             case "start" : 
             	int start = qe.getInfo().indexOf(" ");
             	searchTitle = qe.getInfo().substring(0, start + 1);
             	break;
             case "end":
             	int end = qe.getInfo().lastIndexOf(" ");
             	searchTitle = qe.getInfo().substring(end, qe.getInfo().length());
             break;
             case "any":
            	 searchTitle = qe.getInfo();
             	break;
             	default:
             		System.out.println("Parâmetro desconhecido.");
             }
             if(searchTitle.contains(phrase)){
            	 answer.add(qe);
             }
        }
        return answer;
    }
    
    public void quakesByPhrase(){
    	  EarthQuakeParser parser = new EarthQuakeParser();
          ArrayList<QuakeEntry> list = parser.read(this.source);
          System.out.printf("Quakes by phrase: read data for %d quakes \n", list.size());
          //ArrayList<QuakeEntry> listPhrase = filterByPhrase(list, "end", "California");
          ArrayList<QuakeEntry> listPhrase = filterByPhrase(list, "any", "Quarry Blast");

          for (QuakeEntry qe : listPhrase) {
             System.out.println(qe); 
          }
          System.out.printf("Found %d quakes that match that criteria \n", listPhrase.size());
    }
    
   
    public void quakesOfDepth(){
	    EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(this.source);
        System.out.printf("Quakes of Depth: read data for %d quakes \n", list.size());
        ArrayList<QuakeEntry> listBig = filterByDepth(list,-4000.0, -2000.0);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
        System.out.printf("Found %d quakes that match that criteria \n", listBig.size());
    }
    
            
    public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		System.out.println(list);
	}
	
	public void bigQuakes() {
	    EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(this.source);
        
        System.out.printf("Big Quakes: read data for %d quakes \n", list.size());
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
        System.out.printf("Found %d quakes that match that criteria \n", listBig.size());
	}
	
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(this.source);

        for(QuakeEntry qe : list){
            System.out.printf("(%4.2f,%4.2f), mag = %4.2f, title = %s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
        
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = parser.read(this.source);
        System.out.println("Close to me: quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
        System.out.printf("Found %d quakes that match that criteria", close.size());

    }
    
    public static void main (String args[]){
    	EarthQuakeClient eqc = new EarthQuakeClient();
       	//eqc.createCSV();
//    	eqc.bigQuakes();
//    	eqc.closeToMe();
    	//eqc.quakesOfDepth();
    	eqc.quakesByPhrase();
//    	ClosestQuakes cq = new ClosestQuakes();
//		cq.findClosestQuakes(eqc.getSource());
//		
//		LargestQuakes lq = new LargestQuakes();
//		lq.findLargestQuakes(eqc.getSource(), 50);
    }
}
