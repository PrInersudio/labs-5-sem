package lab3;
import java.lang.Exception;
public class myVector<gen_type> {
    
    private gen_type[] elements;
    private int elements_quantity;
    private int max_elements_quantity;

    public myVector(int max_elements_quantity) {
        this.max_elements_quantity = max_elements_quantity;
        elements = (gen_type[]) new Object[max_elements_quantity];
        elements_quantity = 0;
    }

    public myVector() {
        this(16);
    }

    public myVector(myVector<gen_type> original) {
        this.max_elements_quantity = original.max_elements_quantity;
        this.elements_quantity = original.elements_quantity;
        this.elements = (gen_type[]) new Object[max_elements_quantity];
        for (int i = 0; i < elements_quantity; i++)
            this.elements[i] = original.elements[i];
    }

    private void GrowArray() {
        max_elements_quantity <<= 1;
        gen_type[] new_elements = (gen_type[]) new Object[max_elements_quantity];
        for (int i = 0; i < elements_quantity; i++)
            new_elements[i] = elements[i];
        elements = new_elements;
    }

    public void AddElement(gen_type new_elelment) {
        if (elements_quantity >= max_elements_quantity)
            GrowArray();
        elements[elements_quantity] = new_elelment;
        elements_quantity++;
    }

    public void AddElement(gen_type new_element, int index) throws Exception {
        if (index < 0)
            throw new Exception("Ошибка: индекс не может быть меньше нуля");
        if (index == elements_quantity) {
            AddElement(new_element);
            return;
        }
        if (index > elements_quantity)
            throw new Exception (
                "Ошибка: невозможно поставить данный элемент под номером " + 
                 index + ", так как в данном массиве всего " +
                 elements_quantity + " элементов"
                 );
        elements[index] = new_element;
    }

    public void DeleteElement(int index) throws Exception {
        if (index < 0)
            throw new Exception("Ошибка: индекс не может быть меньше нуля");
        if (index >= elements_quantity)
            throw new Exception (
                "Ошибка: невозможно удалить элемент под номером " + 
                 index + ", так как в данном массиве всего " +
                 elements_quantity + " элементов"
                 );
        elements_quantity--;
        for (int i = index; i < elements_quantity; i++)
            elements[i] = elements[i+1];
        elements[elements_quantity] = null;
    }

    public void DeleteElement() throws Exception {
        DeleteElement(elements_quantity-1);
    }

    public void DeleteVector() {
        for (int i = 0; i < elements_quantity; i++)
            elements[i] = null;
        this.max_elements_quantity = 16;
        elements = (gen_type[]) new Object[max_elements_quantity];
        elements_quantity = 0;
    }

    public int getElementsQuantity() {
        return elements_quantity;
    }

    public int getMaxElementsQuantity() {
        return max_elements_quantity;
    }

    public gen_type getElement(int index) throws Exception {
        if (index < 0)
            throw new Exception("Ошибка: индекс не может быть меньше нуля");
        if (index >= elements_quantity)
        throw new Exception (
            "Ошибка: невозможно получить доступ к элементу под номером " + 
             index + ", так как в данном массиве всего " +
             elements_quantity + " элементов"
             );
        return elements[index];
    }

    public String toString() {
        if (elements_quantity == 0)
            return "Элементов нет";
        String elements_string = new String();
        for (int i = 0; i < elements_quantity; i++)
            elements_string += elements[i].toString() + " ";
        return elements_string;
    }
}