package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BianryTree {
private TreeNode root=null;
    public BianryTree() {
        root=new TreeNode(1,"A");
    }

    /*
    * 构建一个二叉树
    *      A
    *   B     C
    * D   E       F
    *
    *
    * */
    public void createTree() {

        TreeNode B= new TreeNode(2,"B");
        TreeNode C= new TreeNode(3,"C");
        TreeNode D= new TreeNode(4,"D");
        TreeNode E= new TreeNode(5,"E");
        TreeNode F= new TreeNode(6,"F");
        root.lChild=B;
        root.rChild=C;
        B.lChild=D;
        B.rChild=E;
        C.rChild=F;

    }

    /**
     *
     * 求二叉树的高度  递归的方法 直到节点的左孩子 右孩子都为空才返回0  要不就递归执行else里面的语句
     *
     * @return
     */
    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(TreeNode node){
if (node==null){

    return 0;

}
else {

    int i=getHeight(node.lChild);
    int j=getHeight(node.rChild);

    return (i<j)? j+1:i+1;

}
    }

    /**
     * 求树的节点数
     *
     * @return
     */
    public  int getSize(){
        return getSize(root);
    }
//迭代递归思想   当只有一个节点是   它没有孩子  直接执行else return 1
// 当它有孩子时孩子再次递归执行  getSize
    private int getSize(TreeNode node) {

        if (node==null) {
            return 0;
        }
        else {
            return 1+getSize(node.lChild)+getSize(node.rChild);
        }
    }

    /**
     * 前序遍历  根 左  右
     * @param node
     */
    public void proOrder(TreeNode node){
        if (node==null){
            return;
        }else {
            //先打印 本身  然后迭代打印他的左孩子 再迭代打印右孩子
            System.out.println(node.getData());
            proOrder(node.lChild);
            proOrder(node.rChild);
        }
    }

    /**
     *
     * 中序遍历  左  根  右
     * @param node
     */
    public  void  midOder(TreeNode node){
        if (node==null){
            return;
        }
        else{
            //先遍历左孩子  如果有左孩子 左孩子再次调用midOrder()
            // 如果左孩子是叶子节点  没有子节点 当它再次调用midOrder,就执行输出本身。。。
            midOder(node.lChild);
            System.out.println(node.getData());
            midOder(node.rChild);
        }
    }

    /**
     * 后序遍历 左  右  根
     * @param node
     */
    public  void  nextOrder(TreeNode node){
        if (node==null){
            return;
        }
        else{
            //类似中序遍历
            nextOrder(node.lChild);
            nextOrder(node.rChild);
            System.out.println(node.getData());
        }
    }

    /**
     * 不使用递归得方法来实现前序遍历
     * 使用栈的数据结构特性
     * @param node
     */
    public  void proOrder2(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode> stack =new Stack<>();
        //先把根节点放进栈中
        stack.push(node);
        while (!stack.isEmpty()){
            //如果栈不会空就弹出栈顶元素  每弹出一个站顶元素就打印出此元素
            //并压入他的两个子节点 (因为是前序遍历 根 左 右 所以要先压入右节点 这样才能保证左节点先再栈顶 先弹出)
            TreeNode n = stack.pop();
            System.out.println(n.getData());
            if (n.rChild!=null){
                stack.push(n.rChild);
            }
            if (n.lChild!=null){
                stack.push(n.lChild);
            }
        }

    }

    /**
     * 根据一个前序遍历的结果去创建对应的二叉树
     *           A
            B        C
        D      E   #      F
     #   #   #   #      #    #

     要想根据前序遍历的结果去创建对应的二叉树  我们需要把改二叉树的节点以# 补齐
     因为如果不补齐 同一个遍历结果可能会对应多个二叉树
     例如：同样是ABC 如果不加# 就有可能是
         A                    A
     B         或者      B        C
 C

     所以上述二叉树的前序遍历结果为ABD##E##C#F##    #号只起到占位的作用 用来确定唯一的二叉树
     * @param data
     * @return
     */

    public TreeNode createBianyTree(int size,ArrayList<String> data){
        if (data.size()==0){
          return null;
        }
        TreeNode node;
        int index = size-data.size();
        //获取节点
        String n = data.get(0);
        if (n.equals("#")){
            node=null;
            data.remove(0);
            return node;
        }
        node=new TreeNode(size,n);
        if (index==0){
            //创建根节点
            root=node;
        }
        data.remove(0);
        node.lChild=createBianyTree(size,data);
        node.rChild=createBianyTree(size,data);
        return node;
    }



    public static void main(String[] args) {
        //测试树的高度
        BianryTree bianryTree = new BianryTree();
      /*  bianryTree.createTree();
        int height = bianryTree.getHeight();
        System.out.println("height:"+height );
        //求树的节点数
        int size = bianryTree.getSize();
        System.out.println("size:"+size);
        //前序遍历
        //bianryTree.proOrder(bianryTree.node);
        //中序遍历
        //bianryTree.midOder(bianryTree.node);
        //后序遍历
       // bianryTree.nextOrder(bianryTree.node);
        //不适用迭代的方式实现前序遍历
       // bianryTree.proOrder2(bianryTree.root);
        */


      //测试createBianyTree()
      String[] node={"A","B","D","#","#","E","#","#","C","#","F","#","#"};
        ArrayList array=new ArrayList();
        for (String s : node) {
            array.add(s);
        }
       TreeNode bianyTree = bianryTree.createBianyTree(array.size(), array);
        bianryTree.proOrder(bianyTree);
    }
}
