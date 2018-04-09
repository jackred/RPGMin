package com.comportement;

import java.util.concurrent.ThreadLocalRandom;

public class MageAtkPhy implements Attaque{
	public int attack() {		
		return (ThreadLocalRandom.current().nextInt(20,31));
	}
}
