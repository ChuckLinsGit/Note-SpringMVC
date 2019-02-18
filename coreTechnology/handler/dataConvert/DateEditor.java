package coreTechnology.handler.dataConvert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * InitBinder类型转换器：无需在SpringMVCContext.xml中配置
 * @author www25
 *
 */
public class DateEditor extends PropertiesEditor {

	@Override
	public void setAsText(String source) throws IllegalArgumentException {
		SimpleDateFormat sdFormat =getDateFormat(source);
		try {
			Date parse = sdFormat.parse(source);
			setValue(parse);
		} catch (ParseException e) {
			throw new TypeMismatchException("", Date.class);
		}

	}
	
	/**
	 * 利用正则表达式识别多种日期形式
	 * @param source
	 * @return
	 */
	private SimpleDateFormat getDateFormat(String source) {
		SimpleDateFormat sdFormat =new  SimpleDateFormat();
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)){
			return sdFormat=new SimpleDateFormat("yyyy-MM-dd");
		}else if (Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)) {
			return sdFormat=new SimpleDateFormat("yyyy/MM/dd");
		}else if (Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)) {
			return sdFormat=new SimpleDateFormat("yyyyMMdd");
		}
		return sdFormat;
	}
	
}
