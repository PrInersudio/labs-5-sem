package lab5;
import lab1.complex;
import lab3.myVector;
import java.util.Scanner;
import java.lang.Exception;
import java.io.IOException;
public class test_simple_sort {
    
    private static Boolean EnterAscending(Scanner terminal_input) throws Exception, IOException {
        Boolean ascending = false;
        Boolean got_answer = false;
        int tries = 0;
        while (got_answer == false) {
            if (tries >= 5) {
                terminal_input.close();
                throw new IOException("Количество попыток на ввод истекло");
            }
            switch(terminal_input.nextLine()) {
                case "возрастание":
                    ascending = true;
                    got_answer = true;
                    break;
                case "убывание":
                    ascending = false;
                    got_answer = true;
                    break;
                case "выйти":
                    terminal_input.close();
                    throw new Exception("Пользователь инициализировал выход");
                default:
                    System.out.println("Нужно было ввести слово возрастание или слово убывание. Попробуйте ещё раз, либо введите выйти, чтобы выйти");
                    tries++;
                    break;
            }
        }
        return ascending;
    }
    
    public static void main(String[] terminal_arguments) throws Exception {
        if (terminal_arguments.length == 0)
            throw new Exception("В аргументы нужно ввести набор целых чисел");

        
        Integer[] int_array = new Integer[terminal_arguments.length];
        myVector<Integer> vector = new myVector<>();
        for (int i = 0; i < terminal_arguments.length; i++) {
            int_array[i] = Integer.parseInt(terminal_arguments[i]);
            vector.AddElement(Integer.parseInt(terminal_arguments[i]));
        }
        Scanner terminal_input = new Scanner(System.in, "ibm866");
        

        System.out.println("\nТест сортировки массива целых.");
        System.out.println("Как сортировать массив целых? (возрастание или убывание) Или введите выйти, чтобы выйти.");
        Boolean ascending;
        try {
            ascending = EnterAscending(terminal_input);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        catch (Exception e) {
            return;
        }
        

        simple_sort<Integer> sorter = new simple_sort<>();
        Integer[] int_array_for_selection_sort = new Integer[terminal_arguments.length];
        Integer[] int_array_for_insertion_sort = new Integer[terminal_arguments.length];
        Integer[] int_array_for_bubble_sort = new Integer[terminal_arguments.length];
        for (int i = 0; i < terminal_arguments.length; i++) {
            int_array_for_selection_sort[i] = int_array[i];
            int_array_for_insertion_sort[i] = int_array[i];
            int_array_for_bubble_sort[i] = int_array[i];
        }
        System.out.print("Оригинальный массив целых: ");
        for (int i = 0; i < int_array.length; i++)
            System.out.print(int_array[i] + " ");
        sorter.SelectionSort(int_array_for_selection_sort, ascending);
        sorter.InsertionSort(int_array_for_insertion_sort, ascending);
        sorter.BubbleSort(int_array_for_bubble_sort, ascending);
        System.out.println("\nСортировка массива целых:");
        System.out.print("\tСортировка выбором: ");
        for (int i = 0; i < int_array_for_selection_sort.length; i++)
            System.out.print(int_array_for_selection_sort[i] + " ");
        System.out.print("\n\tСортировка вставками: ");
        for (int i = 0; i < int_array_for_insertion_sort.length; i++)
            System.out.print(int_array_for_insertion_sort[i] + " ");
        System.out.print("\n\tСортировка пузырьком: ");
        for (int i = 0; i < int_array_for_bubble_sort.length; i++)
            System.out.print(int_array_for_bubble_sort[i] + " ");

        
        System.out.println("\nКак сортировать подпоследовательность массива целых? (возрастание или убывание) Или введите выйти, чтобы выйти.");
        try {
            ascending = EnterAscending(terminal_input);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        catch (Exception e) {
            return;
        }
        
        System.out.println("Какую подпоследовательность массива целых сортировать? Введите начало и конец. Либо введите выйти, чтобы выйти.");
        for (int i = 0; i < terminal_arguments.length; i++) {
            int_array_for_selection_sort[i] = int_array[i];
            int_array_for_insertion_sort[i] = int_array[i];
            int_array_for_bubble_sort[i] = int_array[i];
        }
        for (int tries = 0; tries <= 5; tries++) {
            if (tries >= 5) {
                terminal_input.close();
                throw new Exception("Количество попыток истекло.");
            }
            if (!terminal_input.hasNextInt()) {
                if(terminal_input.nextLine() == "выйти") {
                    terminal_input.close();
                    return;
                }
                System.out.println("Нужно ввести целое число для продолжения или выйти, чтобы выйти");
                continue;
            }
            int start = terminal_input.nextInt();
            if (!terminal_input.hasNextInt()) {
                if(terminal_input.nextLine() == "выйти") {
                    terminal_input.close();
                    return;
                }
                System.out.println("Нужно ввести целое число для продолжения или выйти, чтобы выйти");
                continue;
            }
            int end = terminal_input.nextInt();
            try {
                sorter.SelectionSort(int_array_for_selection_sort, start, end, ascending);
                sorter.InsertionSort(int_array_for_insertion_sort, start, end, ascending);
                sorter.BubbleSort(int_array_for_bubble_sort, start, end, ascending);
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + " Попробуйте ещё раз. Либо введите выйти, чтобы выйти.");
                continue;
            }
            break;
        }
        terminal_input.nextLine();
        System.out.print("Оригинальный массив целых: ");
        for (int i = 0; i < int_array.length; i++)
            System.out.print(int_array[i] + " ");
        System.out.println("\nСортировка подпоследовательности массива целых:");
        System.out.print("\tСортировка выбором: ");
        for (int i = 0; i < int_array_for_selection_sort.length; i++)
            System.out.print(int_array_for_selection_sort[i] + " ");
        System.out.print("\n\tСортировка вставками: ");
        for (int i = 0; i < int_array_for_insertion_sort.length; i++)
            System.out.print(int_array_for_insertion_sort[i] + " ");
        System.out.print("\n\tСортировка пузырьком: ");
        for (int i = 0; i < int_array_for_bubble_sort.length; i++)
            System.out.print(int_array_for_bubble_sort[i] + " ");


        System.out.println("\n\nТест сортировки вектора целых.");
        System.out.println("Как сортировать вектор? (возрастание или убывание) Или введите выйти, чтобы выйти.");
        try {
            ascending = EnterAscending(terminal_input);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        catch (Exception e) {
            return;
        }

        myVector<Integer> vector_for_selection_sort = new myVector<>(vector);
        myVector<Integer> vector_for_insertion_sort = new myVector<>(vector);
        myVector<Integer> vector_for_bubble_sort = new myVector<>(vector);
        System.out.print("Оригинальный вектор: ");
        System.out.println(vector);
        sorter.SelectionSort(vector_for_selection_sort, ascending);
        sorter.InsertionSort(vector_for_insertion_sort, ascending);
        sorter.BubbleSort(vector_for_bubble_sort, ascending);
        System.out.println("Сортировка вектора:");
        System.out.print("\tСортировка выбором: ");
        System.out.println(vector_for_selection_sort);
        System.out.print("\tСортировка вставками: ");
        System.out.println(vector_for_insertion_sort);
        System.out.print("\tСортировка пузырьком: ");
        System.out.println(vector_for_bubble_sort);

        
        System.out.println("\nКак сортировать подпоследовательность вектора? (возрастание или убывание) Или введите выйти, чтобы выйти.");
        try {
            ascending = EnterAscending(terminal_input);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        catch (Exception e) {
            return;
        }
        
        System.out.println("Какую подпоследовательность вектора сортировать? Введите начало и конец. Либо введите выйти, чтобы выйти.");
        vector_for_selection_sort.DeleteVector();
        vector_for_insertion_sort.DeleteVector();
        vector_for_bubble_sort.DeleteVector();
        vector_for_selection_sort = new myVector<>(vector);
        vector_for_insertion_sort = new myVector<>(vector);
        vector_for_bubble_sort = new myVector<>(vector);
        for (int tries = 0; tries <= 5; tries++) {
            if (tries >= 5) {
                terminal_input.close();
                throw new Exception("Количество попыток истекло.");
            }
            if (!terminal_input.hasNextInt()) {
                if(terminal_input.nextLine() == "выйти") {
                    terminal_input.close();
                    return;
                }
                System.out.println("Нужно ввести целое число для продолжения или выйти, чтобы выйти");
                continue;
            }
            int start = terminal_input.nextInt();
            if (!terminal_input.hasNextInt()) {
                if(terminal_input.nextLine() == "выйти") {
                    terminal_input.close();
                    return;
                }
                System.out.println("Нужно ввести целое число для продолжения или выйти, чтобы выйти");
                continue;
            }
            int end = terminal_input.nextInt();
            try {
                sorter.SelectionSort(vector_for_selection_sort, start, end, ascending);
                sorter.InsertionSort(vector_for_insertion_sort, start, end, ascending);
                sorter.BubbleSort(vector_for_bubble_sort, start, end, ascending);
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + " Попробуйте ещё раз. Либо введите выйти, чтобы выйти.");
                continue;
            }
            break;
        }
        terminal_input.nextLine();
        System.out.print("Оригинальный вектор: ");
        System.out.println(vector);
        System.out.println("Сортировка подпоследовательности вектора:");
        System.out.print("\tСортировка выбором: ");
        System.out.println(vector_for_selection_sort);
        System.out.print("\tСортировка вставками: ");
        System.out.println(vector_for_insertion_sort);
        System.out.print("\tСортировка пузырьком: ");
        System.out.println(vector_for_bubble_sort);


        System.out.println("\n\nТест сортировки массива комплексных чисел по значинию модуля.");
        System.out.println("Введите набор комплексных чисел в формате <вещественная часть> <мнимая часть>. Введите любую строку без чисел, чтобы закончить");
        myVector<Double> double_vector = new myVector<>();
        while(terminal_input.hasNextDouble())
            double_vector.AddElement(terminal_input.nextDouble());
        terminal_input.nextLine();
        if (double_vector.getElementsQuantity() == 0)
            throw new Exception("Не было введено ни одного числа");
        if (double_vector.getElementsQuantity()%2 == 1)
            double_vector.AddElement(0.0);
        complex[] complex_array = new complex[double_vector.getElementsQuantity()/2];
        for (int i = 0; i < complex_array.length; i++)
            complex_array[i] = new complex(double_vector.getElement(2*i), double_vector.getElement(2*i+1));
        double_vector.DeleteVector();

        System.out.println("Как сортировать массив комплексных чисел? (возрастание или убывание) Или введите выйти, чтобы выйти.");
        try {
            ascending = EnterAscending(terminal_input);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        catch (Exception e) {
            return;
        }
        
        complex[] complex_array_for_selection_sort = new complex[complex_array.length];
        complex[] complex_array_for_insertion_sort = new complex[complex_array.length];
        complex[] complex_array_for_bubble_sort = new complex[complex_array.length];
        for (int i = 0; i < complex_array.length; i++) {
            complex_array_for_selection_sort[i] = complex_array[i];
            complex_array_for_insertion_sort[i] = complex_array[i];
            complex_array_for_bubble_sort[i] = complex_array[i];
        }
        System.out.print("Оригинальный массив комплексных чисел: ");
        for (int i = 0; i < complex_array.length; i++)
            System.out.print(complex_array[i] + "  ");
        simple_sort<complex> complex_sorter = new simple_sort<>();
        complex_sorter.SelectionSort(complex_array_for_selection_sort, ascending);
        complex_sorter.InsertionSort(complex_array_for_insertion_sort, ascending);
        complex_sorter.BubbleSort(complex_array_for_bubble_sort, ascending);
        System.out.println("\nСортировка массива комплексных чисел:");
        System.out.print("\tСортировка выбором: ");
        for (int i = 0; i < complex_array_for_selection_sort.length; i++)
            System.out.print(complex_array_for_selection_sort[i] + "  ");
        System.out.print("\n\tСортировка вставками: ");
        for (int i = 0; i < complex_array_for_insertion_sort.length; i++)
            System.out.print(complex_array_for_insertion_sort[i] + "  ");
        System.out.print("\n\tСортировка пузырьком: ");
        for (int i = 0; i < complex_array_for_bubble_sort.length; i++)
            System.out.print(complex_array_for_bubble_sort[i] + "  ");

        System.out.println("\nКак сортировать подпоследовательность массива комплексных чисел? (возрастание или убывание) Или введите выйти, чтобы выйти.");
        try {
            ascending = EnterAscending(terminal_input);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        catch (Exception e) {
            return;
        }
        
        System.out.println("Какую подпоследовательность массива комплексных чисел сортировать? Введите начало и конец. Либо введите выйти, чтобы выйти.");
        for (int i = 0; i < complex_array.length; i++) {
            complex_array_for_selection_sort[i] = complex_array[i];
            complex_array_for_insertion_sort[i] = complex_array[i];
            complex_array_for_bubble_sort[i] = complex_array[i];
        }
        for (int tries = 0; tries <= 5; tries++) {
            if (tries >= 5) {
                terminal_input.close();
                throw new Exception("Количество попыток истекло.");
            }
            if (!terminal_input.hasNextInt()) {
                if(terminal_input.nextLine() == "выйти") {
                    terminal_input.close();
                    return;
                }
                System.out.println("Нужно ввести целое число для продолжения или выйти, чтобы выйти");
                continue;
            }
            int start = terminal_input.nextInt();
            if (!terminal_input.hasNextInt()) {
                if(terminal_input.nextLine() == "выйти") {
                    terminal_input.close();
                    return;
                }
                System.out.println("Нужно ввести целое число для продолжения или выйти, чтобы выйти");
                continue;
            }
            int end = terminal_input.nextInt();
            try {
                complex_sorter.SelectionSort(complex_array_for_selection_sort, start, end, ascending);
                complex_sorter.InsertionSort(complex_array_for_insertion_sort, start, end, ascending);
                complex_sorter.BubbleSort(complex_array_for_bubble_sort, start, end, ascending);
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + " Попробуйте ещё раз. Либо введите выйти, чтобы выйти.");
                continue;
            }
            break;
        }
        terminal_input.nextLine();
        System.out.print("Оригинальный массив комплексных чисел: ");
        for (int i = 0; i < complex_array.length; i++)
            System.out.print(complex_array[i] + "  ");
        System.out.println("\nСортировка подпоследовательности массива комплексных чисел:");
        System.out.print("\tСортировка выбором: ");
        for (int i = 0; i < complex_array_for_selection_sort.length; i++)
            System.out.print(complex_array_for_selection_sort[i] + "  ");
        System.out.print("\n\tСортировка вставками: ");
        for (int i = 0; i < complex_array_for_insertion_sort.length; i++)
            System.out.print(complex_array_for_insertion_sort[i] + "  ");
        System.out.print("\n\tСортировка пузырьком: ");
        for (int i = 0; i < complex_array_for_bubble_sort.length; i++)
            System.out.print(complex_array_for_bubble_sort[i] + "  ");


        terminal_input.close();
    }
}
