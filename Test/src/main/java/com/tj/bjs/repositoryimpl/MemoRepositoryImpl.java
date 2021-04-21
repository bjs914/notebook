package com.tj.bjs.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tj.bjs.domain.Memo;
import com.tj.bjs.repository.MemoRepository;

@Repository
public class MemoRepositoryImpl implements MemoRepository{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Memo notebook) {
		String SQL="INSERT INTO memo(content) VALUES(:content)";
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("content",notebook.getContent());
		jdbcTemplate.update(SQL, params);
		
	}

	@Override
	public List<Memo> getAllContents(String... args) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Memo> result=jdbcTemplate.query("SELECT seqNo, content,substring(content,1,20) FROM memo order by seqNo desc limit 10",params,new MemoMapper());
		return result;
	}

	private static final class MemoMapper implements RowMapper<Memo>{
		public Memo mapRow(ResultSet rs, int rowNum) throws SQLException{
			Memo notebook = new Memo();
			notebook.setSeqNo(rs.getInt("seqNo"));
			notebook.setContent(rs.getString("content"));
			return notebook;
		}
	}

	@Override
	public void delete(String seqNo) {
		String SQL = "DELETE FROM memo WHERE seqNo = :seqNo";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("seqNo", seqNo);
		jdbcTemplate.update(SQL, params);
	}	
}
