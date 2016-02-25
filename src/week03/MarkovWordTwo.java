package week03;

import java.util.ArrayList;
import java.util.Random;

public class MarkovWordTwo {
	private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		int index2 = 0;
		String key1 = myText[index];
		String key2 = myText[index + 1];
		sb.append(key1);
		sb.append(" ");
		sb.append(key2);
		sb.append(" ");
		System.out.println("numwords -1 " + (numWords-1));
		for(int k=0; k < numWords-1; k++){
			System.out.println("Entrei para gerar getfollow k " + k);
		    ArrayList<String> follows = getFollows(key1, key2);
		    if (follows.size() == 0) {
		    	System.out.println("empty follows for " + key1 + " and " + key2);
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			index2 = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			String next2 = follows.get(index2);
			System.out.println("For the key " + key1 + " and key " + key2);
			for(String a : follows){
				System.out.print(a + " ");
			}
			sb.append(next);
			sb.append(" ");
			sb.append(next2);
			sb.append(" ");
			key1 = next2;
			key2 = next;
		}
		
		return sb.toString().trim(); //remove the space on the end
	}

	
	//Arrays doesn't have indexOf method 
	private int indexOf(String [] words, String target1, String target2, int start){
		for (int i = start; i < words.length - 1; i++){
			if(words[i].equals(target1) && words[i+1].equals(target2)){
				return i + 2;
			}
		}
		return -1;
	}
	
	public ArrayList<String> getFollows(String key1, String key2) {
	    ArrayList<String> follows = new ArrayList<String>();
	    int pos = 0;
	    while (pos < myText.length){
	    	int index = indexOf(myText, key1, key2, pos);
	    	if(index == -1 || index + key2.length() >= myText.length -1){
	    		break;
	    	}
		    follows.add(myText[index]);
		    follows.add(myText[index + 1]);
		    //System.out.println("Size of follow for keys " + key1 + " " + key2 + " is:" + follows.size());
		    pos = index + 2;
	    }  
	    return follows;
    }

}
