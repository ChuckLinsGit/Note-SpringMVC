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

@Controller//�̳�controller������ദ����
@RequestMapping("/nstest")//ָ����Դ����ǰ׺
public class myControler{
	
/**-------------------------------------������ܴ���---------------------------------------------**/
/*	
 * ·��ͨ���
	��/do*First,·��������do��ͷ����First��β
	��/doFirst,·�������ľ���ƥ�䣬��nstest��doFirst֮�������һ��·������/nstest/others/doFirst/
	��/*doFirst��·������ƥ�䣬��nstest��doFirst֮������ж༶·����Ҳ����û��
 
 *	RequestMapping��ǩ
	value={"{name}/{age}/hello.do","/world.do"}����Դ���ƣ����Բ���'/',��Я���������ᱻ����ɴ���������
	method=RequestMethod.POST,��������ʽ
	param={"name","!age"},Ҫ�������ַ���뺬��name������������age������������������
	produces="text/html;charset=utf-8" ָ�����ݵ����ݵ��ַ���
*/
	
	/** ��Ƚ�����ʽ������ע��ʽ�Ĵ���������ֱ�ӽ��ղ���
	 *  ע����workplace��jspָ�����ַ���һ�»���������ʱ��������web.xml�����ù�������org.springframework.we
	 	b.filter.CharacterEncodingFilter�������������Ӧ�ַ���
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"hello.do","/world.do"})
	/*������ղ���
	 * public ModelAndView handleForm(@RequestParam("name")/ָ��������/ String name,int age) 
 																		throws Exception {
	 */
	
	/*���ܷ�װ���� :Ҫ��������������������һ��
	 */
	public ModelAndView handleForm(student student) throws Exception {
		System.out.println("handleForm");
		System.out.println("name="+ student.getName());
		System.out.println("age="+ student.getAge());
		System.out.println("school="+ student.getSchool().getSname());
		
		ModelAndView modelAndViewTest = new ModelAndView();
		modelAndViewTest.addObject("name", student.getName());
		modelAndViewTest.addObject("age", student.getAge());
		/*����д����spring���Զ���װ��school�����ٽ�school�����װ��student����
		modelAndViewTest.addObject("school", student.getSchool().getSname());*/
		modelAndViewTest.addObject("school", student.getSchool());
		//modelAndViewTest.setViewName("welcome");ʹ����ͼ�����������ͼ����ģʽ
		modelAndViewTest.setViewName("/output.jsp");
		return modelAndViewTest;
	}
	
	@RequestMapping(value={"first.do","/world.do"})
	public ModelAndView handleFirst(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView modelAndViewTest = new ModelAndView();
		System.out.println("handleFirst");
		modelAndViewTest.addObject("message", "Welcom SpringMVC world!");
		//modelAndViewTest.setViewName("welcome");ʹ����ͼ�����������ͼ����ģʽ
		modelAndViewTest.setViewName("/WEB-INF/welcome.jsp");
		return modelAndViewTest;
	}

	
/**-------------------------------------����ֵ����-----------------------------------------------**/
/*	����������Ҫ��ת���Ҵ������ݵ�ʱ�򣬷��ظ���ͼ������һ��ModelandView����ʱ���ʵģ�����ʱ������Ҫ���߶�ͬ
	ʱ����(ֻ��Ҫ��ת����ֻ��Ҫ��������)����ʱ����һ��ModelandView�����Ե���Щ���࣬�����Ҫ����ֵ��Ҫ������*/
	/**
	 * ����String
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	
	@RequestMapping("return.do")
	public String handleReturn(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws Exception {
		/*�����ڲ���Դ��ͼ��
		return "/welcome.jsp";
		/*������ͼ������
		return "taobao";
	} */
	
	
	/**
	 * PrintWriter����޷���ֵ
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
	} 	*/
	
	
	/**
	 * ����Object����
	 * ������Ҫ�õ�jackson���߰�����Objectת����json���崫�ݣ���ʵ�ֵ�������Http��Ϣת����HttpMessageConver
	   t.HttpMessageConvert��Ҫ��MVCע����������������
	 * @param name
	 * @param age
	 * @param arg1
	 * @throws Exception
	 */
	
	
	@RequestMapping(value="/return.do")
	@ResponseBody				//�����ص����ݷŽ���Ӧ��
	public Object handleReturn() 
			throws Exception {
		System.out.println("return Object");
		//return 123.456;
		//return "������ӭ��";//��Ҫ��@RequestMapping��ǩ�м���produces="text/html;charset=utf-8"�������
		//return new student("������",12,new School("gdou"));
		
		/*Map<String,student> stus=new HashMap<String,student>();
		stus.put("stu1", new student("������",12,new School("gdou")));
		stus.put("stu2", new student("������",14,new School("gdou")));
		return stus;*/
		
		List<student> stus=new ArrayList<student>();
		stus.add( new student("������",12,new School("gdou")));
		stus.add(new student("������",14,new School("gdou")));
		
		return stus;
	}
}
