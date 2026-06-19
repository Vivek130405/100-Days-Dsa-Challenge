public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        helper(root.left, sb);
        helper(root.right, sb);
    }

    int index = 0;

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;
        return build(arr);
    }

    private TreeNode build(String[] arr) {
        if (arr[index].equals("#")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        index++;

        node.left = build(arr);
        node.right = build(arr);

        return node;
    }
}