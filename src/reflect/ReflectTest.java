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

		// �������е�ǰ��ĳ�Ա����������private��public,���ǲ����������
		Field[] fields = clazz.getDeclaredFields();

		// ��������public���Եĳ�Ա���������������
		// Field[] fields = clazz.getFields();

		for (Field field : fields) {
			String key = field.getName();
			System.out.println(key);
		}

		// ��ȡ�����࣬�Ӷ���ȡ����������Ա����
		// Class superClazz = clazz.getSuperclass();
		// Field[] superFields = superClazz.getDeclaredFields();
		// for (Field field : superFields) {
		// String key = field.getName();
		// System.out.println(key);
		// }

		// ��ȡ�������Ա���������������
		Field[] allFields = getAllFields(student);
		for (Field field : allFields) {
			String key = field.getName();
			System.out.println(key);
		}

		// �᷵�����з������������к�˽�У�����������
		// Method[] methods = clazz.getDeclaredMethods();

		// �᷵�����й��з������������࣬��������Object���еĹ��з���
		// Method[] methods = clazz.getMethods();

		// ��ȡ���еķ�����
		Method[] methods = getAllMethods(student);
		for (Method method : methods) {
			System.out.println(method.getName());
		}

		// �������getName����
		try {
			// ע��˴��������ķ�����getMethod�ĵڶ��������Ƿ����������͵�����
			// Method method1 = clazz.getMethod("setName",String.class);
			// ע��ֻ����int.class������ʹ��Integerl.class
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

	// ��ȡ��ǰ�༰���и���ĳ�Ա��������private���Եģ�ע�⸸������Object��ģ�����Object����û�����Ա����
	public static Field[] getAllFields(Object object) {
		Class clazz = object.getClass();
		if (clazz == Object.class) {
			return clazz.getDeclaredFields();
		}
		List<Field> fieldList = new ArrayList<>();
		// ��Ҫ���Ӳ�����Object.class����ж�
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
