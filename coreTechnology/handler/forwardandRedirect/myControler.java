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
@Controller//�̳�controller������ദ����
@RequestMapping("/nstest")//ָ����Դ����ǰ׺
public class myControler{

/**-------------------------------------����ת�����ض���--------------------------------------------**
/*	��
 * ����ת��Я���Ƕ������ݣ�����ֱ��ʹ��modelandview��addobject������request��addAttribute����
      �ض���Я���Ƕ������ݣ�����ͨ��urlƴ�ӷ�ʽ��httpsession�βΡ�redirectAttribute�βη�ʽ��Modeld��addAttribute�Լ��ڷ���modelandview�ķ�����
ʹ��modelandview��addobject
	�ض���model��Я������ԭ��model�ǽ�����ת����String���Ͳ��ӵ�url�У�����������urlƴ��
 *  ����ת������
 	����ת��ҳ�淽ʽ��ֻ࣬���÷����������ղ�������
 *  ����jsp�л�ȡ������ʽ��ͬ
 *  Model��addAttribute��urlƴ�Ӻ�redirectAttribute�βη�ʽ��Ҫ��${param.XXX}����ȡ��httpsession�βη�ʽ
 ��session.getAttribute()����ȡ�����ڷ���modelandview�ķ�����ʹ��modelandview��addobject��ʽ������jsp��ֱ
 ��ʹ��${XXX}����ȡ
	
	
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
		/*��ʹ��modelandview����ֵ�ض����ҳ������
		mv.setViewName("redirect:/welcome.jsp");
		/*�ض��򵽴�����
		mv.setViewName("redirect:forControler.do");
		/*ʹ��modelandview����ֵ����ת��������ת����ҳ���ܽ��յ�model�е�����
		mv.setViewName("forward:/input.jsp");
		return mv;
	} 
	
	/**
	 * ����String
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	
	@RequestMapping("forControler.do")
	public String handleReturnfor(String name, int age,Model m) 
			throws Exception {
		/*�����ڲ���Դ��ͼ��
		return "/welcome.jsp";
		
		/*urlƴ��
		return "redirect:/welcome.jsp?pname="+name+"&page="+age;
		
		/*RedirectAttributesЯ����������Ҫ�ڷ��������б����RedirectAttributes rattri
		 * ��ʽһ��addAttribute()���ᱩ¶����
		rattri.addAttribute("pname", name);
		rattri.addAttribute("page", page);
		 /*��ʽ����addFlashAttribute()�����ᱩ¶����
		rattri.addFlashAttribute("pname", name);
		rattri.addFlashAttribute("page", age);
		
		
		/*ʹ��httpsessionЯ�����������ᱩ¶��������Ҫ�ڷ��������б����HttpSession hse
		hse.setAttribute("pname", name);
		hse.setAttribute("page", age);
		
		m.addAttribute("pname", name);
		m.addAttribute("page", age);
		return "redirect:/welcome.jsp";
	} */
	
	
	/**
	 * PrintWriter����޷���ֵ������ʹ��request��forward��response��redirect��������
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	@RequestMapping("return.do")	
	public void handleReturn(String name,int age,HttpServletResponse response) 
			throws Exception {
		/*ʹ��ServletRequestת�� 
		arg0.getRequestDispatcher("/welcome.jsp").forward(arg0, arg1);
		/*ʹ��ServletResponse�ض��� 
		arg1.sendRedirect("/SpringMVC/welcome.jsp");
		
		//ʹ��Ajax������jsonΪ���������
		System.out.println("return.do");
		System.out.println("name="+name);
		System.out.println("age="+age);
		
		Map<String,Object> datamap=new HashMap<String,Object>();
		datamap.put("name", name);
		datamap.put("age", age);
		System.out.println(datamap.toString());
		
		JSONObject jsOb=JSONObject.fromObject(datamap);//ת����JSON����
		String jsObStr=jsOb.toString();//ת����JSON�ַ���
		System.out.println(jsObStr);
		
		PrintWriter out=response.getWriter();
		out.print(jsObStr);//�������Ӧҳ��
		out.flush();
		out.close();
	} 	

}
*/