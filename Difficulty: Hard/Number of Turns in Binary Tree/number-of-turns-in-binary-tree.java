/* Structure of Binary Tree Node
class Node {
	int data;
	Node left;
	Node right;
	
	Node(int val) {
		data = val;
		left = right = null;
	}
} */

class Solution {
	public int numberOfTurns(Node root, int p, int q) {
		
		List<Integer> pathP = new ArrayList<>();
		List<Integer> pathQ = new ArrayList<>();
		
		// Step 1: Find paths from root to p and q
		if (!findPath(root, p, pathP) || !findPath(root, q, pathQ)) {
			return - 1;
		}
		
		// Step 2: Remove common prefix (find LCA)
		int i = 0;
		while (i < pathP.size() && i < pathQ.size() && pathP.get(i).equals(pathQ.get(i))) {
			i++;
		}
		
		// Sub-paths from the LCA
		List<Integer> leftBranch = pathP.subList(i, pathP.size());
		List<Integer> rightBranch = pathQ.subList(i, pathQ.size());
		
		// Step 3: Handle Edge Cases (one node is the ancestor of the other)
		if (leftBranch.isEmpty() && rightBranch.isEmpty()) {
			return - 1;
		}
		
		if (leftBranch.isEmpty()) {
			int turns = countTurnsInPath(rightBranch);
			return turns == 0 ? -1 : turns;
		}
		
		if (rightBranch.isEmpty()) {
			int turns = countTurnsInPath(leftBranch);
			return turns == 0 ? -1 : turns;
		}
		
		// Step 4: Normal case (nodes are in different branches of LCA)
		// Add 1 extra turn at the LCA because they split into left (0) and right (1)
		int totalTurns = countTurnsInPath(leftBranch) + countTurnsInPath(rightBranch) + 1;
		
		return totalTurns == 0 ? -1 : totalTurns;
	}
	
	// Inorder-based backtracking to find the path
	private boolean findPath(Node root, int target, List<Integer> path) {
		if (root == null) {
			return false;
		}
		
		if (root.data == target) {
			return true;
		}
		
		// Try Left (0)
		path.add(0);
		if (findPath(root.left, target, path)) {
			return true;
		}
		path.remove(path.size() - 1); // Backtrack
		
		// Try Right (1)
		path.add(1);
		if (findPath(root.right, target, path)) {
			return true;
		}
		path.remove(path.size() - 1); // Backtrack
		
		return false;
	}
	
	// Counts transitions (0 -> 1 or 1 -> 0) in a single branch path
	private int countTurnsInPath(List<Integer> path) {
		if (path.isEmpty())
			return 0;
		
		int turns = 0;
		int prev = path.get(0);
		
		for (int i = 1; i < path.size(); i++) {
			if (path.get(i) != prev) {
				turns++;
				prev = path.get(i);
			}
		}
		return turns;
	}
}

