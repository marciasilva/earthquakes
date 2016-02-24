package week03;


/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
       // markov.setRandom(seed);
        System.out.println("running with " + markov.toString());
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed = 8;
		
//        MarkovZero mz = new MarkovZero();
//        runModel(mz, st, size, seed);
//    
//        MarkovOne mOne = new MarkovOne();
//        runModel(mOne, st, size, seed);
//        
//        MarkovModel mThree = new MarkovModel(3);
//        runModel(mThree, st, size, seed);
//        
//        MarkovFour mFour = new MarkovFour();
//        runModel(mFour, st, size, seed);
        
        MarkovWordOne mWordOne = new MarkovWordOne();
        runModel(mWordOne, st, size, seed);

    }
    
    public String toString(IMarkovModel im){
    	if(im.equals(MarkovZero.class)){
    		return "MarkovModel of order 0.";
    	}
    	else if(im.equals(MarkovOne.class))
    		return "MarkovModel of order 1.";
    	else if(im.equals(MarkovFour.class))
    		return "MarkovModel of order 4.";
    	else
    		return "Not recognized";
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
	
	private void testHashMap(){
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		EfficientMarkovModel em = new EfficientMarkovModel(5);
		runModel(em, st, 50, 615);
	}
	
	private void compareMethods(){
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 100;
		int seed = 42;	
		EfficientMarkovModel em = new EfficientMarkovModel(2);
        MarkovModel mm = new MarkovModel(2);
        long startTime = System.nanoTime();    
        runModel(em, st, size, seed);
        long estimatedTime = System.nanoTime() - startTime;
        
        System.out.println("Efficient markov: " + estimatedTime);
        startTime = System.nanoTime();
        runModel(mm, st, size, seed);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Model markov: " + estimatedTime);
	}
	
	
	public static void main(String args[]){
		MarkovRunnerWithInterface mri = new MarkovRunnerWithInterface();
		mri.runMarkov();
//		mri.testHashMap();
//		mri.compareMethods();
		
	}
	
}