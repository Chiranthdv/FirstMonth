import java.util.*;
public class Java{
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

  //iteration Search function
public int search(int key){
    Node temp=head;
    int i=0;
    while(temp!=null){
        if(temp.key==key){
            System.out.println(i);
            return;
        }
        temp=temp.next;
        i++
    }
    return -1;
}
//Recursive Search Function
public int recurSearch(int key){
    return helperFun(head,key);
}
public int helperFun(Node head,int key){
    if(head==null){
        return -1;
    }
    if(head.data==key){
        return 0;
    }
    int idx=helper(head.next,key);
    if(idx==-1){
        return -1;
    }
    return idx+1;
}

public static Node prev=null;
public static Node curr=head;
public static Node next=null;

public void reverse(){
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    head=prev;
}

public int middle(Node head){
     Node slow=head;
     Node fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
}
public boolean checkPalin(){
    Node midNode=middle(head);//middle node
    Node prev=null;
    Node curr=midNode;
    Node next=null;
    while(curr!=null){//reverse 2nd half
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    Node right=prev;
    Node left=head;
    while(right!=null){//check 1st half and 2nd half
        if(left.data!=right.data){
            return false;
        }
        left=left.next;
        right=right.next;
    }
    return true;
}

   public static void main(String args[]){
        LinkedList <Integer> ll=new LinkedList<>();
         
   }
}
