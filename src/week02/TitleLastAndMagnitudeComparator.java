package week02;

import week01.QuakeEntry;
import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator <QuakeEntry> {
	
	public int compare(QuakeEntry q1, QuakeEntry q2) {
		if((getLastWord(q1.getInfo()).compareTo(getLastWord(q2.getInfo())) < 0))
			return -1;
		else if((getLastWord(q1.getInfo()).compareTo(getLastWord(q2.getInfo())) > 0))
			return 1;
		else if(q1.getMagnitude() < q2.getMagnitude())
			return -1;
		else if(q1.getMagnitude() > q2.getMagnitude())
			return 1;
		else
			return 0;
	}
	
	private String getLastWord(String data){
		String[] parts = data.split(" ");
		return parts[parts.length - 1];
	}

}
