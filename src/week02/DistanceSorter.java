package week02;

import java.util.*;

import week01.QuakeEntry;
import week01.EarthQuakeParser;
import week01.Location;


public class DistanceSorter {
    
    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "D:/Personal/DukeFour/data/nov20quakedata.atom.txt";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //You know what would be amazing?  If the Location class documented
        //whether east or west were positive!
        Location where = new Location(35.9886, -78.9072);
        
        //compare based on where location
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    } 
}

