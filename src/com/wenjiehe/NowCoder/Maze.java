package com.wenjiehe.NowCoder;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/7/27.
 */

public class Maze {
    private String command = null;
    private int col;
    private int row;
    private String size;
    private String state;
    private boolean[][] maze;

    Maze(String size, String state) {
        this.size = size;
        this.state = state;
    }

    private boolean[][] render() throws Exception {
        if (size != null && state != null) {
            createMaze();
            modifyMaze();

            return maze;
        } else {
            throw new Exception("Incorrect command format.");
        }
    }

    private void createMaze() throws Exception {
        String[] s = size.split(" ");
        if (s.length == 2) {
            try {
                row = Integer.valueOf(s[0]);
                col = Integer.valueOf(s[1]);
            } catch (NumberFormatException e) {
                throw new Exception("Invalid number format.");
            }

            if (row <= 0 || col <= 0) {
                throw new Exception("Number out of range.");
            }
            maze = new boolean[2 * row + 1][2 * col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[2 * i + 1][2 * j + 1] = true;
                }
            }
            row = 2 * row + 1;
            col = 2 * col + 1;
        } else {
            throw new Exception("Incorrect command format.");
        }

    }

    private void modifyMaze() throws Exception {
        if (maze == null || "".equals(state)) {
            return;
        }
        String[] str = state.split(";");
        if (str.length != 0) {
            String[] first;
            String[] second;
            String[] regStr;
            int fR, fC, sR, sC;
            for (String s : str) {
                regStr = s.split(" ");
                if (regStr.length != 2) {
                    throw new Exception("Incorrect command format.");
                }
                first = regStr[0].split(",");
                second = regStr[1].split(",");
                if (first.length != 2 || second.length != 2) {
                    throw new Exception("Incorrect command format.");
                }

                try {
                    fR = Integer.valueOf(first[0]);
                    fC = Integer.valueOf(first[1]);
                    sR = Integer.valueOf(second[0]);
                    sC = Integer.valueOf(second[1]);
                    // 验证输入的四个数字是否在输入尺寸范围内
                    if (!vertifyNumberRangeCol(fC) ||
                            !vertifyNumberRangeRow(sC) ||
                            !vertifyNumberRangeRow(fR) ||
                            !vertifyNumberRangeRow(sR)) {
                        throw new Exception("Number out of range.");
                    }

                    //验证输入的四个数字是否符合相邻节点限制
                    if (vertifyConnection(fR, fC, sR, sC)) {
                        if (fR == sR) {
                            // 两节点在一行上
                            int max = fC > sC ? 2 * fC : 2 * sC;
                            maze[2 * fR + 1][max] = true;
                        } else {
                            // 两节点再一列上
                            int max = fR > sR ? 2 * fR : 2 * sR;
                            maze[max][2 * fC + 1] = true;
                        }
                    } else {
                        throw new Exception("Number out of range.");
                    }
                } catch (NumberFormatException e) {
                    throw new Exception("Invalid number format.");
                }

            }
        }

    }

    private boolean vertifyConnection(int fR, int fC, int sR, int sC) {

        if (fR == sR) {
            return Math.abs(fC - sC) == 1;
        } else if (Math.abs(fR - sR) == 1) {
            return fC == sC;
        }
        return false;

    }

    private boolean vertifyNumberRangeCol(int x) {
        if (col > 0 && x >= 0 && x < col) {
            return true;
        } else {
            return false;
        }
    }

    private boolean vertifyNumberRangeRow(int x) {
        if (row > 0 && x >= 0 && x < row) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cellSize = null, cellConnectState = null;

        if (sc.hasNext()) {
            cellSize = sc.nextLine();
            cellConnectState = sc.nextLine();
        }

        Maze maze = new Maze(cellSize, cellConnectState);
        boolean[][] result = new boolean[0][];
        try {
            result = maze.render();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {

                    if (result[i][j]) {
                        System.out.print("[R]");
                    } else {
                        System.out.print("[W]");
                    }
                    if (j != result[0].length - 1) {
                        System.out.print(" ");
                    }

                }

                System.out.println();
            }
        }

    }
}
