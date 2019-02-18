package coreTechnology.handler.ConfigurationExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import coreTechnology.Exceptions.AgeException;
import coreTechnology.Exceptions.NameException;

public class myHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
										Object handler,Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/errors/error.jsp");
		
		if(ex instanceof NameException) {
			mv.setViewName("/errors/nameError.jsp");
		}
		if(ex instanceof AgeException) {
			mv.setViewName("/errors/ageError.jsp");
		}
		
		return mv;
	}

}
