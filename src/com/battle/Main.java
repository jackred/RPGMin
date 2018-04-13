package com.battle;

import com.entite.*;
import java.util.Scanner; 

public class Main {
	// main method
	public static void main(String[] args) {
		// create the mage team
		int nbMage = 4;
		Scanner sc = new Scanner(System.in);
		Entity[] mages = new Mage[nbMage];
		Entity demon;
		for (int i = 0 ; i < nbMage ; i++) {
			System.out.println("Name the mage no."+i);
			mages[i] = new Mage(sc.nextLine());
			System.out.println(mages[i].toString());
		}
		// create the demon
		System.out.println("Name the demon ");
		demon = new Demon(sc.nextLine());
		System.out.println(demon.toString());
		// close Scanner
		sc.close();
		// fight
		Battle battle = new Battle(mages, demon);
		battle.fight();
	
	}
}
