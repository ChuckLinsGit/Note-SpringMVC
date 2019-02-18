package coreTechnology.handler.forwardandRedirect;
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
@Controller//继承controller类的子类处理器
@RequestMapping("/nstest")//指定资源名称前缀
public class myControler{

/**-------------------------------------请求转发和重定向--------------------------------------------**
/*	①
 * 请求转发携带非对象数据，可以直接使用modelandview的addobject方法和request的addAttribute方法
      重定向携带非对象数据，可以通过url拼接方式、httpsession形参、redirectAttribute形参方式、Modeld的addAttribute以及在返回modelandview的方法中
使用modelandview的addobject
	重定向model可携带数据原因：model是将数据转换成String类型并接到url中，本质上属于url拼接
 *  ②跳转向处理器
 	和跳转向页面方式差不多，只需用方法参数接收参数即可
 *  ③在jsp中获取参数方式不同
 *  Model的addAttribute、url拼接和redirectAttribute形参方式需要用${param.XXX}来获取，httpsession形参方式
 用session.getAttribute()来获取，而在返回modelandview的方法中使用modelandview的addobject方式可以在jsp中直
 接使用${XXX}来获取
	
	
	/**
	 * 返回modelandview
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
		/*而使用modelandview返回值重定向的页面则不能
		mv.setViewName("redirect:/welcome.jsp");
		/*重定向到处理器
		mv.setViewName("redirect:forControler.do");
		/*使用modelandview返回值请求转发，可以转发的页面能接收到model中的数据
		mv.setViewName("forward:/input.jsp");
		return mv;
	} 
	
	/**
	 * 返回String
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	
	@RequestMapping("forControler.do")
	public String handleReturnfor(String name, int age,Model m) 
			throws Exception {
		/*返回内部资源视图名
		return "/welcome.jsp";
		
		/*url拼接
		return "redirect:/welcome.jsp?pname="+name+"&page="+age;
		
		/*RedirectAttributes携带参数：需要在方法参数列表添加RedirectAttributes rattri
		 * 方式一：addAttribute()，会暴露参数
		rattri.addAttribute("pname", name);
		rattri.addAttribute("page", page);
		 /*方式二：addFlashAttribute()，不会暴露参数
		rattri.addFlashAttribute("pname", name);
		rattri.addFlashAttribute("page", age);
		
		
		/*使用httpsession携带参数：不会暴露参数，需要在方法参数列表添加HttpSession hse
		hse.setAttribute("pname", name);
		hse.setAttribute("page", age);
		
		m.addAttribute("pname", name);
		m.addAttribute("page", age);
		return "redirect:/welcome.jsp";
	} */
	
	
	/**
	 * PrintWriter输出无返回值：即是使用request的forward和response的redirect方法进行
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
	} 	

}
*/