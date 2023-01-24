package ch20.tree;

import java.util.LinkedList;
import java.util.ListIterator;

class TreeNode {
    
    String nName;
    LinkedList<TreeNode> children;
    
    int layer = 0;

    TreeNode(String s) {
        this.nName = s; 
        children = new LinkedList<TreeNode>();
    }
    void addChild(String s) {
        TreeNode node = new TreeNode(s);
        if (node.layer != this.layer+1) {
            node.layer  = this.layer+1;
        }
        children.addLast(node);
    }

    TreeNode find(String s) {
        if (nName.equals(s)) return this;

        /* traverse children */
        ListIterator<TreeNode> iter = children.listIterator();
        while (iter.hasNext()) {
            TreeNode child = iter.next();
            if (child.find(s) != null) return child.find(s);
        }
        return null;
        /**/
    }
    void depthFirstTraverse() {
        for (int i = 0; i < layer; i++) {
            System.out.print("  ");
        }
        System.out.println(layer + " : " + nName);

        for (TreeNode i : children) {
            i.depthFirstTraverse();
        }
    }

}

class Tree {
    TreeNode root;

    void setRoot(String rName) {
        this.root = new TreeNode(rName);
    }
    boolean addChild(String pName, String cName) {
        if (this.root == null) 
            return false; 

        TreeNode temp = root.find(pName); // traverse children
        if (temp == null) // can't finds
            return false;
        
        temp.addChild(cName); 
            return true;
    }
    void depthFirstTraverse() {
        if (root == null) {
            return;
        }
        root.depthFirstTraverse();
    }
    void print() {
        root.print();
    }
}

class TestDriver {
    public static void main(String[] args) {
        Tree tree = new Tree();
        String rName;

        System.out.print("Input the name of the root node of this tree: ");
        rName = System.console().readLine();
        tree.setRoot(rName);

        while (true) {
            String pName, cName;

            System.out.println(">>"); 
			System.out.print("Input a parent name: "); 
			pName = System.console().readLine();
			System.out.print("Input a child name: "); 
			cName = System.console().readLine();
			if (tree.addChild(pName, cName) == false) break;
            tree.depthFirstTraverse();
        }
    }
}