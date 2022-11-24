var player = new Array(6);
var com = new Array(6);
var same = 0;
var bonus;

//중복 숫자와 1~45 범위가 아닌 숫자는 거르기가 가능해짐. but 숫자가 아닌 걸 입력한 것은 아직 못 거름.

for (var i = 0; i < player.length; i++) {
    while (true) {
        player[i] = prompt((i + 1) + "번째 숫자를 입력하세요.(1~45, 중복 금지)");
        if (1>player[i] || player[i]>45) {
            alert("1부터 45까지의 숫자만 입력 가능합니다.");
        } else if (i==0){
            break;
        } else if (i==1){
            if (player[0] == player[1]){
                alert("중복된 숫자가 있습니다. 다시 입력하세요.");
            } else break;
        } else if (i==2){
            if (player[0] == player[1] || player[0] == player[2] || player[1] == player[2]){
                alert("중복된 숫자가 있습니다. 다시 입력하세요.");
            } else break;
        } else if (i==3){
            if (player[0] == player[1] || player[0] == player[2] || player[0] == player[3] || player[1] == player[2] || player[1] == player[3] || player[2] == player[3]){
                alert("중복된 숫자가 있습니다. 다시 입력하세요.");
            } else break;
        } else if (i==4){
            if (player[0] == player[1] || player[0] == player[2] || player[0] == player[3] || player[0] == player[4] || player[1] == player[2] || player[1] == player[3] || player[1] == player[4] || player[2] == player[3] || player[2] == player[4] || player[3] == player[4]){
                alert("중복된 숫자가 있습니다. 다시 입력하세요.");
            } else break;
        } else if (i==5){
            if (player[0] == player[1] || player[0] == player[2] || player[0] == player[3] || player[0] == player[4] || player[0] == player[5] || player[1] == player[2] || player[1] == player[3] || player[1] == player[4] || player[1] == player[5] || player[2] == player[3] || player[2] == player[4] || player[2] == player[5] || player[3] == player[4] || player[3] == player[5] || player[4] == player[5]) {
                alert("중복된 숫자가 있습니다. 처음부터 다시 입력하세요.");
            } else break;
        }
    }
}


com[0] = Math.floor(Math.random() * 45) + 1;
while (true) {
    com[1] = Math.floor(Math.random() * 45) + 1;
    if (com[1] != com[0]) {
        break;
    }
}
while (true) {
    com[2] = Math.floor(Math.random() * 45) + 1;
    if (com[2] != com[0] && com[2] != com[1]) {
        break;
    }
}
while (true) {
    com[3] = Math.floor(Math.random() * 45) + 1;
    if (com[3] != com[0] && com[3] != com[1] && com[3] != com[2]) {
        break;
    }
}
while (true) {
    com[4] = Math.floor(Math.random() * 45) + 1;
    if (com[4] != com[0] && com[4] != com[1] && com[4] != com[2] && com[4] != com[3]) {
        break;
    }
}
while (true) {
    com[5] = Math.floor(Math.random() * 45) + 1;
    if (com[5] != com[0] && com[5] != com[1] && com[5] != com[2] && com[5] != com[3] && com[5] != com[4]) {
        break;
    }
}

while (true) {
    bonus = Math.floor(Math.random() * 45) + 1;
    if (bonus != com[0] && bonus != com[1] && bonus != com[2] && bonus != com[3] && bonus != com[4] && bonus != com[5]) {
        break;
    }
}

document.write("내 숫자: ");


for (var i = 0; i < player.length; i++) {
    document.write(player[i] + " ");
}
document.write("<br>");

document.write("당첨 숫자: ");

for (var i = 0; i < com.length; i++) {
    document.write(com[i] + " ");
}
document.write("<br>");


for (var i = 0; i < player.length; i++) {
    for (var j = 0; j < com.length; j++) {
        if (player[i] == com[j])
            same += 1;
    }
}

document.write("일치하는 수: " + same + "개");
document.write("<br>");

document.write("보너스 숫자: " + bonus);

document.write("<br>");

switch (same) {
    case 3:
        document.write("5등입니다.");
        document.write("<br>");
        break;
    case 4:
        document.write("4등입니다.");
        document.write("<br>");
        break;
    case 5:
        bonus_check();
        break;
    case 6:
        document.write("1등입니다.");
        document.write("<br>");
        break;
    default:
        document.write("꽝입니다.");
        document.write("<br>");
}

function bonus_check() {
    for (var i = 0; i < player.length; i++) {
        if (player[i] == bonus) {
            document.write("2등입니다.");
            return;
        }
    }
    document.write("3등입니다.");
}
