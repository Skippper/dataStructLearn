package com.atguigu.recursion;

public class Maze {

    public static void main(String[] args) {
        //创建二维数组,模拟迷宫
        int[][] map = new int[8][7];

        //1表示墙
        //上下全部置为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }


        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //输出地图
        System.out.println("当前地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t",map[i][j]);
            }
            System.out.println();
        }

        map[3][1] = 1;
        map[3][2] = 1;

        setWay(map,1,1);
        System.out.println("当前地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t",map[i][j]);
            }
            System.out.println();
        }

    }
    //使用快速回溯找路线
    //  i , j 表示从地图哪个位置开始找(1,1)
    //  如果球到map[6][5]位置表示找到
    //约定: 当map[i][j] 为0时表示该点没有走过 1表示墙, 2表示可以走
    /**
     *
     * @param map
     * @param i 从哪个位置开始找
     * @param j
     * @return  找到路线返回true
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
           if (map[i][j] == 0){
               map[i][j] = 2;
               if (setWay(map, i+1, j)){
                   return true;
               }else if (setWay(map, i, j +1)){
                   return true;
               }else if (setWay(map, i -1, j)){
                   return true;
               }else if (setWay(map, i, j -1 )){
                   return true;
               }else {
                   map[i][j] = 3;
                   return false;
               }
           }else {
               return false;
           }
        }
    }
}
