package week03;

import java.util.ArrayList;
import java.util.Random;

public class MarkovWord implements IMarkovModel {
	
	private String [] myText;
	private Random myRandom;
	private int myOrder;
	
	public MarkovWord(int order){
		this.myOrder = order;
		this.myRandom = new Random();
	}
	
	//methods from interface
	public void setTraining(String text){
		this.myText = text.split("\\s+");
	}
    
    public void setRandom(int seed){
    	this.myRandom = new Random(seed);
    }
    
    public String getRandomText(int numWords){
    	return "Not working";
    }
    
    public int indexOf(String [] words, WordGram target, int start){
    	for(int i = start; i < words.length; i++){
    		String currentWord = words[i];
    		for(int j = 0; j< target.length(); j++){
    			if(currentWord.equals(target.wordAt(j))){
    				System.out.println("Match! Word " + words[i] + "gram " + target.wordAt(j));
    				if(j == target.length() -1)
    					return i;
    			}
    			else{
    				j = target.length();
    			}
    		}
    	}
    	return -1;
    }
    
    public ArrayList<String> getFollows(WordGram kGram){
	    ArrayList<String> follows = new ArrayList<String>();
	    int pos = 0;
	    while (pos < myText.length){
	    	int index = indexOf(myText, kGram, pos);
	    	if(index == -1 || index + kGram.length() >= myText.length -1){
	    		break;
	    	}
		    follows.add(myText[index + 1]);
		    pos = index + 1;
	    }
	    return follows;
    }
    
}
