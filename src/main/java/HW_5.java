import java.util.HashMap;

// Создать множество, ключ и значение строки. Добавить шесть элементов. Вывести в консоль значения.
// Добавить ко всем значениям символ "!".
// Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключами первого.
// Объединить значения во втором множестве и первом, если ключи совпадают. Вывести результат в консоль.

public class HW_5 {
    public static void main(String[] args) {

        // Создать множество, ключ и значение строки. Добавить шесть элементов. Вывести в консоль значения.
        HashMap<Integer, String> colorsFirst = new HashMap<>();
        colorsFirst.put(4, "белый");
        colorsFirst.put(8, "синий");
        colorsFirst.put(16, "жёлтый");
        colorsFirst.put(32, "зелёный");
        colorsFirst.put(64, "красный");
        colorsFirst.put(128, "чёрный");
        colorsFirst.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(colorsFirst);

        // Добавить ко всем значениям символ "!".
        colorsFirst.computeIfPresent(4, (k, v) -> v += '!');
        colorsFirst.computeIfPresent(8, (k, v) -> v += '!');
        colorsFirst.computeIfPresent(16, (k, v) -> v += '!');
        colorsFirst.computeIfPresent(32, (k, v) -> v += '!');
        colorsFirst.computeIfPresent(64, (k, v) -> v += '!');
        colorsFirst.computeIfPresent(128, (k, v) -> v += '!');
        System.out.println(colorsFirst);
        colorsFirst.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(colorsFirst);

        // Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключами первого.
        HashMap<Integer, String> colorsSec = new HashMap<>();
        colorsFirst.put(2, "белый");
        colorsFirst.put(1, "синий");
        colorsFirst.put(10, "жёлтый");
        colorsFirst.put(8, "оранжевый");
        colorsFirst.put(4, "красный");
        colorsFirst.put(6, "лиловый");

        // Объединить значения во втором множестве и первом, если ключи совпадают. Вывести результат в консоль.
        for (Integer item : colorsFirst.keySet()) {
            colorsFirst.merge(item, colorsSec.getOrDefault(item, ""), (newVal, tempVal) -> newVal + tempVal);
        }
        System.out.println(colorsFirst);
        colorsFirst.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
