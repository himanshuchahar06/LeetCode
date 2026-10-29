class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node dummy;
    int size;

    public MyLinkedList() {
        dummy = new Node(0);
        size = 0;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = dummy.next;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void addAtHead(int val) {

        addAtIndex(0, val);
    }

    public void addAtTail(int val) {

        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {

        if (index < 0) {
            index = 0;
        }

        if (index > size) {
            return;
        }

        Node curr = dummy;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        Node newNode = new Node(val);

        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        Node curr = dummy;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */