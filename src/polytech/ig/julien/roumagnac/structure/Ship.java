package polytech.ig.julien.roumagnac.structure;

public class Ship {
	private Pos coords[];

	// Constructeur
	public Ship(String startCoord, String endCoord) {
		int xs,xe,ys,ye;
		xs = Character.getNumericValue(startCoord.charAt(0));
		xe = Character.getNumericValue(endCoord.charAt(0));
		ys = Character.getNumericValue(startCoord.charAt(1));
		ye = Character.getNumericValue(endCoord.charAt(1));
		int lenght = Math.abs((xe - xs) + (ye - ys)) + 1;
		this.coords = new Pos[lenght];
		setCoords(startCoord,endCoord);
	}
	
	
	

	// test si toutes les case du bateau sont touche
	public boolean isDestroyed() {
		boolean res = true;
		int i = 0;
		while (res && i < this.getTailleBoat()) {
			if (!coords[i].isHit()) {
				res = false;
			}
			i++;
		}
		return res;
	}

	// hit permet de verifier si un bateau possede la case voulu et si c'est le cas
	// lui met le marqueur "hit"
	public boolean hit(String att) {
		boolean res = false;
		int i = 0;
		while (i < this.getTailleBoat() && !res) {
			if (this.coords[i].getPos().toUpperCase().equals(att.toUpperCase()) && !this.coords[i].isHit()) {
				res = true;
				this.coords[i].hasHit();
			}
			i++;

		}

		return res;
	}

	// teste si le bouteau est touche surune case precise
	public boolean isAllreadyHit(String att) {
		boolean res = false;

		int i = 0;
		while (i < this.getTailleBoat() && !res) {
			if (this.coords[i].getPos().toUpperCase().equals(att.toUpperCase()) && this.coords[i].isHit()) {
				res = true;

			}
			i++;

		}

		return res;

	}
	
	

	// Getters 
	public Pos [] getCoo() {
		return this.coords;
	}
	public int getTailleBoat() {
		return coords.length;
	}
	public char getxstart() {
		char res ;
		res = this.coords[0].getPos().charAt(0);
		return res ;
	}
	public char getxend() {
		char res ;
		res = this.coords[this.getTailleBoat()-1].getPos().charAt(0);
		return res ;
	}
	public int getystart() {
		int res ;
		res = Character.getNumericValue(this.coords[0].getPos().charAt(1));
		return res ;
	}
	public int getyend() {
		int res ;
		res = Character.getNumericValue(this.coords[this.getTailleBoat()-1].getPos().charAt(1));
		return res ;
	}

	// ajoute au tableau des coordonees toutes les coordonees entre Startcoord et
	// End Coord
	private void setCoords(String startCoord, String endCoord) {
		char xMin;
		int yMin ;
		char startX = startCoord.toUpperCase().charAt(0);
		char endX = endCoord.toUpperCase().charAt(0);
		int startY = Character.getNumericValue(startCoord.charAt(1));
		int endY = Character.getNumericValue(endCoord.charAt(1));

		xMin = startX < endX ? startX : endX;
		

		yMin = startY< endY? startY : endY ;
		
		

		if (startX == endX) {
			for (int i = 0; i < this.getTailleBoat(); i++) {
			yMin += 1;
			this.coords[i] = new Pos(xMin, yMin - 1);
		}
	} else {
		for (int i = 0; i < this.getTailleBoat(); i++) {

			this.coords[i] = new Pos(xMin, yMin);
			xMin += 1;
		}
	}}
	


}
