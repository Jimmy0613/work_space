package com.cre;

public class Monster {
	String id = "";
	String name = "";
	int hp = 0;
	int maxHp = 0;
	int attack = 0;
	int location = 0;
	String info = "";
	
	Monster(String id, String name, int hp, int maxHp, int location){
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.location = location;
		info = this.name + "[" + this.hp + "/" + this.maxHp + "]";
	}
	

}
