package tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        HeroNode node1=new HeroNode(1,"张三");
        HeroNode node2=new HeroNode(2,"李四");
        HeroNode node3=new HeroNode(3,"王二");
        HeroNode node4=new HeroNode(4,"老李");
        HeroNode node5=new HeroNode(5,"老王");
        //建立树
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node5);
        node3.setLeft(node4);
        binaryTree.setRoot(node1);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
        //树的查找
        HeroNode heroNode = binaryTree.preOrderSerrch(1);
        if (heroNode!=null){
            System.out.println("找到了"+heroNode);
        }else {
            System.out.println("没有找到");
        }
        //删除节点
        System.out.println("删除前");
        binaryTree.preOrder();
        binaryTree.deleteNode(1);
        System.out.println("删除后");
        binaryTree.preOrder();

    }
}
class BinaryTree{
    private HeroNode root;//根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("根节点为空");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }else {
            System.out.println("根节点为空");
        }
    }
    //后序遍历
    public void postOrder(){
        if (root!=null){
            root.postOrder();
        }else {
            System.out.println("根节点为空");
        }
    }
    //前序查找
    public HeroNode preOrderSerrch(int no){
        if (root!=null){
         return   root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSerrch(int no){
        if (root!=null){
           return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSerrch(int no){
        if (root!=null){
          return   root.postOrderSearch(no);
        }else {
            return null;
        }
    }
    //删除节点
    public void deleteNode(int no){
        if (root!=null){
            if (root.getNo()==no){
                root=null;
            }else {
                root.deleteNode(no);
            }
        }else {
            System.out.println("树为空，不能进行删除");
        }
    }

}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
