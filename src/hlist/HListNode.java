package hlist;

/**
 *
 * @author christian Miller
 * @version 1.0 26-Sep-2024
 * @param <T> The type of element stored in the Node.
 */
public class HListNode<T> {

    /**
     * The next element in the list
     */
    public HListNode<Object> next;

    /**
     * The element stored in this node
     */
    private T data;

    /**
     * Default constructor for the heterogynous list
     */
    public HListNode() {
        this.data = null;
    }

    /**
     *
     * @param item The element to be stored in the node.
     */
    public HListNode(T item) {
        this.data = item;
    }

    /**
     *
     * @return The object reference stored in the node.
     */
    public T getNodeData() {
        return this.data;
    }

    /**
     *
     * @param item The value to set for this node.
     */
    public void setNodeData(T item) {
        this.data = item;
    }

    /**
     *
     * @return The reference to the node pointed at by this node.
     */
    public HListNode<Object> getNextNode() {
        return this.next;
    }

    /**
     *
     * @param node The node reference this node will be pointing at.
     */
    public void setNextNode(HListNode<Object> node) {
        this.next = node;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
