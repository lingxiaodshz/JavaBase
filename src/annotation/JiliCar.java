package annotation;

import annotation.CarColor.Color;

public class JiliCar {
	@CarName(value = "吉利")
	private String carName;
	@CarColor(getCarColor = Color.RED)
	private Color carColor;

	@Override
	public String toString() {
		String color = "红色";
		switch (carColor) {
		case RED:
			color = "红色";
			break;
		case GREEN:
			color = "绿色";
			break;
		case BLUE:
			color = "蓝色";
			break;
		}
		String str = carName + ", 颜色是" + color;
		return str;
	}

	public JiliCar() {
		super();
		CarAnnotationUtil.getCarInfo(getClass(), this);
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	// 注意如果想在参数上使用，必须在注解声明时在Target中添加ElementType.PARAMETER
	public void setCarColor(@CarColor Color carColor) {
		this.carColor = carColor;
	}

}
