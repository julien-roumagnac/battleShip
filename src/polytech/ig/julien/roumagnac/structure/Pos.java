package polytech.ig.julien.roumagnac.structure;

public class Pos {
	private char x;
	private int y;
	private boolean hited;

	public Pos(char x, int y) {
		this.x = x;
		this.y = y;
		this.hited = false;
	}

	public boolean isHit() {
		return this.hited;
	}

	public void hasHit() {
		this.hited = true;
	}
	public String getPos() {
		StringBuffer res = new StringBuffer();
		res.append(this.x);
		res.append(this.y);
		return res.toString().toLowerCase();
	}
	public char getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	// test pour une entree si les valeurs sont coherentes taille 2 et [a-j] [0-9]
	public  static boolean isAvailable(String coord ) {
		boolean cond1,cond2= false;
		// on teste que les entrees sont de taille 2
		 cond1 = coord.length()== 2 ;
		
		if (cond1) {
			// on test si le premier caractere est entre A et J et si le second est entre 0 et 9 
			cond2 = coord.toUpperCase().charAt(0)>=(char)'A' && coord.toUpperCase().charAt(0)<= (char)'J' && Character.getNumericValue(coord.charAt(1))<=9 && Character.getNumericValue(coord.charAt(1))>=0 ;
			}
			else 
				{return false ;}
		return    cond1 && cond2 ;
	} 
	
	

}
