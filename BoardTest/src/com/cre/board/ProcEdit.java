package com.cre.board;

import com.cre.board.data.Data;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcEdit {

	public static void run() {
		ProcList.run();
		Cw.wn("수정할 글의 번호를 입력하세요.");
		String input = Ci.r();
		int index = -1;
		for(int i = 0; i<Data.postArray.size(); i++) {
			if (input.equals(Data.postArray.get(i).num + "")){
				index = i;
				break;
			}
		}
		if(index != -1) {
			editPost(index);
		} else {
			Cw.wn("없는 번호입니다.");
			return;
		}
	}

	public static void editPost(int index) {
		String title = "";
		String content = "";
		Cw.wn("작성자: " + Data.postArray.get(index).writer + "(수정불가)");
		Cw.wn("제목: " + Data.postArray.get(index).title);
		Cw.wn("바꿀 제목: (수정이 필요없으면 Enter만 입력하세요.)");
		String input = Ci.r();
		title = input;
		
		Cw.wn("내용: " + Data.postArray.get(index).content);
		Cw.wn("바꿀 내용: (수정이 필요없으면 Enter만 입력하세요.)");
		input = Ci.r();
		content = input;
		
		if(title != "") {
			Data.postArray.get(index).title = title;
		}
		if(content != "") {
			Data.postArray.get(index).content = content;
		}
		Cw.wn("수정되었어요.");
		return;

		}
	}

