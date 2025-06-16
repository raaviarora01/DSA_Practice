package LinkedList;

class CircularDoublyNode {
    int data;
    CircularDoublyNode next;
    CircularDoublyNode prev;

    public CircularDoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class CircularDoublyLinkedList {
    CircularDoublyNode head, tail;

    public CircularDoublyLinkedList() {
        head = tail = null;
    }

    // Create doubly linked list
    public void createList(int data) {
        CircularDoublyNode newNode = new CircularDoublyNode(data);
        head = tail = newNode;
        newNode.next = newNode.prev = newNode;
    }

    // Insert at beginning
    public void insertAtStart(int data) {
        if (head == null) {
            createList(data);
            return;
        }
        CircularDoublyNode newNode = new CircularDoublyNode(data);
        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        tail.next = newNode;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        if (tail == null) {
            createList(data);
            return;
        }

        CircularDoublyNode newNode = new CircularDoublyNode(data);
        newNode.prev = tail;
        newNode.next = head;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int pos) {
        if (pos == 0) {
            insertAtStart(data);
            return;
        }

        CircularDoublyNode temp = head;
        int i;
        for (i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (i != pos - 1) {
            System.out.println("Position out of bounds");
            return;
        }

        CircularDoublyNode newNode = new CircularDoublyNode(data);
        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
    }

    // Delete from beginning
    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    // Delete from end
    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }

    // Delete from specific position
    public void deleteFromPosition(int pos) {
        if (pos == 0) {
            deleteAtStart();
            return;
        }

        CircularDoublyNode temp = head;
        int i;
        for (i = 0; i < pos && temp.next != head; i++) {
            temp = temp.next;
        }

        if (i != pos) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        if (temp == tail) {
            tail = temp.prev;
        }
    }

    // Delete entire list
    public void deleteEntireList() {
        head = null;
        tail = null;
    }

    // Print the list forward
    public void printForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        CircularDoublyNode temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Print the list backward
    public void printBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        CircularDoublyNode temp = tail;
        do {
            System.out.print(temp.data + "->");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("(back to tail)");
    }

    // Size of list
    public int size() {
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        }
        CircularDoublyNode temp = head;
        int count = 0;
        do {
            temp = temp.next;
            count++;
        } while (temp != head);
        System.out.println("Size of the list : " + count);
        return count;
    }

    // Search in the list
    public boolean search(int key) {
        CircularDoublyNode temp = head;
        int i = 0;
        do {
            if (temp.data == key) {
                System.out.println(key + " is found at location: " + i);
                return true;
            }
            temp = temp.next;
            i++;
        } while (temp != head);

        System.out.println("Node not found!!");
        return false;
    }
}
