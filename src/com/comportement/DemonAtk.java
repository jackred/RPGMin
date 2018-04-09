package com.comportement;

import java.util.concurrent.ThreadLocalRandom;

public class DemonAtk implements Attaque{
	public int attack() {		
		return (ThreadLocalRandom.current().nextInt(60,80));
	}
}
