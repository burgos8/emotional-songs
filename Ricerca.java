package EmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Ricerca{
	
	//FIELDS
	final static String separatore = "<SEP>";
	
	//METHODS
	public static void cercaBranoMusicale(String titolo) throws IOException {
		
		//Apertura stream
		File file = new File("/home/alessandro/Universita/Laboratorio_interdisciplinareA/FiveHundredThousandSongs.txt/");
		BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
		
		//normalizzazione patametro attuale
		titolo = titolo.toLowerCase();
		
		//flag è false se non avvengono stampe, true altrimenti
		boolean flag = false;
		int hash = 0;
		
		String line = br.readLine();
		
		//Struttura dati contenente hash di canzoni già stampate
		ArrayList<Integer> hashArr = new ArrayList<Integer>();
		
		while(line != null) {
			
			
				
			String [] result = line.split("<SEP>");
			String brano = result[3].toLowerCase(); 
			
			if(titolo.equals(brano)) {
				
				if(!flag) {
					
					flag  = true;
					hash = line.substring(32).hashCode();
					hashArr.add(hash);
					System.out.println(line);
					
				}else {
					
					if(!hashEqual(hashArr,line.substring(32).hashCode())) 
						System.out.println(line);
					
				}
		}
			line = br.readLine();	
	}	
			
		if(!flag)
			System.out.println("canzone non trovata");
		
		br.close();
}
	
	
	public static void cercaBranoMusicale(int anno , String autore) throws IOException{
		
		//Apertura streamblues
		File file = new File("/home/alessandro/Universita/Laboratorio_interdisciplinareA/FiveHundredThousandSongs.txt/");
		BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
		
		//normalizzazione parametri attuali
		autore = autore.toLowerCase();
		String year = String.valueOf(anno);
		
		
		String line = br.readLine();
		
		//flag è false se non avvengono stampe, true altrimenti
		boolean flag = false;
		int hash = 0;
				
		//Struttura dati contenente hash di canzoni già stampate
		ArrayList<Integer> hashArr = new ArrayList<Integer>();
		
		while(line != null) {
			
			String [] result = line.split("<SEP>");
			String cantante = result[2].toLowerCase();
			
			if(cantante.equals(autore) && result[0].equals(year)) {
				
				if(!flag) {					
					flag = true;
					hash = line.substring(32).hashCode();
					hashArr.add(hash);
					System.out.println(line);
				}else {
					
					if(!hashEqual(hashArr,line.substring(32).hashCode())) 
						
						System.out.println(line);
						
				}
			}
			
			line = br.readLine();
			
		}
		
		if(!flag)
			
			System.out.println("canzone non trovata");
		
		br.close();
	}
		
		public static boolean hashEqual(ArrayList<Integer> arr, int h){
			
			for(Integer hash : arr){
				if(h == hash)
					return true;
				}
			arr.add(h);
			return false;
				
		}
	

}
