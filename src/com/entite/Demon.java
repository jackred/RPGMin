package com.entite;

import java.util.concurrent.ThreadLocalRandom;
//import com.comportement.*;

public class Demon extends Entite{	
	
	protected int maxHP = 4000;
	protected int minHP = 3500;
	
	public Demon() {
		this.name = "Demon";
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		isDead = false;
	}
	public Demon(String name) {
		this.name = name;
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		isDead = false;
	}
	
	public int attack() {
		int tmp = ThreadLocalRandom.current().nextInt(60, 81);
		System.out.println("->"+this.getName() +" fait une attaque démoniaque infligeant "+ KYEL + ""+ tmp +""+ KNRM +" dégats");
		return(tmp);
	}
	
	
	public String getName() {
		return(KRED+""+this.name+""+KNRM);
	}

	
}
