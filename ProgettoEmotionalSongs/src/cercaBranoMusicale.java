import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class cercaBranoMusicale extends Registrazione {

	

	public static void main(String[] args) {
		
		//cercaBranoMusicale("Pneumonia Blues");
	 cercaBranoMusicaleAnno(1929,"Blind Lemon Jefferson");
	}
	
	
	public static void cercaBranoMusicale(String titolo) {
		
		String path = "C:\\Users\\danym\\Desktop\\ProgettoEmotionalMaps\\Canzoni.txt";
		BufferedReader reader;
		int hash = 0;
		boolean flag =true;			//true non ha ancora stampato una linea, false si
		
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			int cont=0;
			
			
			//Partenza scorrimento file
			
			while (line != null) {
				boolean uguale=true;		
				int h=line.length()-1;
				// i : posizione carattere linea
				//j : posizione carattere input 
				// x : parte da zero e scorre tutto il titolo
				for (int i=line.length()-1, j=titolo.length()-1, x=0; x<titolo.length();i--,j--, x++) {
				
				if(line.charAt(i)=='>'&& h-i==j) {
					break;
				} if(line.charAt(i)!=titolo.charAt(j)) {
					uguale=false;
					break;
				}
				} 
				char c='>';
				if (line.charAt(line.length()-titolo.length()-1)!=c) {
					uguale=false;
				}
				
				//Titolo trovato
				// posizione 32 in line � il primo carattere dell'autore
				
				if(uguale==true) {
					if(flag) {
						flag = false;
						hash = line.substring(32).hashCode();
						System.out.println(line);
						cont++;	
						
						//stampa gi� avvenuta
					}else {
						
						if(line.substring(32).hashCode() != hash) {
							System.out.println(line);
							flag = true;
						}
						
				}
				}
				
					line=reader.readLine();
					if(line==null&&cont==0) {
						System.out.println("non � stata trovata nessuna canzone");
						break;
					}
				}
		
						
			
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void cercaBranoMusicaleAnno(int anno, String autore) {
		
		String path = "C:\\Users\\danym\\Desktop\\ProgettoEmotionalMaps\\Canzoni.txt";
		BufferedReader reader;
		int hash = 0;
		boolean flag = true;	
		
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			String annoo = String.valueOf(anno);
			int cont=0;
			while (line != null) {
				boolean uguale=true;
				boolean ugualee = true;
				for (int i=0; i<annoo.length();i++) {
					if(line.charAt(i)!=annoo.charAt(i)) {
						uguale=false;
						break;
					}
				}
				
				for (int i=32, j=0; j<autore.length();i++,j++) {
					if(line.charAt(i)!=autore.charAt(j)) {
						ugualee=false;
						break;
				}
					}
				int p=32+autore.length();
				if (ugualee==true) {
				char l='<';
				if(line.charAt(p)!=l) {
					ugualee=false;
					break; 
				} 
					
				}
				
				
				if(uguale==true && ugualee==true) {
					
					if(flag) {
						
						flag = false;
						hash = line.substring(32).hashCode();
						System.out.println(line);
						cont++;
						
					}else {
						
						if(line.substring(32).hashCode() != hash) {
							
							System.out.println(line);
							cont++;
						}
				}
			}
				
					line=reader.readLine();
					
					
				}
			if(reader.readLine()==null&&cont==0) 
				System.out.println("non � stata trovata nessuna canzone");
			
			
			
			}catch (Exception e) {
				e.printStackTrace();
		}
		
	}
}


