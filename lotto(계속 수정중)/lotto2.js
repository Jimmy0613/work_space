var player = new Array(6);
var com = new Array(6);
var same = 0;
var bonus;

player = [1, 2, 3, 4, 5, 6]

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
    if (com[4] != com[0] && com[4] != com[1] && com[4] != com[2] && com[4]!=com[3]) {
        break;
    }
}
while (true) {
     com[5] = Math.floor(Math.random() * 45) + 1;
    if (com[5] != com[0] && com[5] != com[1] && com[5] != com[2] && com[5]!=com[3] && com[5]!=com[4]) {
        break;
    }
}

while (true) {
     bonus = Math.floor(Math.random() * 45) + 1;
    if (bonus != com[0] && bonus != com[1] && bonus != com[2] && bonus!=com[3] && bonus!=com[4] && bonus!=com[5]) {
        break;
    }
}

document.write("내 숫자: ");


for(var i=0; i<player.length; i++){
    document.write(player[i] + " ");
}
document.write("<br>");

document.write("당첨 숫자: ");

for(var i=0; i<com.length; i++){
    document.write(com[i] + " ");
}
document.write("<br>");


for(var i=0;i<player.length; i++){
    for(var j=0;j<com.length; j++){
        if(player[i]==com[j])
            same += 1 ;
    }
}

document.write("일치하는 수: " + same + "개");
document.write("<br>");

document.write("보너스 숫자: " + bonus);

document.write("<br>");

switch(same){
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
    for(var i=0; i<player.length; i++){
        if(player[i] == bonus){
        document.write("2등입니다.");
        return;
        }
    }
    document.write("3등입니다.");
}