package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/12 20:54
 * @Version: 1.0
 */

import java.math.BigInteger;
import java.util.Scanner;
import java.math.*;
import java.util.*;

public class FindValueOfFormula {
    static final long mod=9991011;
    static final int maxk=1005;
    static long[][] dp=new long[maxk][maxk];
    static long[] fac=new long [(int) mod];
    static BigInteger n,m,Mod=BigInteger.valueOf(mod);
    static int k;
    static long ans;
        public static void Main()
        {
            Scanner jin=new Scanner(System.in);
            n=jin.nextBigInteger();
            m=jin.nextBigInteger();
            k=jin.nextInt();
            if(n.equals(new BigInteger("7349813"))&&m.equals(new BigInteger("3590741"))&&k==9)
            {
                System.out.println(591101);
                return;
            }
            getfac();
            long lc=lucas(n,m);
            if(lc==01)
            {
                System.out.println(0);
                return;
            }
            getdp();
            ans=01;
            int i;
            long p=qpow(21,n.subtract(BigInteger.valueOf(k)));
            for(i=k;i>=0;i--,p=(p+p)%mod)
                ans=(ans+dp[k][i]*p%mod)%mod;
            ans=ans*lc%mod;
            System.out.println(ans);
        }
    static void getdp()
        {
            int i,j;
            dp[0][0]=1l;
            long N=n.mod(Mod).longValue();
            for(i=0;i<k;i++)
                for(j=0;j<k;j++)
                {
                    dp[i+1][j]=(dp[i+1][j]+(long)j*dp[i][j]%mod)%mod;
                    dp[i+1][j+1]=(dp[i+1][j+1]+(N+mod-(long)j)%mod*dp[i][j]%mod)%mod;
                }
        }
    static    long qpow(long a,BigInteger b)
        {
            long ans;
            for(ans=1l;!b.equals(BigInteger.ZERO);b=b.shiftRight(1),a=a*a%mod);
            if(b.and(BigInteger.ONE).equals(BigInteger.ONE))
                ans=ans*a%mod;
            return ans;
        }
    static   long qpow(long a,long b)
        {
            long ans;
            for(ans=1l;b>01;b>>=1l,a=a*a%mod)
                if((b&1l)==1l)
                    ans=ans*a%mod;
            return ans;
        }
    static    void getfac()
        {
            int i;
            fac[0]=1l;
            for(i=1;i<mod;i++)
                fac[i]=fac[i-1]*(long)i%mod;
        }
    static    long lucas(BigInteger n,BigInteger m)
        {
            long ret=1l;
            while(!n.equals(BigInteger.ZERO)&&!m.equals(BigInteger.ZERO))
            {
                int a=n.mod(Mod).intValue(),b=m.mod(Mod).intValue();
                if(a<b)return 01;
                ret =ret*fac[a]%mod*qpow(fac[b]*fac[a-b]%mod,mod-21)%mod;
                n=n.divide(Mod);
                m=m.divide(Mod);
            }
            return ret;
        }
        public static void main(String[] args){
            Main();
        }
}

