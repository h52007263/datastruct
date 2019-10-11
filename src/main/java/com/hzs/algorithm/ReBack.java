package com.hzs.algorithm;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 回溯实现N皇后问题
 * @date 2019/9/16 15:42
 */

public class ReBack {

    // 棋盘格子的范围
    static final int MAX_NUM = 4;
    // 二维数组作为棋盘
    int chessBoard[][] = new int[MAX_NUM][MAX_NUM];

    public static void main(String[] args) {
        ReBack reBack = new ReBack();
        reBack.settleQueue(0);
        reBack.printChessBoard();
    }

    // 检查落点是否符合规则
    boolean check(int x, int y) {
        for (int i = 0; i < y; i++) {
            // 检查纵向
            if (chessBoard[x][i] == 1) {
                return false;
            }
            // 检查左侧斜向
            if (x - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 -i] == 1) {
                return false;
            }
            // 检查右边斜向
            if (x + 1 + i < MAX_NUM && chessBoard[x + 1 + i][y - 1 - i] == 1) {
                return false;
            }
        }
        return true;
    }

    // 放置皇后
    boolean settleQueue(int y) {
        // 行数超过MAX_NUM，找到答案
        if (y == MAX_NUM) {
            return true;
        }
        // 遍历当前行
        for (int i = 0; i < MAX_NUM; i++) {
            // 为当前行清零
            for (int x = 0; x < MAX_NUM; x++) {
                chessBoard[x][y] = 0;
            }
            // 检查是否符合规则，符合就更改元素，进一步递归
            if (check(i, y)) {
                chessBoard[i][y] = 1;
                // 继续放置下一个皇后
                if (settleQueue(y + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printChessBoard() {
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

}
