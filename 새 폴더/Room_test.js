var roomArray = new Array();

function Room(rName, rId, rDesc, e, w, s, n, u, d) {
    this.rName = rName;
    this.rDesc = rDesc;
    this.rId = rId;
    this.e = e;
    this.w = w;
    this.s = s;
    this.n = n;
    this.u = u;
    this.d = d;

    this.displayRoomInfo = function() {
        tvSystem("[" + this.rName + "] " + this.rDesc + "\n");
        tvSystem(this.roomEnter());
        hr();
    }

    this.roomEnter = function(){
        var enters="출구: [";
        if(e != 0){
            enters = enters + " 동쪽";
        }
        if(w != 0){
            enters = enters + " 서쪽";
        }
        if(s != 0){
            enters = enters + " 남쪽";
        }
        if(n != 0){
            enters = enters + " 북쪽";
        }
        if(u != 0){
            enters = enters + " 올라가기";
        }
        if(d != 0){
            enters = enters + " 내려가기";
        }
        enters = enters + " ]";
        return enters;
    }

    this.getIdByDirection = function(direction){
        switch(direction){
            case "동":
                return e;
                break;
            case "서":
                return w;
                break;
            case "남":
                return s;
                break;
            case "북":
                return n;
                break;
            case "위":
                return u;
                break;
            case "아래":
                return d;
                break;
        }
    }


}



var entrance = new Room("입구", 1000, "아무것도 없는 곳이다. 동쪽으로 가볼까?", 1001, 0, 0, 0, 0, 0);
var trainingRoom = new Room("연습장 서쪽", 1001, "연습장 서쪽이다.", 1002, 1000, 0, 0, 0, 0);
var trainingRoomWest = new Room("연습장", 1002, "연습장이다.", 1003, 1001, 1004, 1005, 1006, 1007);
var trainingRoomEast = new Room("연습장 동쪽", 1003, "연습장 동쪽이다.", 0, 1002, 0, 0, 0, 0);
var trainingRoomSouth = new Room("연습장 남쪽", 1004, "연습장 남쪽이다.", 0, 0, 0, 1002, 0, 0);
var trainingRoomNorth = new Room("연습장 북쪽", 1005, "연습장 북쪽이다.", 0, 0, 1002, 0, 0, 0);
var trainingRoomRoof = new Room("연습장 옥상", 1006, "바람 쐬기 좋은 옥상이다.", 0, 0, 0, 0, 0, 1002);
var trainingRoomUnderground = new Room("연습장 지하", 1007, "어딘가 으스스한 곳이다.", 0, 0, 0, 0, 1002, 0);


roomArray[0] = entrance;

roomArray[1] = trainingRoom;
trainingRoom.monsterGen = 2;

roomArray[2] = trainingRoomWest;
trainingRoomWest.monsterGen = 4;

roomArray[3] = trainingRoomEast;

roomArray[4] = trainingRoomSouth;

roomArray[5] = trainingRoomNorth;
trainingRoomNorth.monsterGen = 1;

roomArray[6] = trainingRoomRoof;

roomArray[7] = trainingRoomUnderground;
trainingRoomUnderground.monsterGen = 1;



var currentRoomId = 0;
function getCurrentRoom() {
    for (var i = 0; i < roomArray.length; i++) {
        if (roomArray[i].rId == currentRoomId) {
            return roomArray[i];
        }
    }
}

