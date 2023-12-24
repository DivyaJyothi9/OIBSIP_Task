package Chap2;

public class _resulting_data_type {
    public static void main(String[] args) {
        byte x=5;
        int y=6;
        short z = 8;
        int a = y+ z;
        float b = 6.54f + x;
        System.out.println(b);

        // increment and decrement operator
        int i= 56;
        System.out.println(i++); //first it is assigned and then it is incremented
        System.out.println(i);
        System.out.println(++i); //first it is incremented and then it is assigned
        System.out.println(i);
        int p = 7;
        System.out.println( ++p *8);
        char ch = 'r';
        System.out.println(++ch);
    }
}
