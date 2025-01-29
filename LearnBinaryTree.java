import java.util.Scanner;
class LinkedList{
    Node root;
    int NodeCount;
    // Boolean inserted = false;
    public Node Insert(Node parent, int data){
        if(parent == null){
            Node n = new Node(data);
            parent = n;
        }
        else if(parent.data > data){
            parent.left =  Insert(parent.left, data );
        }
        else if(parent.data < data){
            parent.right =  Insert(parent.right, data );
        }
        else{
            System.out.println("This data is equal to parent node So, doesn't be inserted");
        }
        return parent;
    }
    public void postOrderTraverse(Node node) {
        if (node == null) return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }
}
class Node{
    int data;
    Node left, right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
class LearnBinaryTree {
    public static void main(String[] args) {
        LinkedList tree = new LinkedList();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter root node: ");
        tree.root= new Node(scan.nextInt());
        System.out.print("Do you want to add Another node ( 1/0 ): ");
        while(scan.nextInt() == 1){
            System.out.print("Enter data : ");
            int data = scan.nextInt();
            tree.Insert(tree.root,data);
            System.out.print("Do you want to add Another node ( 1/0 ): ");    
        }
        System.out.println(tree.root.data);
        System.out.print("PostOrderTraversal : ");
        tree.postOrderTraverse(tree.root);
    }
}