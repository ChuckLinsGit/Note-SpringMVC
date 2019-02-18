package coreTechnology.handler;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import coreTechnology.handler.validator.entity.student;

@Controller//�̳�controller������ദ����
@RequestMapping("/nstest")//ָ����Դ����ǰ׺
public class myControler{


	@RequestMapping("forLogin.do")
	public String handleReturn(Model m) 
			throws Exception {
		System.out.println("handler method was executed");
		m.addAttribute("loginMessage", "��¼�ɹ�");
		return "/login.jsp";
	}
	
	@RequestMapping("forLogout.do")
	public String handleReturn1(HttpServletRequest request, Model m) 
			throws Exception {
		System.out.println("handler method was executed");
		request.getSession().removeAttribute("user");
		m.addAttribute("logoutMessage", "�˳��ɹ�");
		return "/logout.jsp";
	}
}
