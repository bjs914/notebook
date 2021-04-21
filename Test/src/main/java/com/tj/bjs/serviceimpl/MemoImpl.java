package com.tj.bjs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.bjs.domain.Memo;
import com.tj.bjs.repository.MemoRepository;
import com.tj.bjs.service.MemoService;

@Service
public class MemoImpl implements MemoService{
	@Autowired
	private MemoRepository notebookRepository;
	
	@Override
	public void insert(Memo notebook) {
		notebookRepository.insert(notebook);
	}

	@Override
	public List<Memo> getAllContents() {
		return notebookRepository.getAllContents();
	}

	@Override
	public void delete(String seqNo) {
		notebookRepository.delete(seqNo);
	}

}
