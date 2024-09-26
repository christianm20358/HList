package hlist;

public class Main {

    public static void main(String[] args) {
        HList list = new HList();

        HListNode<Float> floatNode = new HListNode<>(1.55f);
        HListNode<Integer> intNode = new HListNode<>(10);
        HListNode<String> stringNode = new HListNode<>("Hello World");

        list.addItem(floatNode);
        list.addItem(intNode);
        list.addItem(stringNode);

        list.displayList();
    }
}
