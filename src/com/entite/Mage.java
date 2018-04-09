package com.entite;

import java.util.concurrent.ThreadLocalRandom;
//import com.comportement.*;

public class Mage extends Entite{
	
	protected int pm;
	private int maxPM = 700;
	private int minPM = 500;
	protected int maxHP = 300;
	protected int minHP = 200;
	
	public Mage() {
		name = "Mage";
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		pm = ThreadLocalRandom.current().nextInt(minPM, maxPM + 1);
		isDead = false;
	}
	
	public Mage(String name) {
		this.name = name;
		hp = ThreadLocalRandom.current().nextInt(minHP, maxHP + 1);
		pm = ThreadLocalRandom.current().nextInt(minPM, maxPM + 1);
		isDead = false;
	}
	
	
	public int attack() {
		if(this.pm < 30) {
			return(attackPhy());
		} else {
			return(attackPM());
		}
	}
	private int attackPM () {
		setPM(this.pm - 30);
		int tmp = ThreadLocalRandom.current().nextInt(80, 131);
		System.out.println("->"+this.getName() +" fait une attaque magique infligeant "+ KGRN + ""+ tmp +""+ KNRM +" dégats");
		return(tmp);
	}
	private int attackPhy () {
		int tmp = ThreadLocalRandom.current().nextInt(20, 30);
		System.out.println("->"+this.getName() +" fait une attaque magique infligeant "+ KGRN + ""+ tmp +""+ KNRM +" dégats");
		return(tmp);
	}
	
	public String toString() {
		return(super.toString() +"\nPM : "+ this.getPM());
	}
	
	// setters
	public void setPM(int pm) {
		this.pm = pm;
	}
	
	// getters
	public int getPM(){
		return(this.pm);
	}
	public String getName() {
		return(KBLU+""+this.name+""+KNRM);
	}
	
}
