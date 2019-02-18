package coreTechnology.handler.validator;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coreTechnology.handler.validator.entity.student;


//@Controller//�̳�controller������ദ����
@RequestMapping("/nstest")//ָ����Դ����ǰ׺
public class myControler{
	/**
	 *������֤
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

		//��ȡУ������������ڴ���errorCount>0�����������binging.getFieldError��ȡ
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
