package EmotionalSongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import prog.io.ConsoleInputManager;

public class Login {
	
	//FIELDS
	private static String separatore = "/";
	
	//METHODS
	public static boolean login() throws IOException {
			
			
		ConsoleInputManager in = new ConsoleInputManager();
		String username=in.readLine("inserisci user");
		String password = in.readLine("inserisci password");
		
		//creazione oggetto file
		File file = new File("UtentiRegistrati.dati.txt");
		
		//apertura stream in lettura
		String path = file.getAbsolutePath();
		BufferedReader br= new BufferedReader(new FileReader(path));
		String line = br.readLine();
		
		boolean login=false;
		
		while(line!=null&&login==false) {
			
			 login=true;
			 String[] result = line.split(separatore);
			 
			 if(!(result[9].equals(username) && result[10].equals(password)))
				 
				 login = false;
			
			line=br.readLine();
						   
				
			} if(login==true) 
				
				System.out.println("accesso effettuato");
			
			else 
				
				System.out.println("credenziali errate");
			
		br.close();
		return login;
				
	}
}
