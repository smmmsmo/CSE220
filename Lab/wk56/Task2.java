//Before starting to work on this design the Tree in the Tester code 
// Complete the sumOfLeaves method
public class Task2 {

    // ===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    public static String findPath(BSTNode root, Integer key) {
        // If tree is empty or we reached a null node, key not found
        if (root == null) {
            return "No Path Found";
        }

        // Check if we found the key at current node
        if (root.elem.equals(key)) {
            return root.elem + ""; // Return just this node's value
        }

        // Decide which direction to go based on BST property
        String path;
        if (key < root.elem) {
            // Key is smaller, so search left subtree
            path = findPath(root.left, key);
        } else {
            // Key is larger, so search right subtree
            path = findPath(root.right, key);
        }

        // Check if we found the key in the subtree
        if (path.equals("No Path Found")) {
            return "No Path Found"; // Key doesn't exist
        } else {
            return root.elem + " " + path; // Add current node to the path
        }
    }
    // ============================================================================

}
