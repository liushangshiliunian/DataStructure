package com.atguigu;

import java.io.*;

public class ObjecOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("test.txt"));
        try {
            obj.writeObject(new SparseArray());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                obj.flush();
                obj.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("test.txt"));
        SparseArray sparse = (SparseArray) inp.readObject();
        System.out.println(sparse.toString());
        inp.close();
    }
}
