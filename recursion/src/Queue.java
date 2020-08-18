import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.concurrent.ScheduledExecutorService;

public class Queue {
    static int count=0;
    static int judgCount=0;
    int max = 8;
    int[] queue = new int[max];
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.check(0);
        System.out.println(count);
        System.out.println(judgCount);
    }

    public  void check(int n){
        if (n==max){
            print();
            return;
        }
        for (int i=0;i<max;i++){
            queue[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }



//  i表示放置第n个皇后前面的皇后
    public boolean judge(int n){
        judgCount++;
        for (int i=0;i<n;i++){
            if (queue[i]==queue[n]||Math.abs(n-i)==Math.abs(queue[n]-queue[i])){
                    return false;
            }
        }
        return true;

    }


    public void print(){
        count++;
        for (int i=0;i<queue.length;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
}
