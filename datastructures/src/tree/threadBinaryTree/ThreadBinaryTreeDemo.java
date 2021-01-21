package tree.threadBinaryTree;



public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.setRoot(root);
       // System.out.println("前序遍历二叉树");
       //binaryTree.threadedPreBinaryTree(root);
       // System.out.println(node3.getRight());
        //binaryTree.listThreadPreBinaryTree(root);
       // System.out.println("中序遍历二叉树");
       // binaryTree.threadedInfixBinaryTree(root);
       // binaryTree.listThreadInfixBinaryTree(root);
        System.out.println("后序遍历二叉树");
        binaryTree.threadedPostBinaryTree(root);
        binaryTree.listThreadPostBinaryTree(root);
    }
}
class BinaryTree{
    private HeroNode root;//根节点
    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //线索化遍历前序二叉树
    public void listThreadPreBinaryTree(HeroNode node){
        if (node==null){
            System.out.println("二叉树为空");
        }
        //1.遍历当前节点
        System.out.println(node);
        //2.递归遍历左子树
        if (node.getLeftType()!=1&&node.getLeft()!=null){
            listThreadPreBinaryTree(node.getLeft());
        }
        //3.递归遍历右子树
        if (node.getRightType()!=1&&node.getRight()!=null){
            listThreadPreBinaryTree(node.getRight());
        }
    }
    //线索化遍历中序二叉树
    public void listThreadInfixBinaryTree(HeroNode node){
        if (node==null){
            System.out.println("二叉树为空");
        }

        //1.递归遍历左子树
        if (node.getLeftType()!=1&&node.getLeft()!=null){
            listThreadInfixBinaryTree(node.getLeft());
        }
        //2.遍历当前节点
        System.out.println(node);
        //3.递归遍历右子树
        if (node.getRightType()!=1&&node.getRight()!=null){
            listThreadInfixBinaryTree(node.getRight());
        }
    }
    //线索化遍历后序二叉树
    public void listThreadPostBinaryTree(HeroNode node){
        if (node==null){
            System.out.println("二叉树为空");
        }

        //1.递归遍历左子树
        if (node.getLeftType()!=1&&node.getLeft()!=null){
            listThreadPostBinaryTree(node.getLeft());
        }
        //2.递归遍历右子树
        if (node.getRightType()!=1&&node.getRight()!=null){
            listThreadPostBinaryTree(node.getRight());
        }
        //3.遍历当前节点
        System.out.println(node);
    }
    //线索化前序二叉树
    public void threadedPreBinaryTree(HeroNode node){
        if (node==null){
            return;
        }
        //1.线索化当前节点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //2.先线索化左子树
        if (node.getLeftType()!=1){
            threadedPreBinaryTree(node.getLeft());
        }
        //3线索化右子树
        if (node.getRightType()!=1) {
            threadedPreBinaryTree(node.getRight());
        }

    }
    //线索化中序遍历二叉树
    public void threadedInfixBinaryTree(HeroNode node){
        //如果当前节点为空，则表示不能线索化
        if (node==null){
            return;
        }
        //(一)，先线索化左子树
        threadedInfixBinaryTree(node.getLeft());
        //(二)线索化当前结点[有难度]

        //处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //(三)，线索化右子树
        threadedInfixBinaryTree(node.getRight());

    }
    //线索化后序二叉树
    public void threadedPostBinaryTree(HeroNode node){
        if (node==null){
            return;
        }
        //1.先线索化左子树
        threadedPostBinaryTree(node.getLeft());
        //2线索化右子树
        threadedPostBinaryTree(node.getRight());
        //3.线索化当前节点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

    }


}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //根据左右子树标识来判别是否为左右子树还是线索化节点，1表示是线索化的前驱后继节点，0表示为左右子节点
    private int rightType;
    private int leftType;
    //构造方法
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
    //前序遍历
    public  void  preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public  void  infixOrder(){

        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public  void  postOrder(){

        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序查找
    public HeroNode preOrderSearch(int no){
        //判断当前节点编号是否等于编号
        if (this.no==no){
            return this;
        }
        //不满足时向左遍历左子树
        HeroNode heroNode=null;
        if (this.left!=null){
            heroNode=this.left.preOrderSearch(no);
        }
        //判断heroNode是否为空，不为空则说明找到了
        if (heroNode!=null){
            return heroNode;
        }
        //如果右子树不为空，递归前序查找向右遍历右子树
        if (this.right!=null){
            heroNode=this.right.preOrderSearch(no);
        }
        return heroNode;
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        //判断当前节点的左子树是否为空，递归中序查找遍历左子树
        HeroNode heroNode=null;
        if (this.left!=null){
            heroNode=this.left.infixOrderSearch(no);
        }
        //判断heroNode是否为空，不为空则说明找到了
        if (heroNode!=null){
            return heroNode;
        }
        //判断当前节点编号是否等于编号
        if (this.no==no){
            return this;
        }
        //如果右子树不为空，递归前序查找向右遍历右子树
        if (this.right!=null){
            heroNode=this.right.infixOrderSearch(no);
        }
        return heroNode;
    }
    //后续查找
    public HeroNode postOrderSearch(int no){
        //判断当前节点的左子树是否为空，递归中序查找遍历左子树
       HeroNode heroNode=null;
        if (this.left!=null){
            heroNode=this.left.infixOrderSearch(no);
        }
        //判断heroNode是否为空，不为空则说明找到了
        if (heroNode!=null){
            return heroNode;
        }
        //如果右子树不为空，递归前序查找向右遍历右子树
        if (this.right!=null){
            heroNode=this.right.infixOrderSearch(no);
        }
        if (heroNode!=null){
            return heroNode;
        }
        //判断当前节点编号是否等于编号
        if (this.no==no){
            return this;
        }
        return heroNode;
    }
    //二叉树节点的删除
    public void deleteNode(int no){
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        //向左递归删除
        if (this.left!=null){
            this.left.deleteNode(no);
        }
        //向右递归删除
        if (this.right!=null){
            this.right.deleteNode(no);
        }
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
