package configuration.handle;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 继承MultiActionController类的处理器可以拥有多个处理方法
 * MultiActionController有一个methodNameResolver属性，名为方法解析器，将方法名作为资源名称来解析，使用时意味
 着方法名应作为资源名称
 * 注意：应为public方法
 * @author www25

public class myControler extends MultiActionController {

	public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");使用视图解析器后的视图设置模式
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		
		return modelAndViewTest;
	}
	
	public ModelAndView doSecond(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");使用视图解析器后的视图设置模式
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		
		return modelAndViewTest;
	}
 *
 */

/**继承了AbstractController的子类处理器可以在配置文件中限制请求方式：get、post或者其他方式
 * 因为AbstractController继承了WebContentGenerator，WebContentGenerator类主要用来限制请求方式

public class myControler extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");使用视图解析器后的视图设置模式
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		
		return modelAndViewTest;
	}
 *
 */

/*子类处理器继承接口Controller
 * 

public class myControler implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//		
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");使用视图解析器后的视图设置模式
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		//
		return new ModelAndView("ecommerce");
	}
	
}
 */