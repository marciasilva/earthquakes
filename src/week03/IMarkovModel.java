package week03;


public interface IMarkovModel {
    public void setTraining(String text);
    
    public String getRandomText(int numChars);
    
}