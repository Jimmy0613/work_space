function Character(name, hp, maxhp, attack, exp, maxexp, coin) {
    this.name = name;
    this.hp = hp;
    this.maxhp = maxhp;
    this.attack = attack;
    this.exp = exp;
    this.maxexp = maxexp;
    this.coin = coin;
    this.info = function () {
        dw("[🧙‍♂️" + this.name + "(" + this.hp + "/" + this.maxhp + ")](경험치: " + this.exp + "/" + this.maxexp + ", 보유 코인: " + this.coin + ")");

    }
}
function Monster(name, hp, maxhp, attack, exp, coin) {
    this.name = name;
    this.hp = hp;
    this.maxhp = maxhp;
    this.attack = attack;
    this.exp = exp; //몬스터 처치 시 얻는 경험치
    this.coin=coin; //몬스터 처치 시 얻는 랜덤 코인에 곱해줄 코인 상수
    this.info = function () {
        dw("[" + this.name + "(" + this.hp + "/" + this.maxhp + ")]");

    }
}

