package DataStructures;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val) {
        this.val = val;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    private void insert(Node node){
        // if no root, then assign root
        if(this.root == null){
            this.root = node;
            return;
        }
        Node temp = this.root;
        Node y = null;
        while(temp!= null){
            y = temp;
            if(temp.val<node.val){
                temp = temp.right;
//                insert(temp.left);// this will cause infinite root because of temp = root declaration

            }
            else if(temp.val>=node.val){
                temp = temp.left;
//                insert(temp.right);
            }
        }
        node.parent = y;
        if(y.val < node.val){
            y.right = node;
        }else{
            y.left = node;
        }

    }
    private void delete(Node node){
        Node temp = null;
        Node y = null;
        temp = this.root;
        while(temp!=null){
            if(temp.val < node.val){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }
            if(temp.left.val == node.val){
                // delete node. find the smallest element of right subtree and replace the value here.
                  temp = minimum(temp.right);
                  temp.left = node.left;
                  temp.right = node.right;
                  temp.parent = node.parent;

                  // problem here. The deletion is not happening because temp is returned as null.

            }
        }

    }

    private Node minimum(Node node){
        Node temp = node;
        while(temp.left!=null){
            temp = temp.left;
        }
        return temp;
    }
    private Node maximum(Node node){
        Node temp = node;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }


    private void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.val);
            inorder(node.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();

        Node a, b, c, d, e, f, g, h, i, j, k, l, m;
        a = new Node(10);
        b = new Node(20);
        c = new Node(30);
        d = new Node(100);
        e = new Node(90);
        f = new Node(40);
        g = new Node(50);
        h = new Node(60);
        i = new Node(70);
        j = new Node(80);
        k = new Node(150);
        l = new Node(110);
        m = new Node(120);
        /*
        10
            20
                30
                    100
                90
              40
                50
                    60
                        70
                            80
                                150
                            110
                                120
         */

        t.insert(a);
        t.insert(b);
        t.insert(c);
        t.insert(d);
        t.insert(e);
        t.insert(f);
        t.insert(g);
        t.insert(h);
        t.insert(i);
        t.insert(j);
        t.insert(k);
        t.insert(l);
        t.insert(m);

        t.delete(a);
        t.delete(m);

        t.inorder(t.root);
        System.out.println("root value is:" + t.root.val);
    }
}

