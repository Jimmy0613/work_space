function getCurrentRoom() {
        for (var i = 0; i < roomArray.length; i++) {
            if (roomArray[i].rId == currentRoomId) {
                return roomArray[i];
            }
        }
}

function getRoomMonsters(){
    var roomMonsters = new Array();
    for(var i=0; i<monsterArray.length; i++){
        if(monsterArray[i].location == currentRoomId){
            roomMonsters.push(monsterArray[i]);
        }
    }
    return roomMonsters;
}

function getRoomMonstersHostile() {
    var roomMonstersHostile = new Array();
    for(var i=0; i<monsterArray.length;i++){
        if(monsterArray[i].location==currentRoomId && monsterArray[i].aggressionType=="H"){
            roomMonstersHostile.push(monsterArray[i]);
        }
    }
    return roomMonstersHostile;
}

function roomCheckHostile(){
    var roomMonsters = getRoomMonsters();
    for(var i=0;i<roomMonsters.length;i++){
        if(roomMonsters[i].aggressionType == "H"){
            console.log("적대적인 몬스터가 있음");
            mode = "전투";
        }
    }
}

