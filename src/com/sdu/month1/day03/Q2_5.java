package com.sdu.month1.day03;

import java.util.Comparator;
import java.util.PriorityQueue;

/**二维数组装水问题
 * @author huaikong
 * @create 2021-02-01 8:04
 */
public class Q2_5 {

    public static class Node{
        public int value;
        public int row;
        public int col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }
    }

    public static int water(int[][] arr){
        if(arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0){
            return 0;
        }
        int N = arr.length;
        int M = arr[0].length;
        boolean[][] isEnter = new boolean[N][M];
        PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
        for(int col = 0;col < M ;col++){
            isEnter[0][col] = true;
            isEnter[N - 1][col] = true;
            heap.add(new Node(arr[0][col],0,col));
            heap.add(new Node(arr[N - 1][col],N - 1,col));
        }
        for(int row = 1;row < N - 1;row++){
            isEnter[row][0] = true;
            isEnter[row][M - 1] = true;
            heap.add(new Node(arr[row][0],row,0));
            heap.add(new Node(arr[row][M - 1],row,M - 1));
        }
        int water = 0;
        int max = 0;
        while(!heap.isEmpty()){
            Node cur = heap.poll();
            max = Math.max(max,cur.value);
            int r = cur.row;
            int c = cur.col;
            if(r > 0 && !isEnter[r - 1][c]){
                water += Math.max(0,max - arr[r - 1][c]);
                isEnter[r - 1][c] = true;
                heap.add(new Node(arr[r - 1][c],r - 1,c));
            }
            if(r < N - 1 && !isEnter[r + 1][c]){
                water += Math.max(0.max - arr[r + 1][c]);
                isEnter[r + 1][c] = true;
                heap.add(new Node(arr[r + 1][c],r + 1 ,c));
            }
            if(c > 0 && !isEnter[r][c - 1]){
                water += Math.max(0,max - arr[r][c - 1]);
                isEnter[r][c - 1] = true;
                heap.add(new Node(arr[r][c - 1],r,c - 1));
            }
            if(c < M - 1 && !isEnter[r][c + 1]){
                water += Math.max(0,max - arr[r][c + 1]);
                isEnter[r][c + 1] = true;
                heap.add(new Node(arr[r][c + 1],r,c + 1));
            }
        }
        return water;
    }

}
