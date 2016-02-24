package week03;


/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;
import java.util.*;

public class MarkovRunner {
    public void runMarkovZero() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setRandom(88);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
    
    public void runMarkovOne(){
    	FileResource fr = new FileResource();
    	String st = fr.asString();
    	st = st.replace('\n', ' ');
    	MarkovOne markov = new MarkovOne();
    	markov.setRandom(273);
    	markov.setTraining(st);
    	for(int k=0; k < 1; k++){
    		String text = markov.getRandomText(100);
    		printOut(text);
    	}
    }
    
    public void runMarkovFour(){
    	FileResource fr = new FileResource();
    	String st = fr.asString();
    	st = st.replace('\n', ' ');
    	MarkovFour markov = new MarkovFour();
    	markov.setRandom(371);
    	markov.setTraining(st);
    	for(int k=0; k < 3; k++){
    		String text = markov.getRandomText(500);
    		printOut(text);
    	}
    }
    
    public void runMarkovModel(){
    	FileResource fr = new FileResource();
    	String st = fr.asString();
    	st = st.replace('\n', ' ');
    	MarkovModel markov = new MarkovModel(8);
    	markov.setRandom(365);
    	markov.setTraining(st);
    	for(int k=0; k < 1; k++){
    		String text = markov.getRandomText(500);
    		printOut(text);
    	}
    }
    
    public void runMarkovWordOne(){
    	FileResource fr = new FileResource();
    	String st = fr.asString();
       	st = st.replace('\n', ' ');
    	//st = "this is just a test yes this is a simple test";
    	MarkovWordOne mwo = new MarkovWordOne();
    	mwo.setRandom(175);
    	mwo.setTraining(st);
    	String text = mwo.getRandomText(120);
    	printOut(text);
    }
    
    public void runMarkovWordTwo(){
    	FileResource fr = new FileResource();
    	String st = fr.asString();
    	st = st.replace('\n', ' ');
    	//st = "this is just a test yes this is a simple test";
    	MarkovWordTwo mwt = new MarkovWordTwo();
    	mwt.setRandom(549);
    	mwt.setTraining(st);
    	String text = mwt.getRandomText(500);
    	printOut(text);
    }
    
    private void testGetFollows(){
    	String st = "this is a test yes this is a test.";
    	MarkovOne markovOne = new MarkovOne();
    	markovOne.setTraining(st);
    	ArrayList<String> test = markovOne.getFollows("t");
    	System.out.println("Size of follows: " + test.size());
    	for(String a : test){
    		System.out.print(a + "-");
    	}
    }
    
    private void testGetFollowsInFile(){
    	FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
    	MarkovOne markov = new MarkovOne();
    	markov.setTraining(st);
    	ArrayList<String> test = markov.getFollows("th");
    	System.out.println("Size of follows: " + test.size());
 
    }

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
	public static void main(String args[]){
		MarkovRunner mr = new MarkovRunner();
//		mr.runMarkovZero();
//		mr.runMarkovOne();
//		mr.runMarkovFour();
//		mr.runMarkovModel();
//		mr.testGetFollows();
//		mr.testGetFollowsInFile();
//		mr.runMarkovWordOne();
		mr.runMarkovWordTwo();
	}
}
