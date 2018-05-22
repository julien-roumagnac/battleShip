package polytech.ig.julien.roumagnac.structure;
import java.util.ArrayList;
import java.util.Scanner;

import polytech.ig.julien.roumagnac.game.Game;

public class Player implements Play{
	private Ship flotte [] ;
	private ArrayList<Integer> TaillesDispos ;
	private ArrayList<Pos> shootList;

	
		
	
	public Player() {
			this.shootList = new ArrayList<Pos>();
			this.TaillesDispos = new ArrayList<Integer>();
			this.TaillesDispos.add(5);
			this.TaillesDispos.add(4);
			this.TaillesDispos.add(3);
			this.TaillesDispos.add(3);
			this.TaillesDispos.add(2);
			
			
			this.flotte = new Ship[this.TaillesDispos.size()];	
				
			}
	// le joueur est il mort on test isDestroyed sur tout ces bateaux	
	public boolean isDead() {
		boolean res = true ;
		int i = 0;
		while (i< flotte.length && res) {
			if (!this.flotte[i].isDestroyed()) {
				res = false ;
			}
			i++;
		}
		return res ;
		
	}
	
	
	// attaque test la pos sur tout les bateaux si elle la trouve elle ajoute un marqueur "hit" a cette pos et renvoi touche coule ou loupe 
	public String attaque(String pos){
		String res ="";
		boolean isHit = false;
		boolean isDest = false;
		int i =0;
		
		
		
		while (i<this.flotte.length && !isHit) {
			
				isHit=this.flotte[i].hit(pos);
				if (isHit) 
					{isDest = this.flotte[i].isDestroyed();}
				i++;
				}
		
		
		if(isHit && isDest) {res = "Touché Coulé !! ";}
			else if (isHit) {res = "Touché ! ";}
				else {res = "Loupé ..";}
		
		return res ;
	}
	
	// verifie si un bateau chevauche un des bateaux du joueur 
	
	
		public boolean contain(String startCoord , String endCoord) {
			boolean res = false;
			int i = 0;
			int j =0;
			int k = 0 ;
			int nbbateau = this.flotte.length - this.TaillesDispos.size() ;
			Ship boat = new Ship(startCoord,endCoord);
			
			while (k< nbbateau && !res) {
			
			i=0;
			while (!res && i < boat.getTailleBoat()) {
				 j = 0;
				while (j < this.flotte[k].getTailleBoat() && !res) {
					if (this.flotte[k].getCoo()[j].getPos().equals(boat.getCoo()[i].getPos())) {
						res = true;

					}
					j++;

				}
				i++;
			}
			k++;}
		

			return res;
		}
		
		
		public void addBoat(String startCoord, String endCoord) {
			Ship boat = new Ship(startCoord,endCoord);
			Integer taille = boat.getTailleBoat();
			int premierePlaceDispo = this.flotte.length - this.TaillesDispos.size();
			if (premierePlaceDispo < this.flotte.length) {
			this.flotte[premierePlaceDispo] = boat;
			this.TaillesDispos.remove(taille);   }
			
		}
		
		public Ship[] getFlotte() {
			return this.flotte;
		}
		public ArrayList<Integer> getTailles(){
			return this.TaillesDispos;
		}
			
		
		public boolean tailleDispo (String startCoord,String endCoord) {
			boolean res= true ;
			int startY = Character.getNumericValue(startCoord.charAt(1));
			int endY = Character.getNumericValue(endCoord.charAt(1));
			int xs = Character.getNumericValue(startCoord.charAt(0));
			int xe = Character.getNumericValue(endCoord.charAt(0));
			int taille =  Math.abs((xe - xs) + (endY - startY)) + 1;; 
			res = this.TaillesDispos.contains(taille);
			
			
			return res ;
		}
		
		
		
		
		// Fonctions de l'Interface Play ______________________
		public  void init () {
			boolean cond = true ;
	
			int bug = 0;
			Scanner sc = new Scanner(System.in);
			for (int i =0 ;  i< this.getFlotte().length;i++) {
				this.display();
				cond=true;
				bug = 0 ;
				
				System.out.println("voici la grille de jeu  au format: A->J;0->9 ");
				
				System.out.println("voici les tailles de bateaux disponible :" + this.getTailles().toString());
				
				while (cond) {
				
					if (bug==1) {System.err.println("attention coordonées non valides: bateau en diagonale ou format de l'entrée incorrect");}
					else if (bug == 2) {System.err.println("attention ce navire en chevaucherai un deja present ! ");}
					else if (bug==3) {System.err.println("La taille du bateau que vous vouliez creez n'est plus disponible");}
					System.out.println("entrez une coordonnées de depart pour votre bateau au format: A0 ou C6 ou E8 ");
					
					String startCoord = sc.nextLine();
					System.out.println("entrez mainteant une coordonées de fin pour votre bateau toujour au format A2 ou C8 etc ");
					String endCoord = sc.nextLine();
					if (Game.areAvailable(startCoord, endCoord)) {
						if (!this.contain(startCoord, endCoord)){
							if (this.tailleDispo(startCoord, endCoord)) {
								this.addBoat(startCoord, endCoord);
								cond=false;
								bug=0;
								
								System.out.println("Navire ajouté avec succes !");
							}else {bug=3;}// taille indisponible}
						}else {bug=2;}// chevauchement }
					}else {bug=1;}// coordonées non valides 
				}
			
			}
			
			this.display();
			System.out.println("le joueur a tout ses bateau ");
			
			
			

		}
		
		
		public String choixAtt() {
			
			System.out.println();
			this.display();
			System.out.println();
			System.out.println("veuillez entrer une coordonée d'attaque au format A0 ou b5 ou C7 etc ");
			Scanner sc = new Scanner(System.in);
			String att="";
			
			
				att = sc.nextLine();
			    
			
			
			
			
			while(!Pos.isAvailable(att)) {
				System.err.println("la coordonée n'avait pas le format attendu ( A0 ou B3 ou c7 ou D9 ou J5) etc ");
				System.out.println("Reesayez une coordonée correcte svp ");
				att=sc.nextLine();
				
				
				
			
			}
			
			return att;
			
			}
		public void addShoot(String pos , boolean res ) {
			Pos nPos = new Pos(pos.charAt(0), Character.getNumericValue(pos.charAt(1)) );
			if(res) { nPos.hasHit(); }
			this.shootList.add(nPos);
		}
		
		public void display() {
			int k,l;
			boolean cond,hit=false;
			String pos;
			System.out.println(                "Voici votre flotte                voici les coups que vous avez deja éffectué ( x: touché ; L: loupé )");
			System.out.println("            A| B| C| D| E| F| G| H| I| J            A| B| C| D| E| F| G| H| I| J");
			System.out.println("           ===============================         ===============================");
			for(int i = 0; i < 10; i++){
			
			System.out.print("        "+ i + " | ");
	            for(int j = 0; j < 10 ; j++){
	            	 cond=false;
	    			
	    			 l=0;
	    			 pos =""+(char) (j+65) + i ;
	    			 while(!cond && l<this.flotte.length - this.TaillesDispos.size()) {
	    				 k =0 ;
	    				 hit = false ;
		    			 while(!cond && k<this.flotte[l].getTailleBoat()) {
		    				
		    				if (this.flotte[l].getCoo()[k].getPos().toUpperCase().equals(pos.toUpperCase())) {
		    					cond=true;
		    					hit = this.flotte[l].getCoo()[k].isHit();
		    					
		    				}
		    				k++;
		    				}
		    			 l++;
		            	
		    			 }
	    			 if(cond && hit) {System.out.print("x" + "  ");}
	    			 else if (cond && !hit) {System.out.print("O" + "  ");}
		            	else {System.out.print("~" + "  ");}
	    			 	
	            	}
	            System.out.print("|");
	            System.out.print("     "+ i + " | ");
	            for(int j = 0; j < 10 ; j++){
	            	 cond=false;
	    			 k =0 ;
	    			 pos =""+(char) (j+65) + i ;
	    			while(!cond && k<this.shootList.size()) {
	    				
	    				if (this.shootList.get(k).getPos().toUpperCase().equals(pos.toUpperCase())) {
	    					cond=true;
	    					hit = this.shootList.get(k).isHit();
	    				}
	    				k++;
	    				}
	            	if(cond && hit) {System.out.print("x" + "  ");}
	            	else if (cond) {System.out.print("L" + "  ");}
	            	else {System.out.print("~" + "  ");}
	            }
	            System.out.println("|");
			
				}
			System.out.println("           ===============================         ===============================");
		}
		}
