package coreTechnology.handler.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**-------------------------------------------拦截器----------------------------------------------**/
/*1、拦截器执行流程：请求->preHandler1->preHandler2->处理器方法->postHandler2->postHandler1
			     								视图解析器->afterCompletion2->afterCompletion1->响应
  2、当preHandler返回true后，其后的拦截器和自身的afterCompletion必然发生。即
  		当preHandler1为true：
  		请求->preHandler1->拦截器2->..->afterCompletion1->响应
  		当preHandler1为true，preHandler2为false:
  		请求->preHandler1->preHandler2->postHandler1->afterCompletion1->响应
  		当preHandler1为false，preHandler2为true:
  		请求->preHandler1->响应
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
				request.setAttribute("loginMessage", "登录失败");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return false;
			}
		}else {
			request.setAttribute("loginMessage", "登录失败");
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
