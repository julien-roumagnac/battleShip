package polytech.ig.julien.roumagnac.structure;
import java.util.ArrayList;



public class IAMedium extends IA implements Play {
	
	private ArrayList<String> shootList;

	
		
	//constructeur a refaire car il faut le faire sans arguments les bateaux doivent lui etre ajoute un par un 
	public IAMedium() {
			super();
			this.shootList = new ArrayList<String>();
			
				
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
	
	
	
		private ArrayList<String> getShootList() {
			return shootList;
		}
		
		// fonction de l'interface Play 
		public String choixAtt() {
			String att=IAMedium.randomPos();
			
			while(this.getShootList().contains(att)) {
				att=IAMedium.randomPos();
			}
			this.addShoot(att,true);
			System.out.println("L'IA tire en "+ att);
			return att;
		}
		public void addShoot(String pos, boolean res  ) {
			this.getShootList().add(pos);
		}
		private static String randomPos() {
			String att ;
			int x = (int)(Math.random()*10)+65;
			int y = (int)(Math.random()*10)+48;
			char X = (char)x;
			char Y = (char)y;
			att = ""+ X + Y ;
			return att;
		}
		
		
		
	
}


