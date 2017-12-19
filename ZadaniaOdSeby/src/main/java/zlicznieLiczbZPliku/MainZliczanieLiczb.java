package zlicznieLiczbZPliku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.css.Counter;

public class MainZliczanieLiczb {

	private static final String LICZBY_TXT = "liczby.txt";
	private static final String WYNIK_TXT = "wynik.txt";
	private List <Integer> listNumbers = new ArrayList<Integer>() ;
	

	public void addNumber ( int number) {
		listNumbers.add(number) ; 
	}
	
	public int stringToInt(String data) {
		return Integer.parseInt(data) ;  
	}
	
	public int getSize() {
		return listNumbers.size() ; 
	}
	
	public int getElement (int i) {
		return listNumbers.get(i) ; 
	}
	
	public static void main(String[] args) {
		
		MainZliczanieLiczb a = new MainZliczanieLiczb () ; 
		int [] counter = new int[1001] ; 
		String line = "" ; 
		BufferedReader br = null ; 
		PrintWriter pw = null ; 
		
		try {
			br= new BufferedReader(new FileReader(LICZBY_TXT)) ;
			while ((line = br.readLine()) != null ) {
				int integerNumber = a.stringToInt(line);
				a.addNumber(integerNumber);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for ( int i = 0 ; i < counter.length ; i++) {
			for (int j = 0 ; j < a.getSize() ; j++ ) {
				if ( i == a.getElement(j)) counter [i] ++ ; 
			}
		}
		
		try {
			pw = new PrintWriter(WYNIK_TXT) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for (int i = 0 ; i < counter.length ; i ++ ) {
			System.out.println(i + ": " + counter[i]);
			pw.println(i + ": " + counter[i] );
		}
		pw.close();
	}
}
