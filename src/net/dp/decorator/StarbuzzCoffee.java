package net.dp.decorator;

import net.dp.decorator.coffee.DarkRoast;
import net.dp.decorator.coffee.Espresso;
import net.dp.decorator.coffee.HouseBlend;
import net.dp.decorator.flovoring.Mocha;
import net.dp.decorator.flovoring.Soy;
import net.dp.decorator.flovoring.Whip;

public class StarbuzzCoffee {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new DarkRoast();
//		beverage2 = new Mocha(beverage2);
		//这里传入的beverage2不是Beverage beverage2 = new DarkRoast();而是经过修饰后的beverage2 = new Mocha(beverage2);每次传入的都是经过修饰后的
//		beverage2 = new Mocha(new Mocha(beverage2));
		//如果要一个对象可以被装饰，辣么这个可以被装饰的对象必须要接收一个父类的引用
		beverage2 = new Whip(new Mocha(new Mocha(beverage2)));
		System.out
				.println(beverage2.getDescription() + " $" + beverage2.cost());

		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage2);
		beverage3 = new Mocha(beverage2);
		beverage3 = new Whip(beverage2);
		System.out
				.println(beverage3.getDescription() + " $" + beverage3.cost());
	}
}
