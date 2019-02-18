package annotation.handler.requestHandle;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import annotation.entity.School;
import annotation.entity.student;
import net.sf.json.JSONObject;

@Controller//继承controller类的子类处理器
@RequestMapping("/nstest")//指定资源名称前缀
public class myControler{
	
/**-------------------------------------请求接受处理---------------------------------------------**/
/*	
 * 路径通配符
	①/do*First,路径必须以do开头，以First结尾
	②/doFirst,路径级数的绝对匹配，在nstest和doFirst之间必须有一级路径，如/nstest/others/doFirst/
	③/*doFirst，路径级数匹配，在nstest和doFirst之间可以有多级路径，也可以没有
 
 *	RequestMapping标签
	value={"{name}/{age}/hello.do","/world.do"}，资源名称，可以不加'/',可携带参数并会被处理成处理器参数
	method=RequestMethod.POST,限制请求方式
	param={"name","!age"},要求请求地址必须含有name参数，不含有age参数，其他参数任意
	produces="text/html;charset=utf-8" 指定传递的数据的字符集
*/
	
	/** 相比较配置式开发，注解式的处理器可以直接接收参数
	 *  注：在workplace和jsp指定的字符集一致还出现乱码时，可以在web.xml中配置过滤器（org.springframework.we
	 	b.filter.CharacterEncodingFilter）设置请求和响应字符集
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"hello.do","/world.do"})
	/*逐个接收参数
	 * public ModelAndView handleForm(@RequestParam("name")/指定参数名/ String name,int age) 
 																		throws Exception {
	 */
	
	/*接受封装参数 
	 */
	public ModelAndView handleForm(student student) throws Exception {
		System.out.println("handleForm");
		System.out.println("name="+ student.getName());
		System.out.println("age="+ student.getAge());
		System.out.println("school="+ student.getSchool().getSname());
		
		ModelAndView modelAndViewTest = new ModelAndView();
		modelAndViewTest.addObject("name", student.getName());
		modelAndViewTest.addObject("age", student.getAge());
		/*如下写法，spring会自动封装成school对象，再将school对象封装进student对象
		modelAndViewTest.addObject("school", student.getSchool().getSname());*/
		modelAndViewTest.addObject("school", student.getSchool());
		//modelAndViewTest.setViewName("welcome");使用视图解析器后的视图设置模式
		modelAndViewTest.setViewName("/output.jsp");
		return modelAndViewTest;
	}
	
	@RequestMapping(value={"first.do","/world.do"})
	public ModelAndView handleFirst(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView modelAndViewTest = new ModelAndView();
		System.out.println("handleFirst");
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");使用视图解析器后的视图设置模式
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		return modelAndViewTest;
	}

}
