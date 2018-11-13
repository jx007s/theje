package mvc.controll;

import java.util.Arrays;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.BoardDTO;
import mvc.model.ListDTO;
import mvc.model.PageStatus;
import mvc.service.BoardDAO;
import mvc.service.FileService;

@Controller
@RequestMapping("/mybatis/{service}")
public class MybatisController {
	
	@Autowired
	BoardDAO dao;
	
	@Autowired
	FileService fileService;
	
	
	PageStatus status = new PageStatus();
	
	@ModelAttribute("status")
	public Object statusGo() {
		return status;
	}
	
	@ModelAttribute
	public void listGo(@PathVariable("service")String service, ListDTO dto) {
		if(service.equals("insertMultiReg")) {
			dao.insertList(dto);
		}
		if(service.equals("insertErrorReg")) {
			
			try {
				dao.insertError(dto);
				status.setMsg("입력되었습니다");
				status.setUrl("list");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				status.setMsg("id 입력에러 발생");
				status.setUrl("list");
			}
		}
		
	}
	

	@ModelAttribute("data")
	public Object dataGo(@PathVariable("service")String service, 
			BoardDTO dto,
			HttpServletRequest request) {
		
		Object res = null;
		switch(service) {
		
			case "list":
				System.out.println(dto.getCntType());
				res = dao.list(dto);
				break;
				
			case "detail":
				dao.addCount(dto);
			case "modifyForm":
				res = dao.selectOne(dto);
				break;
				
			case "insertReg":
				System.out.println(dto.getUpfileMM().isEmpty());
				if(!dto.getUpfileMM().isEmpty())
					dto.setUpfile(fileService.fileUpload(dto.getUpfileMM(), request));
				dao.insertOne(dto);
				
				status.setMsg("입력되었습니다");
				status.setUrl("detail?id="+dto.getId());
				res = dto;
				break;
				
				
				
			case "insertMultiReg":
				status.setMsg("입력되었습니다");
				status.setUrl("list");
				res = dto;
				
				break;
			
				
			case "deleteReg":
				status.setMsg("id pw 불일치");
				status.setUrl("deleteForm?id="+dto.getId());
				
				if((int)dao.deleteOne(dto) >= 1) {
					status.setMsg("삭제 성공");
					status.setUrl("list");
				}
				res = dto;
				break;
				
			case "modifyReg":
				
				status.setMsg("id pw 불일치");
				status.setUrl("modifyForm?id="+dto.getId());
				
				if((int)dao.modify(dto) >= 1) {
					status.setMsg("수정 성공");
					status.setUrl("detail?id="+dto.getId());
				}
				res = dto;
				
				break;
				
		}
		
		return res;
	}
	
	@RequestMapping()
	public String view(@PathVariable("service")String service) {
		
		String res = "mybatis/"+service;
		
		String [] arr = {
				"deleteReg",
				"modifyReg",
				"insertReg",
				"insertMultiReg",
				"insertErrorReg"};
		
		if(Arrays.asList(arr).contains(service)) {
			res = "mybatis/alert";
		}
		
		/*if(service.equals("insertReg"))
			res = "redirect:list";*/
		/*if(service.equals("deleteReg") || 
				service.equals("modifyReg") || 
				service.equals("insertReg") ||
				service.equals("insertMultiReg")
				)
			res = "mybatis/alert";*/
			
		return res;
	}
}
