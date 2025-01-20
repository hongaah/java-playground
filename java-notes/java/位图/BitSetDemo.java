
import java.util.BitSet;

public class BitSetDemo {
 public static void main(String args[]) {
    // 创建两个 bitSet 集合，存储16位数据
    BitSet bits1 = new BitSet(16);
    BitSet bits2 = new BitSet(16);
 
    // 放入一些数到 bitSet 里面去
    for (int i = 0; i < 16; i++) {
      if ((i % 2) == 0) {
        bits1.set(i);
      }
      if ((i % 5) != 0){
        bits2.set(i);
      }
    }

    System.out.println("Initial pattern in bits1: ");
    System.out.println(bits1);
    System.out.println("\n Initial pattern in bits2: ");
    System.out.println(bits2);

    // AND bits 两个位图中的每一位相与，结果为1的位才保留
    bits2.and(bits1);
    System.out.println("\n bits2 AND bits1: ");
    System.out.println(bits2);

    // OR bits 两个位图中的每一位进行相或，结果为1的位才保留
    bits2.or(bits1);
    System.out.println("\n bits2 OR bits1: ");
    System.out.println(bits2);

    // XOR bits 两个位图中的每一位进行相异或，结果为1的位才保留
    bits2.xor(bits1);
    System.out.println("\n bits2 XOR bits1: ");
    System.out.println(bits2);
 }
}
