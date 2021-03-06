package utils;

/**
 * Created by farazw808 on 5/30/15.
 */
public class BST<T extends Comparable<T>> {
    public BSTNode<T> root = null;

    public static boolean isIsFound() {
        return isFound;
    }

    public static void setIsFound(boolean isFound) {
        BST.isFound = isFound;
    }

    static boolean isFound = false;


    public void resetFound() {
        isFound=false;
    }

    /**
     * Method to insert data into BST
     *
     * @param root
     * @param data
     * @return
     */
    public BSTNode<T> insert(BSTNode<T> root, T data) {

        if (root == null) {
            root = new BSTNode<>(data);
            //if root of this tree is empty set it
            if (this.root == null) {
                this.root = root;
            }
            return root;
        }

        if (root.data.compareTo(data) < 0) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }

        return root;
    }


    public BSTNode<T> find(BSTNode<T> root, T data) {
        //compare it with root's data and return the node
        if (root != null && root.data.compareTo(data) == 0) {
            return root;
        } else if (root != null && root.data.compareTo(data) < 0) {
            //if root is smaller than data .. search the right subtree
            return find(root.right, data);
        } else if (root != null && root.data.compareTo(data) > 0) {
            //if root is bigger than data .. search the left subtree
            return find(root.left, data);
        }

        return null;
    }

    public BSTNode<T> remove(BSTNode<T> root, T data) {

        //if the data equals to the data of the root
        if (root != null && root.data.compareTo(data) == 0) {
            // if root has no children
            if (root.left == null && root.right == null) {
                return null;
            }

            //if root has just 1 children
            // if the root has only right child
            if (root.left == null) {
                return root.right;
            }
            //if the root has only left child
            if (root.right == null) {
                return root.left;
            }

            // if root has 2 childrens ..

            // find left most child of the right subtree
            BSTNode<T> minNode = findMin(root.right);

            //remove this child from right subtree
            root = remove(root, minNode.data);

            //copy the value of minNode into root
            root.data = minNode.data;

        } else if (root != null && root.data.compareTo(data) < 0) {
            //if root is smaller than data .. search the right subtree
            root.right = remove(root.right, data);
        } else if (root != null && root.data.compareTo(data) > 0) {
            //if root is bigger than data .. search the left subtree
            root.left = remove(root.left, data);
        }

        return root;
    }

    public BSTNode<T> findMin(BSTNode<T> root) {
        if (root.left == null) {
            return root;
        } else {
            return findMin(root.left);
        }
    }


    public void preOrder(BSTNode<T> root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(BSTNode<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public void postOrder(BSTNode<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public int findIfTreeIsBalanced(BSTNode<T> root, int depth) throws Exception {

        if (root == null)
            return depth; // we are either at leaf or tree with root null. a null tree is also a balanced tree. at leaf there is no subtree
        // traverse left tree then right
        depth++; // increase the depth as we are going down.
        int leftDepth = findIfTreeIsBalanced(root.left, depth);
        int rightDepth = findIfTreeIsBalanced(root.right, depth);
        //depth--; // now decrease the depth as we are going up
        if (Math.abs(leftDepth - rightDepth) > 1) throw new Exception("Tree is not balanced");
        // return greater of the length
        if (leftDepth > rightDepth) return leftDepth;
        else
            return rightDepth;

    }

    public BSTNode<T> findLowestCommonAncestor(BSTNode<T> root, int p, int q )  {

        /**
         * here is algorithm. search for nodes in left and right trees. if nodes are found like p in left and q right or vice versa then current
         * node is common ancestor and return
         * if only p is find return p, if only q is find then return q. if no node is find then return null.
         * We are using a flag, commonAncestor set to true in case we find a common ancestor
         *
         */

        if (root == null) // we have returned at bottom and should return null as neither p and q are found. // case 1
            return null;

        if( root.data.equals(p))
            return root;

        if(root.data.equals(q))
            return root;

        BSTNode<T> left = findLowestCommonAncestor(root.left, p, q);


        if (isFound) // it means we have already found the ancestor in left sub-tree or right
            return left;

        BSTNode<T> right = findLowestCommonAncestor(root.right, p, q);

        if (isFound)
            return right;

        // it means we have not found it in subtrees. now let see what we have found from left and right sub-trees.

        if (left != null && right != null) // it means from each subtree we found p and q and current node is lowest ancestor
        {
            isFound = true;
            return root;
        }

        // if either left or right node is found return it or return null

        if (left != null)
            return left;

        if (right != null)
            return right;
        else
            return null;

    }





    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 12);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 0);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 16);
        tree.inOrder(tree.root);

        try {
            tree.findIfTreeIsBalanced(tree.root, 0);
            System.out.println("Tree is balanced");
        } catch (Exception exp) {
            if (exp.getMessage().indexOf("Tree is not balanced") > -1)
                System.out.println("Tree is not balanced");
        }

        // find lowest common ancestor
        BSTNode<Integer> ancestor =  tree.findLowestCommonAncestor(tree.root, 5, 7);

        if(ancestor == null) System.out.println("No common ancestor found");
        else
            System.out.println("common ancestor is > " + ancestor.data);

        tree.resetFound();

      ancestor =  tree.findLowestCommonAncestor(tree.root,  2, 6);

        if(ancestor == null) System.out.println("No common ancestor found");
        else
            System.out.println("common ancestor is > " + ancestor.data);

        tree.resetFound();

        ancestor =  tree.findLowestCommonAncestor(tree.root,  16, 10);

        if(ancestor == null) System.out.println("No common ancestor found");
        else
            System.out.println("common ancestor is > " + ancestor.data);

        tree.resetFound();

        ancestor =  tree.findLowestCommonAncestor(tree.root, 5, 16);

        if(ancestor == null) System.out.println("No common ancestor found");
        else
            System.out.println("common ancestor is > " + ancestor.data);

        tree.resetFound();

        ancestor =  tree.findLowestCommonAncestor(tree.root, 22, 16);

        if(ancestor == null || tree.isIsFound()) System.out.println("No common ancestor found");
        else
            System.out.println("common ancestor is > " + ancestor.data);

    }
}
