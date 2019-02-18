package coreTechnology.handler.dataConvert;

import java.text.ParseException;	
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

/**
 * DateConverter����ת������ʽ
 * @author www25
 *
 */
public class DateConvert implements Converter<String, Date> {

	/**
	 * ��������ת��������springĬ��ֻʶ��yyyy/MM/dd��ʽ�����ڣ������Ҫ��չ������ʽ��������ʽ
	 */
	@Override
	public Date convert(String source) {
		SimpleDateFormat sdFormat =getDateFormat(source);
		try {
			return sdFormat.parse(source);
		} catch (ParseException e) {
//			e.printStackTrace();
			//parseException�ڴ��ѱ����������׳�һ��TypeMismatchException���쳣����������
			throw new TypeMismatchException("", Date.class);
		}
	}

	/**
	 * ����������ʽʶ�����������ʽ
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
