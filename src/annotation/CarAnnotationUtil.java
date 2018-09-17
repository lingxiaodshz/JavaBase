package annotation;

import java.lang.reflect.Field;

import annotation.CarColor.Color;

public class CarAnnotationUtil {
	public static void getCarInfo(Class<?> clazz, Object object) {
		String carNameStr = "����Ʒ����:";

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(CarName.class)) {
				CarName carName = field.getAnnotation(CarName.class);
				carNameStr = carNameStr + carName.value();
				if (object instanceof JiliCar) {
					try {
						// ע���ȡprivate����ֵʱ�ǲ���Ҫ���õģ�����setֵʱ�������������ѡ��ſ���
						field.setAccessible(true);
						field.set(object, carNameStr);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			if (field.isAnnotationPresent(CarColor.class)) {
				CarColor carColor = field.getAnnotation(CarColor.class);
				Color color = carColor.getCarColor();
				if (object instanceof JiliCar) {
					try {
						field.setAccessible(true);
						field.set(object, color);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
