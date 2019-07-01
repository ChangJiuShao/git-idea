package Tree;

public class TreeNode {

    private Integer index;
    private String Data;

    @Override
    public String toString() {
        return "TreeNode{" +
                "index=" + index +
                ", Data='" + Data + '\'' +
                ", lChild=" + lChild +
                ", rChild=" + rChild +
                '}';
    }

    public TreeNode lChild;
   public TreeNode rChild;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }


    public TreeNode(Integer index, String data) {
        this.index = index;
        Data = data;
        this.lChild = null;
        this.rChild = null;
    }

}
