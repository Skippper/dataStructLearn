package com.atguigu.sparsearr;

import java.io.*;
import java.util.Arrays;

/**
 * 稀疏数组
 */
public class AlgorithmDemo01 {


    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\代码\\DataStructures\\src\\com\\atguigu\\sparsearray\\map.data"));
        BufferedReader br ;
        int [][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        for (int[] row : chessArr) {

            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二位数组转陈稀疏数组
        //1.将二维数组遍历,得到非0数据的个数
        //
        int sum = 0;
        for (int i = 0; i !=chessArr.length ; ++i) {
            for (int j = 0; j != chessArr[i].length; ++j) {
                if (chessArr[i][j] != 0){
                    sum ++;
                }
            }
        }
        System.out.println(sum);
        //2.创建对应的稀疏数组
        int [][]sparseArr = new int[sum+1][3];
            //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

            //遍历二维数组,将非0的值存入到稀疏数组中
        int count =0; //用于记录是第几个非0数据
        for (int i = 0; i !=chessArr.length ; ++i) {
            for (int j = 0; j != chessArr[i].length; ++j) {
                if (chessArr[i][j] != 0){
                    count++;
                   sparseArr[count][0] =i;
                   sparseArr[count][1] =j;
                   sparseArr[count][2] =chessArr[i][j];
                }
            }
        }
        //输出稀疏数组并且写入到文件
        System.out.println("得到的稀疏数组为:");
        getSparseArrAndWrite(bos,sparseArr);

        // 读取文件的稀疏数组并且恢复成之前的二维数组
        br = new BufferedReader(new FileReader("E:\\BaiduNetdiskDownload\\尚硅谷Java数据结构和算法\\代码\\DataStructures\\src\\com\\atguigu\\sparsearray\\map.data"));

        int[][] chessArr2 = recoverSparseArr(br);


//        for (int i = 1; i !=sparseArr.length ; ++i) {
//            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
//        }

        System.out.println("恢复后的二维数组为:");
        for (int[] row : chessArr2) {

            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }

    private static void getSparseArrAndWrite(BufferedOutputStream bos, int [][] sparseArr) throws IOException {

        int rowCount =0;
        for (int[] row : sparseArr) {

            for (int data : row) {
                rowCount ++;
                System.out.printf("%d\t",data);
                String dataStr = String.format("%d\t", data);
                bos.write(dataStr.getBytes());
                if (rowCount == 3){
                    bos.write("\n".getBytes());
                }


            }
            rowCount =0;
            System.out.println();
        }
        bos.close();
    }

    private static int[][] recoverSparseArr(BufferedReader br) throws IOException {
        String firstLine = br.readLine();
        String[] rowArr = firstLine.split("\\s+");
        int [][] chessArr2 = new int[Integer.parseInt(rowArr[0])][Integer.parseInt(rowArr[1])];
        //将稀疏数组恢复成之前的二维数组
        /**
         * 1. 读取稀疏数组第一行,根据第一行数据创建原始的二维数组
         * 2. 再读取稀疏数组后几行的数据,并赋值给原始的二维数组即可
         */
        int b = 0;
        int lineCount = 0;
        while ((b = br.read())!=-1){
            String dataStr = br.readLine();
            String[] dataArr = dataStr.split("\\s+");
            lineCount++;
            chessArr2[lineCount][Integer.parseInt(dataArr[1])] = Integer.parseInt(dataArr[2]);
        }

        System.out.println("一共" + lineCount);
        return chessArr2;
    }

}
