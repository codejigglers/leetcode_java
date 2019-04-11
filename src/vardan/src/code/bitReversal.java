package code;

public class bitReversal {

    public static void main(String[] args) {
        System.out.println(reverseBits(3));
    }

    public static int reverseBits(int n) {
        int result = 0;

        for(int i = 0; i < 32; i++, n>>=1){
            result = result | (n & 1) << (31 - i);
        }

        return result;
    }
}
