package searchtree;

public class Node {
    public  Long data;
    public Integer index;
    public Node rChild;
    public Node lChild;

    public Node(Long data, Integer index) {
        this.data = data;
        this.index = index;
    }
}
