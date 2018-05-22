package polytech.ig.julien.roumagnac.game;
import polytech.ig.julien.roumagnac.structure.Play;

public class Game {
			
			// test si les positions choisient sont acceptables ( diago ? taille ? a,J ; 0,9 ? une seule case ? )
			public  static boolean areAvailable(String startCoord , String endCoord) {
				boolean cond1,cond2,cond4 = false;
				// on teste que les entrees sont de taille 2
				boolean cond3 = startCoord.length()== 2 && endCoord.length()==2;
				
				if (cond3) {
					// on teste si ce n'est pas en diago 
					cond1 = (startCoord.toLowerCase().charAt(0) == endCoord.toLowerCase().charAt(0)) || (startCoord.toLowerCase().charAt(1) == endCoord.toLowerCase().charAt(1));
					// on test que ce ne soit pas la meme case 
					cond2 = ! startCoord.toLowerCase().equals(endCoord.toLowerCase());
					 
				
					// on test si le premier caractere est entre A et J et si le second est entre 0 et 9 
					cond4 = startCoord.toUpperCase().charAt(0)>=(char)'A' && startCoord.toUpperCase().charAt(0)<= (char)'J' && Character.getNumericValue(startCoord.charAt(1))<=9 && Character.getNumericValue(startCoord.charAt(1))>=0 && endCoord.toUpperCase().charAt(0)>=(char)'A' && endCoord.toUpperCase().charAt(0)<= (char)'J' && Character.getNumericValue(endCoord.charAt(1))>=0 && Character.getNumericValue(endCoord.charAt(1))<=9 ;
					}
					else 
						{return false ;}
				return    cond1 && cond2 && cond3 && cond4;
			} 
			
			
		public static String tour(Play j1, Play j2) {
			String att ;
			String resAtt;
			att=j1.choixAtt();
			
			
			resAtt = j2.attaque(att);
			boolean res = resAtt.equals("Touche Coule !! ") || resAtt.equals("Touche ! ") ? true : false ;
			j1.addShoot(att.toUpperCase(), res);
			
			
			return resAtt;
			
		}
		
	

	
		public static void main(String[] args) {
			
			
			
		}
		
		
	

}
