package com.learn.exam.spring2020;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 瞬步移动
 * 一个地图n*m，包含1个起点"S"，1个终点"E"，其他点包括可达点"."和不可达点"#"。
 * 每一次可以：上下左右移动，或使用1点能量从（i,j)瞬间移动到（n-1-i, m-1-j)，最多可以使用5点能量。
 * 求从起点到终点的最少步数
 *
 * @author yymuhua
 * @create 2020-04-13 14:54
 */
public class FlashMove {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;
    static int endX;
    static int endY;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        char[][] map = new char[n][m];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map[i] = input.next().toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    Node pair = new Node(i, j);
                    queue.add(pair);
                } else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        System.out.println(BFS(map, queue));
    }

    public static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m)
            return true;
        return false;
    }

    public static int BFS(char[][] map, Queue<Node> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node thisNode = queue.poll();
                if (thisNode.x == endX && thisNode.y == endY)
                    return thisNode.step;
                for (int i = 0; i < 4; i++) {
                    int curX = thisNode.x + dx[i];
                    int curY = thisNode.y + dy[i];
                    Node neighbor = new Node(curX, curY);
                    neighbor.step = thisNode.step + 1;
                    neighbor.flash = thisNode.flash;
                    if (check(curX, curY) && (map[curX][curY] == '.' || map[curX][curY] == 'E')) {
                        queue.add(neighbor);
                        map[curX][curY] = 'X';
                    }
                }
                int flyX = n - 1 - thisNode.x;
                int flyY = m - 1 - thisNode.y;
                if (check(flyX, flyY) && thisNode.flash < 5 && (map[flyX][flyY] == '.' || map[flyX][flyY] == 'E')) {
                    Node pair = new Node(flyX, flyY);
                    pair.step = thisNode.step + 1;
                    pair.flash = thisNode.flash + 1;
                    queue.add(pair);
                    map[flyX][flyY] = 'X';
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int step; // 到达这个节点的步数
        int flash;  // 到达这个节点使用的闪现次数

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
