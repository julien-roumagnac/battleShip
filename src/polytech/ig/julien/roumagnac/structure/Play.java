package polytech.ig.julien.roumagnac.structure;

public interface Play {
	public void init();
	public String choixAtt();
	public String attaque(String pos);
	public boolean isDead();
	public void addShoot(String pos,boolean res );
}
