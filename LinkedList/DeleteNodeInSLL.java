package LinkedList;

public class DeleteNodeInSLL {
    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
