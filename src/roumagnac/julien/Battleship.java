package roumagnac.julien;

import java.util.Scanner;

import polytech.ig.julien.roumagnac.game.Game;
import polytech.ig.julien.roumagnac.structure.IAHigh;
import polytech.ig.julien.roumagnac.structure.IATop;
import polytech.ig.julien.roumagnac.structure.IALow;
import polytech.ig.julien.roumagnac.structure.IAMedium;
import polytech.ig.julien.roumagnac.structure.Play;
import polytech.ig.julien.roumagnac.structure.Player;

public class Battleship extends Game {

	public static void main(String[] args) {
		String replay ="o";
		int numpartie =0 ;
		String lvl ="";
		String mode="";
		Play j1 = null , j2 = null;
		
		System.out.println("Quel mode desirez vous ? pour jouer avec un ami entrez '1' si vous voulez jouez contre une IA entrez '2'");
		Scanner sc = new Scanner(System.in);
		mode = sc.nextLine();
		while(!(mode.equals("1")|| mode.equals("2"))){
			System.err.println("Vous n'avez pas rentré ( 1 ou 2  ) . ");
			
			System.out.println("tapez :  1 pour jouer avec un ami ; 2 pour jouer contre une IA");
			mode = sc.nextLine();
		}
		if(mode.equals("2")) {
			System.out.println("Choisissez le level de L'IA : 1 , 2 ,3 ou 4");
			lvl = sc.nextLine();
			while(!(lvl.equals("1")|| lvl.equals("2")|| lvl.equals("3") || lvl.equals("4"))){
				System.err.println("Vous n'avez pas rentré ( 1 ou 2 ou 3 ou 4  ) . ");
				
				System.out.println("tapez :  1 pour Low; 2 pour Medium ; 3 pour High ; 4 pour HighAieAie");
				lvl = sc.nextLine();
			}
		}
		while (replay.equals("o")) {
		if( mode.equals("1")) {
			j1 = new Player();
			j2 = new Player();
			
		}
		else {
			int cas = Integer.parseInt(lvl);
			 j1 = new Player();
			
			switch (cas)
			{
			  case 1:
			     j2 = new IALow();
			    break;
			  case 2:
				  j2 = new IAMedium();
			    break;
			  case 3:
				  j2 = new IAHigh();
			    break;
			  case 4:
				  j2 = new IATop();
			    break;
			  default:
			    j2 = new IALow();
			}
			
			
			 
			
			
		}
		
		
		j1.init();
		j2.init();
		
		
		
		boolean fin = true ;
		
		while  (fin ) {
			
				if(numpartie%2==0) {
					System.out.println("________________________________________________________________________");
					System.out.println("                            votre tour");
					String res = tour(j1,j2);
					System.out.println(res );
					System.out.println();
					System.out.println("________________________________________________________________________");
					System.out.println("                             tour de l'adversaire");
					String res2 = tour ( j2,j1);
					System.out.println(res2 );
					System.out.println();
					
				}
				else {
					System.out.println("________________________________________________________________________");
					System.out.println("                            tour de l'adversaire");
					String res = tour(j2,j1);
					System.out.println(res );
					System.out.println();
					System.out.println("________________________________________________________________________");
					System.out.println("                             Votre tour ");
					String res2 = tour ( j1,j2);
					System.out.println(res2 );
					System.out.println();
				}
				
				
				if (j1.isDead() || j2.isDead()) {
					fin = false ;}
				
			
				}
				System.out.println();
		
				if(j1.isDead()) { 
					System.out.println("________________  Vous avez perdu ! entrainez vous et réessayer !  _____________________ ");
					 
					}
				else {
					System.out.println("_______________  Bravo vous avez gagne l'IA de level "+ lvl+"  __________________");}
				
				numpartie ++;
				System.out.println("Voulez vous prendre votre revanche ? entrez 'o' pour continuer et 'n' ");
				replay=sc.nextLine();
				while(!(replay.toLowerCase().equals("o")||replay.toLowerCase().equals("n"))) {
					System.err.println("attention vous n'avez pas rentré : o  ou n ");
					System.out.println("Voulez vous prendre votre revanche ? entrez 'o' pour continuer et 'n' ");
					replay=sc.nextLine();
				}
		
		
		
		}
		
		
		}
		
}
	



