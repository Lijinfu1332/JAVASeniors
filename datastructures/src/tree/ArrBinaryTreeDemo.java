package tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree=new ArrBinaryTree(arr);
        System.out.println("前序遍历:");
       arrBinaryTree.preOrder(0);
        System.out.println("\n中序遍历:");
        arrBinaryTree.infixOrder(0);
        System.out.println("\n后序遍历:");
       arrBinaryTree.postOrder(0);

    }
}
class ArrBinaryTree{
    private int[] arr;
//构造器
    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        System.out.printf(arr[index]+"\t");
        //向左前序遍历
        if (2*index+1<arr.length){
            preOrder(2*index+1);
        }
        //向右前序遍历
        if (2*index+2<arr.length){
            preOrder(2*index+2);
        }

    }
    public void infixOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        //向左中序遍历
        if (2*index+1<arr.length){
            infixOrder(2*index+1);
        }

        System.out.printf(arr[index]+"\t");
        //向右前序遍历
        if (2*index+2<arr.length){
            infixOrder(2*index+2);
        }

    }
    public void postOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        //向右前序遍历
        if (2*index+1<arr.length){
            postOrder(2*index+1);
        }
        //向右前序遍历
        if (2*index+2<arr.length){
            postOrder(2*index+2);
        }

        System.out.printf(arr[index]+"\t");

    }
}
