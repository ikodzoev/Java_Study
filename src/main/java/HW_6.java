import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Разработать программу, имитирующую поведение коллекции HashSet. В программе создать метод add, добавляющий элемент,
// метод toString, возвращающий строку с элементами множества, и метод, позволяющий читать элементы по индексу. Формат данных Integer.
public class HW_6 {
    public static void main(String[] args) {
        NewSet newSet = new NewSet();
        newSet.add(4);
        newSet.add(0);
        newSet.add(7);
        newSet.add(5);
        newSet.add(9);
        newSet.add(4);
        System.out.println(newSet);
        System.out.println(newSet.size());
        System.out.println(newSet.get(newSet.size() - 1));
        ArrayList list = newSet.toArrayList();
        System.out.println(list);
        System.out.println(newSet.contain(3));
        System.out.println(newSet.contain(4));
        System.out.println(newSet.headSet(7));
        System.out.println(newSet.tailSet(7));
        System.out.println(newSet.subSet(4, 7));
    }
}

class NewSet {
    private final Map<Integer, Object> map = new HashMap<>();
    private static final Object OBJECT = new Object();

    public void add(int key) {
        map.put(key, OBJECT);
    }

    public Integer size() {
        return map.size();
    }

    public int get(int key) {
        return (int) map.keySet().toArray()[key];
    }

    public NewSet headSet(int key) {
        NewSet set = new NewSet();
        for (int i = 0; i < map.size(); i++) {
            if ((int) map.keySet().toArray()[i] == key) {
                set.add((int) map.keySet().toArray()[i]);
                break;
            } else set.add((int) map.keySet().toArray()[i]);
        }
        return set;
    }

    public NewSet tailSet(int key) {
        NewSet set = new NewSet();
        for (int i = map.size() - 1; i >= 0; i--) {
            if ((int) map.keySet().toArray()[i] == key) {
                set.add((int) map.keySet().toArray()[i]);
                break;
            } else set.add((int) map.keySet().toArray()[i]);
        }
        return set;
    }

    public NewSet subSet(int key1, int key2) {
        NewSet set = new NewSet();
        boolean flag = false;
        for (int i = 0; i < map.size(); i++) {
            if ((int) map.keySet().toArray()[i] == key1) flag = true;
            if (flag) set.add((int) map.keySet().toArray()[i]);
            if ((int) map.keySet().toArray()[i] == key2) break;
        }
        return set;
    }

    public ArrayList toArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++)
            list.add((int) map.keySet().toArray()[i]);
        return list;
    }

    public boolean contain(int key) {
        return map.containsKey(key);
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }
}

