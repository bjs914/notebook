package com.tj.bjs.repository;

import java.util.List;

import com.tj.bjs.domain.Memo;

public interface MemoRepository {
	void insert(Memo notebook);
	List<Memo> getAllContents(String...args);
	void delete(String seqNo);
}
