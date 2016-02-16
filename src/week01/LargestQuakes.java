package week01;

import java.util.*;

public class LargestQuakes {
	
	public void findLargestQuakes(String source, int howMany){
		EarthQuakeParser parser = new EarthQuakeParser();
		ArrayList<QuakeEntry> list  = parser.read(source);
		//System.out.println("read data for " + list.size());
		ArrayList<QuakeEntry> largests = getLargest(list, howMany);
		for (QuakeEntry qe: largests) { 
            System.out.println(qe);
        }
	}
	
	private int indexOfLargest(ArrayList<QuakeEntry> quakeData){
		double largestMag = 0;
		int indexOfLargest = 0;
		 for (int i = 0; i < quakeData.size(); i++) {
			 QuakeEntry qe = quakeData.get(i);
			 if (qe.getMagnitude() > largestMag) {
				 largestMag = qe.getMagnitude();
				 indexOfLargest = i;
	         }
		 }
		 //System.out.printf("The largest magnitude is %f.2f on position %d \n", largestMag, indexOfLargest);
		
		return indexOfLargest;
	}
	
	private ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
		
		if(quakeData.size() < howMany){
			answer = quakeData;
		}
		else{
			for(int i = 0; i <= howMany; i++){
				int largest = indexOfLargest(copy);
				answer.add(copy.get(largest));
				copy.remove(largest);
			}
		}
		
		return answer;
	}
	
	
}
