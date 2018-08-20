/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
	private static final String SPLITER = ",";
	private static final String NAN = "#";
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) return NAN;
		return root.val + SPLITER + serialize(root.left) + SPLITER + serialize(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("")) return null;
		List<String> tempList = Arrays.asList(data.split(SPLITER));
		Queue<String> queue = new LinkedList<>();
		queue.addAll(tempList);
		return helper(queue);
	}
	
	private TreeNode helper(Queue<String> queue){
		String curr = queue.poll();
		if(curr.equals(NAN)) return null;
		TreeNode root = new TreeNode(Integer.valueOf(curr));
		root.left = helper(queue);
		root.right = helper(queue);
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));