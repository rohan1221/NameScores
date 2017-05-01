import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ScoringNames {
	BufferedReader x = null;
	String location = "C:\\Users\\Rohan Vidyarthi\\Dropbox\\"
					+ "College\\COSC 1430\\Scoring Names\\names.txt";
	
	ArrayList<String> names = new ArrayList<String>();
	static ArrayList<Integer> scores = new ArrayList<Integer>();
	static int ns[];
	
	public void fillNS(){
		for (int x = 0; x < ns.length; x++){
			ns[x] = scores.get(x) * (x+1);
		}
	}
	
	public void printNS(){
		for (int x = 0; x < ns.length; x++)
			System.out.print(ns[x] + ", ");
	}
	
	public void readFile(){ //Opens file, and prints every line.
		try{
			x = new BufferedReader(new FileReader(location));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			String name = x.readLine();
			while(name != null){
				//System.out.println(name);
				names.add(name);
				name = x.readLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void sortNames(){ //Sort names array in alphabetical order
		Collections.sort(names);
	}
	
	public void printNames(){
		for(String counter: names)
			System.out.println(counter);
	}
	
	public int alphValue(char x){
		return (x - 'A' + 1);
	}
	
	public void returnSize(){
		System.out.println(names.size());
	}
	
	public int nameScore(String name){
		int score = 0;
		char[] tempName = name.toCharArray();
		for (char i : tempName){
				score += alphValue(i);
			}
				
		return score;
	}
	
	public void addScores(){
		for(String x : names){
			scores.add(nameScore(x));
		}
	}

	public void printScores(){
		for(int counter: scores)
			System.out.println(counter);
	}
	
	public int totalNS(int[] x){
		int sum = 0;
		for(int i = 0; i < x.length; i++){
			sum += x[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		ScoringNames abc = new ScoringNames(); 
		abc.readFile(); 
		abc.sortNames(); 
		//abc.printNames(); 
		abc.addScores(); 
		//abc.printScores(); 
		ns = new int[scores.size()];
		abc.fillNS(); 
		//abc.printNS();
		//System.out.println(ns[937]); //"COLIN"
		System.out.println("The sum total of all name scores is: " + 
							abc.totalNS(ns));
	}

}
