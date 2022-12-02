package com.cre;

public class Monster {
	String id = "";
	String name = "";
	int hp = 0;
	int maxHp = 0;
	int attack = 0;
	int location = 0;
	int exp = 0;
	
	Monster(String id, String name, int hp, int maxHp, int location, int attack, int exp){
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.location = location;
		this.attack = attack;
		this.exp = exp;
	}
	String info() {
		String info = this.name + " [" + this.hp + "/" + this.maxHp + "]";
		return info;
	}

}
