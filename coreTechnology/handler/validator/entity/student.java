package coreTechnology.handler.validator.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class student {
	@NotNull(message="用户名不能为空")
	@Size(min=3,max=5,message="长度必须在{min}-{max}之间")
	private String name;
	
	@Min(value=10,message="年龄不能小于{value}")
	@Max(value=30,message="年龄不能大于{value}")
	private Integer age;
	
	@NotNull(message="手机号码不能为空")
	@Pattern(regexp="^1[34578]\\d{9}$",message="手机格式必须为1(34578)XXXXXXXXX")
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
