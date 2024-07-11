package lab4;
import java.util.Scanner;
public class test_binary_tree {
    public static void main(String[] terminal_arguments) throws Exception {
        
        Scanner terminal_input = new Scanner(System.in);
        binary_tree<Integer> test_tree = new binary_tree<>();
        
        System.out.println("\nТест добавления новых элеметов");
        for (int i = 0; i < terminal_arguments.length; i++)
            test_tree.addValue(Integer.parseInt(terminal_arguments[i]));
        System.out.println("Количество элементов: " + test_tree.getNodesQuantity() + " элементы: " + test_tree);

        System.out.println("\nТест поиска элемента. Введите элемент: ");
        System.out.println(test_tree.IsItHave(terminal_input.nextInt()));

        System.out.println("\nТест поиска максимума и минимума");
        System.out.println("Минимум: " + test_tree.findMin());
        System.out.println("Максимум: " + test_tree.findMax());

        System.out.println("\nТест удаления элемента. Введите, какой элемент нужно удалить: ");
        test_tree.Remove(terminal_input.nextInt());
        System.out.println("Количество элементов: " + test_tree.getNodesQuantity() + " элементы: " + test_tree);

        System.out.println("\nТест сортировки массива");
        Integer[] array_for_sort = new Integer[terminal_arguments.length];
        for (int i = 0; i < terminal_arguments.length; i++)
            array_for_sort[i] = Integer.parseInt(terminal_arguments[i]);
        binary_tree<Integer> sort_tree = new binary_tree<>();
        sort_tree.BSTsort(array_for_sort);
        for (int i = 0; i < array_for_sort.length; i++)
            System.out.printf("%d ", array_for_sort[i]);

        System.out.println("\n\nТест копирования");
        binary_tree<Integer> tree_copy = new binary_tree<>(test_tree);
        System.out.println("Количество элементов: " + tree_copy.getNodesQuantity() + " элементы: " + tree_copy);
        
        System.out.println("\nТест удаления элементов");
        tree_copy.DeleteTree();
        System.out.println("Количество элементов: " + tree_copy.getNodesQuantity() + " элементы: " + tree_copy);
        
        terminal_input.close();
    }
}