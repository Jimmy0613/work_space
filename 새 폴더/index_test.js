
var tSystem;
var tObject;
var tPlayerInfo;
var tPlayerExp;
var tPlayerBag;
var mode;
var strSystem = "";
var strPlayerInfo = "";
var strPlayerExp = "";
var strPlayerBag = "";

window.onload = function () {

    tSystem = document.getElementById("system");
    tObject = document.getElementById("object");
    tPlayerInfo = document.getElementById("info");
    tPlayerExp = document.getElementById("exp");
    tPlayerBag = document.getElementById("bag");
    input_turn = document.getElementById("input_turn");
    input_turn.value = turnCount;



    mode = "대기";
    currentRoomId = 1000;
    hr();
    tvPlayerInfo("[PLAYER]");
    displayPlayerExp();
    Jimmy.info();
    getCurrentRoom().displayRoomInfo();


}


