package mvc.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.model.BoardDTO;
import mvc.model.ListDTO;

@Transactional
@Service
public class BoardDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	
	public Object list(BoardDTO dto) {
		System.out.println(dto.getSch());
		return sqlSessionTemplate.selectList("boardMM.list", dto);
	}
	
	public Object insertOne(BoardDTO dto) {
		return sqlSessionTemplate.insert("boardMM.insertOne", dto);
	}
	
	public Object selectOne(BoardDTO dto) {
		return sqlSessionTemplate.selectOne("boardMM.selectOne", dto);
	}
	
	public Object deleteOne(BoardDTO dto) {
		return sqlSessionTemplate.delete("boardMM.deleteOne", dto);
	}
	
	public Object modify(BoardDTO dto) {
		return sqlSessionTemplate.update("boardMM.modify", dto);
	}
	public void addCount(BoardDTO dto) {
		sqlSessionTemplate.update("boardMM.addCount", dto);
	}
	
	
	public Object insertList(ListDTO dto) {
		return sqlSessionTemplate.insert("boardMM.insertList", dto);
	}
	
	
	public void insertError(ListDTO dto)throws Exception {
		for (BoardDTO baordDTO : dto.getMem()) {
			sqlSessionTemplate.insert("boardMM.insertError", baordDTO);
		}
		
	}
	
	
}
