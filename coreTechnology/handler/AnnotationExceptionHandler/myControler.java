package coreTechnology.handler.AnnotationExceptionHandler;
import java.io.PrintWriter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import annotation.entity.School;
import annotation.entity.student;
import coreTechnology.Exceptions.AgeException;
import coreTechnology.Exceptions.NameException;
import net.sf.json.JSONObject;

/**
 * 继承了包含异常处理的基本处理器BaseController
 * @author www25
 *

@Controller//继承controller类的子类处理器
@RequestMapping("/nstest")//指定资源名称前缀
public class myControler extends BaseController{

	@RequestMapping("forControler.do")
	public String handleReturnfor(String name, int age,Model m) 
			throws Exception {
		System.out.println("exceptionhandler");
		int i=3/0;
		
		if(!"泥马曹".equals(name)) {
			throw new  NameException("用户名不正确");
		}
		if(age>60) {
			throw new AgeException("年龄太大");
		}
		System.out.println(name);
		System.out.println(age);

		return "redirect:/welcome.jsp";
	} 
} */
