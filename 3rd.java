
public class Javabasic {
   public static class Node {
       int data;
       Node next;
       public Node(int data) {
           this.data=data;
           this.next=null;
       }
   }
   public static Node head;
   public static boolean detect(){
       Node slow=head;
       Node fast=head;
       while (fast!=null && fast.next!=null) {
           slow=slow.next;
           fast=fast.next.next;
           if (slow==fast) { 
               return true;
           }
       }
       return false; 
   }
  public static void removeCycle() {
      detect();
      if (fast == null || fast.next == null) {
          System.out.println("No cycle detected to remove.");
          return;
      }
      slow = head;
      Node prev = null; 
      while (slow != fast) {
          prev = fast;
          slow = slow.next;
          fast = fast.next;
      }
      prev.next = null;
      System.out.println("Cycle removed.");
  }
   public static void main(String[] args) {
       Javabasic ll=new Javabasic();
       head=new Node(1);
       head.next=new Node(2);
       head.next.next=new Node(3);
       head.next.next.next=head; 
       System.out.println(detect()); 
       removeCycle();
   }
}
