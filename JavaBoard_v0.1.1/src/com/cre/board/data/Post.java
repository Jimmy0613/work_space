package com.cre.board.data;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cre.board.display.Disp;
import com.cre.util.Cw;

public class Post {
	String writer = "";
	String date = "";
	public static int listNum = 0;
	public int num = 0;
	public int re = 0;
	public String title = "";
	public String content = "";
	public String pw = "";
	public boolean open = true;
	public static ArrayList<Reply> comments;
	
	public static void loadReply() {
		comments = new ArrayList<>();
	}
	
	public Post(String title, String content, String writer, boolean open, String pw) {
		listNum++;
		this.num = listNum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		LocalDate now = LocalDate.now();
		this.date = now.toString();
		this.open = open;
		this.pw = pw;
	}
	
	public void postInfo() {
		
		Disp.menuPrint(Cw.sf("["+this.num+"]",4) + " 제목: " + this.title + " ");
		Cw.wn(Cw.sf("[작성자:"+this.writer, 12) + Cw.sf("|"+this.date, 15) + "]");
		Cw.wn();
		Cw.wn(" " + this.content);
		Cw.wn();
		Cw.lineBar();
		Cw.wn("[댓글] (" + this.re + "개의 댓글이 있습니다.) r:댓글쓰기");
		Cw.lineBar();
		if(comments.size() != 0) {
			for(Reply r: comments) {
				if(r.postNum == this.num) {
					r.replyInfo();
					Cw.lineBar();
				}
			}
		}
		Cw.wn();
		Cw.wn(" [ 이전글:1 | 목록:2 | 다음글:3 ] [수정:4][삭제:5]");
		Cw.lineBar();
	}
	
	public void postInfoList() {
		Cw.dot();
		Cw.wn(Cw.sf(" "+this.num,4) +" "+ Cw.sf(" "+this.writer, 8) + Cw.sf("  "+this.date, 12) + "    " + this.title);
	}
	
}
