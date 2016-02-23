package week03;

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne extends AbstractMarkovModel{
	public MarkovOne() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - 1);
		String key = myText.substring(index, index+1);
		sb.append(key);
		for(int k=0; k < numChars - 1; k++){
			ArrayList<String> follows = getFollows(key);
			String next = follows.get(myRandom.nextInt(follows.size()));
			sb.append(next);
			key = next;
		}
		
		return sb.toString();
	}
	
	public ArrayList<String> getFollows(String key) {
	    ArrayList<String> follows = new ArrayList<String>();
	    int pos = 0;
	    while (pos < myText.length()){
	    	int index = myText.indexOf(key, pos);
		    if(index != -1){
		    	if(index == myText.length()-1){
		    		follows.add(myText.substring(index, index + 1));
		    	}
		    	else{
		    		follows.add(myText.substring(index +1, index + 2));
		    	}
		    	pos = index + 1;
		    }
		    else{
		    	break;
		    }
	    }  
	    return follows;
    }
}
