package com.comportement;

import java.util.concurrent.ThreadLocalRandom;

public class MageAtkPm implements Attaque{
	public int attack() {		
		return (ThreadLocalRandom.current().nextInt(80,130));
	}
}
