package EmotionalSongs;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import prog.io.*;

public class Registrazione{
		
	//FIELDS
  	private static final Pattern EmailValido = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	  
  	public static void main (String [] args) throws IOException {
 
  		registrazione();
  	}
  	//METHODS
	
	public static void registrazione() throws IOException {	
	
		ConsoleInputManager in = new ConsoleInputManager ();
		
		String nome= in.readLine("nome ");
		String cognome = in.readLine("cognome ");
		String codicefiscale = in.readLine("codice fiscale ");
		
		//check sulla validità del codice fiscale
		while(!codicefiscaleValido(codicefiscale))
			codicefiscale = in.readLine("codice fiscale non corretto, reinserire : ");
        
		 
		String indirizzo = in.readLine("indirizzo");
		int numerocivico = in.readInt("numero civico ");
		int cap = in.readInt("cap ");
		String comune = in.readLine("comune ");
		String provincia = in.readLine("provincia ");
		String email = in.readLine("email ");
		while(validamail(email)==false) {
			
	    	   email=in.readLine("inserisci la mail correttamente ");
	    	   
		}
		String user = in.readLine("user ");
	
		//creazione oggetto file
		File file = new File("UtentiRegistrati.dati.txt");
		//creazione file al primo run del metodo
		if(!file.exists())
			file.createNewFile();
		
		String path = file.getAbsolutePath();
		
		while(alreadyExists(user, new BufferedReader(new FileReader(path)))) 
				user = in.readLine();
				
		String password = in.readLine("inserire password : ");
		//check su password
		while(!passwordIsValid(password))
			password = in.readLine("reinserire password : ");
		
		FileWriter fw = new FileWriter(path, true);
	
        fw.write(nome.toUpperCase());
        fw.write("/"+ cognome.toUpperCase());
        fw.write("/"+codicefiscale.toUpperCase());
        fw.write("/"+indirizzo.toUpperCase());
        fw.write("/"+numerocivico);
        fw.write("/"+cap);
        fw.write("/"+comune.toUpperCase());
        fw.write("/"+provincia.toUpperCase());
        fw.write("/"+email.toUpperCase());
        fw.write("/"+user);
        fw.write("/"+password);
        fw.write("\n");
        fw.close();      
        
        System.out.println("registrazione effettuata correttamente ");
         
	} 
	/*
	 * metodo che controlla la sintassi della mail
	 * ritorna true se essa è valida
	 * false altrimenti
	 */
	private static boolean validamail(String email) {
		
        Matcher matcher = EmailValido .matcher(email);
        return matcher.find();
    }
	
	/*
	 * 
	 * metodo che controlla sul file utentiregistrati se esiste già un user uguale a quello dato come parametro dall'user
	 * ritorna true se esiste
	 * false altrimenti
	 */
	private static boolean alreadyExists(String username,BufferedReader br) throws IOException {
	
		String line = br.readLine();
		while(line != null) {
			
			String [] result = line.split("/");
			if(result[9].equals(username)) {
				System.out.println("utente gia esistente, reinserire: ");
				return true;
			}
			
			line = br.readLine();
		}	
		return true;
	}
	/*
	 * metodo che controlla che la password sia lunga almeno otto caratteri
	 * e che contenga almeno un numero, una lettera maiuscola e una minuscola
	 * 
	 */
	private static boolean passwordIsValid(String s) {
		
		int maiuscole = 0;
		int minuscole = 0;
		int numeri = 0;
		
		if(s.length() < 8) {
			System.out.println("password troppo corta");
			return false;
		}
		
		for(int i = 0; i< s.length();i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c))
				
				numeri++;	
			else if(Character.isUpperCase(c))
				maiuscole++;
			
			else if(Character.isLowerCase(c))
				minuscole ++;
	}
		if(numeri > 0 && maiuscole > 0 && minuscole > 0)
			return true;
		else {
			System.out.println("password non valida , deve contenere minimo un numero, una lettera maiuscola e una minuscola");
			return false;
		}
	}
	
	/**
	 * 
	 * metodo che controlli la sintassi corretta del codice fiscale
	 * ritorna true se è corretta
	 * false altrimenti
	 */
	public static boolean codicefiscaleValido(String codiceFiscale) {

		String codRegex = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";

		Pattern codPat = Pattern.compile(codRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = codPat.matcher(codiceFiscale);
		return matcher.find();
		
	}
}