package niuke.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tqid11212 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(pRoot==null){
            return results;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode levelStart = pRoot;
        int level = 1;
        ArrayList<Integer> result = null;
        queue.add(pRoot);
        while (queue.size()>0){
            // 首先从队列中取出一个值
            TreeNode tnode = queue.removeFirst();
            // 找出当前结点左右结点是否为空，不为空则入队列
            if(tnode.left!=null){
                queue.addLast(tnode.left);
            }
            if(tnode.right!=null){
                queue.addLast(tnode.right);
            }
            // 然后判断是否是一层的开始，如果是则进行层信息更新
            if(tnode==levelStart){
                level = 1 - level;   // 更新下一轮层级
                if(result!=null)
                    results.add(result);
                result = new ArrayList<>();   // 创建新的结果记录数组
                if(tnode.left!=null){   // 如果开始结点的左子树不为空，则下一层以这个结点的左子树开始
                    levelStart = tnode.left;
                }else if(tnode.right!=null){   // 否则以右子树开始
                    levelStart = tnode.right;
                }else {   // 如果左右子树都为空，则将下一层的开始置为空，用于下一次记录
                    levelStart = null;
                }
            }
            if(levelStart==null){   // 这个结点为空，说明这一层之前的结点都没有子结点
                if(tnode.left!=null){   // 如果开始结点的左子树不为空，则下一层以这个结点的左子树开始
                    levelStart = tnode.left;
                }else if(tnode.right!=null){   // 否则以右子树开始
                    levelStart = tnode.right;
                }
            }
            // 将当前结点插入结果列表中
            if(level==0){   // 奇数层，顺序插入
                result.add(tnode.val);
            }else{   // 偶数层，倒序插入
                result.add(0, tnode.val);
            }
        }
        results.add(result);

        return results;
    }
}
