package week02;

import java.util.*;

import week01.QuakeEntry;
import week01.EarthQuakeParser;

public class QuakeSort {
    public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
        QuakeEntry min = quakes.get(0);
        for(QuakeEntry q: quakes) {
            if (q.getMagnitude() < min.getMagnitude()) {
                min = q;
            }
        }
        return min;
    }
    
    //Get the index with the smallest magnitude 
    public int getSmallestSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from){
    	int minIdx = from;
    	for(int i = from + 1; i < quakes.size(); i++){
    		if(quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()){
    			minIdx = i;
    		}
    	}
    	return minIdx;
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
    	int maxIdx = from;
    	for(int i = from + 1; i < quakeData.size(); i++){
    		if(quakeData.get(i).getDepth() > quakeData.get(maxIdx).getDepth()){
    			maxIdx = i;
    		}
    	}
    	return maxIdx;
    }
    
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
    	for(int i = 0; i< 70; i++){
    		int maxIdx = getLargestDepth(in, i);
    		QuakeEntry qe = in.get(i);
    		QuakeEntry qMax = in.get(maxIdx);
    		in.set(i, qMax);
    		in.set(maxIdx, qe);
    	}
    	
    	for(QuakeEntry qe: in) {
            System.out.println(qe);
        }
    }
    
    public void sortByMagnitudeInPlace(ArrayList<QuakeEntry> in){
    	for(int i = 0; i < in.size(); i++){
    		 int minIdx = getSmallestSmallestMagnitude(in,i);
    		 QuakeEntry qe = in.get(i);
    		 QuakeEntry qMin = in.get(minIdx);
    		 in.set(i, qMin);
    		 in.set(minIdx, qe);
    	}
    	
    	 for(QuakeEntry qe: in) {
             System.out.println(qe);
         }
    }
    
    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
        //out starts as empty ArrayList
        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
        //As long as in is not empty
        while(!in.isEmpty()) {
            //Find smallest element in in (minElement)
            QuakeEntry minElement = getSmallestMagnitude(in); 
            //Remove minElement from in
            in.remove(minElement);                            
            //Add minElement to out
            out.add(minElement);
        }
        //out is the answer
        return out;
    }
    
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
    	for(int i = 0; i < quakeData.size() - numSorted - 1 ; i++){
    		 QuakeEntry qa = quakeData.get(i);
    		 QuakeEntry qb = quakeData.get(i+1);
    		if(qa.getMagnitude() > qb.getMagnitude()){
    			quakeData.set(i, qb);
    			quakeData.set(i+1,qa);
    		}
    	}
    	
    }
    
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
    	for (int i = 0; i < in.size(); i++){
    		onePassBubbleSort(in,i);
       	}
    	
    	 for(QuakeEntry qe: in) {
             System.out.println(qe);
         }
    }
    
    //check if it is ordered by magnitude
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
    	for(int i = 0; i < quakes.size() -1; i++){
    		QuakeEntry qa = quakes.get(i);
   		 	QuakeEntry qb = quakes.get(i+1);
   		 	if(qa.getMagnitude() > qb.getMagnitude()){
   		 		return false;
   		 	}
    	}
    	return true;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
    	for (int i = 0; i < in.size(); i++){
    		onePassBubbleSort(in,i);
    		if(checkInSortedOrder(in)){
    			System.out.println("It was necessary " + (i+1) + " steps to order");
    			i = in.size();
    		}
       	}
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
    	for(int i = 0; i < in.size(); i++){
    		int minIdx = getSmallestSmallestMagnitude(in,i);
   		 	QuakeEntry qe = in.get(i);
   		 	QuakeEntry qMin = in.get(minIdx);
   		 	in.set(i, qMin);
   		 	in.set(minIdx, qe);
   		 	if(checkInSortedOrder(in)){
   		 		System.out.println("\nsortByMagnitudeWithCheck \nIt was necessary " + (i+1) + " steps to order");
   		 		i = in.size();
   		 	}
    	}
    }
    
    
    /* tester method to use in BlueJ */
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "D:/Personal/EarthQuakes/data/earthQuakeDataWeekDec6sample2.atom.txt";
        
        ArrayList<QuakeEntry> list = parser.read(source);
        //sortByMagnitudeInPlace(list);
        //sortByLargestDepth(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
//       list = parser.read(source);
//
        //sortByMagnitudeWithCheck(list);
    }
    
    public static void main(String args[]){
    	QuakeSort qs = new QuakeSort();
    	qs.testSort();
    }

}