package coreTechnology.handler.dataConvert;

import java.text.ParseException;	
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

/**
 * DateConverter类型转换器方式
 * @author www25
 *
 */
public class DateConvert implements Converter<String, Date> {

	/**
	 * 日期类型转换函数：spring默认只识别yyyy/MM/dd形式的日期，因此需要扩展其他形式的日期形式
	 */
	@Override
	public Date convert(String source) {
		SimpleDateFormat sdFormat =getDateFormat(source);
		try {
			return sdFormat.parse(source);
		} catch (ParseException e) {
//			e.printStackTrace();
			//parseException在此已被处理，可以抛出一个TypeMismatchException被异常处理器处理
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
