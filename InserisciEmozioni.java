package EmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import prog.io.ConsoleInputManager;

public class InserisciEmozioni {
	
	public static void inserisciEmozioniBrano() throws IOException {
	
		//creazione file emozioni.dati.txt
		File file = new File("Emozioni.dati.txt");
		String path = file.getAbsolutePath();
		
		//apertura stream in scrittura 
		FileWriter fw = new FileWriter(path, true);
		
		//creazione oggetto file
		ConsoleInputManager in = new ConsoleInputManager();
       
		//apertura stream in lettura 
		File filePlaylist = new File("Playlist.dati.txt");
		String pathPlaylist = filePlaylist.getAbsolutePath();
  		BufferedReader reader = new BufferedReader(new FileReader(pathPlaylist));
     
  		String line = reader.readLine();
		boolean trovata=false;
        String canzone = in.readLine("quale canzone vuoi ricercare?");
        Scanner b = new Scanner(filePlaylist);
        String now=null;
        
        while(line!=null&&trovata==false) {
        	
	        	for(int i=0; i<line.length();i++) {
	        		if(line.length()!=canzone.length()||line.charAt(i)!=canzone.charAt(i)) {
	        			trovata=false;
	        			
	        		} else if(line.length()==canzone.length()&&line.charAt(i)==canzone.charAt(i)){
	        			
	        			trovata=true;
	        			break;
	        		}
	        	} line=reader.readLine();
	        }
        
	        if(trovata==true) {
	        	
	        	System.out.println("canzone trovata, inserisci un'emozione ");
	        	fw.write(canzone + "\n" + "\n");
	        	
	        	//inserimento emozione meraviglia
	        	int meraviglia = in.readInt("quanta meraviglia ti ha trasmesso questo brano da 1 a 5?");
	        	
        		while(meraviglia<1||meraviglia>5) {
        			System.out.println("numero invalido");
        			meraviglia=in.readInt("inserisci il nuovo numero");
        		}
        		
        		fw.write("meraviglia " + meraviglia);
        		fw.write("\n");
        		
        		//inserimento emozione solennita
        		int solennita = in.readInt("quanta solennità ti ha trasmesso questo brano da 1 a 5?");
        		while(solennita<1||solennita>5) {
        			System.out.println("numero invalido");
        			solennita=in.readInt("inserisci il nuovo numero");
        		}
        		fw.write("solennità " + solennita);
        		fw.write("\n");
        		
        		//inserimento emozione tenerezza
        		int tenerezza = in.readInt("quanta tenerezza ti ha trasmesso questo brano da 1 a 5?");
        		while(tenerezza<1||tenerezza>5) {
        			System.out.println("numero invalido");
        			tenerezza=in.readInt("inserisci il nuovo numero");
        		}
        		
        		fw.write("tenerezza " + tenerezza);
        		fw.write("\n");
        		
        		//inserimento emozione nostalgia
        		int nostalgia = in.readInt("quanta nostalgia ti ha trasmesso questo brano da 1 a 5?");
        		while(nostalgia<1||nostalgia>5) {
        			System.out.println("numero invalido");
        			nostalgia=in.readInt("inserisci il nuovo numero");
        		}
        		fw.write("nostalgia " + nostalgia);
        		fw.write("\n");
        		
        		//inserimento emozione calma
        		int calma = in.readInt("quanta calma ti ha trasmesso questo brano da 1 a 5?");
        		while(calma<1||calma>5) {
        			System.out.println("numero invalido");
        			calma=in.readInt("inserisci il nuovo numero");
        		}
        		fw.write("calma " + calma);
        		fw.write("\n");
        		
        		//inserimento emozione forza
        		int forza = in.readInt("quanta forza ti ha trasmesso questo brano da 1 a 5?");
        		while(forza<1||forza>5) {
        			System.out.println("numero invalido");
        			forza=in.readInt("inserisci il nuovo numero");
        		}
        		fw.write("forza " + forza);
        		fw.write("\n");
        		
        		//inserimento emozione gioia
        		int gioia = in.readInt("quanta gioia ti ha trasmesso questo brano da 1 a 5?");
        		while(gioia<1||gioia>5) {
        			System.out.println("numero invalido");
        			gioia=in.readInt("inserisci il nuovo numero");
        		}
        		fw.write("gioia " + gioia);
        		fw.write("\n");
        		
        		//inserimento emozione tensione
        		int tensione = in.readInt("quanta tensione ti ha trasmesso questo brano da 1 a 5?");
        		while(tensione<1||tensione>5) {
        			System.out.println("numero invalido");
        			tensione=in.readInt("inserisci il nuovo numero");
        		}
        		fw.write("tensione " + tensione);
        		fw.write("\n");
        		
        		//inserimento emozione tristezza
        		int tristezza = in.readInt("quanta tristezza ti ha trasmesso questo brano da 1 a 5?");
        		while(tristezza<1||tristezza>5) {
        			System.out.println("numero invalido");
        			tristezza=in.readInt("inserisci il nuovo numero");
        		}
        		fw.write("tristezza " + tristezza);
	        		fw.write("\n" + "_ _ _ _ _ _ _"+ "\n"+"\n");
	        		fw.close();
	    		
	    		 }
	        	
	         else if(trovata!=true) {
	        	 System.out.println("non è stata trovata nessuna canzone ");
    			 
	        }

	}
}