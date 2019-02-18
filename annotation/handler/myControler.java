package annotation.handler;
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
	
	/*接受封装参数 :要求表单参数名与对象属性名一致
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

	
/**-------------------------------------返回值处理-----------------------------------------------**/
/*	处理器在需要跳转并且传递数据的时候，返回给视图处理器一个ModelandView对象时合适的；但有时并不需要两者都同
	时进行(只需要跳转或者只需要传递数据)，此时返回一个ModelandView对象显得有些多余，因此需要返回值需要多样化*/
	/**
	 * 返回String
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	
	@RequestMapping("return.do")
	public String handleReturn(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws Exception {
		/*返回内部资源视图名
		return "/welcome.jsp";
		/*返回视图对象名
		return "taobao";
	} */
	
	
	/**
	 * PrintWriter输出无返回值
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	@RequestMapping("return.do")	
	public void handleReturn(String name,int age,HttpServletResponse response) 
			throws Exception {
		/*使用ServletRequest转发 
		arg0.getRequestDispatcher("/welcome.jsp").forward(arg0, arg1);
		/*使用ServletResponse重定向 
		arg1.sendRedirect("/SpringMVC/welcome.jsp");
		
		//使用Ajax传递以json为载体的数据
		System.out.println("return.do");
		System.out.println("name="+name);
		System.out.println("age="+age);
		
		Map<String,Object> datamap=new HashMap<String,Object>();
		datamap.put("name", name);
		datamap.put("age", age);
		System.out.println(datamap.toString());
		
		JSONObject jsOb=JSONObject.fromObject(datamap);//转换成JSON对象
		String jsObStr=jsOb.toString();//转化成JSON字符串
		System.out.println(jsObStr);
		
		PrintWriter out=response.getWriter();
		out.print(jsObStr);//输出到相应页面
		out.flush();
		out.close();
	} 	*/
	
	
	/**
	 * 返回Object类型
	 * 这里需要用到jackson工具包，将Object转换成json载体传递，而实现的容器是Http消息转化器HttpMessageConver
	   t.HttpMessageConvert需要由MVC注解驱动来创建对象
	 * @param name
	 * @param age
	 * @param arg1
	 * @throws Exception
	 */
	
	
	@RequestMapping(value="/return.do")
	@ResponseBody				//将返回的数据放进响应体
	public Object handleReturn() 
			throws Exception {
		System.out.println("return Object");
		//return 123.456;
		//return "北京欢迎你";//需要在@RequestMapping标签中加上produces="text/html;charset=utf-8"解决乱码
		//return new student("草泥马",12,new School("gdou"));
		
		/*Map<String,student> stus=new HashMap<String,student>();
		stus.put("stu1", new student("龙傲天",12,new School("gdou")));
		stus.put("stu2", new student("草泥马",14,new School("gdou")));
		return stus;*/
		
		List<student> stus=new ArrayList<student>();
		stus.add( new student("龙傲天",12,new School("gdou")));
		stus.add(new student("草泥马",14,new School("gdou")));
		
		return stus;
	}
}
