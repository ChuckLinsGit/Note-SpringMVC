package configuration.handle;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * �̳�MultiActionController��Ĵ���������ӵ�ж��������
 * MultiActionController��һ��methodNameResolver���ԣ���Ϊ����������������������Ϊ��Դ������������ʹ��ʱ��ζ
 �ŷ�����Ӧ��Ϊ��Դ����
 * ע�⣺ӦΪpublic����
 * @author www25

public class myControler extends MultiActionController {

	public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");ʹ����ͼ�����������ͼ����ģʽ
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		
		return modelAndViewTest;
	}
	
	public ModelAndView doSecond(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");ʹ����ͼ�����������ͼ����ģʽ
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		
		return modelAndViewTest;
	}
 *
 */

/**�̳���AbstractController�����ദ���������������ļ�����������ʽ��get��post����������ʽ
 * ��ΪAbstractController�̳���WebContentGenerator��WebContentGenerator����Ҫ������������ʽ

public class myControler extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");ʹ����ͼ�����������ͼ����ģʽ
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		
		return modelAndViewTest;
	}
 *
 */

/*���ദ�����̳нӿ�Controller
 * 

public class myControler implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//		
		ModelAndView modelAndViewTest = new ModelAndView();
		
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");ʹ����ͼ�����������ͼ����ģʽ
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		//
		return new ModelAndView("ecommerce");
	}
	
}
 */