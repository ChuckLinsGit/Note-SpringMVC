package coreTechnology.handler.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**-------------------------------------------������----------------------------------------------**/
/*1��������ִ�����̣�����->preHandler1->preHandler2->����������->postHandler2->postHandler1
			     								��ͼ������->afterCompletion2->afterCompletion1->��Ӧ
  2����preHandler����true�������������������afterCompletion��Ȼ��������
  		��preHandler1Ϊtrue��
  		����->preHandler1->������2->..->afterCompletion1->��Ӧ
  		��preHandler1Ϊtrue��preHandler2Ϊfalse:
  		����->preHandler1->preHandler2->postHandler1->afterCompletion1->��Ӧ
  		��preHandler1Ϊfalse��preHandler2Ϊtrue:
  		����->preHandler1->��Ӧ
   */


public class permissonInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("permissonInterceptor preHandle method was executed");
		String user = (String)request.getSession().getAttribute("user");
		if(user!=null) {
			if (user.equals("chuck")) {
				return true;
			}else {
				request.setAttribute("loginMessage", "��¼ʧ��");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return false;
			}
		}else {
			request.setAttribute("loginMessage", "��¼ʧ��");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("permissonInterceptor postHandle method was executed");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("permissonInterceptor afterCompletion method was executed");
	}

}
