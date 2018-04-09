package com.battle;

import com.entite.*;
import java.util.Scanner; 

public class Main {
	public static void main(String[] args) {
		Battle battle = new Battle();
		int nbMage = 4;
		Scanner sc = new Scanner(System.in);
		Entite[] mage = new Mage[nbMage];
		Entite demon;
		for (int i = 0 ; i < nbMage ; i++) {
			System.out.println("Nommez le mage n°"+i);
			mage[i] = new Mage(sc.nextLine());
			System.out.println(mage[i].toString());
		}
		System.out.println("Nommez le Démon");
		demon = new Demon(sc.nextLine());
		System.out.println(demon.toString());
		battle.fight(demon, mage);
		sc.close();
	}
}
