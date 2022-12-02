package com.cre;

import com.cre.util.Util;

public class Battle {
	static Monster[] monsterArr;
	static Monster target;

	static Monster[] getMonsterArray(Monster[] monsterArray) {
		monsterArr = monsterArray;
		return monsterArr;
	}

	static boolean game = true;

	static void battleOneByOne(int currentRoomId) {
		target = RoomFunctions.roomMonsters.get(0);

		int monsterDamage = Util.random(target.attack);
		int characterDamage = Util.random(Character.attack);

		Character.hp = Character.hp - monsterDamage;
		Util.prl("<시스템> " + target.name + "이(가) " + Character.name + "에게 " + monsterDamage + "만큼 데미지를 입혔습니다.");
		target.hp = target.hp - characterDamage;
		Util.prl("<시스템> " + Character.name + "이(가) " + target.name + "에게 " + characterDamage + "만큼 데미지를 입혔습니다.");
		Util.br();
		if (Character.hp <= 0) {
			battleEnd(target);
			return;
		} else if (target.hp <= 0) {
			battleEnd(target);
			return;
		}

		Turn.turn++;
	}

	static void battleEnd(Monster target) {
		if (target.hp <= 0) {
			RoomFunctions.roomMonsters.remove(0);
			deleteDieMonster(target);
			Util.prl("<시스템> " + Character.name + "이(가) " + target.name + "을(를) 처치했습니다.");
			battleGetReward(target);
			Character.lvUpCheck();
			Util.br();
		} else if (Character.hp <= 0) {
			Util.prl("<시스템> 죽었습니다.");
			Util.prl("<시스템> GameOver");
			Util.br();
			isGameOver(false);
		}
	}

	static void deleteDieMonster(Monster dieMonster) {
		int findI = -1;
		for (int i = 0; i < monsterArr.length; i++) {
			if (monsterArr[i] != null) {

				if (dieMonster.id == monsterArr[i].id) {
					findI = i;
				}
			}
		}
		if (findI != -1) {
			monsterArr[findI] = null;
		}
	}

	static boolean isGameOver(boolean game) {
		if (game == false) {
			Battle.game = false;
		} else {
			Battle.game = true;
		}
		return Battle.game;
	}

	static void battleGetReward(Monster target) {
		Character.exp += target.exp;
		Util.prl("<시스템> 경험치를 얻었습니다.(" + target.exp + ")");
	}

}
