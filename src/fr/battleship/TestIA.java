package fr.battleship;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import polytech.ig.julien.roumagnac.game.Game;
import polytech.ig.julien.roumagnac.structure.IAHigh;
import polytech.ig.julien.roumagnac.structure.IATop;
import polytech.ig.julien.roumagnac.structure.IALow;
import polytech.ig.julien.roumagnac.structure.IAMedium;
import polytech.ig.julien.roumagnac.structure.Play;

public class TestIA extends Game {
	
	
	public static void main(String[] args) {
		
		
		int compteur =0;
		
		
		int nbparties = 100;
		int x1,x2,x3,x4,x5,x6,y1,y2,y3,y4,y5,y6 =0 ;
		
		
		
		
		
		
		
		// debut des parties 
		for(int i =0; i<nbparties;i++) {
			
			Play j1,j2;
			
			j1=new IATop();
			j2=new IAHigh();
			// placement des bateaux 
			j1.init();
			j2.init();
				
				
			boolean fin = true ;
			 // compteur de tour d'une partie et pris en compte seulement en cas de victoire
			
			// tour de joueur 1 puis tour de joueur 2 jusqua ce qu'un des deux soit mort 
			while  (fin ) {
				if (i%2==0) {
				String res = tour( j2,j1);
				System.out.println(res );
				String res2 = tour ( j1,j2);
				System.out.println(res2 );
				}
				else {
					String res = tour( j1,j2);
					System.out.println(res );
					String res2 = tour ( j2,j1);
					System.out.println(res2 );
					
				}
			
				
			
			
			
			if (j1.isDead() || j2.isDead()) {fin = false ;}
			}
			if(j2.isDead()) { 
				compteur++; 
				 
				}
			}
			x3 = compteur;
			
			compteur =0 ;
			
			
			
			for(int i =0; i<nbparties;i++) {
				
				Play j1,j2;
				
				j1=new IAHigh();
				j2=new IAMedium();
				// placement des bateaux 
				j1.init();
				j2.init();
					
					
				boolean fin = true ;
				 // compteur de tour d'une partie et pris en compte seulement en cas de victoire
				
				// tour de joueur 1 puis tour de joueur 2 jusqua ce qu'un des deux soit mort 
				while  (fin ) {
					if (i%2==0) {
					String res = tour( j2,j1);
					System.out.println(res );
					String res2 = tour ( j1,j2);
					System.out.println(res2 );
					}
					else {
						String res = tour( j1,j2);
						System.out.println(res );
						String res2 = tour ( j2,j1);
						System.out.println(res2 );
						
					}
				
					
				
				
				
				if (j1.isDead() || j2.isDead()) {fin = false ;}
				}
				if(j2.isDead()) { 
					compteur++; 
					  
					}
				else {
					System.out.println("_______________  IA de niveau inferieur a gagné   __________________");}
				}
			x2=compteur;
			
			 
			compteur =0;
			for(int i =0; i<nbparties;i++) {
				
				Play j1,j2;
				
				j1=new IAMedium();
				j2=new IALow();
				// placement des bateaux 
				j1.init();
				j2.init();
					
					
				boolean fin = true ;
				 // compteur de tour d'une partie et pris en compte seulement en cas de victoire
				
				// tour de joueur 1 puis tour de joueur 2 jusqua ce qu'un des deux soit mort 
				while  (fin ) {
					if (i%2==0) {
					String res = tour( j2,j1);
					System.out.println(res );
					String res2 = tour ( j1,j2);
					System.out.println(res2 );
					}
					else {
						String res = tour( j1,j2);
						System.out.println(res );
						String res2 = tour ( j2,j1);
						System.out.println(res2 );
						
					}
				
					
				
				
				
				if (j1.isDead() || j2.isDead()) {fin = false ;}
				}
				if(j2.isDead()) { 
					compteur++; 
					 
					}
				else {
					}
				}
			x1=compteur;
			
			compteur=0;
			for(int i =0; i<nbparties;i++) {
				
				Play j1,j2;
				
				j1=new IATop();
				j2=new IALow();
				// placement des bateaux 
				j1.init();
				j2.init();
					
					
				boolean fin = true ;
				 // compteur de tour d'une partie et pris en compte seulement en cas de victoire
				
				// tour de joueur 1 puis tour de joueur 2 jusqua ce qu'un des deux soit mort 
				while  (fin ) {
					if (i%2==0) {
					String res = tour( j2,j1);
					System.out.println(res );
					String res2 = tour ( j1,j2);
					System.out.println(res2 );
					}
					else {
						String res = tour( j1,j2);
						System.out.println(res );
						String res2 = tour ( j2,j1);
						System.out.println(res2 );
						
					}
				
					
				
				
				
				if (j1.isDead() || j2.isDead()) {fin = false ;}
				}
				if(j2.isDead()) { 
					compteur++; 
					
					}
				else {
					}
				}
			x4=compteur;
			
			
			compteur=0;
			for(int i =0; i<nbparties;i++) {
				
				Play j1,j2;
				
				j1=new IATop();
				j2=new IAMedium();
				// placement des bateaux 
				j1.init();
				j2.init();
					
					
				boolean fin = true ;
				 // compteur de tour d'une partie et pris en compte seulement en cas de victoire
				
				// tour de joueur 1 puis tour de joueur 2 jusqua ce qu'un des deux soit mort 
				while  (fin ) {
					if (i%2==0) {
					String res = tour( j2,j1);
					System.out.println(res );
					String res2 = tour ( j1,j2);
					System.out.println(res2 );
					}
					else {
						String res = tour( j1,j2);
						System.out.println(res );
						String res2 = tour ( j2,j1);
						System.out.println(res2 );
						
					}
				
					
				
				
				
				if (j1.isDead() || j2.isDead()) {fin = false ;}
				}
				if(j2.isDead()) { 
					compteur++; 
					  
					}
				else {
					}
				}
			x5=compteur;
			
			
			compteur=0;
			for(int i =0; i<nbparties;i++) {
				
				Play j1,j2;
				
				j1=new IAHigh();
				j2=new IALow();
				// placement des bateaux 
				j1.init();
				j2.init();
					
					
				boolean fin = true ;
				 // compteur de tour d'une partie et pris en compte seulement en cas de victoire
				
				// tour de joueur 1 puis tour de joueur 2 jusqua ce qu'un des deux soit mort 
				while  (fin ) {
					if (i%2==0) {
					String res = tour( j2,j1);
					System.out.println(res );
					String res2 = tour ( j1,j2);
					System.out.println(res2 );
					}
					else {
						String res = tour( j1,j2);
						System.out.println(res );
						String res2 = tour ( j2,j1);
						System.out.println(res2 );
						
					}
				
					
				
				
				
				if (j1.isDead() || j2.isDead()) {fin = false ;}
				}
				if(j2.isDead()) { 
					compteur++; 
					 
					}
				else {
					}
				}
			x6=compteur;
			
			
			compteur=0;
			
			
			
			
			
			
			
			
			y1=nbparties-x1;
			y2=nbparties-x2;
			y3=nbparties-x3;
			y4=nbparties-x4;
			y5=nbparties-x5;
			y6=nbparties-x6;
			
			
			
			FileWriter fw = null;
			try {
				fw = new FileWriter(new File("."+File.separator+"ai_proof.csv"));
				fw.append("IA Name; Score1 ; IA2 name ;  score2; \n");
				fw.append("IATop ; "+ x3 + " ;IAHigh;"+ y3+"; \n");
				fw.append("IATop ; "+ x5 + " ;IAMedium;"+ y5+"; \n");
				fw.append("IATop ; "+ x4  + " ;IALow;"+ y4+"; \n");
				fw.append("IAHigh ; "+ x2 + " ;IAMedium;"+ y2+"; \n");
				fw.append("IAHigh ; "+ x6  + " ;IALOW;"+ y6+"; \n");
				fw.append("IAMedium ; "+ x1 + " ;IALow;"+ y1+"; \n");
				
			}	
			catch(Exception e){
				System.out.println("Erreur lors de la creation du fichier.");
				e.printStackTrace();
			}
			finally {
				try {
					fw.flush();
					System.out.println("fichier créé");
					fw.close();
					}
				catch(IOException i) {
					System.out.println("probleme dans lors de l'exportation du fichier.");
					i.printStackTrace();
					
					
				}
				
			}
    
			
			
	}	
}


