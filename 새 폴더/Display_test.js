function tSystemScroll(){
    tSystem.scrollTop = tSystem.scrollHeight;
}
function br(){
    strSystem = strSystem + "\n";
    tSystem.value = strSystem;
}

function hr(){
    strSystem = strSystem + "\n===========================================================================\n";
    tSystem.value = strSystem;
}


function tvSystem(s){
    strSystem = strSystem + s;
    tSystem.value = strSystem;
    tSystemScroll();
}

function tSystemClear(){
    tSystem.value = "";
}



function tvPlayerInfo(s){
    strPlayerInfo = s;
    tPlayerInfo.value = "[PLAYER]" + s;
}

function displayPlayerExp(){
    strPlayerExp = "EXP [" + Jimmy.exp + "/" + Jimmy.requiredExp + "]";
    tPlayerExp.value = strPlayerExp;
}

function tPlayerInfoClear(){
    tPlayerInfo.value = "";
}


function displayRoomInfo() {
    getCurrentRoom().displayRoomInfo();
    displayRoomMonstersInfo();
    displayCharacterInfo();
}

function displayCharacterInfo() {
    Jimmy.info();
}

function displayRoomMonstersInfo(){
    var roomMonsters = getRoomMonsters();
    var monsterStr = "";

    for(var i=0;i<roomMonsters.length;i++){
        console.log(roomMonsters[i].name);
    
    if(roomMonsters[i].aggressionType == "H"){
        monsterStr = monsterStr + "<span class='monstersHostile' id='" + roomMonsters[i].id + "' onclick='objectClick(this.id)'" + ">" + roomMonsters[i].getInfo() + "</span>";
    } else if (roomMonsters[i].aggressionType == "N"){
        monsterStr = monsterStr + "<span class='monsterNone' id='" + roomMonsters[i].id + "' onclick='objectClick(this.id)'" + ">" + roomMonsters[i].getInfo() + "</span>";
    }
    }
    tObject.innerHTML = monsterStr;
}
