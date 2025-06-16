package LinkedList;

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DoublyNode head, tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    // Create doubly linked list
    public void createList(int data) {
        DoublyNode newNode = new DoublyNode(data);
        head = tail = newNode;
    }

    // Insert at beginning
    public void insertAtStart(int data) {
        if (head == null) {
            createList(data);
            return;
        }
        DoublyNode newNode = new DoublyNode(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        if (tail == null) {
            createList(data);
            return;
        }

        DoublyNode newNode = new DoublyNode(data);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int pos) {
        if (pos == 0) {
            insertAtStart(data);
            return;
        }

        DoublyNode newNode = new DoublyNode(data);
        DoublyNode temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.prev = temp;
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
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
        head.prev = null;
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
        tail.next = null;
    }

    // Delete from specific position
    public void deleteFromPosition(int pos) {
        if (pos == 0) {
            deleteAtStart();
            return;
        }

        DoublyNode temp = head;
        for (int i = 0; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        temp.prev.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
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
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Print the list backward
    public void printBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DoublyNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Size of list
    public int size() {
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        }
        DoublyNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        System.out.println("Size of the list : " + count);
        return count;
    }

    // Search in the list
    public boolean search(int key) {
        DoublyNode temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println(key + " is found at location: " + i);
                return true;
            }
            temp = temp.next;
            i++;
        }

        System.out.println("Node not found!!");
        return false;
    }
}
