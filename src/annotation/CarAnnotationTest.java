package annotation;

import annotation.CarColor.Color;

public class CarAnnotationTest {

	public static void main(String[] args) {
		JiliCar car = new JiliCar();
		car.setCarColor(Color.GREEN);
		// ����ڴ���������Ʒ�����ƣ�����ע���������ӵ�"����Ʒ����:"�Ͳ���������
		// car.setCarName("����");
		System.out.println(car);
		car.setCarColor(Color.BLUE);
		System.out.println(car);
	}

}
