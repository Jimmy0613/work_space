package com.cre.board;

import com.cre.board.data.Data;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcDel {
	public static void run(int postNum) {
		int index = -1;
		for (int i = 0; i < Data.postArray.size(); i++) {
			if (Data.postArray.get(i).num == postNum) {
				index = i;
			}
		}
		if (index != -1) {
			if (Data.postArray.get(index).open == false) {
				Cw.wn("비공개 글입니다. 삭제하시려면 암호를 입력하세요.");
				ProcMenu.input = Ci.r();
				if (!ProcMenu.input.equals(Data.postArray.get(index).pw)) {
					Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
					return;
				}
			}
			Data.postArray.remove(index);
			Cw.wn("삭제되었습니다.");
		}
		return;
	}

}
