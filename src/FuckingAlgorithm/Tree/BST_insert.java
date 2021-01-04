package FuckingAlgorithm.Tree;

/**
 * @author wq
 * @date 2020-04-17 1:07
 */
public class BST_insert {
    public void Bst_insert(TreeNode node,TreeNode insert_node){
        if(insert_node.val<node.val){
            if(node.left != null){
                Bst_insert(node.left, insert_node);
            }else {
                node.left = insert_node;
            }
        }else{
            if(node.right!=null){
                Bst_insert(node.right, insert_node);
            }else{
                node.right = insert_node;
            }
        }
    }

    public void preorder_print(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preorder_print(root.left);
        preorder_print(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t4.left = t2;
        t2.left = t1;
        t2.right = t3;
        t4.right = t6;
        t6.left = t5;
        t6.right = t7;

        BST_insert test = new BST_insert();
        TreeNode t8 = new TreeNode(8);
        test.Bst_insert(t4, t8);
        test.preorder_print(t4);
    }
}
