package EmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import prog.io.ConsoleInputManager;

public class VisualizzaEmozioni {
public static void Visualizzaemozioni() throws IOException{
	
		//apertura stream tastiera
		ConsoleInputManager in = new ConsoleInputManager();
		
		//apertura stream letura
		File file = new File("Emozioni.dati.txt");
		String path = file.getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		
		boolean trovata=false;
        String canzone = in.readLine("quale canzone vuoi ricercare?");
        Scanner b = new Scanner(file);
        String now=null;
        while(line!=null&&trovata==false) {      	
        	for(int i=0; i<line.length();i++) {
        		if(line.length()!=canzone.length()||line.charAt(i)!=canzone.charAt(i)) {
        			trovata=false;
        		} else if(line.length()==canzone.length()&&line.charAt(i)==canzone.charAt(i)){    			
        			trovata=true;       			
        		}
        	} line=br.readLine();
        }
        if(trovata==true) {
        	System.out.println("canzone trovata");
        	System.out.println("le emozioni di questa canzone sono:");
    			for (int i=0; i<10;i++) {
    				System.out.println(line);
    				line=br.readLine();				
    		}  		
    		 }   	
         else if(trovata!=true) {
        	System.out.println("canzone non trovata");
        }	
	}	
}
