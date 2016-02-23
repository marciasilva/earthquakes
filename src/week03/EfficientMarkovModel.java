package week03;

import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel{
	private int numPredict;
	private HashMap<String, ArrayList<String>> keyMap;
	
	public EfficientMarkovModel(int num) {
		myRandom = new Random();
		keyMap = new HashMap<String,ArrayList<String>>();
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
		buildMap(key);
		for(int k=0; k < numChars - numPredict; k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0) break;
			String next = follows.get(myRandom.nextInt(follows.size()));
			sb.append(next);
			key = key.substring(1) + next;
			buildMap(key);
		}
		printHashMapInfo();
		return sb.toString();
	}
	
	public ArrayList<String> getFollows(String key) {
		return keyMap.get(key);
    }
	
	public String toString(){
		return "This is the EfficientMarkovModel class of order " + numPredict;
	}
	
	public void buildMap(String key){
		if(!keyMap.containsKey(key)){
			ArrayList<String> follows = new ArrayList<String>();
			int pos = 0;
		    while (pos < myText.length()){
		    	int index = myText.indexOf(key, pos);
			    if(index != -1 && (index + (numPredict +1) < myText.length())){
			    	follows.add(myText.substring(index + numPredict, index + (numPredict +1)));
			    	pos = index + 1;
			    }
			    else{
			    	break;
			    }
		    } 
		    keyMap.put(key, follows);
		}		
	}
	
	private void printHashMapInfo(){
		if(keyMap.size() < 20){
			System.out.println(Arrays.asList(keyMap));
		}
		
		System.out.println("Number of keys in the HashMap: " + keyMap.size());
		int max = getLargestArrayList();
		System.out.println("Largest value in the HashMap: " + max);
		for(String key : keyMap.keySet()){
			if(keyMap.get(key).size() == max){
				System.out.println(key);
			}
		}
	}
	
	private int getLargestArrayList(){
		int max = 0;
		for(String key : keyMap.keySet()){
			int size = keyMap.get(key).size();
			if(size > max) max = size;
		}
		return max;
	}
}
