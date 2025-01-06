import java.util.*;
public  class Javabasic{
     public static class Node {
            int data;
            Node next;
            public Node(int data){
               this.data=data;
               this.next=null;
            }
     }
public static Node head;
public static Node tail;
public static int size;
//Add Element at First
public void addFirst(int data){
      Node newNode=new Node(data);
      size++;
      if(head==null){
         head=tail=newNode;
         return;
      }
      newNode.next=head;
      head=newNode;
 }
 //Print the Linked List
public void print(){
   if(head==null){
      System.out.println("LL is empty");
   }
   Node temp=head;
   while(temp!=null){
      System.out.print(temp.data+"->");
      temp=temp.next;
   }
   System.out.println("null");
 }
 //Add element at the Last of Linked List
public void addLast(int data){
   Node newNode=new Node(data);
   size++;
   if(head==null){
      head=tail=newNode;
   }
   tail.next=newNode;
   tail=newNode;
 }
 //Add Element at the given index
 public void addMiddle(int data,int index){
      if(index==0){
         addFirst(data);
      }
      Node newNode=new Node(data);
      size++;
      Node temp=head;
      int i=0;
      while(i<index-1){
         temp=temp.next;
         i++;
      }
      newNode.next=temp.next;
      temp.next=newNode;
 }
//Removing the element from the first
public void removeFirst(){
   if(size==0){
      System.out.println("LL is empty");
   }
   else if(size==1){
      int val=head.data;
      head=tail=null;
      System.out.println("The removed element is"+val);
   }
   else{
      int val=head.data;
      head=head.next;
      size--;
      System.out.println("The removed element is "+val);
   }
}
//Removing the element from the Last
public void removedLast(){
   if(size==0){
      System.out.println("LL is empty");
   }
   else if(size==1){
      int val=head.data;
      head=tail=null;
      System.out.println("The removed element is "+val);
   }else{
      Node prev=head;
      for(int i=0;i<size-2;i++){
         prev=prev.next;
      }
      int val=prev.next.data;
      prev.next=null;
      tail=prev;
      size--;
      System.out.println("The removed element is "+val);
   }
}
public void removedMiddle(int index){
   if(size==0){
      System.out.println("LL is empty");
   }
   else if(size==1){
      removeFirst();
   }
   else{
      Node prev=head;
      int i=0;
      while(i<index-1){
         prev=prev.next;
         i++;
      }
      prev.next=prev.next.next;
      size--;
   }
}
public static void main(String[] args) {
      Javabasic ll=new Javabasic();
      ll.addFirst(2);
      ll.addFirst(1);
      ll.addLast(4);
      ll.addLast(5);
      ll.addLast(6);
      ll.addLast(7);
      ll.addLast(8);
      ll.addMiddle(3,2);
      ll.print();
      System.out.println(size);
      //ll.removeFirst();
      //ll.removedLast();
      ll.removedMiddle(5);
      ll.print();
      System.out.println(size);
      }
}
