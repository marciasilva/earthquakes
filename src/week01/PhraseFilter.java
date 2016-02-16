package week01;

public class PhraseFilter implements Filter{
	
	private String where;
	private String phrase;
	private String name;
	
	public PhraseFilter(String w, String p, String n){
		this.where = w;
		this.phrase = p;
		this.name = n;
	}
	
    public  boolean satisfies(QuakeEntry qe){
        String searchTitle = new String();
    	switch(where){
        case "start" : 
        	int start = qe.getInfo().indexOf(" ");
        	searchTitle = qe.getInfo().substring(0, start + 1);
        	break;
        case "end":
        	int end = qe.getInfo().lastIndexOf(" ");
        	searchTitle = qe.getInfo().substring(end, qe.getInfo().length());
        break;
        case "any":
       	 searchTitle = qe.getInfo();
        	break;
        	default:
        		System.out.println("Parâmetro desconhecido.");
        }
    	
    	return  searchTitle.contains(phrase);
    }
    
    public String getName(){
    	return this.name;
    }

}
