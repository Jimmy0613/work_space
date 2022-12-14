package com.cre.board.data;

import java.time.LocalDate;

import com.cre.util.Cw;

public class Post {
	public static int postNum = 0;
	public int num = 0;
	public String writer;
	public String title;
	public String content;
	String date;
	
	public Post(String writer, String title, String content) {
		postNum++;
		this.num = postNum;
		this.writer = writer;
		this.title = title;
		this.content = content;
		LocalDate now = LocalDate.now();
		this.date = now.toString();
	}
	
	public void infoList() {
		Cw.wn("글번호("+this.num + ") " + "작성자(" + this.writer + ") " + "제목(" + this.title + ") 작성일(" + this.date + ")");
	}
	public void infoRead() {
		Cw.wn("글번호("+this.num + ") " + "작성자(" + this.writer + ") 작성일(" + this.date + ")");
		Cw.lineBar();
		Cw.wn("제목(" + this.title + ")");
		Cw.lineBar();
		Cw.wn(" " + this.content);
		Cw.wn();
	}
	
}
