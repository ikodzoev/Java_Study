import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
// 1. Создать новый список, добавить несколько строк с названиями цветов и вывести коллекцию на экран.
// 2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
// 3. Вставить элемент в список в первой позиции.
// 4. Извлечь элемент (по указанному индексу) из заданного списка.
// 5. Обновить определенный элемент списка по заданному индексу.
// 6. Удалить третий элемент из списка.
// 7. Поиска элемента в списке по строке.
// 8. Создать новый список и добавить в него несколько елементов первого списка.
// 9. Удалить из первого списка все элементы отсутствующие во втором списке.
// 10. *Сортировка списка.
// 11. *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.

public class HW_3 {
    public static void main(String[] args){
        // 1.
        System.out.println("Задача № 1:");
        System.out.println(colorsList());
        // 2.
        System.out.println("Задача № 2:");
        System.out.println(iteration(colorsList()));
        // 3.
        System.out.println("Задача № 3:");
        System.out.println(insertTop(iteration(colorsList())));
        // 4.
        System.out.println("Задача № 4:");
        System.out.println(extractElem(insertTop(iteration(colorsList()))));
        // 5.
        System.out.println("Задача № 5:");
        System.out.println(updateElem(insertTop(iteration(colorsList())), "синий", "синий!"));
        // 6.
        System.out.println("Задача № 6:");
        System.out.println(delList(updateElem(insertTop(iteration(colorsList())), "синий", "синий!")));
        // 7.""
        System.out.println("Задача № 7:");
        String searchElem = "белый!";
        System.out.println(searchElem(delList(updateElem(insertTop(iteration(colorsList())), "синий", "синий!")), searchElem));
        // 8.
        System.out.println("Задача № 8:");
        System.out.println(newcolorsList());
        // 9.
        System.out.println("Задача № 9:");
        System.out.println(findDiff());
        // 10.
        System.out.println("Задача № 10:");
        System.out.println(sortList(delList(updateElem(insertTop(iteration(colorsList())), "синий", "синий!"))));
    }
    // Задача № 1.Создать новый список, добавить несколько строк с названиями цветов и вывести коллекцию на экран.
    public static List<String> colorsList(){
        List<String> colors = new ArrayList<>();
        colors.add("зелёный");
        colors.add("красный");
        colors.add("белый");
        return colors;
    }
    // Задача № 2.Итерация всех элементов списка цветов и добавления к каждому символа '!'.
    public static List<String> iteration(List<String> getlist){
        ListIterator<String> newList = getlist.listIterator();
        while (newList.hasNext()){
            newList.set(newList.next().concat("!"));
        }
        return getlist;
    }
    // 3. Вставить элемент в список в первой позиции.
    public static List<String> insertTop(List<String> getlist){
        getlist.add(0, "синий");
        return getlist;
    }
    // 4. Извлечь элемент (по указанному индексу) из заданного списка.
    public static String extractElem(List<String> getlist){
        return getlist.get(3);
    }
    // 5. Обновить определенный элемент списка по заданному индексу.
    public static List<String> updateElem(List<String> getlist, String firstElem, String secondElem){
        getlist.set(getlist.indexOf(firstElem), secondElem);
        return getlist;
    }
    // 6. Удалить третий элемент из списка.
    public static List<String> delList(List<String> getlist){
        getlist.remove(2);
        return getlist;
    }
    // 7. Поиска элемента в списке по строке.
    public static boolean searchElem (List<String> getlist, String elem){
        return getlist.contains(elem);
    }

    // 8. Создать новый список и добавить в него несколько элементов первого списка.
    public static List<String> newcolorsList(){
        List<String> colors = new ArrayList<>();
        colors.add("зелёный!");
        colors.add("синий!");
        return colors;
    }
    // 9. Удалить из первого списка все элементы отсутствующие во втором списке.
    public static List<String> findDiff() {
        List<String> diff = newcolorsList();
        diff.removeAll(colorsList());
        return diff;
    }
    // 10. *Сортировка списка.
    public static List<String> sortList(List<String> getlist){
        Collections.sort(getlist);
        return getlist;
    }

}
