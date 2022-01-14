package OtherProblems.BitOperation;

public class SwitchOddAndEven {//交换一个数相邻的奇数位与偶数位

    public static void main(String[] args) {
//        int num = 0xaaaaaaaa;
        int num = 0b0100000_00000000_00000000_00000000; //jdk8的特殊用法
        int switchNum = Switch(num);
        System.out.printf("%x",switchNum);
    }

    private static int Switch(int num){
        int evenMask = 0xaaaaaaaa; //32位的偶数掩码
        int oddMask = 0x55555555; //32位的奇数掩码
        int even = num & evenMask;
        int odd = num & oddMask;
        return(odd << 1)+(even >> 1);//用加法还是异或两个都行
    }
}
