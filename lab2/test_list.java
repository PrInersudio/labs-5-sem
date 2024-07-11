package lab2;
import javax.security.auth.DestroyFailedException;
import java.util.Scanner;

public class test_list
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		myList<Integer> new_list = new myList<Integer>();
		for (int i = 0; i < args.length; i++)
			new_list.AddLast(Integer.parseInt(args[i]));
		System.out.println("Тест добавления новых элементов в конец списка");
		System.out.println("Кол-во: " + new_list.getQuan() + " Значения: " + new_list.toString());
		myList<Integer> newer_list = new myList<Integer>(new_list);
		System.out.println("Тест копирования");
		System.out.println("Кол-во: " + newer_list.getQuan() + " Значения: " + newer_list.toString());
		System.out.println("Тест удаления первого элемента");
		try
		{
			newer_list.DelFirst();
		}
		catch (DestroyFailedException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Кол-во: " + newer_list.getQuan() + " Значения: " + newer_list.toString());
		System.out.println("Тест удаления последнего элемента");
		try
		{
			newer_list.DelLast();
		}
		catch (DestroyFailedException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Кол-во: " + newer_list.getQuan() + " Значения: " + newer_list.toString());
		System.out.println("Тест удаления заданного элемента");
		try
		{
			newer_list.DelData(sc.nextInt());
		}
		catch (DestroyFailedException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Кол-во: " + newer_list.getQuan() + " Значения: " + newer_list.toString());
		System.out.println("Тест очистки");
		newer_list.Del();
		System.out.println("Кол-во: " + newer_list.getQuan() + " Значения: " + newer_list.toString());
		System.out.println("Тест добавления новых элементов в начало списка (4 элемента)");
		for (int i = 0; i < 4; i++)
			newer_list.AddFirst(sc.nextInt());
		System.out.println("Кол-во: " + newer_list.getQuan() + " Значения: " + newer_list.toString());
		sc.close();
	}
}