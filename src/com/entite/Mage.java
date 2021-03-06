package com.entite;

import java.util.concurrent.ThreadLocalRandom;

public class Mage extends Entity{
	// pm of the mage (mana)
	protected int pm;
	// the max and min HP a mage could have
	private final int maxPM = 700;
	private final int minPM = 500;
	// the max and min HP a mage could have
	protected final int maxHP = 300;
	protected final int minHP = 200;
	
	// default construtor
	public Mage() {
		name = "Mage";
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		pm = ThreadLocalRandom.current().nextInt(minPM, maxPM + 1);
		isDead = false;
	}
	
	// constructor with a name
	public Mage(String name) {
		this.name = name;
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		pm = ThreadLocalRandom.current().nextInt(minPM, maxPM + 1);
		isDead = false;
	}
	

	// adding the pm to the method
	public String toString() {
		return(super.toString() +"\nPM : "+ this.getPM());
	}
	
	// setters
	public void setPM(int pm) {
		this.pm -= pm;
	}
	
	// getters
	public int getPM(){
		return(this.pm);
	}
	public String getName() {
		return(KBLU+""+this.name+""+KNRM);
	}
	
	
	/* 
	 * mage attack method. If the mage has more than 30 pm, he could do 
	 * a magic attack, otherwise he do a physical attack 
	*/
	public void attack(Entity... target) {
		if(this.pm < 30) {
			attackPhy(target[0]);
		} else {
			attackPM(target[0]);
		}
	}
	// magick attack of the mage, costing 30pm
	private void attackPM (Entity target) {
		setPM(30);
		int tmp = ThreadLocalRandom.current().nextInt(80, 131);
		System.out.println("->"+this.getName() +" do a magic attack inflicting "+ KGRN + ""+ tmp +""+ KNRM +" damages to "+ target.getName());
		target.setHP(tmp);
	}
	// physical attack of the mage, costing no mana
	private void attackPhy (Entity target) {
		int tmp = ThreadLocalRandom.current().nextInt(20, 30);
		System.out.println("->"+this.getName() +" do a physical	attack inflicting "+ KGRN + ""+ tmp +""+ KNRM +" damages to "+ target.getName());
		target.setHP(tmp);
	}
	
	
	
}
