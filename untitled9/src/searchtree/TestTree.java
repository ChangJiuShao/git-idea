package searchtree;

public class TestTree {
    public static void main(String[] args) {

        SearchBinaryTree tree = new SearchBinaryTree();
        tree.createTree(10l,1);
        tree.createTree(20l,2);
        tree.createTree(15l,3);
        tree.createTree(30l,4);
        tree.createTree(3l,5);
        System.out.println(tree.root.data);
        System.out.println(tree.root.rChild.data);
        System.out.println(tree.root.rChild.rChild.data);
        Node node = tree.findNode(30l);
        System.out.println(node.data+"   "+node.index);

    }
}
