package com.entite;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class Demon extends Entity{	
	// the max and min HP a demon could have
	protected final int maxHP = 4000;
	protected final int minHP = 3500;
	
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

	// getters
	public String getName() {
		return(KRED+""+this.name+""+KNRM);
	}

	// demon attack method, returning an int between 2 boundaries
	public void attack(Entity... mages) {
		// the demon attack alive mage
		Entity aliveMage[];
		aliveMage = Arrays.stream(mages).filter(x -> (!(x.getLife()))).toArray(Entity[]::new);
		Entity target = aliveMage[ThreadLocalRandom.current().nextInt(0,aliveMage.length)];
		int tmp = ThreadLocalRandom.current().nextInt(60, 81);
		System.out.println("->"+this.getName() +" do a demonic attack inflicting "+ KYEL + ""+ tmp +""+ KNRM +" damages to "+ target.getName());
		target.setHP(tmp);
	}
	
}
