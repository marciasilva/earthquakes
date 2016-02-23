package week03_oldVersion;

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel {
	private String myText;
	private Random myRandom;
	private int numPredict;
	
	public MarkovModel(int num) {
		myRandom = new Random();
		numPredict = num;
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
		int index = myRandom.nextInt(myText.length() - numPredict);
		String key = myText.substring(index, index + numPredict);
		sb.append(key);
		
		for(int k=0; k < numChars - numPredict; k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0) break;
			String next = follows.get(myRandom.nextInt(follows.size()));
//			System.out.println("next " + next);
			sb.append(next);
			key = key.substring(1) + next;
		}
		
		return sb.toString();
	}
	
	public ArrayList<String> getFollows(String key) {
//		System.out.println("Key = " + key);
		ArrayList<String> follows = new ArrayList<String>();
	    int pos = 0;
	    while (pos < myText.length()){
	    	int index = myText.indexOf(key, pos);
		    if(index != -1){
		    	follows.add(myText.substring(index + numPredict, index + (numPredict +1)));
		    	pos = index + 1;
		    }
		    else{
		    	break;
		    }
	    }  
	    return follows;
    }
}
