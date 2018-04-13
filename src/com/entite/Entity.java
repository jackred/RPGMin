package com.entite;

public abstract class Entity {
	// constant of text color
	public static final String KNRM = "\033[1;0m";  // Reset color
	public static final String KRED = "\033[1;31m"; // Red
	public static final String KGRN = "\033[1;32m"; // Green
	public static final String KYEL = "\033[1;33m"; // Yellow
	public static final String KBLU = "\033[1;34m"; // Blue
	public static final String KMAG = "\033[1;35m"; // Magenta
	public static final String KCYN = "\033[1;36m"; // Cyan
	public static final String KWHT = "\033[1;37m"; // White
	public static final String LGRN = "\033[1;92m"; // Light green
	public static final String LBLU = "\033[1;94m"; // Light Blue
	public static final String LRED = "\033[1;91m"; // Light red
	
	// hp of the entity
	protected int hp;
	// name of the entity
	protected String name;
	// is the entity dead ?
	protected boolean isDead;
	
	// return the damage of the attack of an entity
	public abstract void attack(Entity...targets);
	
	// describe an entity in a string which is returning by the function
	public String toString() {
		return (this.getClass()+"\nNom : "+ this.getName() + "\nHP : "+ this.getHP());
	}
	
	// setters
	public void setHP(int hp) {
		this.hp = Math.max(0,this.hp-hp);
		System.out.println(this.getName() +" now has "+ KCYN +""+ this.getHP() +""+ KNRM +" HPs");
		// is it dead ?
		this.setLife();
	}
	public void setLife() {
		// dead mean less than 0 hp
		this.isDead = this.getHP() <= 0;
		if (isDead) {
			System.out.println("/!\\"+this.getName() +" is dead! /!\\");
		}
	}
	
	// getters
	public int getHP() {
		return(this.hp);
	}
	public boolean getLife() {
		return(this.isDead);
	}
	public abstract String getName();

	
}
