//Before starting to work on this design the Tree in the Tester code 
// Complete the lowestCommonAncestor method
public class Task1 {

    //======================TASK#1======================
    // This method takes only 3 parameter first one is root
    // and second & third parameter are as 2 integers
    // You'll need to find the lowest common ancestor of them and return it
    public static Integer lowestCommonAncestor( BSTNode root, Integer x, Integer y ){
        // Base case: if root is null, return null
        if (root == null) {
            return null;
        }
        
        // If both x and y are smaller than root, LCA lies in left subtree
        if (x < root.elem && y < root.elem) {
            return lowestCommonAncestor(root.left, x, y);
        }
        
        // If both x and y are greater than root, LCA lies in right subtree
        if (x > root.elem && y > root.elem) {
            return lowestCommonAncestor(root.right, x, y);
        }
        
        // Otherwise, this node is the LCA (one value is on left, one on right, or one equals root)
        return root.elem;
    }
    //==================================================

}
