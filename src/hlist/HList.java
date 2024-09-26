package hlist;

/**
 *
 * @author Christian Miller
 */
public class HList {
    private HListNode<Object> listHead;
    private HListNode<Object> listTail;
    private int numberOfItems;

    public boolean isListEmpty() {
        return this.listHead == null;
    }

    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    public boolean addItem(Object item) {
        HListNode<Object> newNode = new HListNode<>(item);

        if (isListEmpty()) {
            this.listHead = newNode;
            this.listTail = newNode;
        } else {
            this.listTail.setNextNode(newNode);
            this.listTail = newNode;
        }

        this.numberOfItems++;
        return true;
    }

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
