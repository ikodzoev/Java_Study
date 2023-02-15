// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
// Пункты реализовать в методе main
// *Пункты реализовать в разных методах

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int min = Short.MIN_VALUE;
        int max = Short.MAX_VALUE;
        int i = getRandNum();
        System.out.println("Случайное целое число в диапазоне от 0 до 2000: " + i);
        int n = firstBit(i);
        System.out.println("Номер старшего бита из i: n = " + n);
        ArrayList<Integer> m1 = multyArr(i, n, max);
        ArrayList<Integer> m2 = notmultyArr(i, n, min);
        System.out.println("Массив с кратными n числами в диапазоне от i до Short.MAX_VALUE: " + m1);
        System.out.println("Массив с некратными n числами в диапазоне от Short.MIN_VALUE до i: " + m2);
    }

    // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i:
    public static int getRandNum() {
        return new Random().nextInt(2000);
    }

    // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа:
    public static int firstBit(int i) {
        return Integer.toBinaryString(i).length() - 1;
    }

    // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1:
    public static ArrayList<Integer> multyArr(int i, int n, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = i + 1; j <= max; j++) {
            if (j % n == 0) {
                list.add(j);
            }
        }
        return list;
    }

    // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2:
    public static ArrayList<Integer> notmultyArr(int i, int n, int min) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = i - 1; j >= min; j--) {
            if (j % n != 0) {
                list.add(j);
            }
        }
        return list;
    }
}