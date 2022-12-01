package com.cre;

public class Character {
	String name = "";
	int hp = 0;
	int maxHp = 0;
	int attack = 0;
	int exp = 0;
	int coin = 0;
	
	Character(String name, int hp, int maxHp, int attack){
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.attack = attack;
	}
	void info() {
		System.out.println("[캐릭터]  " + this.name + " [" + this.hp + "/" + this.maxHp + "]");
	}
}
