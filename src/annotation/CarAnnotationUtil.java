package annotation;

import java.lang.reflect.Field;

import annotation.CarColor.Color;

public class CarAnnotationUtil {
	public static void getCarInfo(Class<?> clazz, Object object) {
		String carNameStr = "汽车品牌是:";

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(CarName.class)) {
				CarName carName = field.getAnnotation(CarName.class);
				carNameStr = carNameStr + carName.value();
				if (object instanceof JiliCar) {
					try {
						// 注意获取private变量值时是不需要设置的，但是set值时必须先设置这个选项才可以
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
