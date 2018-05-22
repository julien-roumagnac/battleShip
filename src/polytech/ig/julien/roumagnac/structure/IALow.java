package polytech.ig.julien.roumagnac.structure;




public class IALow extends IA implements Play {
	

	
		
	//constructeur a refaire car il faut le faire sans arguments les bateaux doivent lui etre ajouté un par un 
	public IALow() {
			
			super();
				
				
			}
	
		
		// fonction de l'interface Play 
		public String choixAtt() {
			String att=IALow.randomPos();
			System.out.println("L'IA tire en "+ att);
			return att;
			
		}
		public static String randomPos() {
			String att ;
			int x = (int)(Math.random()*10)+65;
			int y = (int)(Math.random()*10)+48;
			char X = (char)x;
			char Y = (char)y;
			att = ""+ X + Y ;
			return att;
		}
		
		
		public void addShoot(String pos , boolean res ) {
			
		}
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
	
}

