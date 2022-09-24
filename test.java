import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DEBUG测试类
 */

public class test {
        public int n = 5;

        public static void main(String[] args) {
                StringBuilder builder = new StringBuilder();  
                long time = System.currentTimeMillis();  
                for(int i=0;i<10000000;i++){  
                    builder = new StringBuilder();  
                    builder.append("aa");  
                    builder.append("bb");  
                    builder.append("cc");  
                    builder.append("dd");  
                    builder.append("ee");  
                }  
                System.out.println("new 耗时：" + (System.currentTimeMillis() - time));  
                long time1 = System.currentTimeMillis(); 
                StringBuilder builder1 = new StringBuilder();
                for(int i=0;i<10000000;i++){  
                    builder1.delete(0, builder.length());  
                    builder1.append("a");  
                    builder1.append("b");  
                    builder1.append("c");  
                    builder1.append("d");  
                    builder1.append("e");  
                }  
                System.out.println("delete 耗时：" + (System.currentTimeMillis() - time1));  
                long time2 = System.currentTimeMillis(); 
                StringBuilder builder2 = new StringBuilder();
                for(int i=0;i<10000000;i++){  
                    builder2.setLength(0);  
                    builder2.append("1a");  
                    builder2.append("1b");  
                    builder2.append("1c");  
                    builder2.append("1d");  
                    builder2.append("1e");  
                }  
                System.out.println("setLenth=0 耗时：" + (System.currentTimeMillis() - time2));  
        
               

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