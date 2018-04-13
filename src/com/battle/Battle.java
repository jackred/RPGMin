package com.battle;

import com.entite.*;

public class Battle {
	Entity[] mages;
	Entity demon;	
	
	public Battle(Entity[] mages, Entity demon) {
		this.demon = demon;
		this.mages = mages;
	}
	/*
	 * fight method
	 * take a team of 4 mages and a demon, and makes them fight
	 * it's a turn by turn battle
	 */
	public void fight () {
		System.out.println("The battle start");
		while (!(isWin())) {
			turn();
		}
		// display the winner
		announceVictory();
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
	public void turn (){
		System.out.println("\n");
		int i = 0;
		while (i < mages.length && (!(isWin())) ) {
			if (!(mages[i].getLife())) {
				mages[i].attack(demon);
			}
			// 1%1 and 3%1 == 1
			if ((i % 2 == 1) && (!(isWin()))) {
				System.out.println("");
				demon.attack(mages);
				System.out.println("");
			}
			i++;
		}
	}
	
	// did the mage team win ?
	public boolean isWin(){
		boolean tmp = true;
		for (Entity one: mages) {
			tmp = tmp && one.getLife();
		}
		return(tmp || demon.getLife());
	}

	// display all the opponents
	public void display() {
		System.out.println(demon.toString());
		for(Entity one:mages) {
			System.out.println(one.toString());
		}
	}
	
	// display the winner
	public void announceVictory() {
		if (demon.getLife()) {
			System.out.println("The mages won");
		} else {
			System.out.println("The demon win");
		}
	}
}
