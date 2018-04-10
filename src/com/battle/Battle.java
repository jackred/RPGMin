package com.battle;

import com.entite.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {
	/*
	 * fight method
	 * take a team of 4 mages and a demon, and makes them fight
	 * it's a turn by turn battle
	 */
	public void fight (Entity demon, Entity mage[]) {
		System.out.println("The battle start");
		while ((!(isWin(demon))) && (!(isWin(mage)))) {
			turn(demon, mage);
		}
		// display the winner
		announceVictory(demon, mage);
	}
	
	/*
	 * turn method
	 * each turn all mage and the demon attack in the following order :
	 *  1rst mage
	 *  2nd mage
	 *  demon
	 *  3rd mage
	 *  4th mage
	 *  demon   
	 */
	public void turn (Entity demon, Entity mage[]) {
		System.out.print("");
		int i = 0;
		boolean tmp = true;
		Entity aliveMage[];
		while (i < mage.length && tmp ) {
			attackEntity(mage[i],demon);
			tmp = (!(isWin(demon))) && (!(isWin(mage)));
			// 1%1 and 3%1 == 1
			if ((i % 2 == 1) && ((tmp))) {
				// the demon attack alive mage
				aliveMage = Arrays.stream(mage).filter(x -> (!(x.getLife()))).toArray(Entity[]::new);
				attackEntity(demon,aliveMage[ThreadLocalRandom.current().nextInt(0,aliveMage.length)]);
			}
			i++;
		}
	}
	
	// attack method taking a target and an attacker
	public void attackEntity(Entity atks, Entity target) {
		int dmg = atks.attack();
		target.setHP(target.getHP() - dmg);
	}
	
	// did the mage team win ?
	public boolean isWin(Entity entite[]) {
		boolean tmp = true;
		for (Entity one: entite) {
			tmp = tmp && one.getLife();
		}
		return(tmp);
	}
	// did the demon win ?
	public boolean isWin(Entity entity) {
		return(entity.getLife());
	}
	
	// display all the opponents
	public void display(Entity demon, Entity mage[]) {
		System.out.println(demon.toString());
		for(Entity one:mage) {
			System.out.println(one.toString());
		}
	}
	
	// display the winner
	public void announceVictory(Entity demon, Entity mage[]) {
		if (isWin(demon)) {
			System.out.println("The mages won");
		} else {
			System.out.println("The demon win");
		}
	}
}
