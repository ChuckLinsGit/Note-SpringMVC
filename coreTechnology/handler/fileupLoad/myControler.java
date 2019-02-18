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


//@Controller继承controller类的子类处理器
@RequestMapping("/nstest")//指定资源名称前缀
public class myControler{
	/**
	 *上传单个文件
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	
	@RequestMapping("for.do")
	public String handleReturn(MultipartFile img,HttpSession session,Model mv) 
			throws Exception {
		/*文件为空时，img对象不为null，因此需要通过getSize来判断
		if(img.getSize()>0) {
			String fileName=img.getOriginalFilename();
			/*限制文件格式
			if(fileName.endsWith("png")||fileName.endsWith("jpg")) {	
				/*io类中需要使用getServletContext().getRealPath获得服务器路径，"/imgs"会指向物理路径
				String pathName=session.getServletContext().getRealPath("/imgs");
				File file=new File(pathName, fileName);
				img.transferTo(file);
				mv.addAttribute("fileMessage", "上传成功！");
			}else {
				mv.addAttribute("fileMessage", "上传失败！文件格式不正确。");
			}
		}else{
			mv.addAttribute("fileMessage", "上传失败，文件为空。");
		}
		
		return "/input.jsp";
	} */

	
	/**
	 *上传多个文件：参数MultipartFile[] imgs需要用注解@RequestParam来校正
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
					mv.addAttribute("file"+(i+1)+"Message", "上传成功！");
				}else {
					mv.addAttribute("file"+(i+1)+"Message", "上传失败！文件格式不正确。");
				}
			}else{
				mv.addAttribute("file"+(i+1)+"Message", "上传失败，文件为空。");
			}
		}
	
		
		return "/input.jsp";
	}
}
