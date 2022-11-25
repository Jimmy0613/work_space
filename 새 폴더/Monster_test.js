function Monster(name, id, hp, attack, location, aggressionType, c) {
    this.name = name;
    this.id = id;
    this.hp = hp;
    this.maxhp = hp;
    this.attack = attack;
    this.exp = 20; //몬스터 처치 시 얻는 경험치
    this.coin = c; //몬스터 처치 시 얻는 랜덤 코인에 더해줄 코인 상수
    this.location = location;
    this.aggressionType = aggressionType;
    this.getInfo = function () {
        return "[" + this.name + "(" + this.hp + "/" + this.maxhp + ")]";
    }
}
var monsterArray = new Array();

var orc = new Monster("🧟‍♂️오크", 300, 70, 20, 1005, "H", 20);
var scarecrow1 = new Monster("🕴허수아비", 101, 50, 1, 1001, "N", 1);
var scarecrow2 = new Monster("🕴허수아비", 102, 50, 1, 1001, "N", 1);
var rat1 = new Monster("🐀쥐", 201, 100, 10, 1002, "H", 10);
var rat2 = new Monster("🐀쥐", 202, 100, 10, 1002, "H", 10);
var rat3 = new Monster("🐀쥐", 203, 100, 10, 1002, "H", 10);
var rat4 = new Monster("🐀쥐", 204, 100, 10, 1002, "H", 10);
var ratKing = new Monster("🐭왕쥐", 210, 100, 30, 1007, "H", 30);

monsterArray[0] = scarecrow1;
monsterArray[1] = scarecrow2;
monsterArray[2] = rat1;
monsterArray[3] = rat2;
monsterArray[4] = rat3;
monsterArray[5] = rat4;
monsterArray[6] = orc;
monsterArray[7] = ratKing;
