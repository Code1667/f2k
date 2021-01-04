package FuckingAlgorithm.Tree;

/**
 * @author wq
 * @date 2020-04-17 22:47
 */
public class SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        BST_preorder(root, data);
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split("#");
        int len = split.length;

        StringBuilder data_sb = new StringBuilder(data);

        int val = 0;
        TreeNode[] nodes = new TreeNode[len];   //几个数字就有几个节点
        int index = 0;
        for (int i = 0; i < data_sb.length(); i++) {
            if(data_sb.charAt(i)=='#'){
                nodes[index] = new TreeNode(val);
                index++;
                val = 0;
            }else{
                val = val*10 + data_sb.charAt(i) - '0';
            }
        }

        for (int i = 1; i < nodes.length; i++) {
            Bst_insert(nodes[0],nodes[i]);
        }
        return nodes[0];
    }

    /**
     * 前序遍历编码操作   遍历一个加一个#
     * @param node
     * @param str
     */
    public static void BST_preorder(TreeNode node,StringBuilder str){
        if(node==null){
            return;
        }
        str.append(String.valueOf(node.val));
        str.append("#");
        BST_preorder(node.left, str);
        BST_preorder(node.right, str);
    }

    /**
     * 解码时候的插入（构建）二叉树节点
     * @param node
     * @param insert_node
     */
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

        SerializeAndDeserialize test = new SerializeAndDeserialize();
        String serialize = test.serialize(t4);
        System.out.println(serialize);
        TreeNode deserialize = test.deserialize(serialize);
        test.preorder_print(deserialize);


    }


}
