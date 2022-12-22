package com.cre.board.c;

import java.util.ArrayList;

import com.cre.board.c.db.DataGetInfo;
import com.cre.board.c.db.DataSelect;
import com.cre.board.c.util.Cw;
import com.cre.board.c.util.display.Disp;

public class List {
	DataSelect ds = new DataSelect();
	DataGetInfo dgi = new DataGetInfo();
	Page p = new Page();

	public void generalBoard(int startIndex) { //자게 목록
		p.getPages(); //총페이지수 구함
		Disp.boardTitle(" ❤ 자유게시판 ❤ [ 1.쓰기 | 2.읽기 | 3.검색 | x.이전으로 ] [게시글 " + dgi.getCount("board_post", "") + "개]");
		Cw.lineBar();
		Cw.wn(Cw.sf("🖤 번호 ", 4) + Cw.sf("|  글쓴이", 10) + Cw.sf("| 제목 ", 40) + Cw.sf("| 조회수 ", 10));
		Cw.lineBar();
		int cnt = 0;
		String where = "order by post_num desc limit " + startIndex + ", " + Page.PER_PAGE; //최신글부터 순서대로 짜릅니다
		cnt = dgi.getCount("board_post", where);
		if (cnt == 0) {
			Cw.wn(" 아직 글이 없어요.");
			Cw.lineBar();
			return;
		} else { //PostAndReply의 주석 참고. 똑같음
			ArrayList<Integer> postNum = ds.dbExecuteQueryIntArr("post_num", "board_post", where);
			ArrayList<String> wr_id = ds.dbExecuteQueryStrArr("wr_id", "board_post", where);
			ArrayList<String> title = ds.dbExecuteQueryStrArr("title", "board_post", where);
			ArrayList<Integer> re_count = ds.dbExecuteQueryIntArr("re_count", "board_post", where);
			ArrayList<Integer> hit = ds.dbExecuteQueryIntArr("hit", "board_post", where);
			if (re_count.size() != 0) {
				for (int i = 0; i < re_count.size(); i++) {
					String t = title.get(i);
					if (t.length() > 38) {
						t = t.substring(0, 20);
					}
					if (re_count.get(i) == 0) {
						Cw.w("❤");
						Cw.wn(Cw.sf(" " + postNum.get(i), 6) + Cw.sf(" " + wr_id.get(i), 10) + Cw.sf(t, 40)
								+ Cw.sf(" " + hit.get(i), 10));
					} else {
						Cw.w("❤");
						Cw.wn(Cw.sf(" " + postNum.get(i), 6) + Cw.sf(" " + wr_id.get(i), 10)
								+ Cw.sf(t + " (" + re_count.get(i) + ")", 40) + Cw.sf(" " + hit.get(i), 10));
					}
					Cw.lineBar();
				}
			}
		}
		Disp.dispPageInfo(Page.currentPage, Page.lastPage);
		Cw.lineLeo();
	}

	public void popularPosts() {//인기글은 게시판 구분없이(지금은 어차피 자게 하나지만..)조회수 순대로 딱 10개만 보여줄거.
		int cnt = 0;
		Disp.boardTitle(" ❤🖤 인기글 🖤❤ 🔥🔥 조회수 TOP10 🔥🔥 [ 1.읽기 | x.이전으로 ] ");
		Cw.lineBar();
		Cw.wn(Cw.sf("🖤 게시판 ", 6) + Cw.sf("| 번호 ", 4) + Cw.sf("|  글쓴이", 10) + Cw.sf("| 제목 ", 30) + Cw.sf("| 조회수 ", 10));
		Cw.lineBar();
		String where = "order by hit desc limit 0, 10"; 
		cnt = dgi.getCount("board_post", where);
		if (cnt == 0) {
			Cw.wn(" 아직 글이 없어요.");
			Cw.lineBar();
			return;
		} else {
			ArrayList<String> b_name = ds.dbExecuteQueryStrArr("b_name", "board_post", where);
			ArrayList<Integer> postNum = ds.dbExecuteQueryIntArr("post_num", "board_post", where);
			ArrayList<String> wr_id = ds.dbExecuteQueryStrArr("wr_id", "board_post", where);
			ArrayList<String> title = ds.dbExecuteQueryStrArr("title", "board_post", where);
			ArrayList<Integer> re_count = ds.dbExecuteQueryIntArr("re_count", "board_post", where);
			ArrayList<Integer> hit = ds.dbExecuteQueryIntArr("hit", "board_post", where);
			if (re_count.size() != 0) {
				for (int i = 0; i < re_count.size(); i++) {
					String t = title.get(i);
					if (t.length() > 38) {
						t = t.substring(0, 20);
					}
					if (re_count.get(i) == 0) {
						String b = Cw.sf(" [" + b_name.get(i) + "]", 6) + Cw.sf(" " + postNum.get(i), 6)
								+ Cw.sf(" " + wr_id.get(i), 10) + Cw.sf(t, 30) + Cw.sf(" " + hit.get(i), 10);
						Cw.w("❤");
						Cw.wn(b);
					} else {
						String b = Cw.sf(" [" + b_name.get(i) + "]", 6) + Cw.sf(" " + postNum.get(i), 6)
								+ Cw.sf(" " + wr_id.get(i), 10) + Cw.sf(t + " (" + re_count.get(i) + ")", 30)
								+ Cw.sf(" " + hit.get(i), 10);
						Cw.w("❤");
						Cw.wn(b);
					}
					Cw.lineBar();
				}
			}
		}
		Cw.lineLeo();

	}

	public void todayBest() { //**'오늘' 작성된 글 중 하트 많은거 세개.
		int cnt = 0;
		ArrayList<String> best = new ArrayList<String>();
		Disp.infoPrint(" 🔥🔥 오늘의 BEST 🔥🔥 ");
		Cw.wn(Cw.sf("🖤 게시판 ", 6) + Cw.sf("| 번호 ", 4) + Cw.sf("|  글쓴이", 8) + Cw.sf("| 제목 ", 30) + Cw.sf("| 조회수 ", 10));
		Cw.lineBar();
		String where = "where date_format(post_date, '%y-%m-%d')=curdate() order by like_count desc limit 0, 3";
		cnt = dgi.getCount("board_post", where);
		if (cnt == 0) {
			Cw.wn(" 아직 글이 없어요.");
			Cw.lineBar();
			return;
		} else {
			ArrayList<String> b_name = ds.dbExecuteQueryStrArr("b_name", "board_post", where);
			ArrayList<Integer> postNum = ds.dbExecuteQueryIntArr("post_num", "board_post", where);
			ArrayList<String> wr_id = ds.dbExecuteQueryStrArr("wr_id", "board_post", where);
			ArrayList<String> title = ds.dbExecuteQueryStrArr("title", "board_post", where);
			ArrayList<Integer> re_count = ds.dbExecuteQueryIntArr("re_count", "board_post", where);
			ArrayList<Integer> hit = ds.dbExecuteQueryIntArr("hit", "board_post", where);
			if (re_count.size() != 0) {
				for (int i = 0; i < re_count.size(); i++) {
					if (re_count.get(i) == 0) {
						String b = Cw.sf(" [" + b_name.get(i) + "]", 6) + Cw.sf(" " + postNum.get(i), 6)
								+ Cw.sf(" " + wr_id.get(i), 10) + Cw.sf(title.get(i), 30) + Cw.sf(" " + hit.get(i), 10);
						best.add(b);
					} else {
						String b = Cw.sf(" [" + b_name.get(i) + "]", 6) + Cw.sf(" " + postNum.get(i), 6)
								+ Cw.sf(" " + wr_id.get(i), 10) + Cw.sf(title.get(i) + " (" + re_count.get(i) + ")", 30)
								+ Cw.sf(" " + hit.get(i), 10);
						best.add(b);
					}
				}
			}
			if (best.size() > 0)
				Cw.wn("🥇" + best.get(0));
			if (best.size() > 1)
				Cw.wn("🥈" + best.get(1));
			if (best.size() > 2)
				Cw.wn("🥉" + best.get(2));
			Cw.lineBar();
		}
	}

	public void searchList(String key, String keyword, int limit) { //검색목록
		Disp.infoPrint(" [ 검색 ] '" + keyword + "'(으)로 검색한 결과 (1.읽기 x.이전)");
		Cw.dot();
		Cw.wn(Cw.sf(" 번호 ", 4) + Cw.sf("|  글쓴이", 10) + Cw.sf("| 제목 ", 40) + Cw.sf("| 조회수 ", 10));
		p.getPagesInSearch(key, keyword);
		Cw.lineBar();

		String where = "where " + key + " like '%" + keyword + "%' limit " + limit + ", " + Page.PER_PAGE;
		int cnt = dgi.getCount("board_post", where);
		if (cnt == 0) {
			return;
		} else {
			ArrayList<Integer> postNum = ds.dbExecuteQueryIntArr("post_num", "board_post", where);
			ArrayList<String> wr_id = ds.dbExecuteQueryStrArr("wr_id", "board_post", where);
			ArrayList<String> title = ds.dbExecuteQueryStrArr("title", "board_post", where);
			ArrayList<Integer> re_count = ds.dbExecuteQueryIntArr("re_count", "board_post", where);
			ArrayList<Integer> hit = ds.dbExecuteQueryIntArr("hit", "board_post", where);
			if (re_count.size() != 0) {
				for (int i = 0; i < re_count.size(); i++) {
					if (re_count.get(i) == 0) {
						String b = Cw.sf(" " + postNum.get(i), 6) + Cw.sf(" " + wr_id.get(i), 10)
								+ Cw.sf(title.get(i), 40) + Cw.sf(" " + hit.get(i), 10);
						Cw.w("❤");
						Cw.wn(b);
					} else {
						String b = Cw.sf(" " + postNum.get(i), 6) + Cw.sf(" " + wr_id.get(i), 10)
								+ Cw.sf(title.get(i) + " (" + re_count.get(i) + ")", 40) + Cw.sf(" " + hit.get(i), 10);
						Cw.w("❤");
						Cw.wn(b);
					}
					Cw.lineBar();
				}
			}
			Disp.dispPageInfo(Page.currentPageS, Page.lastPageS);
			
		}
	}
}
