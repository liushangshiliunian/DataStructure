package com.atguigu;

import java.io.*;

public class SparseArray implements Serializable {
    private static final long  serialVersionUID=21321312;

    public static void main(String[] args) throws IOException {
//     二维数组转换为稀疏数组
        int[][] array=new int [11][11];
        array[1][2]=2;
        array[2][3]=1;
        int sum=0;
        for (int[] i:array){
            System.out.println();
            for (int j:i){
                System.out.print(j);
                if (j!=0){
                    sum++;
                }
            }
        }
        int[][] sparse = new int[sum + 1][3];
        sparse[0][0]=11;
        sparse[0][1]=11;
        sparse[0][2]=sum;
        int count =1;
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
             if (array[i][j]!=0){
                 sparse[count][0]=i;
                 sparse[count][1]=j;
                 sparse[count][2]=array[i][j];
                 count++;
             }
            }
        }

        System.out.println();
        System.out.println("================================");
//        稀疏数组转换为二维数组
        int [][] array2=new int [sparse[0][0]][sparse[0][1]];
        for (int i=1;i<sparse.length;i++) {
            array2[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        for (int[] i:array){
            System.out.println();
            for (int j:i){
                System.out.print(j);}}

    }

    }


