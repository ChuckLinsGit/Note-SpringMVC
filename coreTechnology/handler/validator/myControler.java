package coreTechnology.handler.validator;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coreTechnology.handler.validator.entity.student;


//@Controller//继承controller类的子类处理器
@RequestMapping("/nstest")//指定资源名称前缀
public class myControler{
	/**
	 *数据验证
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	*/
	@RequestMapping("for.do")
	public ModelAndView handleReturn(@Validated student stu,BindingResult binging) 
			throws Exception {
		System.out.println(stu.getName());
		System.out.println(stu.getAge());
		System.out.println(stu.getMobile());
		
		ModelAndView mv=new ModelAndView();

		//获取校验结果，如果存在错误errorCount>0，错误可以用binging.getFieldError获取
		int errorCount = binging.getErrorCount();
		if(errorCount>0) {
			FieldError nameFieldError=binging.getFieldError("name");
			FieldError ageFieldError=binging.getFieldError("age");
			FieldError mobileFieldError=binging.getFieldError("mobile");
			
			if(ageFieldError!=null) {
				String ageMessage = ageFieldError.getDefaultMessage();
				mv.addObject("ageMessage", ageMessage);
			}
			if(nameFieldError!=null) {
				String nameMessage = nameFieldError.getDefaultMessage();
				mv.addObject("ageMessage", nameMessage);
			}
			if(mobileFieldError!=null) {
				String mobileMessage = mobileFieldError.getDefaultMessage();
				mv.addObject("ageMessage", mobileMessage);
			}
		}

		mv.setViewName("forward:/input.jsp");
		return mv;
	} 

}
