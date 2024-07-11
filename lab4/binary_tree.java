package lab4;
import java.lang.Exception;
public class binary_tree<value_type extends Comparable<value_type>> {

    private class Node {

        public value_type value;
        public Node left_descendant;
        public Node right_descendant;

        public Node(value_type value) {
            this.value = value;
            left_descendant = null;
            right_descendant = null;
        }

        public void clear() {
            value = null;
            left_descendant = null;
            right_descendant = null;
        }
    }

    private Node root;
    private int nodes_quantity;

    public binary_tree() {
        root = null;
        nodes_quantity = 0;
    }

    public void addValue(value_type new_value) throws Exception {
        if (root == null) {
            root = new Node(new_value);
            nodes_quantity++;
            return;
        }
        Node cur_node = root;
        Node next_node = root;
        while (next_node != null) {
            if (new_value.compareTo(next_node.value) == 0)
                throw new Exception("Данная реализация бинарного дерева не позволяет хранить равные значения");
            cur_node = next_node;
            if (new_value.compareTo(next_node.value) > 0)
                next_node = next_node.right_descendant;
            else
                next_node = next_node.left_descendant;
        }
        if (new_value.compareTo(cur_node.value) > 0)
            cur_node.right_descendant = new Node(new_value);
        else
            cur_node.left_descendant = new Node(new_value);
        nodes_quantity++;
    }

    private void copyTree(Node copy, Node original) {
        copy.value = original.value;
        if (original.right_descendant != null) {
            copy.right_descendant = new Node(null);
            copyTree(copy.right_descendant, original.right_descendant);
        }
        if (original.left_descendant != null) {
            copy.left_descendant = new Node(null);
            copyTree(copy.left_descendant, original.left_descendant);
        }
    }
    
    public binary_tree(binary_tree<value_type> original) {
        this();
        if (original.root == null)
            return;
        this.nodes_quantity = original.nodes_quantity;
        this.root = new Node(null);
        copyTree(this.root, original.root);
    }

    public boolean IsItHave(value_type desired_value) {
        Node node = root;
        while(node != null) {
            if (desired_value.compareTo(node.value) == 0)
                return true;
            if (desired_value.compareTo(node.value) > 0)
                node = node.right_descendant;
            else
                node = node.left_descendant;
        }
        return false;
    }

    private void DeleteTree(Node node) {
        if (node == null)
            return;
        DeleteTree(node.left_descendant);
        DeleteTree(node.right_descendant);
        node.clear();
    }
    
    public void DeleteTree() {
        DeleteTree(root);
        root = null;
        nodes_quantity = 0;
    }

    public value_type findMin() {
        Node node = root;
        while (node.left_descendant != null)
            node = node.left_descendant;
        return node.value;
    }

    public value_type findMax() {
        Node node = root;
        while (node.right_descendant != null)
            node = node.right_descendant;
        return node.value;
    }

    public void Remove(value_type removed_value) throws Exception {
        
        Node ancestor_of_removed_node = root;
        Node removed_node = root;

        while(removed_node != null) {
            if (removed_value.compareTo(removed_node.value) == 0)
                break;
            ancestor_of_removed_node = removed_node;
            if (removed_value.compareTo(removed_node.value) > 0)
                removed_node = removed_node.right_descendant;
            else
                removed_node = removed_node.left_descendant;
        }

        if (removed_node == null)
            throw new Exception("Данного значения и так не было в узле");

        if (removed_node.left_descendant == null) {
            if (ancestor_of_removed_node.left_descendant == removed_node)
                ancestor_of_removed_node.left_descendant = removed_node.right_descendant;
            else
                ancestor_of_removed_node.right_descendant = removed_node.right_descendant;
            removed_node.clear();
            nodes_quantity--;
            return;
        }

        if (removed_node.right_descendant == null) {
            if (ancestor_of_removed_node.left_descendant == removed_node)
                ancestor_of_removed_node.left_descendant = removed_node.left_descendant;
            else
                ancestor_of_removed_node.right_descendant = removed_node.left_descendant;
            removed_node.clear();
            nodes_quantity--;
            return;
        }

        Node node_before_biggest = removed_node.left_descendant;
        Node biggest_node_in_left_descendant = removed_node.left_descendant;

        while (biggest_node_in_left_descendant.right_descendant != null) {
            node_before_biggest = biggest_node_in_left_descendant;
            biggest_node_in_left_descendant = biggest_node_in_left_descendant.right_descendant;
        }
        if (node_before_biggest.right_descendant != null) { // случай, когда while хотя бы один раз сработал
            removed_node.value = biggest_node_in_left_descendant.value;
            node_before_biggest.right_descendant.clear();
            node_before_biggest.right_descendant = null;
        }
        else { // случай, когда мы сразу наткнулись на самый большой элемент и while ни разу не сработал
            biggest_node_in_left_descendant.right_descendant = removed_node.right_descendant;
            if (ancestor_of_removed_node.right_descendant == removed_node)
                ancestor_of_removed_node.right_descendant = biggest_node_in_left_descendant;
            else
                ancestor_of_removed_node.left_descendant = biggest_node_in_left_descendant;
            removed_node.clear();
        }
        nodes_quantity--;
    }

    private int BSTsort(Node node, value_type[] array, int index) {
        if (node == null)
            return index;
        index = BSTsort(node.left_descendant, array, index);
        array[index] = node.value;
        index++;
        index = BSTsort(node.right_descendant, array, index);
        return index;
    }
    
    public void BSTsort(value_type[] array) throws Exception {
        if (nodes_quantity != 0)
            throw new Exception("Попытка использовать для сортировки не пустое дерево");
        for (int i = 0; i < array.length; i++)
            addValue(array[i]);
        BSTsort(root, array, 0);
    }

    private String formString(Node node) {
        if (node == null)
            return "";
        String new_values = formString(node.left_descendant);
        new_values += node.value + " ";
        new_values += formString(node.right_descendant);
        return new_values;
    }
    
    public String toString() {
        if (nodes_quantity == 0)
            return "Дерево пустое";
        return formString(root);
    }

    public int getNodesQuantity() {
        return nodes_quantity;
    }
}