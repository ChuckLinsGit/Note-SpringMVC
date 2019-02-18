package coreTechnology.handler.fileupLoad;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import coreTechnology.handler.validator.entity.student;


//@Controller�̳�controller������ദ����
@RequestMapping("/nstest")//ָ����Դ����ǰ׺
public class myControler{
	/**
	 *�ϴ������ļ�
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	
	@RequestMapping("for.do")
	public String handleReturn(MultipartFile img,HttpSession session,Model mv) 
			throws Exception {
		/*�ļ�Ϊ��ʱ��img����Ϊnull�������Ҫͨ��getSize���ж�
		if(img.getSize()>0) {
			String fileName=img.getOriginalFilename();
			/*�����ļ���ʽ
			if(fileName.endsWith("png")||fileName.endsWith("jpg")) {	
				/*io������Ҫʹ��getServletContext().getRealPath��÷�����·����"/imgs"��ָ������·��
				String pathName=session.getServletContext().getRealPath("/imgs");
				File file=new File(pathName, fileName);
				img.transferTo(file);
				mv.addAttribute("fileMessage", "�ϴ��ɹ���");
			}else {
				mv.addAttribute("fileMessage", "�ϴ�ʧ�ܣ��ļ���ʽ����ȷ��");
			}
		}else{
			mv.addAttribute("fileMessage", "�ϴ�ʧ�ܣ��ļ�Ϊ�ա�");
		}
		
		return "/input.jsp";
	} */

	
	/**
	 *�ϴ�����ļ�������MultipartFile[] imgs��Ҫ��ע��@RequestParam��У��
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	*/
	@RequestMapping("for.do")
	public String handleReturn(@RequestParam MultipartFile[] imgs,HttpSession session,Model mv) 
			throws Exception {
		for(int i=0;i<3;i++) {
			if(imgs[i].getSize()>0) {
				String fileName=imgs[i].getOriginalFilename();
				if(fileName.endsWith("png")||fileName.endsWith("jpg")) {	
					String pathName=session.getServletContext().getRealPath("/imgs");
					File file=new File(pathName, fileName);
					imgs[i].transferTo(file);
					mv.addAttribute("file"+(i+1)+"Message", "�ϴ��ɹ���");
				}else {
					mv.addAttribute("file"+(i+1)+"Message", "�ϴ�ʧ�ܣ��ļ���ʽ����ȷ��");
				}
			}else{
				mv.addAttribute("file"+(i+1)+"Message", "�ϴ�ʧ�ܣ��ļ�Ϊ�ա�");
			}
		}
	
		
		return "/input.jsp";
	}
}
