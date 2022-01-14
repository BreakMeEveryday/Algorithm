package Month4.buleBridge.AlgoTraining;

import java.math.BigInteger;
import java.util.Scanner;

public class P0505 {
    static int n;

    public static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
    }

    public static void solve(){
//        long long  res = n;
        Integer N = new Integer(n);
        BigInteger res = new BigInteger(N.toString());
        BigInteger TEN = new BigInteger("10");
        while(--n > 0){
//            res = res*n % ((int)Math.pow(10,10));
//            while(res % 10 == 0){ //尾部有0
//                res /= 10;        //去尾部0
//            }
            N = n;
            res = res.and(new BigInteger(N.toString()));
            while(res.mod(TEN) == BigInteger.ZERO){
                res = res.divide(TEN);
            }
        }

//        return res%10;
        System.out.println(res.mod(TEN)); //最右边的非0元素
    }



    public static void main(String[] args) {
        input();
        solve();
//        System.out.println(10^10);//0
    }
}
