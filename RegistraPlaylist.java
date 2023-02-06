package EmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import prog.io.ConsoleInputManager;


public class RegistraPlaylist {
	
	
	//METHODS
	
	public static void registraPlaylist() throws IOException {	
				
		//creazione file playlist.dati.txt
		File file = new File("Playlist.dati.txt");
		String path = file.getAbsolutePath();
		
		//apertura stream in scrittura
		FileWriter fw = new FileWriter(path,true);
		
		//aertura stream da tastiera
	    ConsoleInputManager in = new ConsoleInputManager();
	    
		System.out.println("inserisci il titolo della playlist");
		String nomeplaylist = in.readLine();
		
		fw.write(nomeplaylist + "\n" + "\n");
		
		//flag per continuare inserimento canzoni
		boolean continua=true;	   
		
		while(continua!=false) {	
		
			String titolo = in.readLine("inserisci il titolo della canzone");
			
			if(songExists(titolo)) {
				
				ArrayList<String> brani = getBrani(titolo);
				
				//branch true se esiste un solo brano con il titolo il input
				if(brani.size() == 1)
					
					fw.write(brani.get(0));	
				
				else {
					
					int i = 0;
					
					for(String h : brani ) {
						
						System.out.print(i+"-->"+h + "\n");
						i++;
						
					}
					int n = in.readInt("quale canzone vuoi inserire?");
					
					while(!(n >= 0 && n < brani.size())) {
						
						n = in.readInt("seleziona posizione corretta");
						
					}
					
					System.out.println("Canzone aggiunta correttamente");
					fw.write(brani.get(n)+"\n");
				
				}
					
					
		       
			}else 
				System.out.println("Brano non presente nella repository");
			
			continua= in.readSiNo("vuoi inserire un'altra canzone?(S/N)");
			
			if(continua==false) 	  
				
				fw.write("_ _ _ _ _ _" + "\n" + "\n");
			       
				}
		//chiusura stream
		fw.close();
	}
	
	
	/*
	 * metodo per ricercare canzone, restituisce true se esiste
	 * 								false altrmenti
	 */
	private static boolean songExists(String titolo) throws IOException {
		
		//normalizzazione titolo non cap sensitive
		titolo = titolo.toLowerCase();
		
		//apertura stream lettura su repository
		BufferedReader br = new BufferedReader(new FileReader("/home/alessandro/Universita/Laboratorio_interdisciplinareA/FiveHundredThousandSongs.txt/"));
		
		//dichiarazione e inzializzazione variabili di supporto per il metodo 
		boolean trovata = false;
		String line = br.readLine();
		
		//ricerca iterativa		
		while(line != null) {
			
			/*
			 * array contenente informazioni sul brano splitatte nelle posizioni rispetto al separatore
			 * [0] : anno
			 * [1] : id
			 * [2] : autore
			 * [3] : titolo
			 */
			String [] result = line.split("<SEP>");
			String brano = result[3].toLowerCase(); 
					
				if(titolo.equals(brano)) 
						
					trovata = true;
				
				line = br.readLine();	
				
			}	
		
		return trovata;
	}
	
	/*
	 * metodo per confrontare nome playlist inserito dall'utente con quelli già inseriti
	 * ritorna true see esitono già playlist con quel nome
	 * false altrimenti
	 * 
	 */
//	private static boolean nomeEqual(String titolo,ArrayList<String> arr) {
//		
//		boolean flag = false;
//		titolo = titolo.toLowerCase();
//		
//		for(String tmp : arr) {
//			
//			if(titolo.equals(tmp.toLowerCase()))
//				
//				return true;
//		}
//		
//		return false;
//	}
	
	/*
	 * metodo che ritorna una array list contente i brani con lo stesso titlo
	 * 
	 */
	private static ArrayList<String> getBrani(String titolo) throws IOException{
		
		//normalizzazione titolo non cap sensitive
		titolo = titolo.toLowerCase();
		
		//apertura stream lettura su repositor
		BufferedReader br = new BufferedReader(new FileReader("/home/alessandro/Universita/Laboratorio_interdisciplinareA/FiveHundredThousandSongs.txt/"));
		
		//dichiarazione e inzializzazione variabili di supporto per il metodo 
		boolean flag = false;
		String line = br.readLine();
		int hash = 0;
		
		//Arraylist contente le canzoni con il titolo dato in ingresso 
		ArrayList<String> brani = new ArrayList<>();
		
		//Arraylist contente hash dei brani per rimuovere duplicati
		ArrayList<Integer> hashArr = new ArrayList<>();
		
		//ricerca iterativa
		while(line != null) {
			
			String [] result = line.split("<SEP>");
			String brano = result[3].toLowerCase();
			
			if(titolo.equals(brano)) {
				
				if(!flag) {		
					
					flag = true;
					hash = line.substring(32).hashCode();
					hashArr.add(hash);
					brani.add(line);
					
				}else {
					
					if(!Ricerca.hashEqual(hashArr,line.substring(32).hashCode())) 
						
						brani.add(line);
						
				}
			}
			
			line = br.readLine();
			
			}
		
		return brani;
			
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
