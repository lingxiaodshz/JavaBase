package annotation;

import annotation.CarColor.Color;

public class JiliCar {
	@CarName(value = "����")
	private String carName;
	@CarColor(getCarColor = Color.RED)
	private Color carColor;

	@Override
	public String toString() {
		String color = "��ɫ";
		switch (carColor) {
		case RED:
			color = "��ɫ";
			break;
		case GREEN:
			color = "��ɫ";
			break;
		case BLUE:
			color = "��ɫ";
			break;
		}
		String str = carName + ", ��ɫ��" + color;
		return str;
	}

	public JiliCar() {
		super();
		CarAnnotationUtil.getCarInfo(getClass(), this);
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	// ע��������ڲ�����ʹ�ã�������ע������ʱ��Target�����ElementType.PARAMETER
	public void setCarColor(@CarColor Color carColor) {
		this.carColor = carColor;
	}

}
