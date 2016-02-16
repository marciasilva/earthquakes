package week02;

import week01.QuakeEntry;
import week01.EarthQuakeParser;
import week01.Location;


/**
 * Write a description of class DifferentSorters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class DifferentSorters {
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "D:/Personal/DukeFour/data/earthQuakeDataWeekDec6sample2.atom.txt";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        
        int quakeNumber = 600;
        System.out.println("\nCompareTo \nPrint quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
        
    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "D:/Personal/DukeFour/data/earthQuakeDataDec6sample1.atom.txt";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        
        int quakeNumber = 50;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }
    
    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "D:/Personal/DukeFour/data/nov20quakedata.atom.txt";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
    
    public void sortByTitleAndDepth(){
    	  EarthQuakeParser parser = new EarthQuakeParser();
          String source = "D:/Personal/DukeFour/data/earthQuakeDataWeekDec6sample2.atom.txt";
          //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
          ArrayList<QuakeEntry> list  = parser.read(source);
          Collections.sort(list, new TitleAndDepthComparator());
          int quakeNumber = 500;
          System.out.println("\nsortByTitleAndDepth \nPrint quake entry in position " + quakeNumber);
          System.out.println(list.get(quakeNumber));
    }
    
    public void sortByLastWordInTitleThenByMagnitude(){
    	 EarthQuakeParser parser = new EarthQuakeParser();
         String source = "D:/Personal/DukeFour/data/earthQuakeDataWeekDec6sample2.atom.txt";
         //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
         ArrayList<QuakeEntry> list  = parser.read(source);
         Collections.sort(list, new TitleLastAndMagnitudeComparator());
         int quakeNumber = 500;
         System.out.println("sortByLastWordInTitleThenByMagnitude \nPrint quake entry in position " + quakeNumber);
         System.out.println(list.get(quakeNumber));
    }
    
    
    public static void main(String args[]){
    	DifferentSorters ds = new DifferentSorters();
    	ds.sortWithCompareTo();
    	ds.sortByTitleAndDepth();
    	ds.sortByLastWordInTitleThenByMagnitude();
    }
}

