package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectTest {

	public static void main(String[] args) {
		Student student = new Student("xiaoming", 15);
		Class clazz = student.getClass();

		// 返回所有当前类的成员变量，包括private和public,但是不包括父类的
		Field[] fields = clazz.getDeclaredFields();

		// 返回所有public属性的成员变量，包括父类的
		// Field[] fields = clazz.getFields();

		for (Field field : fields) {
			String key = field.getName();
			System.out.println(key);
		}

		// 获取到父类，从而获取到父类的类成员变量
		// Class superClazz = clazz.getSuperclass();
		// Field[] superFields = superClazz.getDeclaredFields();
		// for (Field field : superFields) {
		// String key = field.getName();
		// System.out.println(key);
		// }

		// 获取所有类成员变量，包括父类的
		Field[] allFields = getAllFields(student);
		for (Field field : allFields) {
			String key = field.getName();
			System.out.println(key);
		}

		// 会返回所有方法，包括公有和私有，不包括父类
		// Method[] methods = clazz.getDeclaredMethods();

		// 会返回所有公有方法，包括父类，甚至包括Object类中的公有方法
		// Method[] methods = clazz.getMethods();

		// 获取所有的方法名
		Method[] methods = getAllMethods(student);
		for (Method method : methods) {
			System.out.println(method.getName());
		}

		// 反射调用getName方法
		try {
			// 注意此处带参数的方法，getMethod的第二个参数是方法参数类型的数组
			// Method method1 = clazz.getMethod("setName",String.class);
			// 注意只能用int.class，不能使用Integerl.class
			Method method1 = clazz.getMethod("setNameAndAge", new Class[] { String.class, int.class });
			method1.invoke(student, "zhangsan", 18);
			Method method2 = clazz.getMethod("getName");
			System.out.println(method2.invoke(student));
			Method method3 = clazz.getMethod("getAge");
			System.out.println(method3.invoke(student));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	// 获取当前类及所有父类的成员变量包括private属性的，注意父类会包括Object类的，但是Object类中没有类成员变量
	public static Field[] getAllFields(Object object) {
		Class clazz = object.getClass();
		if (clazz == Object.class) {
			return clazz.getDeclaredFields();
		}
		List<Field> fieldList = new ArrayList<>();
		// 需要增加不等于Object.class类的判断
		while (clazz != null && clazz != Object.class) {
			// System.out.println(clazz.getName());
			fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		Field[] fields = new Field[fieldList.size()];
		fieldList.toArray(fields);
		return fields;
	}

	public static Method[] getAllMethods(Object object) {
		Class clazz = object.getClass();
		if (clazz == Object.class) {
			return clazz.getDeclaredMethods();
		}
		List<Method> methodList = new ArrayList<>();
		while (clazz != null && clazz != Object.class) {
			methodList.addAll(Arrays.asList(clazz.getDeclaredMethods()));
			clazz = clazz.getSuperclass();
		}
		Method[] methods = new Method[methodList.size()];
		return methodList.toArray(methods);
	}
}
