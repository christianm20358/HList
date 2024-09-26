package hlist;

/**
 * A list that allows storage of heterogynous elements.
 *
 * @author Christian Miller
 * @version 1.0 26-Sep-2024
 */
public class HList {
    /**
     * The element at the beginning of the list.
     */
    private HListNode<Object> listHead;
    /**
     * The element at the end of the list.
     */
    private HListNode<Object> listTail;
    /**
     * The number of items contained in the list.
     */
    private int numberOfItems;

    /**
     * Determine if the list has any elements stored.
     *
     * @return true if the list is empty, otherwise false.
     */
    public boolean isListEmpty() {
        return this.listHead == null;
    }

    /**
     *
     * @return The number of elements in the list.
     */
    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    /**
     * Adds an object to the end of the list.
     *
     * @param item The item to be stored at the end of the list.
     */
    public void addItem(Object item) {
        HListNode<Object> newNode = new HListNode<>(item);

        if (isListEmpty()) {
            this.listHead = newNode;
            this.listTail = newNode;
        } else {
            this.listTail.setNextNode(newNode);
            this.listTail = newNode;
        }

        this.numberOfItems++;
    }

    /**
     * Removes the object matching the input item, or null if no matching items
     * are found.
     *
     * @param value The object matching the element being searched for.
     * @return The object reference matching the input value, or null.
     */
    public Object removeItem(Object value) {
        HListNode<Object> current = this.listHead;
        HListNode<Object> previous = null;

        while (current != null) {
            Object obj = current.getNodeData();
            if (obj != null && obj.equals(value)) {
                if (this.listHead.equals(value)) {
                    this.listHead = current.getNextNode();
                } else if (previous.equals(this.listTail)) {
                    this.listTail = previous;
                } else {
                    previous.setNextNode(current.getNextNode());
                }
                this.numberOfItems--;
                return obj;
            }
            previous = current;
            current = current.getNextNode();
        }

        return null;
    }

    /**
     * Displays all the elements in the list, printing to stdout.
     */
    public void displayList() {
        System.out.println("Displaying Heterogynous List");

        if (isListEmpty()) {
            System.out.println("\tThe List is Empty");
            return;
        }

        int listIndex = 0;
        HListNode<Object> current = this.listHead;

        while (current != null) {
            Object obj = current.getNodeData();
            if (obj != null) {
                System.out.printf("Item %d: %s\n", listIndex, obj);
            }
            current = current.getNextNode();
            listIndex++;
        }
    }
}
