package com.tj.bjs.service;

import java.util.List;

import com.tj.bjs.domain.Memo;

public interface MemoService {
	void insert(Memo notebook);
	List<Memo> getAllContents();
	void delete(String seqNo);
}
