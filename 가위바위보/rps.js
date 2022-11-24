var com_result;
var player_result;
var game_result;
var com;

var str_result;
var img_result_com;
var img_result_player;
window.onload = function(){
    com_result = document.getElementById("com");
    player_result = document.getElementById("player");
    game_result = document.getElementById("result");
    img_result_com = document.getElementById("com_img")
    img_result_player = document.getElementById("player_img")
}

function input_sc() {
    com = Math.floor(Math.random()*3)+1;
    img_result_player.innerHTML = "<img src='player_sc.png'>";

    switch (com) {
        case 1:
            game_result.innerHTML = "당신의 승리!";
            img_result_com.innerHTML = "<img src='com_pa.png'>";
            break;

        case 2:
            game_result.innerHTML = "컴퓨터의 승리!";
            img_result_com.innerHTML = "<img src='com_ro.png'>";
            break;

        case 3:
            game_result.innerHTML = "무승부!";
            img_result_com.innerHTML = "<img src='com_sc.png'>";
    }
}

function input_ro() {
    com = Math.floor(Math.random()*3)+1;
    img_result_player.innerHTML = "<img src='player_ro.png'>";

    switch (com) {
        case 1:
            game_result.innerHTML = "당신의 승리!";
            img_result_com.innerHTML = "<img src='com_sc.png'>";
            break;

        case 2:
            game_result.innerHTML = "컴퓨터의 승리!";
            img_result_com.innerHTML = "<img src='com_pa.png'>";
            break;

        case 3:
            game_result.innerHTML = "무승부!";
            img_result_com.innerHTML = "<img src='com_ro.png'>";
    }
}

function input_pa() {
    com = Math.floor(Math.random()*3)+1;
    img_result_player.innerHTML = "<img src='player_pa.png'>";

    switch (com) {
        case 1:
            game_result.innerHTML = "당신의 승리!";
            img_result_com.innerHTML = "<img src='com_ro.png'>";
            break;

        case 2:
            game_result.innerHTML = "컴퓨터의 승리!";
            img_result_com.innerHTML = "<img src='com_sc.png'>";
            break;

        case 3:
            game_result.innerHTML = "무승부!";
            img_result_com.innerHTML = "<img src='com_pa.png'>";
    }
}