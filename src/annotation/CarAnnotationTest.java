package annotation;

import annotation.CarColor.Color;

public class CarAnnotationTest {

	public static void main(String[] args) {
		JiliCar car = new JiliCar();
		car.setCarColor(Color.GREEN);
		// 如果在此设置汽车品牌名称，则在注解解析中添加的"汽车品牌是:"就不会再有了
		// car.setCarName("长安");
		System.out.println(car);
		car.setCarColor(Color.BLUE);
		System.out.println(car);
	}

}
