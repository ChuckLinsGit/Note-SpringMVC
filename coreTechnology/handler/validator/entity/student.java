package coreTechnology.handler.validator.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class student {
	@NotNull(message="�û�������Ϊ��")
	@Size(min=3,max=5,message="���ȱ�����{min}-{max}֮��")
	private String name;
	
	@Min(value=10,message="���䲻��С��{value}")
	@Max(value=30,message="���䲻�ܴ���{value}")
	private Integer age;
	
	@NotNull(message="�ֻ����벻��Ϊ��")
	@Pattern(regexp="^1[34578]\\d{9}$",message="�ֻ���ʽ����Ϊ1(34578)XXXXXXXXX")
	private String mobile;
	
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public student(String name, Integer age, String mobile) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}


	
}
