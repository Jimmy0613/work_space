package com.cre;

import com.cre.util.Util;

public class Character {
	static String name = "";
	static int hp = 0;
	static int maxHp = 0;
	static String mode = "";
	static int attack = 0;
	static int exp = 0;
	static int coin = 0;
	static int expFull = 100;
	static int Lv = 1;
	
	Character(String name, int hp, int maxHp, int attack){
		Character.name = name;
		Character.hp = hp;
		Character.maxHp = maxHp;
		Character.mode = "대기";
		Character.attack = attack;
	}
	static void info() {
		Util.prl("[캐릭터]  [Lv." + Lv + "]<" + name + "> 체력[" + hp + "/" + maxHp + "] 경험치[" + Character.exp + "/" + Character.expFull + "] (상태: " + mode + ")");
	}
	static void getExpForNextLv(int Lv) {
		expFull = Lv * 100;
	}
	static void lvUpCheck() {
		int overExp = 0;
		if (Character.exp>=Character.expFull) {
			Lv++;
			attack += 8*Lv;
			maxHp += 5*Lv;
			hp = maxHp;
			overExp = exp - expFull;
			exp = overExp;
			getExpForNextLv(Lv);
			Util.prl("<시스템> 레벨이 올랐습니다!(레벨" + Lv + ")");
		} else return;
	}
	
	static void displayCharacterInfo() {
		lvUpCheck();
		info();
	}
}
