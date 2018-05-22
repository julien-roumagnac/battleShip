package polytech.ig.julien.roumagnac.structure;

import java.util.ArrayList;

import polytech.ig.julien.roumagnac.game.Game;

public abstract class IA {
	private Ship flotte [] ;
	private ArrayList<Integer> TaillesDispos ;
	
	public IA() {
		
		
		this.TaillesDispos = new ArrayList<Integer>();
		this.TaillesDispos.add(5);
		this.TaillesDispos.add(4);
		this.TaillesDispos.add(3);
		this.TaillesDispos.add(3);
		this.TaillesDispos.add(2);
		this.flotte = new Ship[this.TaillesDispos.size()];	
			
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
	
	// verifie si un bateau chevauche celui ci 
	
	
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
	public  void init () {
		int xory;
		char up ;
		
		for (int i = 0;i<this.getFlotte().length;i++) {
			String sCoord = IALow.randomPos();
			String eCoord ;
			xory= (int)(Math.random()*4);
			
			if (xory==1) {
				up = sCoord.charAt(1);
				up+=this.getTailles().get(0)-1;
				eCoord = ""+ sCoord.charAt(0)+up;
			}
			else if (xory==0){
				up = sCoord.charAt(0);
				up+=this.getTailles().get(0)-1;
				eCoord = ""+ up+ sCoord.charAt(1);
			}
			else if (xory==2){
				up = sCoord.charAt(0);
				up-=this.getTailles().get(0)-1;
				eCoord = ""+ up+ sCoord.charAt(1);
			}
			else {
				up = sCoord.charAt(1);
				up-=this.getTailles().get(0)-1;
				eCoord = ""+ sCoord.charAt(1)+up ;
			}
			
			while (this.contain(sCoord, eCoord)|| !Game.areAvailable(sCoord,eCoord)) {
				sCoord = IALow.randomPos();
				xory= (int)Math.random()*2;
				if (xory==1) {
					up = sCoord.charAt(1);
					up+=this.getTailles().get(0)-1;
					eCoord = ""+ sCoord.charAt(0)+up;
				}
				else if (xory==0) {
					up = sCoord.charAt(0);
					up+=this.getTailles().get(0)-1;
					eCoord = ""+ up+ sCoord.charAt(1);
				}
				else if (xory==2){
					up = sCoord.charAt(0);
					up-=this.getTailles().get(0)-1;
					eCoord = ""+ up+ sCoord.charAt(1);
				}
				else {
					up = sCoord.charAt(1);
					up-=this.getTailles().get(0)-1;
					eCoord = ""+ sCoord.charAt(1)+up ;
				}
				
				
			}
			
			this.addBoat(sCoord, eCoord);
			
			System.out.println("Navire ajouté avec succes !");
			
			
		}
		System.out.println("tous les bateau de l'ia");
		
		
		
	}

}
