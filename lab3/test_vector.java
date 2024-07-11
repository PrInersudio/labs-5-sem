package lab3;
import java.lang.Exception;
import java.util.Scanner;
public class test_vector {
    public static void main(String[] terminal_arguments) throws Exception {
        
        Scanner terminal_input = new Scanner(System.in);
        myVector<Integer> test_vector = new myVector<>();
        
        System.out.println("\nТест добавления элементов в конец списка:");
        for (int i = 0; i < terminal_arguments.length; i++)
            test_vector.AddElement(Integer.parseInt(terminal_arguments[i]));
        System.out.println(
            "количество: " + test_vector.getElementsQuantity() +
            " макс. количество: " + test_vector.getMaxElementsQuantity() +
            " значения: " + test_vector + '\n'
            );
        
        System.out.println("Тест добавления элемета по индексу. Введите элемент и индекс:");
        test_vector.AddElement(terminal_input.nextInt(), terminal_input.nextInt());
        System.out.println(
            "количество: " + test_vector.getElementsQuantity() +
            " макс. количество: " + test_vector.getMaxElementsQuantity() +
            " значения: " + test_vector + '\n'
            );

        System.out.println("Тест вывода элемента по индексу. Введите номер элемента: ");
        System.out.println("Ваш элемент: " + test_vector.getElement(terminal_input.nextInt()) + '\n');
        
        System.out.println("Тест удаления по индексу. Введите номер элемента: ");
        test_vector.DeleteElement(terminal_input.nextInt());
        System.out.println(
            "количество: " + test_vector.getElementsQuantity() +
            " макс. количество: " + test_vector.getMaxElementsQuantity() +
            " значения: " + test_vector + '\n'
            );
        
        System.out.println("Тест удаления последнего элемента: ");
        test_vector.DeleteElement();
        System.out.println(
            "количество: " + test_vector.getElementsQuantity() +
            " макс. количество: " + test_vector.getMaxElementsQuantity() +
            " значения: " + test_vector + '\n'
            );

        System.out.println("Тест конструктора копирования: ");
        myVector<Integer> new_vector = new myVector<>(test_vector);
        System.out.println(
            "количество: " + new_vector.getElementsQuantity() +
            " макс. количество: " + new_vector.getMaxElementsQuantity() +
            " значения: " + new_vector + '\n'
            );

        System.out.println("Тест удаления всех элементов: ");
        test_vector.DeleteVector();
        System.out.println(
            "количество: " + test_vector.getElementsQuantity() +
            " макс. количество: " + test_vector.getMaxElementsQuantity() +
            " значения: " + test_vector + '\n'
            );

        terminal_input.close();
    }  
}
