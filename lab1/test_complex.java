package lab1;
import java.util.Scanner;
public class test_complex
{
	public static void main (String[] args)
	{
		double RePar, ImPar, DegIndex;
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите вещественную, мнимую часть и показатель степени");
		RePar = sc.nextDouble();
		ImPar = sc.nextDouble();
		DegIndex = sc.nextDouble();
		sc.close();
		complex z = new complex(RePar, ImPar);
		System.out.println("Ваше число: " + z.Re + " " + z.Im);
		System.out.println("Модуль: " + z.abs() + " Аргумент: " + z.arg());
		complex w = z.pow(DegIndex);
		System.out.println("Число в степени: " + w.Re + " " + w.Im);
		complex sum = z.sum(w);
		System.out.println("Сумма: " + sum.Re + " " + sum.Im);
		complex dif = sum.dif(z);
		System.out.println("Разность: " + dif.Re + " " + dif.Im);
		complex mul = z.mul(w);
		System.out.println("Произведение: " + mul.Re + " " + mul.Im);
		complex div = w.div(z);
		System.out.println("Частное: " + div.Re + " " + div.Im);
	}
}