package com.tj.bjs.domain;

import java.io.Serializable;

public class Memo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5489689896030181097L;
	private String content;
	private int seqNo;
	
	public Memo() {

	}

	public int getSeqNo() {
		return seqNo;
	}


	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
