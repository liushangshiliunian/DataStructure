public class RecursionTest {

    public static void main(String[] args) {
        test2(4);

        System.out.println(factorial(3));
    }

    public static void test(int i){
        if (i>2){
            test(i-1);
        }
        System.out.println(i);
    }
    public static void test2(int i){
        if (i>2){
            test2(i-1);
        }else{
            System.out.println(i);
        }
    }
    public static int factorial(int i){
        if (i==1){
            return 1;
        }else {


            return factorial(i-1)*i ;
        }
    }
}
