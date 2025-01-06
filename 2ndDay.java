public class Java {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    // Add Element at First
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    // Print the Linked List
    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // Add element at the Last of Linked List
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    // Iterative Search Function
    public int search(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println(i);
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    // Recursive Search Function
    public int recurSearch(int key) {
        return helperFun(head, key);
    }

    public int helperFun(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helperFun(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }
    // Reverse the Linked List
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    // Find Middle Node
    public Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Check Palindrome
    public boolean checkPalin() {
        Node midNode = middle(head); // Middle node
        Node prev = null;
        Node curr = midNode;
        Node next = null;

        // Reverse the second half
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // Reversed second half
        Node left = head;
        boolean isPalindrome = true;
        while (right != null) {
            if (left.data != right.data) {
                isPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        // Restore the second half of the list
        curr = prev;
        prev = null;
        next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return isPalindrome;
    }
    public static void main(String args[]) {
        Java ll = new Java();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.print();
        ll.search(4);
        System.out.println(ll.recurSearch(4));
        ll.reverse();
        ll.print();
        System.out.println(ll.checkPalin());
    }
}
