package com.sdu.month1.day02;

/**二叉树上的各种最大距离问题
 * @author huaikong
 * @create 2021-01-31 10:20
 */
public class Q1_7 {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //从头节点到叶子节点最大距离
    public static int process1(Node x){
        if(x.left == null && x.right == null){
            return x.value;
        }
        int max = Integer.MIN_VALUE;
        if(x.left != null){
            max = process1(x.left);
        }
        if(x.right != null){
            max = Math.max(max,process1(x.right));
        }
        return max + x.value;
    }

    public static int maxDis1(Node head){
        if(head == null){
            return 0;
        }
        return process1(head);
    }

    //任意节点向下到任意节点最大距离
    public static class Info{
        public int allTreeMax;
        public int fromHeadMax;

        public Info(int allTreeMax, int fromHeadMax) {
            this.allTreeMax = allTreeMax;
            this.fromHeadMax = fromHeadMax;
        }
    }

    public static Info process2(Node x){
        if(x == null){
            return null;
        }
        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);
        int p1 = Integer.MIN_VALUE;
        if(leftInfo != null){
            p1 = leftInfo.allTreeMax;
        }
        int p2 = Integer.MIN_VALUE;
        if(rightInfo != null){
            p2 = rightInfo.allTreeMax;
        }
        int p3 = x.value;
        int p4 = Integer.MIN_VALUE;
        if(leftInfo != null){
            p4 = leftInfo.fromHeadMax + x.value;
        }
        int p5 = Integer.MIN_VALUE;
        if(rightInfo != null){
            p5 = rightInfo.fromHeadMax + x.value;
        }
        int allTreeMax = Math.max(Math.max(Math.max(p1,p2),Math.max(p3,p4)),p5);
        int fromHeadMax = Math.max(Math.max(p3,p4),p5);
        return new Info(allTreeMax,fromHeadMax);
    }

    public static int maxDis2(Node head){
        if(head == null){
            return 0;
        }
        return process2(head).allTreeMax;
    }

    //任何节点到任何节点最大距离
    public static Info process3(Node x){
        if(x == null){
            return null;
        }
        Info leftInfo = process3(x.left);
        Info rightInfo = process3(x.right);
        int p1 = Integer.MIN_VALUE;
        if(leftInfo != null){
            p1 = leftInfo.allTreeMax;
        }
        int p2 = Integer.MIN_VALUE;
        if(rightInfo != null){
            p2 = rightInfo.allTreeMax;
        }
        int p3 = x.value;
        int p4 = Integer.MIN_VALUE;
        if(leftInfo != null){
            p4 = x.value + leftInfo.fromHeadMax;
        }
        int p5 = Integer.MIN_VALUE;
        if(rightInfo != null){
            p5 = x.value + rightInfo.fromHeadMax;
        }
        int p6 = Integer.MIN_VALUE;
        if(rightInfo != null && leftInfo != null){
            p6 = leftInfo.fromHeadMax + rightInfo.fromHeadMax + x.value;
        }
        int allTreeMax = Math.max(Math.max(Math.max(Math.max(p1,p2),Math.max(p3,p4)),p5),p6);
        int fromHeadMax = Math.max(Math.max(p3,p4),p5);
        return new Info(allTreeMax,fromHeadMax);
    }

    public static int maxDis3(Node head){
        if(head == null){
            return 0;
        }
        return process3(head).allTreeMax;
    }
}
