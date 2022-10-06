import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DEBUG测试类
 */

public class test {
        public int n = 5;

        public static void main(String args[]) {


                Thread t = new Thread() {
                        public void run() {
                                dianping();
                        }
                };
                t.start();
                System.out.print("dazhong");
        }

        static void dianping() {
                System.out.print("dianping");
        }

        public static TreeNode createTree(String[] nums) {
                TreeNode root = new TreeNode(Integer.valueOf(nums[0]));
                Deque<TreeNode> que = new ArrayDeque<>();
                que.addLast(root);
                int index = 0;
                while (!que.isEmpty()) {
                        int size = que.size();
                        for (int i = 0; i < size; i++) {
                                TreeNode node = que.removeFirst();
                                TreeNode left = null;
                                TreeNode right = null;
                                if (++index < nums.length && !nums[index].equals("null")) {
                                        left = new TreeNode(Integer.valueOf(nums[index]));
                                }
                                if (++index < nums.length && !nums[index].equals("null")) {
                                        right = new TreeNode(Integer.valueOf(nums[index]));
                                }
                                node.left = left;
                                node.right = right;
                                if (node.left != null) {
                                        que.addLast(node.left);
                                }
                                if (node.right != null) {
                                        que.addLast(node.right);
                                }

                        }
                }

                return root;
        }

        public static double sqrt() {
                double low = 1.4;
                double high = 1.5;
                double mid = 0;
                double flag = 0.0000000001;
                while (high - low > flag) {
                        mid = (low + high) / 2;
                        if (mid * mid > 2) {
                                high = mid;
                        } else
                                low = mid;
                }

                return mid;
        }

}

class TreeNode {
        int val;

        TreeNode() {
        }

        TreeNode(int val) {
                this.val = val;
        }

        TreeNode left;
        TreeNode right;

}