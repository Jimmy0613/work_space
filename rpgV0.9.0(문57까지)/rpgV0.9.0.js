var str = "";
var orc;
var elf;
var t;

window.onload = function () {
    t = document.getElementById("a");

    orc = new Monster("오크", 100, 100, 10, 100, 1);
    elf = new Character("엘프", 200, 200, 20, 0, 300, 0);

    hr();
    orc.info();
    dw("vs");
    elf.info();

    hr();
    dw("<전투 시작>");
    fight();
    orc.info();
    dw("vs");
    elf.info();
    hr();
    dw("<전투 종료>");
    hr();

    if (elf.hp > 0) {
        elf.exp = elf.exp + orc.exp;
        elf.coin = elf.coin + (r(10) + 20) * orc.coin;
        dw(elf.name + "가 " + orc.name + "를 처치했습니다.");
        br();
        dw("경험치를 " + orc.exp + "만큼 획득했습니다.")
        br();
        dw("코인을 " + (r(10) + 20) * orc.coin + "만큼 얻었습니다.");
        hr();
        elf.info();
    } else {
        dw("엘프가 전투에서 패배했습니다.");
    }
    hr();
}

function fight() {
    while (true) {
        hr();
        var orcDamage = r(orc.attack);
        var elfDamage = r(elf.attack);
        orc.hp = orc.hp - elfDamage;
        elf.hp = elf.hp - orcDamage;
        dw("오크가 엘프에게 데미지를 " + orcDamage + "만큼 입혔습니다.");
        br();

        dw("엘프가 오크에게 데미지를 " + elfDamage + "만큼 입혔습니다.");
        br();

        if (orc.hp <= 0 || elf.hp <= 0) break;
        orc.info();
        dw("vs");
        elf.info();
    }
    if (orc.hp <= 0) {
        orc.hp = 0;
    }
    if (elf.hp < 0) elf.hp = 0;

}
