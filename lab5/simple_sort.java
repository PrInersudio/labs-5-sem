package lab5;
import lab3.myVector;
import java.lang.Exception;
public class simple_sort <elements_type extends Comparable<elements_type>> {
    
    private int FindIndexOfMaxElement(elements_type[] array, int start, int end) {
        int index_of_max_element = start;
        for (int i = start+1; i <= end; i++)
            if (array[index_of_max_element].compareTo(array[i]) < 0)
                index_of_max_element = i;
        return index_of_max_element;
    }

    private int FindIndexOfMinElement(elements_type[] array, int start, int end) {
        int index_of_min_element = start;
        for (int i = start+1; i <= end; i++)
            if (array[index_of_min_element].compareTo(array[i]) > 0)
                index_of_min_element = i;
        return index_of_min_element;
    }

    private void SwapElements(elements_type[] array, int index1, int index2) {
        elements_type temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    private void SelectionSortAscending(elements_type[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            int index_of_min_element = FindIndexOfMinElement(array, i, end);
            SwapElements(array, index_of_min_element, i);
        }
    }

    private void SelectionSortDescending(elements_type[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            int index_of_max_element = FindIndexOfMaxElement(array, i, end);
            SwapElements(array, index_of_max_element, i);
        }
    }
    
    public void SelectionSort(elements_type[] array, int start, int end, Boolean ascending) throws Exception {
        if (start < 0)
            throw new Exception("Подпоследовательность массива не может начинаться с отрицательного индекса");
        if (start >= array.length)
            throw new Exception("Подпоследовательность массива не может начинаться с индекса, большего или равного длине массива");
        if (end < 0)
            throw new Exception("Подпоследовательность массива не может заканчиваться на отрицательном индексе");
        if (end >= array.length)
            throw new Exception("Подпоследовательность массива не может заканчиваться на индексе, большем или равном длине массива");
        if (end < start)
            throw new Exception("Подпоследовательность массива не может заканчиваться раньше, чем она начинается (конец не может быть меньше начала)");
        if (ascending == true)
            SelectionSortAscending(array, start, end);
        else
            SelectionSortDescending(array, start, end);
    }

    public void SelectionSort(elements_type[] array, Boolean ascending) throws Exception {
        SelectionSort(array, 0, array.length - 1, ascending);
    }

    private void InsertionSortAscending(elements_type[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++)
            for (int j = i; j > start; j--)
                if (array[j].compareTo(array[j-1])  < 0)
                    SwapElements(array, j, j-1);
                else
                    break;
    }

    private void InsertionSortDescending(elements_type[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++)
            for (int j = i; j > start; j--)
                if (array[j].compareTo(array[j-1])  > 0)
                    SwapElements(array, j, j-1);
                else
                    break;
    }

    public void InsertionSort(elements_type[] array, int start, int end, Boolean ascending) throws Exception {
        if (start < 0)
            throw new Exception("Подпоследовательность массива не может начинаться с отрицательного индекса");
        if (start >= array.length)
            throw new Exception("Подпоследовательность массива не может начинаться с индекса, большего или равного длине массива");
        if (end < 0)
            throw new Exception("Подпоследовательность массива не может заканчиваться на отрицательном индексе");
        if (end >= array.length)
            throw new Exception("Подпоследовательность массива не может заканчиваться на индексе, большем или равном длине массива");
        if (end < start)
            throw new Exception("Подпоследовательность массива не может заканчиваться раньше, чем она начинается (конец не может быть меньше начала)");
        if (ascending == true)
            InsertionSortAscending(array, start, end);
        else
            InsertionSortDescending(array, start, end);
    }

    public void InsertionSort(elements_type[] array, Boolean ascending) throws Exception {
        InsertionSort(array, 0, array.length - 1, ascending);
    }

    private void BubbleSortAscending(elements_type[] array, int start, int end) {
        for (int i = start; i <= end; i++)
            for (int j = start; j < (end + start - i); j++)
                if (array[j].compareTo(array[j+1]) > 0)
                    SwapElements(array, j, j+1);
    }

    private void BubbleSortDescending(elements_type[] array, int start, int end) {
        for (int i = start; i <= end; i++)
            for (int j = start; j < (end + start - i); j++)
                if (array[j].compareTo(array[j+1]) < 0)
                    SwapElements(array, j, j+1);
    }
    
    public void BubbleSort(elements_type[] array, int start, int end, Boolean ascending) throws Exception {
        if (start < 0)
            throw new Exception("Подпоследовательность массива не может начинаться с отрицательного индекса");
        if (start >= array.length)
            throw new Exception("Подпоследовательность массива не может начинаться с индекса, большего или равного длине массива");
        if (end < 0)
            throw new Exception("Подпоследовательность массива не может заканчиваться на отрицательном индексе");
        if (end >= array.length)
            throw new Exception("Подпоследовательность массива не может заканчиваться на индексе, большем или равном длине массива");
        if (end < start)
            throw new Exception("Подпоследовательность массива не может заканчиваться раньше, чем она начинается (конец не может быть меньше начала)");
        if (ascending == true)
            BubbleSortAscending(array, start, end);
        else
            BubbleSortDescending(array, start, end);
    }

    public void BubbleSort(elements_type[] array, Boolean ascending) throws Exception {
        BubbleSort(array, 0, array.length - 1, ascending);
    }



    private int FindIndexOfMaxElement(myVector<elements_type> vector, int start, int end) throws Exception {
        int index_of_max_element = start;
        for (int i = start+1; i <= end; i++)
            if (vector.getElement(index_of_max_element).compareTo(vector.getElement(i)) < 0)
                index_of_max_element = i;
        return index_of_max_element;
    }

    private int FindIndexOfMinElement(myVector<elements_type> vector, int start, int end) throws Exception {
        int index_of_min_element = start;
        for (int i = start+1; i <= end; i++)
            if (vector.getElement(index_of_min_element).compareTo(vector.getElement(i)) > 0)
                index_of_min_element = i;
        return index_of_min_element;
    }

    private void SwapElements(myVector<elements_type> vector, int index1, int index2) throws Exception {
        elements_type temp = vector.getElement(index1);
        vector.AddElement(vector.getElement(index2), index1);
        vector.AddElement(temp, index2);
    }
    
    private void SelectionSortAscending(myVector<elements_type> vector, int start, int end) throws Exception {
        for (int i = start; i < end; i++) {
            int index_of_min_element = FindIndexOfMinElement(vector, i, end);
            SwapElements(vector, index_of_min_element, i);
        }
    }

    private void SelectionSortDescending(myVector<elements_type> vector, int start, int end) throws Exception {
        for (int i = start; i < end; i++) {
            int index_of_max_element = FindIndexOfMaxElement(vector, i, end);
            SwapElements(vector, index_of_max_element, i);
        }
    }
    
    public void SelectionSort(myVector<elements_type> vector, int start, int end, Boolean ascending) throws Exception {
        if (start < 0)
            throw new Exception("Подпоследовательность массива не может начинаться с отрицательного индекса");
        if (start >= vector.getElementsQuantity())
            throw new Exception("Подпоследовательность массива не может начинаться с индекса, большего или равного длине массива");
        if (end < 0)
            throw new Exception("Подпоследовательность массива не может заканчиваться на отрицательном индексе");
        if (end >= vector.getElementsQuantity())
            throw new Exception("Подпоследовательность массива не может заканчиваться на индексе, большем или равном длине массива");
        if (end < start)
            throw new Exception("Подпоследовательность массива не может заканчиваться раньше, чем она начинается (конец не может быть меньше начала)");
        if (ascending == true)
            SelectionSortAscending(vector, start, end);
        else
            SelectionSortDescending(vector, start, end);
    }

    public void SelectionSort(myVector<elements_type> vector, Boolean ascending) throws Exception {
        SelectionSort(vector, 0, vector.getElementsQuantity() - 1, ascending);
    }

    private void InsertionSortAscending(myVector<elements_type> vector, int start, int end) throws Exception {
        for (int i = start + 1; i <= end; i++)
            for (int j = i; j > start; j--)
                if (vector.getElement(j).compareTo(vector.getElement(j-1))  < 0)
                    SwapElements(vector, j, j-1);
                else
                    break;
    }

    private void InsertionSortDescending(myVector<elements_type> vector, int start, int end) throws Exception {
        for (int i = start + 1; i <= end; i++)
            for (int j = i; j > start; j--)
                if (vector.getElement(j).compareTo(vector.getElement(j-1))  > 0)
                    SwapElements(vector, j, j-1);
                else
                    break;
    }

    public void InsertionSort(myVector<elements_type> vector, int start, int end, Boolean ascending) throws Exception {
        if (start < 0)
            throw new Exception("Подпоследовательность массива не может начинаться с отрицательного индекса");
        if (start >= vector.getElementsQuantity())
            throw new Exception("Подпоследовательность массива не может начинаться с индекса, большего или равного длине массива");
        if (end < 0)
            throw new Exception("Подпоследовательность массива не может заканчиваться на отрицательном индексе");
        if (end >= vector.getElementsQuantity())
            throw new Exception("Подпоследовательность массива не может заканчиваться на индексе, большем или равном длине массива");
        if (end < start)
            throw new Exception("Подпоследовательность массива не может заканчиваться раньше, чем она начинается (конец не может быть меньше начала)");
        if (ascending == true)
            InsertionSortAscending(vector, start, end);
        else
            InsertionSortDescending(vector, start, end);
    }

    public void InsertionSort(myVector<elements_type> vector, Boolean ascending) throws Exception {
        InsertionSort(vector, 0, vector.getElementsQuantity() - 1, ascending);
    }

    private void BubbleSortAscending(myVector<elements_type> vector, int start, int end) throws Exception {
        for (int i = start; i <= end; i++)
            for (int j = start; j < (end + start - i); j++)
                if (vector.getElement(j).compareTo(vector.getElement(j+1)) > 0)
                    SwapElements(vector, j, j+1);
    }

    private void BubbleSortDescending(myVector<elements_type> vector, int start, int end) throws Exception {
        for (int i = start; i <= end; i++)
            for (int j = start; j < (end + start - i); j++)
                if (vector.getElement(j).compareTo(vector.getElement(j+1)) < 0)
                    SwapElements(vector, j, j+1);
    }
    
    public void BubbleSort(myVector<elements_type> vector, int start, int end, Boolean ascending) throws Exception {
        if (start < 0)
            throw new Exception("Подпоследовательность массива не может начинаться с отрицательного индекса");
        if (start >= vector.getElementsQuantity())
            throw new Exception("Подпоследовательность массива не может начинаться с индекса, большего или равного длине массива");
        if (end < 0)
            throw new Exception("Подпоследовательность массива не может заканчиваться на отрицательном индексе");
        if (end >= vector.getElementsQuantity())
            throw new Exception("Подпоследовательность массива не может заканчиваться на индексе, большем или равном длине массива");
        if (end < start)
            throw new Exception("Подпоследовательность массива не может заканчиваться раньше, чем она начинается (конец не может быть меньше начала)");
        if (ascending == true)
            BubbleSortAscending(vector, start, end);
        else
            BubbleSortDescending(vector, start, end);
    }

    public void BubbleSort(myVector<elements_type> vector, Boolean ascending) throws Exception {
        BubbleSort(vector, 0, vector.getElementsQuantity() - 1, ascending);
    }
}