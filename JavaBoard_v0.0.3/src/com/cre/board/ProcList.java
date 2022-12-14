package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcList {
	static boolean ox = true;
	static String pw = "";
	static int postNum = -1;
	static String num = "";
	static String input;

	public static void run() {

		// 목록 보여줌
		while (true) {
			getList();
			if (input.equals("x")) {
				return;
			}
			// 선택한 글 보여줌
			post: while (true) {
				if (input.equals("x")) {
					break post;
				}
				getPost();
				// 하단 메뉴 구동
				next: while (true) {
					if (input.equals("x")) {
						break post;
					}
					input = Ci.r();
					nextInput();
					break next;
				}
			}
		}
	}

	public static void getList() {

		Disp.menuPrint(" [ 목록 ] 조회하려면 글 번호를 입력하세요. (x:이전으로)");
		Cw.dot();
		Cw.wn(Cw.sf(" 번호 ", 4) + Cw.sf("| 작성자 ", 8) + Cw.sf("| 작성일 ", 12) + "|  제목");
		Cw.lineBar();
		if (Data.postArray.size() == 0) {
			Cw.wn("아직 글이 없습니다. 처음으로 돌아갈게요.");
			input = "x";
			return;
		} else {
			for (Post p : Data.postArray) {
				p.postInfoList();
			}
		}
		input = Ci.r();
	}

	public static void getPost() {
		if (input.equals("x"))
			return;
		for (Post p : Data.postArray) {
			String n = p.num + "";
			if (n.equals(input)) {
				if (p.open == false) {
					Cw.wn("비공개 글입니다. 암호를 입력하세요.");
					input = Ci.r();
					if (!input.equals(p.pw)) {
						Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
						input = "x";
						return;
					}
					ox = false;
					pw = p.pw;
				}
				num = input;
				postNum = p.num;
				p.postInfo();
				input = "";
			}
		}
		if (num.equals("")) {
			Cw.wn("없는 번호입니다.");
			input = "x";
			return;
		}
	}

	// [ 이전글:1 | 목록:2 | 다음글:3 ] [수정:4][삭제:5]
	public static void nextInput() {
		switch (input) {
		case "1":
			int prePost = -1;
			for (int i = postNum - 1; i > 0; i--) {
				for (Post p : Data.postArray) {
					if (p.num == i) {
						prePost = i;
					}
				}
				if (prePost != -1)
					break;
			}
			if (prePost == -1) {
				Cw.wn("이전글이 없습니다. 목록으로 돌아갑니다.");
				input = "x";
				return;
			} else {
				input = prePost + "";
			}
			return;
		case "2":
			input = "x";
			return;
		case "3":
			int nextPost = -1;
			for (int i = postNum + 1; i <= Post.listNum; i++) {
				for (Post p : Data.postArray) {
					if (p.num == i) {
						nextPost = i;
					}
				}
				if (nextPost != -1)
					break;
			}
			if (nextPost == -1) {
				Cw.wn("다음글이 없습니다. 목록으로 돌아갑니다.");
				input = "x";
				return;
			} else {
				input = nextPost + "";
			}
			return;
		case "4":
			editPost(postNum);
			return;
		case "5":
			Cw.wn("정말 삭제하시겠어요? (o:삭제 x:취소)");
			input = Ci.r();
			switch (input) {
			case "o":
				delPost(postNum);
				break;
			default:
				Cw.wn("목록으로 돌아갑니다.");
			}
			input = "x";
			return;
		default:
			return;
		}

	}

	public static void delPost(int postNum) {
		int index = -1;
		for (int i = 0; i < Data.postArray.size(); i++) {
			if (Data.postArray.get(i).num == postNum) {
				index = i;
			}
		}
		if (index != -1) {
			if (Data.postArray.get(index).open == false) {
				Cw.wn("비공개 글입니다. 암호를 입력하세요.");
				input = Ci.r();
				if (!input.equals(Data.postArray.get(index).pw)) {
					Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
					return;
				}
			}
			Data.postArray.remove(index);
			Cw.wn("삭제되었습니다.");
		}
		return;
	}

	public static void editPost(int postNum) {
		String title = "";
		String content = "";
		boolean ox = true;

		Disp.menuPrint("[ 수정하기 ]");
		Cw.wn("*변동사항이 없을시 그냥 Enter만 입력*");
		title: while (true) {
			title = Ci.rl("제목(0~50자)");
			if (title.length() < 1) {
				break title;
			} else if (title.length() > 50) {
				Cw.wn("글자 수가 초과되었습니다.");
			} else
				break title;
		}
		content: while (true) {
			content = Ci.rl("내용");
			if (content.length() < 1) {
				break content;
			} else
				break content;
		}
		for (Post p : Data.postArray) {
			if (p.num == postNum) {
				if (title.length() == 0) {
					title = p.title;
				}
				if (content.length() == 0) {
					content = p.content;
				}
				Cw.dot();
				Cw.wn("제목:" + title);
				Cw.wn(content);
				Cw.w("이대로 수정할까요? o:적용 x:취소");
				while (true) {
					input = Ci.r();
					switch (input) {
					case "o":
						if (p.open == false) {
							Cw.wn("비공개 글입니다. 공개로 전환할까요? o:네 x:아니요");
							input = Ci.r();
							if (input.equals("x")) {
								ox = false;
								title = title + " 🔒";
							}
							Cw.wn("비공개 글입니다. 수정하시려면 암호를 입력하세요.");
							input = Ci.r();
							if (!input.equals(p.pw)) {
								Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
								input = "x";
								return;
							}
						}
						p.title = title;
						p.content = content;
						p.open = ox;
						Cw.wn("수정했습니다.");
						input = postNum + "";
						return;
					case "x":
						return;
					default:
						break;
					}
				}
			}
		}

	}

}
