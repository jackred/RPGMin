package com.entite;

//import java.util.concurrent.ThreadLocalRandom;
//import com.comportement.*;

public abstract class Entite {
	public static final String KNRM = "\033[1;0m";
	public static final String KRED = "\033[1;31m";
	public static final String KGRN = "\033[1;32m";
	public static final String KYEL = "\033[1;33m";
	public static final String KBLU = "\033[1;34m";
	public static final String KMAG = "\033[1;35m";
	public static final String KCYN = "\033[1;36m";
	public static final String KWHT = "\033[1;37m";
	public static final String LGRN = "\033[1;92m";
	public static final String LBLU = "\033[1;94m";
	public static final String LRED = "\033[1;91m";
	
	protected int hp;
	protected String name;
	protected boolean isDead;
	//protected Attaque atk;
	
	
	public abstract int attack();
	
	public String toString() {
		return (this.getClass()+"\nNom : "+ this.getName() + "\nHP : "+ this.getHP());
	}
	
	// setters
	public void setHP(int hp) {
		if (hp <= 0) {
			this.hp = 0;
		}else {
			this.hp = hp;
		}
		System.out.println(this.getName() +" a maintenant "+ KCYN +""+ this.getHP() +""+ KNRM +" HPs");
		this.setLife();
	}
	public void setLife() {
		this.isDead = this.getHP() <= 0;
		if (isDead) {
			System.out.println("/!\\"+this.getName() +" est mort ! /!\\");
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
