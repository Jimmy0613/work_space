package com.cre.board;

import com.cre.board.data.Data;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcDel {
	public static void run() {
		ProcList.run();
		Cw.wn("삭제할 글의 번호를 입력하세요.");
		String input = Ci.r();
		int index = -1;
		for(int i = 0; i<Data.postArray.size(); i++) {
			if (input.equals(Data.postArray.get(i).num + "")){
				index = i;
				break;
			}
		}
		if(index != -1) {
			Data.postArray.remove(index);
			Cw.wn("삭제되었습니다.");
		} else {
			Cw.wn("없는 번호입니다.");
			return;
		}
	}
}
