package searchtree;

public class SearchBinaryTree {
    public  Node root;


    public  void  createTree(Long value,Integer index){
        //接收参数 创建节点
        Node newNode = new Node(value,index);
        //创建根节点 根节点为当前节点
        Node current=root;
        //定义父节点
        Node parent;
       //如果当前没有根节点 就把新创建的节点作为根节点
        if (root==null){
            root=newNode;
            return;
        }
        //如果已经有了根节点 进入此循环
        while (true){
            //把当前节点赋值给父节点，赋值给parent作用是先把当前节点保存一下 在下面的程序中current要改变了
            parent=current;
            //如果传进来的值 大于当前节点的值 就把当前节点的右孩子作为当前节点再次进入循环进行比较
            //因为节点的右孩子一定是大于此节点的
            if (value>current.data){
                current=current.rChild;
                //如果当前节点没有右孩子 那就把这个新创建的节点当作当前节点的右孩子
                if (current==null){
                    parent.rChild=newNode;
                    return;
                }
            }else {
                current=current.lChild;

                if (current==null){
                    parent.lChild=newNode;
                    return;
                }
            }
        }
    }

    /**
     * 二叉树的查找
     * 先拿传入数据和根节点比较 如果比根节点大往右走  反之往左走
     *
     * @param value
     * @return
     */
    public  Node findNode(Long value){
        Node current=root;
        //只要当前节点的值不等于传进来的值 就一直循环下去
        while (current.data!=value){
            if (value>current.data){
                current=current.rChild;
            }else {
                current=current.lChild;
            }
            if (current==null){
                System.out.println("不存在此节点");
                return null;
            }
        }
       return current;

    }






}
