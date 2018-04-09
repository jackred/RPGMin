package com.battle;

import com.entite.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {

	public void fight (Entite demon, Entite mage[]) {
		System.out.println("Debut de la bataille");
		while ((!(isWin(demon))) && (!(isWin(mage)))) {
			turn(demon, mage);
		}
		announceVictory(demon, mage);
	}
	
	public void turn (Entite demon, Entite mage[]) {
		System.out.print("=====");
		int i = 0;
		boolean tmp = true;
		Entite aliveMage[];
		while (i < mage.length && tmp ) {
			attackEntite(mage[i],demon);
			tmp = (!(isWin(demon))) && (!(isWin(mage)));
			if ((i % 2 == 1) && ((tmp))) {
				aliveMage = Arrays.stream(mage).filter(x -> (!(x.getLife()))).toArray(Entite[]::new);
				attackEntite(demon,aliveMage[ThreadLocalRandom.current().nextInt(0,aliveMage.length)]);
			}
			i++;
		}
	}
	
	public void attackEntite(Entite atks, Entite cible) {
		int dmg = atks.attack();
		cible.setHP(cible.getHP() - dmg);
	}
	
	public boolean isWin(Entite entite[]) {
		boolean tmp = true;
		for (Entite one: entite) {
			tmp = tmp && one.getLife();
		}
		return(tmp);
	}
	public boolean isWin(Entite entite) {
		return(entite.getLife());
	}
	
	public void display(Entite demon, Entite mage[]) {
		System.out.println(demon.toString());
		for(Entite one:mage) {
			System.out.println(one.toString());
		}
	}
	
	// display 
	public void announceVictory(Entite demon, Entite mage[]) {
		if (isWin(demon)) {
			System.out.println("Les magiciens ont gagné");
		} else {
			System.out.println("Le démon a gagné");
		}
	}
}
