package mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Exam;

@Controller
public class ExamController {

	@RequestMapping("mvc/first")
	public String first(Model model) {
		
		System.out.println("mvc/first");
		model.addAttribute("st", new Exam("����", 88,87,86));
		
		return "mvc/first";
	}
	
	@RequestMapping("mvc/sec")
	public ModelAndView sec() {
		
		ModelAndView res = new ModelAndView("mvc/sec");
		//model.addAttribute("st", new Exam("장동건", 88,87,86));
		
		res.addObject("st", new Exam("장동건", 98,77,56));
		return res;
	}
	
	@RequestMapping("mvc/thr")
	public String thr(@ModelAttribute("st") Exam st) {
		
		st.setName("원빈");
		st.setJum(new int[] {45,67,89});
		
		//System.out.println(exam.getName());
		return "mvc/thr";
	}
	
	@RequestMapping("mvc/four")
	public String four(@ModelAttribute("st") Exam st) {
		
		return "mvc/four";
	}
	
	@RequestMapping(value="mvc/five",method=RequestMethod.GET )
	public String five() {
		
		return "mvc/five";
	}
	
	@RequestMapping(value="mvc/five",method=RequestMethod.POST )
	public String fiveComplete(Exam st) {
		
		return "mvc/fiveReg";
	}
	
	/*@RequestMapping("mvc/fiveReg")
	public String fiveReg(Exam st) {
		
		return "mvc/fiveReg";
	}*/
}
