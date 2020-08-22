import javax.lang.model.element.NestingKind;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class HuffuManCode {
    public static void main(String[] args) {
//        String content ="i like like like java do you like a java";
//        byte[] contentBytes = content.getBytes();
//        System.out.println(contentBytes.length);
//
//        byte[] huffmanCodesBytes= HuffManTreeZip.huffmanZip(contentBytes);
//        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodesBytes) + " 长度= " + huffmanCodesBytes.length);
//
//
//        //测试一把byteToBitString方法
////        System.out.println(byteToBitString((byte)1));
//        byte[] sourceBytes = HuffManUnzip.decode(HuffManTreeZip.huffmanCodes, huffmanCodesBytes);
//
//        System.out.println("原来的字符串=" + new String(sourceBytes));

//        String srcFile = "e://2.jpg";
//		String dstFile = "e://jpg.zip";
//
//		HuffManTreeZip.zipFile(srcFile, dstFile);
//		System.out.println("压缩文件ok~~");


        String zipFile = "e://jpg.zip";
        String dstFile = "e://3.jpg";
        HuffManUnzip.unZipFile(zipFile, dstFile);
        System.out.println("解压成功!");

//        如何将 数据进行解压(解码)
//        分步过程

//		List<Node> nodes = HuffManTreeZip.getNodes(contentBytes);
//		System.out.println("nodes=" + nodes);
//
//		//测试一把，创建的赫夫曼树
//		System.out.println("赫夫曼树");
//		Node huffmanTreeRoot =HuffManTreeZip.createHuffManTree(nodes);
//		System.out.println("前序遍历");
//		HuffManTreeZip.preOrder(huffmanTreeRoot);
//
//        Map<Byte, String> huffmanCodes = HuffManTreeZip.getCodes(huffmanTreeRoot);
//        System.out.println("~生成的赫夫曼编码表= " + huffmanCodes);
//
//        HuffManTreeZip.zip(contentBytes,huffmanCodes);
//
//        byte[] huffmanCodeBytes = HuffManTreeZip.zip(contentBytes, huffmanCodes);
//        System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));//17
    }
}
class HuffManUnzip{
    public static void unZipFile(String zipFile,String dstFile){
        InputStream is=null;
        ObjectInputStream ois=null;

        OutputStream os=null;

        try {
            is=new FileInputStream(zipFile);
            ois=new ObjectInputStream(is);
            byte[] huffmanBytes=(byte[])ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            os=new FileOutputStream(dstFile);
            os.write(bytes);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                os.close();
                ois.close();
                is.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }



    public static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<huffmanBytes.length;i++){
            byte b = huffmanBytes[i];
            boolean flag=(i== huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b));
        }

        HashMap<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String > entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        ArrayList<Byte> list = new ArrayList<>();
        for (int i=0;i<stringBuilder.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;

            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b=map.get(key);
                if (b==null){
                      count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte[] b=new byte[list.size()];
        for (int i=0;i<list.size();i++){
                b[i]=list.get(i);
        }
        return b;
    }


    public static String byteToBitString(boolean flag,byte b){
        int temp=b;
        if (flag){
            temp|=256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }
}


class  HuffManTreeZip{
    public static void zipFile(String srcFile,String dstFile){
        OutputStream os=null;
        ObjectOutputStream oos=null;
        InputStream is=null;
        try {
             is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            byte[] huffmanBytes=huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(huffmanCodes);


        } catch (Exception e) {
            System.out.println(e.getMessage());;
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }


    public static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        Node huffManTree = createHuffManTree(nodes);
        Map<Byte, String> codes = getCodes(huffManTree);
        byte[] huffmanCodeBytes = zip(bytes, codes);
        return huffmanCodeBytes;
    }


    public static  byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("测试 stringBuilder~~~=" + stringBuilder.toString());
        int len;
        if (stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else {
            len=stringBuilder.length()/8+1;
        }
        byte[] huffmanCodeBytes=new byte[len];
        int index=0;
        for (int i=0;i<stringBuilder.length();i+=8){
            String strByte;
            if (i+8>stringBuilder.length()){
                strByte=stringBuilder.substring(i);
            }else{
                strByte=stringBuilder.substring(i,i+8);
            }
            huffmanCodeBytes[index]=(byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }

    public static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    static Map<Byte,String> huffmanCodes=new HashMap<Byte, String>();
    static StringBuilder stringBuilder=new StringBuilder();

    public static void getCodes(Node node ,String code , StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            if (node.data==null){
                getCodes(node.left,"0",stringBuilder1);
                getCodes(node.right,"1",stringBuilder1);
            }else {
                huffmanCodes.put(node.data,stringBuilder1.toString());
            }
        }

    }


    public static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> Node = new ArrayList<>();

        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b:bytes){
            Integer count = counts.get(b);
            if (count==null){
             counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            Node.add(new Node(entry.getValue(),entry.getKey()));
        }
        return Node;
    }



    public static void preOrder(Node root){
        if (root==null){
            System.out.println("树为空，不能遍历");
        }else {
            root.preOrder();
        }
    }

    public   static Node createHuffManTree(List<Node> nodes){
        while (nodes.size()>1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.weight + right.weight, null);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }
        return nodes.get(0);
    }

}

class Node  implements Comparable<Node> {
    Node left;
    Node right;
    int weight;
    Byte data;

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public Node(int weight, Byte data) {
        this.weight = weight;
        this.data = data;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
         this.right.preOrder();
        }
    }
}