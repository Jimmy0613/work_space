package com.cre.board.data;

import java.time.LocalDate;

import com.cre.util.Cw;

public class Reply {
	String writer;
	String comment;
	String date;
	int postNum;
	public Reply(int postNum, String writer, String comment) {
		this.postNum = postNum;
		this.writer = writer;
		this.comment = comment;
		LocalDate now = LocalDate.now();
		this.date = now.toString();
	}
	
	public void replyInfo() {
		Cw.wn(this.writer + ": " + this.comment + "(" + this.date + ")");
	}
}
