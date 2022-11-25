function getRandomAttackValue(attack) {
    var random = Math.floor(Math.random() * attack) + 1;
    return random;
}

function battleOneByOne (target){
    var monsterDamage = getRandomAttackValue(target.attack);
    Jimmy.hp = Jimmy.hp - monsterDamage;
        tvSystem(target.name + "가" + Jimmy.name + "에게 데미지를 " + monsterDamage + "만큼 입혔습니다.");
    var playerDamage = getRandomAttackValue(Jimmy.attack);
    target.hp = target.hp - playerDamage;
    br();
    tvSystem(Jimmy.name + "가" + target.name + "에게 데미지를 " + playerDamage + "만큼 입혔습니다.");
    displayRoomMonstersInfo();
    displayCharacterInfo();
    hr();
    turn();

    if(target.hp<=0){
        getReward(target);
        monsterDeleteFromMonsterArray(target);
        displayRoomMonstersInfo();
        return;
    }
}

function turnBattle() {
        var hostileMonsters = getRoomMonstersHostile();
        var target = hostileMonsters[0];
        battleOneByOne(target);

    if(Jimmy.hp <=0){
        tvSystem("죽었습니다.");
        br();
        tvSystem("[GAME OVER]");
        hr();
        tvObject("[GAME OVER]");
        tvPlayer("[GAME OVER]");
        mode = "사망";
    }

    hostileMonsters = getRoomMonstersHostile();
    if(hostileMonsters.length==0){
        battleEnd();
        return;
    }
    return;
}

function battleEnd() {
    tvSystem("전투 종료");
    hr();
    mode = "대기";
}

function monsterDeleteFromMonsterArray(dieMonster) {
    var findI = -1;
    for(var i=0;i<monsterArray.length;i++){
        if(monsterArray[i].id == dieMonster.id){
            findI = i;
        }
    }
    if(findI != -1){
        monsterArray.splice(findI,1);
    }
}

function getReward(dieMonster){
    Jimmy.exp = Jimmy.exp + dieMonster.exp;
    displayPlayerExp();
    levelUp();

    tvSystem(dieMonster.name + "를 처치했습니다. 경험치를 " + dieMonster.exp + "만큼 얻었습니다.");
    hr();
    var randomCoin = Math.floor(Math.random()*dieMonster.coin) + 1;
    Jimmy.coin = Jimmy.coin + randomCoin;
    tvSystem("코인을 " + randomCoin + "만큼 얻었습니다.");
    hr();
    return;
}

function objectClick(objectId){
    if(mode == "전투") {
        console.log("이미 전투 상태입니다.");
        return;
    }

    console.log("클릭한 오브젝트 ID:"+ objectId);
    mode = "전투";

    for(var i=0;i<monsterArray.length; i++){
        if(monsterArray[i].id == objectId){
            monsterArray[i].aggressionType = "H";
        }
    }
    displayRoomMonstersInfo();
    turn();
}