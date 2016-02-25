package week03;


public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < myWords.length; i++){
        	ret += myWords[i] + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if(other.length() != this.length())
        	return false;
        for(int i =0; i< myWords.length; i++){
        	if(! myWords[i].equals(other.wordAt(i))){
        		return false;
        	}
        }
        return true;

    }

    public WordGram shiftAdd(String word) {	
    	String newArrayString [] = this.myWords;
    	for(int i = 0; i < newArrayString.length -1; i++){
    		newArrayString[i] = newArrayString[i +1];
    	}
    	if(newArrayString.length > 1){
    		newArrayString[newArrayString.length -1] = word;
    	}
    	WordGram other = new WordGram(newArrayString, 0, this.length());
    	return other;
    }

}