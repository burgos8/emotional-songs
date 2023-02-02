import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.io.FileWriter;
import java.io.BufferedReader;
import prog.io.*;
public class Registrazione extends RegistraPlaylist{
	  		private static final Pattern EmailValido = 
	  		Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	/*		metodo inutilizzato
	 * public static void RegistrazioneNome(String nome, String cognome, String codicefiscale, String via, int numerocivico, int cap, String comune, String provincia, String email, String userid, String password) throws IOException {
		ConsoleInputManager in = new ConsoleInputManager ();
		try {
        FileWriter fw = new FileWriter("C:\\Users\\danym\\Desktop\\ProgettoEmotionalMaps\\UtentiRegistrati.dati.txt", true);
        boolean codfiscale=true;
        boolean primacond=false;
        while(codicefiscale.length()!=16||primacond!=true) {
        	primacond=true;
        	if(Character.isDigit(codicefiscale.charAt(6))==false||Character.isDigit(codicefiscale.charAt(7))==false||Character.isDigit(codicefiscale.charAt(9))==false||Character.isDigit(codicefiscale.charAt(10))==false||Character.isDigit(codicefiscale.charAt(12))==false||Character.isDigit(codicefiscale.charAt(13))==false||Character.isDigit(codicefiscale.charAt(14))==false) {
            	primacond=false;
            }
            
           for(int i=0;i<6;i++) {
        	   if(Character.isLetter(codicefiscale.charAt(i))==false) {
        		   primacond=false;
        		   break;
        	   }
           }
           if(Character.isLetter(codicefiscale.charAt(8))==false||Character.isLetter(codicefiscale.charAt(11))==false||Character.isLetter(codicefiscale.charAt(15))==false) {
        	   primacond=false;
           }
        	
        	System.out.println("inserire il codice fiscale correttamente");
        	codicefiscale=in.readLine();    
      	
        }
   
       boolean emaill=false;
       for(int i=0; i<email.length();i++) {
    	  
    	   if(email.charAt(i)=='@') {
    		   emaill=true;
    		   break;
    	   }
       }
        if(codfiscale==true&&primacond==true&&emaill==true) {
        fw.write(nome.toUpperCase());
        fw.write("/"+ cognome.toUpperCase());
        fw.write("/"+codicefiscale.toUpperCase());
        fw.write("/"+via.toUpperCase());
        fw.write("/"+numerocivico);
        fw.write("/"+cap);
        fw.write("/"+comune.toUpperCase());
        fw.write("/"+provincia.toUpperCase());
        fw.write("/"+email.toUpperCase());
        fw.write("/"+userid);
        fw.write("/"+password);
        fw.write("\n");
        fw.close();
        
        
	
	
	
	} else {
		if(codfiscale==false||primacond==false) {
			System.out.println("codice fiscale errato");
		} else if(emaill==false) {
			System.out.println("formato email non valido");
		}
	}	if(codfiscale==true && primacond==true) {
		System.out.println("registrazione effettuata correttamente");
	}
        } catch (Exception e) {
		e.printStackTrace();
	}
}	*/
	  public static boolean validamail(String email) {
          Matcher matcher = EmailValido .matcher(email);
          return matcher.find();
      }
public static void Registrazione() {	
		ConsoleInputManager in = new ConsoleInputManager ();
		String nome= in.readLine("nome ");
		String cognome = in.readLine("cognome ");
		String codicefiscale = in.readLine("codice fiscale ");
		boolean codfiscale=true;
        boolean primacond=false;
		  while(primacond!=true) {
			 	        	primacond=true;
	        	if(codicefiscale.length()!=16||Character.isDigit(codicefiscale.charAt(6))==false||Character.isDigit(codicefiscale.charAt(7))==false||Character.isDigit(codicefiscale.charAt(9))==false||Character.isDigit(codicefiscale.charAt(10))==false||Character.isDigit(codicefiscale.charAt(12))==false||Character.isDigit(codicefiscale.charAt(13))==false||Character.isDigit(codicefiscale.charAt(14))==false) {
	            	primacond=false;     	
	            }
	           for(int i=0;i<6;i++) {
	        	   if(codicefiscale.length()!=16||Character.isLetter(codicefiscale.charAt(i))==false||codicefiscale.length()!=16) {
	        		   primacond=false;    		   
	        	   }
	           }
	           if(codicefiscale.length()!=16||Character.isLetter(codicefiscale.charAt(8))==false||Character.isLetter(codicefiscale.charAt(11))==false||Character.isLetter(codicefiscale.charAt(15))==false||codicefiscale.length()!=16) {
	        	   primacond=false;        
	           }
	        	if(primacond==false) {
	        	System.out.println("inserire il codice fiscale correttamente");
	        	codicefiscale=in.readLine();  	
	        	}      	
	        }  
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
		String password = in.readLine("password ");
		
		try {
			FileWriter fw = new FileWriter("C:\\Users\\danym\\Desktop\\ProgettoEmotionalMaps\\UtentiRegistrati.dati.txt", true);
		
	       
	     
	      
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
	    	
	       
	        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}

