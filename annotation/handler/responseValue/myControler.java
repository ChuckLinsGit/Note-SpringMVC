package annotation.handler.responseValue;
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
