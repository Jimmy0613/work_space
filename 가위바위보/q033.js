var rpsInput;
var rpsResult;
var resultStr = "";
var player;
var divComphoto;
var divPlayerphoto;

window.onload = function() {
    rpsInput = document.getElementById("rps_input");
    rpsResult = document.getElementById("rps_result");

    divComphoto = document.getElementById("div_comphoto");
    divPlayerphoto = document.getElementById("div_playerphoto");
}

function buttonClick() {

    resultStr = "";
    rpsResult.value = resultStr;


    while (true) {
            player = rpsInput.value;
        if (player=="가위" || player=="바위" || player=="보") {
            break;
        } else {
            alert("가위나 바위나 보를 쓰세요~~~~");
        }
    }

    resultStr += "나: " + rpsInput.value;
    resultStr += "\n";

    var com = Math.floor(Math.random() * 3) + 1;

    switch (com) {
        case 1:
            com = "가위";
            divComphoto.innerHTML = "<img src='s.png'>";
            break;

        case 2:
            com = "바위";
            divComphoto.innerHTML = "<img src='r.png'>";
            break;

        default:
            com = "보";
            divComphoto.innerHTML = "<img src='p.png'>";
    }

    resultStr += "컴퓨터: " + com;
    resultStr += "\n";


    if (player == com) {
        resultStr += "결과: 무승부~";

    } else if (player == "가위") {
        divPlayerphoto.innerHTML = "<img src=s.png>";
        if (com == "바위") {
            resultStr += "결과: 패배ㅠㅡㅠ";
        } else {
            resultStr += "결과: 승리 >_<";
        }
    } else if (player == "바위") {
        divPlayerphoto.innerHTML = "<img src=r.png>";
        if (com == "보") {
            resultStr += "결과: 패배ㅠㅡㅠ";
        } else {
            resultStr += "결과: 승리 >_<";
        }
    } else if (player == "보") {
        divPlayerphoto.innerHTML = "<img src=p.png>";
        if (com == "가위") {
            resultStr += "결과: 패배ㅠㅡㅠ";
        } else {
            resultStr += "결과: 승리 >_<";
        }
    }

    resultStr += "\n";

    rpsResult.value = resultStr;

    
}