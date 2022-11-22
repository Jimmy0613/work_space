var player = new Array(6);
var random = new Array(6);

for (var i = 0; i<=5; i++){
    while(true){
    player[i]=prompt((i+1)+"번째 숫자를 입력하세요.(1~45, 중복 금지)");
    if (player[i]>45 || player[i]<1) {
        alert("1부터 45까지만 입력 가능합니다.");
    } else break;
    }
}
for (var i = 0; i <= 5; i++) {
    random[i] = Math.floor(Math.random() * 45) + 1;
    if (i > 0) {
        if (i <= 1) {
            while (true) {
                if (random[i] == random[i - 1]) {
                    random[i] = Math.floor(Math.random() * 45) + 1;
                } else break;
            }
        } else if (i <= 2) {
            while (true) {
                if (random[i] == random[i - 1] || random[i] == random[i - 2]) {
                    random[i] = Math.floor(Math.random() * 45) + 1;
                } else break;
            }
        } else if (i <= 3) {
            while (true) {
                if (random[i] == random[i - 1] || random[i] == random[i - 2] || random[i] == random[i - 3]) {
                    random[i] = Math.floor(Math.random() * 45) + 1;
                } else break;
            }
        } else if (i <= 4) {
            while (true) {
                if (random[i] == random[i - 1] || random[i] == random[i - 2] || random[i] == random[i - 3] || random[i] == random[i - 4]) {
                    random[i] = Math.floor(Math.random() * 45) + 1;
                } else break;
            }
        } else {
            while (true) {
                if (random[i] == random[i - 1] || random[i] == random[i - 2] || random[i] == random[i - 3] || random[i] == random[i - 4] || random[i] == random[i - 5]) {
                    random[i] = Math.floor(Math.random() * 45) + 1;
                } else break;
            }
        }
    }
}

var bonus = Math.floor(Math.random() * 45) + 1;
while (true) {
    if (bonus == random[0] || bonus == random[1] || bonus == random[2] || bonus == random[3] || bonus == random[4] || bonus == random[5]) {
        bonus = Math.floor(Math.random() * 45) + 1;
    } else break;
}


var cnt = 0;

for (var i = 0; i <= 5; i++) {
    for (var j = 0; j <= 5; j++) {
        if (player[i] == random[j]) {
            cnt++;
        }
    }
}


document.write("내 숫자:");
for (var i = 0; i <= 5; i++) {
    document.write(" " + player[i]);
}
document.write("<br>당첨 숫자:");
for (var i = 0; i <= 5; i++) {
    document.write(" " + random[i]);
}
document.write("<br>보너스 숫자:" + bonus);
document.write("<br>")



switch (cnt) {
    case 0:
    case 1:
    case 2:
        document.write("꽝입니다.");
        break;
    case 3:
        document.write("5등입니다.");
        break;
    case 4:
        document.write("4등입니다.");
        break;
    case 5:
        if (bonus == player[0] || bonus == player[1] || bonus == player[2] || bonus == player[3] || bonus == player[4] || bonus == player[5]) {
            document.write("2등입니다");
        } else document.write("3등입니다.");
        break;
    case 6:
        document.write("1등입니다.");
}
