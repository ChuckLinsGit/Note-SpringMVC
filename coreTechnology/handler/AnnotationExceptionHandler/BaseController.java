package coreTechnology.handler.AnnotationExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import coreTechnology.Exceptions.AgeException;
import coreTechnology.Exceptions.NameException;


/**
 * �����������������˶��쳣�Ĵ�����������̳�ʱ���Դ����쳣��ȱ�㣺ռ��������ļ̳�λ
 * @author www25
 *
 */
@Controller
public class BaseController {
	
	@ExceptionHandler()
	public ModelAndView defaultResolveException(Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/errors/error.jsp");
		
		return mv;
	}
	
	@ExceptionHandler(NameException.class)
	public ModelAndView nameResolveException(Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("ex", ex);
		if(ex instanceof NameException) {
			mv.setViewName("/errors/nameError.jsp");
		}
		return mv;
	}
	
	@ExceptionHandler(AgeException.class)
	public ModelAndView ageResolveException(Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("ex", ex);
		if(ex instanceof AgeException) {
			mv.setViewName("/errors/ageError.jsp");
		}
		return mv;
	}
}
