// Before starting to work on this design the Tree in the Tester code 
// Complete the sumOfLeaves method
public class Task3 {

    // ===================================TASK#3======================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is the sum initiliazed as 0
    // You'll need to return the sum of the leaf nodes
    public static Integer sumOfLeaves(BSTNode root, Integer sum) {
        // Base case: if node is null, return current sum
        if (root == null) {
            return sum;
        }

        // Check if current node is a leaf (no left and no right children)
        if (root.left == null && root.right == null) {
            return sum + root.elem; // Add leaf value to sum
        }

        // Recursively calculate sum from left and right subtrees
        sum = sumOfLeaves(root.left, sum); // Add left subtree leaves
        sum = sumOfLeaves(root.right, sum); // Add right subtree leaves

        return sum;
    }
    // ===============================================================

}
