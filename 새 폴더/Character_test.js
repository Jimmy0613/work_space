function Character(name, hp, attack) {
    this.name = name;
    this.hp = hp;
    this.maxhp = hp;
    this.attack = attack;
    this.exp = 0;
    this.level = 1;
    this.coin = 0;
    this.info = function () {
        tvPlayerInfo("[" + this.name + "<lv:" + this.level + "> (" + this.hp + "/" + this.maxhp + ")]");
    }
    this.getRequiredExpForLevelUp = function(){
        return this.level * 100;
    }
    this.requiredExp = this.getRequiredExpForLevelUp();
}

var Jimmy = new Character("π©βπΎμ§λ―Έ", 200, 50);

function levelUp(){
    if(Jimmy.exp>=Jimmy.requiredExp){
        var overExp = Jimmy.exp - Jimmy.requiredExp;
        Jimmy.level ++;
        tvSystem("[λ λ²¨μ΄ μ¬λμ΅λλ€.]");
        hr();

        Jimmy.exp = overExp;
        Jimmy.requiredExp = Jimmy.getRequiredExpForLevelUp();
        Jimmy.maxhp += 50;
        Jimmy.hp = Jimmy.maxhp;
        Jimmy.attack += 5;
        displayPlayerExp();
        displayCharacterInfo();
    }
}