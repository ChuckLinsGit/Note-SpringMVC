package annotation.entity;

public class student {
	
	private String name;
	private Integer age;
	private School school;
	
	
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public student(String name, Integer age, School school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
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


	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}


	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}

	
}
