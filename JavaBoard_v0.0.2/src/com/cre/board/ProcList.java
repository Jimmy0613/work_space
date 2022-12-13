package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcList {
	public static void run() {
		String input;
		String n;
		int postNum = 0;
		boolean ox = true;
		String pw = "";
		list: while (true) {
			Disp.menuPrint(" [ 목록 ] 조회하려면 글 번호를 입력하세요. (x:이전으로)");
			Cw.dot();
			Cw.wn(Cw.sf(" 번호 ", 4) + Cw.sf("| 작성자 ", 8) + Cw.sf("| 작성일 ", 12) + "|  제목");
			Cw.wn();
			if (Data.postArray.size() == 0) {
				Cw.wn("아직 글이 없습니다. (x:이전으로)");
				Cw.lineBar();
			} else {
				for (Post p : Data.postArray) {
					p.postInfoList();
					Cw.lineBar();
				}
			}
			input = Ci.r();
			if (input.equals("x")) {
				break list;
			}
			post: while (true) {
				for (Post p : Data.postArray) {
					n = p.num + "";
					if (n.equals(input)) {
						if (p.open == false) {
							Cw.wn("비공개 글입니다. 암호를 입력하세요.");
							input = Ci.r();
							if (!input.equals(p.pw)) {
								Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
								break post;
							}
							ox = false;
							pw = p.pw;
						}
						postNum = p.num;
						p.postInfo();
					}
				}
				input = Ci.r();
				switch (input) {
				// [ 이전글:1 | 목록:2 | 다음글:3 ] x:처음으로 [수정:4][삭제:5]
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
						break post;
					} else {
						input = prePost + "";
					}
					break;
				case "2":
					break post;
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
						break post;
					} else {
						input = nextPost + "";
					}
					break;
				case "4":
					if (ox == false) {
						Cw.wn("비공개 글입니다. 암호를 입력하세요.");
						input = Ci.r();
						if (!input.equals(pw)) {
							Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
							break post;
						}
					}
					editPost(postNum);
					input = postNum + "";
					break;
				case "5":
					if (ox == false) {
						Cw.wn("비공개 글입니다. 암호를 입력하세요.");
						input = Ci.r();
						if (!input.equals(pw)) {
							Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
							break post;
						}
					}
					Cw.wn("정말 삭제하시겠어요? (o:삭제 x:취소)");
					input = Ci.r();
					switch (input) {
					case "o":
						delPost(postNum);
						break;
					default:
						Cw.wn("목록으로 돌아갑니다.");
					}
					break post;
				case "x":
					return;
				}

			}
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
			Data.postArray.remove(index);
		}
		return;
	}

	public static void editPost(int postNum) {
		String input = "";
		String title = "";
		String content = "";

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
						p.title = title;
						p.content = content;
						Cw.wn("수정했습니다.");
						return;
					case "x":
						return;
					default:
						input = Ci.r();
					}
				}
			}
		}

	}

}
