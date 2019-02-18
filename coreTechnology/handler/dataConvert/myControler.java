package coreTechnology.handler.dataConvert;
import java.awt.TexturePaint;
import java.awt.print.Pageable;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
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
import coreTechnology.handler.dataConvert.DateEditor;
import net.sf.json.JSONObject;
/**
@Controller//�̳�controller������ദ����
@RequestMapping("/nstest")//ָ����Դ����ǰ׺
public class myControler{

	/**
	 * ����modelandview
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	
	@RequestMapping("for.do")
	public ModelAndView handleReturn(Date date, int age) 
			throws Exception {
		
		System.out.println(date);
		System.out.println(age);
		ModelAndView mv=new ModelAndView();
		mv.addObject("pdate", date);
		mv.addObject("page", age);
		mv.setViewName("forward:/input.jsp");
		return mv;
	} 

/*-------------------------------InitBinder����ת����--------------------------------------------
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
	/*	һ����������ת����	
	 *  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df,true));
		
		/*������������ת����
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	/**
	 * ����ת���쳣������
	 * @param request
	 * @param exception
	 * @return

	@ExceptionHandler(TypeMismatchException.class)
	public ModelAndView handleException(HttpServletRequest request,TypeMismatchException exception) {
		
		String age =(String) request.getParameter("age");
		String  date=(String)request.getParameter("date");
		String eRMesg=exception.getMessage();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("page",age);
		mv.addObject("pdate",date);
		mv.addObject("ex", exception);
		//���ݻ���
		if(exception.getMessage().contains(age)) {
			mv.addObject("ageMessage", "������д����");
		}
		if (exception.getMessage().contains(date)) {
			mv.addObject("dateMessage", "������д����");
		}
		mv.setViewName("forward:/input.jsp");
		return mv;
	}
}
*/