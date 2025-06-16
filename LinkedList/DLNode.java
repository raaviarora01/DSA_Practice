package LinkedList;

public class DLNode {
    int data;
    DLNode next;
    DLNode prev;

    public DLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DLNode(int data, DLNode next, DLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public static DLNode convertArr2DLL(int[] arr) {
        DLNode head = new DLNode(arr[0]);
        DLNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            DLNode temp = new DLNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}
