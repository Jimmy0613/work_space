function move(direction) {
    if(mode == "사망"){
        return;
    }
    currentRoom = getCurrentRoom();
    var connectionRoomID = currentRoom.getIdByDirection(direction);
    if(connectionRoomID == 0) {
        tvSystem("그곳으로는 갈 수 없습니다.")
        hr();
        return;
    } else {
        currentRoomId = connectionRoomID;
        console.log("현재 방번호:" + currentRoomId);
    }

    if(mode == "전투"){
        tvSystem("몬스터로부터 도망칩니다.")
        hr();
        mode = "대기";
    }

    switch (direction) {
        case "동":
            tvSystem("동쪽으로 이동했습니다.");
            hr();
            break;
        case "서":
            tvSystem("서쪽으로 이동했습니다.");
            hr();
            break;
        case "남":
            tvSystem("남쪽으로 이동했습니다.");
            hr();
            break;
        case "북":
            tvSystem("북쪽으로 이동했습니다.");
            hr();
            break;
        case "위":
            tvSystem("위쪽으로 올라왔습니다.");
            hr();
            break;
        case "아래":
            tvSystem("아래쪽으로 내려왔습니다.");
            hr();
            break;
    }

    displayRoomInfo();
    roomCheckHostile();
    turn();
}