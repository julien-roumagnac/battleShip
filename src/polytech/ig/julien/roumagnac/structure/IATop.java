package polytech.ig.julien.roumagnac.structure;
import java.util.ArrayList;
import java.util.Stack;




public class IATop extends IA implements Play {
	
	private ArrayList<Pos> shootList;
	private Stack<String> pile ;

	
		
	//constructeur a refaire car il faut le faire sans arguments les bateaux doivent lui etre ajoute un par un 
	public IATop() {
			this.pile = new Stack <String>();
			this.shootList = new ArrayList<Pos>();
			
				
			}
	// le joueur est il mort on test isDestroyed sur tout ces bateaux	
	public boolean isDead() {
		boolean res = true ;
		int i = 0;
		while (i< this.getFlotte().length && res) {
			if (!this.getFlotte()[i].isDestroyed()) {
				res = false ;
			}
			i++;
		}
		return res ;
		
	}
	
	
	// attaque test la pos sur tout les bateaux si elle la trouve elle ajoute un marqueur "hit" a cette pos et renvoi touche coule ou loupe 
	
		
		private ArrayList<Pos> getShootList() {
			return shootList;
		}
		
		private boolean addable (String att) {
			boolean cond=true;
			int i =0 ;
			while(cond && i<this.shootList.size()) {
				if (this.shootList.get(i).getPos().toUpperCase().equals(att.toUpperCase())) {
					cond=false;		
				}
				i++;
				}
			
			return cond && !this.pile.contains(att.toUpperCase()); 
		}
		
		// fonction de l'interface Play 
		public String choixAtt() {
			if(this.shootList.isEmpty()) {
				return "e4" ; // cas du 1er tir ou la liste de tir est vide 
			}
			
			else {
			
			
				String att = "";
				
				Pos  lastShoot = this.shootList.get(this.shootList.size()-1);
				boolean cond = false ;
			
				if(lastShoot.isHit()) {
					
					String np1,np2,np3,np4= "";
					np1 = "" + (char)(lastShoot.getPos().charAt(0)) + (char)(lastShoot.getPos().charAt(1)+1);
					np2 = "" + (char)(lastShoot.getPos().charAt(0)+1) + (char)(lastShoot.getPos().charAt(1));
					np3 = "" + (char)(lastShoot.getPos().charAt(0)-1) + (char)(lastShoot.getPos().charAt(1));
					np4 = "" + (char)(lastShoot.getPos().charAt(0)) + (char)(lastShoot.getPos().charAt(1)-1);
					if(Pos.isAvailable(np1)&& this.addable(np1.toUpperCase())) {pile.push(np1.toUpperCase());}
					if(Pos.isAvailable(np2)&& this.addable(np2.toUpperCase())) {pile.push(np2.toUpperCase());}
					if(Pos.isAvailable(np3)&& this.addable(np3.toUpperCase())) {pile.push(np3.toUpperCase());}
					if(Pos.isAvailable(np4)&& this.addable(np4.toUpperCase())) {pile.push(np4.toUpperCase());}
					
					}
				if (!this.pile.isEmpty()) {att=pile.pop();}
				
				
				else  {
				
				
					while (!cond) {
					
					att = IATop.randomPos();
					
					cond = this.addable(att);
					

					}}
				
				
			System.out.println("L'IA tire en "+ att);
			return att;
		}}
		public void addShoot(String pos, boolean res  ) {
			
			Pos nPos = new Pos(pos.charAt(0), Character.getNumericValue(pos.charAt(1)) );
			if(res) { nPos.hasHit(); }
			this.getShootList().add(nPos);
			
		}
		private static String randomPos() {
			String att ;
			int x = (int)(Math.random()*10)+65;
			int y = (int)(Math.random()*10)+48;
			
			while((x+y)%2!=0) {
				 x = (int)(Math.random()*10)+65;
				 y = (int)(Math.random()*10)+48;
				 
					
				
			}
			
			char X = (char)x;
			char Y = (char)y;
			att = ""+ X + Y ;
			return att;
		}
		
		
		

		
		
		}
		

