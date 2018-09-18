package reflect;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class Student extends People {

	public Student(String name, int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		String str = getName() + "   " + getAge();
		return str;
	}
	
	
	private void say() {
	
	}
}
