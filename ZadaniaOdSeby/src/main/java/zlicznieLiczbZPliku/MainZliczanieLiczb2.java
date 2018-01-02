 package zlicznieLiczbZPliku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.css.Counter;

public class MainZliczanieLiczb2 {

	private static final String LICZBY_TXT = "liczby.txt";
	private static final String WYNIK_TXT = "wynik1.txt";
	private static final  int maxValue = 1000 ; 
	
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
		
		MainZliczanieLiczb2 a = new MainZliczanieLiczb2 () ;  
		int counter = 0 ; 
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
			System.out.println("B³¹d wczytywania danych");
		}
		
		try {
			pw = new PrintWriter(WYNIK_TXT) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("B³¹d zapisywania pliku");
		}  
		
		
		for ( int i = 0 ; i <= maxValue ; i++) {
			for (int j = 0 ; j < a.getSize() ; j++ ) {
				if ( i == a.getElement(j)) counter++ ; 
			}
			pw.println(i + ": " + counter) ;
			System.out.println(i + ": " + counter);
			counter = 0 ; 
		}
		
		pw.close();
	}
}
