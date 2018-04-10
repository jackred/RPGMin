package com.entite;

import java.util.concurrent.ThreadLocalRandom;


public class Demon extends Entity{	
	// the max and min HP a demon could have
	protected int maxHP = 4000;
	protected int minHP = 3500;
	
	// default constructor
	public Demon() {
		this.name = "Demon";
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		isDead = false;
	}
	// constructor with a name
	public Demon(String name) {
		this.name = name;
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		isDead = false;
	}
	
	// demon attack method, returning an int between 2 boundaries
	public int attack() {
		int tmp = ThreadLocalRandom.current().nextInt(60, 81);
		System.out.println("->"+this.getName() +" do a demonic attack inflicting "+ KYEL + ""+ tmp +""+ KNRM +" damages");
		return(tmp);
	}
	
	// getters
	public String getName() {
		return(KRED+""+this.name+""+KNRM);
	}

	
}
