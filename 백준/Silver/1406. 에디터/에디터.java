import java.io.*;
import java.util.*;

class Node{
    char data;
    Node left;
    Node right;
    Node(){}
    Node(char data){
        this.data = data;
    }
}
class LinkedList{
    Node head;
    Node tail;
    int size;
    Node pointNode;

    LinkedList(){
        head = new Node();
        tail = new Node();

        pointNode = tail;

        head.right = tail;
        tail.left = head;
    }
    void add(char data){
        Node node = new Node(data);
        
        Node curr = tail.left;
        Node next = tail;
        
        node.left = curr;
        node.right = next;
        curr.right = node;
        next.left = node;

        size++;
    }
    void moveLeft(){ //pointNode는 head.left를 넘어가지 않음
        if(pointNode.left == head) return;
        pointNode = pointNode.left;
    }
    void moveRight(){ //pointNode는 tail을 넘어가지 않음
        if (pointNode == tail) return;
        pointNode = pointNode.right;
    }

    void deleteLeft(){
        if(pointNode.left == head) return;
        Node curr = pointNode.left.left;
        Node next = pointNode;

        curr.right = next;
        next.left = curr;
        
        size--;
    }

    void insert(char data){
        Node node = new Node(data);
        
        Node curr = pointNode.left;
        Node next = pointNode;

        curr.right = node;
        next.left = node;

        node.right = next;
        node.left = curr;

        if(pointNode.left == head) moveLeft(); // 맨 앞 pointNode에서 왼쪽에 추가해줬으면 pointNode 맨 앞으로 바꿔줘야 함
         
        size++;
    }

    void printList(){
        Node curr = head.right;
        StringBuilder sb = new StringBuilder();
        while(curr.right != null){
            sb.append(curr.data);
            curr = curr.right;
        }
        System.out.println(sb);
    }
}

public class Main {
    static int N;
    static LinkedList list;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        list = new LinkedList();    
        getList();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            char cmd = st.nextToken().charAt(0);
            switch (cmd) {
                case 'L':
                    list.moveLeft();
                    break;
                case 'D':
                    list.moveRight();
                    break;
                case 'B':
                    list.deleteLeft();
                    break;
                case 'P':
                    char data = st.nextToken().charAt(0);
                    list.insert(data);
                    break;
            }
        }
        list.printList();
    } 

    static void getList() throws NumberFormatException, IOException{
        char[] cArr = br.readLine().toCharArray();

        for(char c : cArr){
           list.add(c);
        }
    }
}