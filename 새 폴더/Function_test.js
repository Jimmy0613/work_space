var turnCount = 1;
var input_turn;

function turn() {
    turnCount = turnCount + 1;
    input_turn.value = turnCount;
}

function r(n) {
    var random = Math.floor(Math.random() * n) + 1;
    return random;
}

function turnNormal() {
    turn();
    tvSystem("특별한 것은 보이지 않는다.")
    hr();
    console.log("현재 턴: " + turnCount);
    input_turn.value = turnCount;
}



var mode;


function go() {
    if (mode == "대기") {
        turnNormal();
    } else if (mode == "전투") {
        turnBattle();
    } else if (mode =="사망") {
        tvSystem("죽었습니다. 다시 시작하시려면 새로고침하세요.\n")
        tvPlayerInfo("[GAME OVER]");
    }
}
