package FuckingAlgorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-04-04 2:16
 * 最近公共祖先 leetcode236
 */
public class LowestCommonAncestor {
    List<TreeNode> p_path = new ArrayList<>();
    List<TreeNode> q_path = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int flag = 0;

        preOrder(root, p, new ArrayList<>(), p_path, flag);
        flag = 0;
        preOrder(root, q, new ArrayList<>(), q_path, flag);

        int len = p_path.size()<q_path.size()?p_path.size():q_path.size();
        TreeNode res = null;
        for (int i = len-1; i >0 ; i--) {
            if(p_path.get(i)==q_path.get(i)){
                res =  p_path.get(i);
            }
        }
        return res;
    }

    public void preOrder(TreeNode root,TreeNode search,List<TreeNode> path,List<TreeNode> result,int flag){
        if(root==null||flag==1){//节点为空或者flag=1找到了时，跳出递归
            return ;
        }
        path.add(root);
        if(root == search){
            flag = 1;
            result = path;
        }
        preOrder(root.left, search, new ArrayList<>(path), result, flag);
        preOrder(root.right, search, new ArrayList<>(path), result, flag);


    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t11 = new TreeNode(11);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2);
        TreeNode t8 = new TreeNode(8);
        TreeNode t13 = new TreeNode(13);
        TreeNode t4_r = new TreeNode(4);
        TreeNode t5_r = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);


        t5.left = t4;
        t5.right = t8;
        t4.left = t11;
        t11.left = t7;
        t11.right = t2;
        t8.left = t13;
        t8.right = t4_r;
        t4_r.left = t5_r;
        t4_r.right = t1;

        LowestCommonAncestor test = new LowestCommonAncestor();
        TreeNode treeNode = test.lowestCommonAncestor(t5, t2, t5);
        System.out.println(treeNode.val);
    }
}
