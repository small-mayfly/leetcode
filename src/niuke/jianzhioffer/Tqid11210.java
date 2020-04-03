package niuke.jianzhioffer;

public class Tqid11210 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        // 如果当前结点是根结点
        if(pNode.next==null){
            // 如果当前结点左子树
            if(pNode.right!=null){
                TreeLinkNode right = pNode.right;
                if(right.left==null){   // 如果右子结点的左子树为空，则下一个结点为右子结点
                    return right;
                }else{   // 否则下一个结点为右子树的第一个结点
                    while (right.left!=null){
                        right = right.left;
                    }
                    return right;
                }
            }else{   // 如果右子树为空，则不存在下一个结点
                return null;
            }

        }else{

            if(pNode.right!=null){   // 如果右子树不为空，则下一个结点是右子树的第一个结点
                TreeLinkNode right = pNode.right;
                if(right.left==null){   // 如果右子树的左子树为空，则下一个结点为右子结点
                    return right;
                }else{   // 如果右子结点的左子树不为空，则为右子树的第一个结点
                    while (right.left!=null){
                        right = right.left;
                    }
                    return right;
                }
            }else{
                // 先找到父结点
                TreeLinkNode parent = pNode.next;
                if(parent==null){   // 右子树和父结点都为空，说明没有下一个结点
                    return null;
                }else{
                    if(parent.left==pNode){   // 如果当前结点是左子结点
                        return parent;    // 如果右子树为空，则下一个结点是父结点
                    }else{   // 如果是父结点的右子树,则只能迭代的向上找
                        TreeLinkNode rem = parent;
                        while (true){
                            parent = parent.next;
                            if(parent==null){   // 如果再也没有父结点，说明没有下一个结点了
                                return null;
                            }else{
                                if(rem==parent.left){   // 如果找到父结点，且当前结点为父结点的左子树则返回父结点
                                    return parent;
                                }else{   // 否则只能迭代的向上找
                                    rem = parent;
                                }
                            }

                        }
                    }
                }
            }


        }
    }
}
