import java.util.Scanner;

// 1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
// 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
// 3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
// 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
// 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
// 6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
// 7. *Сравнить время выполнения пункта 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
public class HW_2 {
    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        System.out.println("Задача № 1: ");
        System.out.print("Введите первую строку: ");
        String input1 = inScanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String input2 = inScanner.nextLine();
        inScanner.close();

        inFind(input1, input2);
        System.out.println();
        if (revStr(input1, input2)) {
            System.out.println("Задача № 2: \nВведенные строки являются вращением друг друга");
        } else
            System.out.println("Задача № 2: \nВведенные строки не являются вращением друг друга");
        System.out.printf("Задача № 3: \nПеревёрнутая первая строка: %s\n", revstrRec(input1));
        System.out.printf("Перевёрнутая вторая строка: %s\n", revstrRec(input2));
        int num1 = 3;
        int num2 = 56;

        System.out.println("Задача № 4: ");
        System.out.println(glueStr(num1, num2,'+'));
        System.out.println(glueStr(num1,num2,'-'));
        System.out.println(glueStr(num1,num2,'*'));

        System.out.println("Задача № 5: ");
        System.out.println(replaceDel(glueStr(num1,num2,'+')));
        System.out.println("Задача № 6: ");
        System.out.println(replaceBuild(glueStr(num1,num2,'-')));
        System.out.println("Задача № 7: ");
        long start = System.currentTimeMillis();
        replaceString(testStr());
        long stop = System.currentTimeMillis();
        System.out.println("Затраченное время при использовании String в мс: ");
        System.out.println(stop - start);
        long begin = System.currentTimeMillis();
        replaceBuild(testStr());
        long end = System.currentTimeMillis();
        System.out.println("Затраченное время при использовании StringBuilder в мс: ");
        System.out.println(end - begin);
    }

    public static void inFind(String str1, String str2) {
        if (str1.toLowerCase().contains(str2.toLowerCase())) {System.out.print("Вторая строка содержится в первой.");}
        else{System.out.print("Вторая строка не содержится в первой.");}
    }
    public static boolean revStr(String firstStr, String secondStr){
        return firstStr.toLowerCase().equals(new StringBuilder(secondStr.toLowerCase()).reverse().toString());
    }
    public static String revstrRec(String string){
        if (string.length() <= 1){
            return string;
        }
        return revstrRec(string.substring(1))+ string.charAt(0);
    }
    public static String glueStr(int number1, int number2, char symbol){
        StringBuilder app = new StringBuilder();
        app.append(number1).append(" ").append(symbol).append(" ").append(number2).append(" = ");
        switch (symbol) {
            case '+' -> app.append(number1 + number2);
            case '-' -> app.append(number1 - number2);
            case '*' -> app.append(number1 * number2);
        }
        return app.toString();
    }
    public static String replaceDel(String app){
        StringBuilder get = new StringBuilder(app);
        int i = get.indexOf("=");
        return get.deleteCharAt(i).insert(i,"равно").toString();
    }
    public static String replaceBuild(String app){
        StringBuilder get = new StringBuilder(app);
        int i = get.indexOf("=");
        return get.replace(i,i+1,"равно").toString();
    }
    public static String replaceString(String app){
        app.replace("=","равно");
        return app;
    }
    public static String testStr(){
        int N = 10000;
        char[] charArray = new char[N];
        for (int i = 0; i < N; i++) {
            charArray[i] = '=';
        }
        String testString = new String(charArray);
        return testString;
//        System.out.println(testString);
    }
}