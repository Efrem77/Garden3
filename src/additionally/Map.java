package additionally;


import items.Shorties;
import items.Subject;

public class Map {
    private static Map map;
    private static Cage[] arr = new Cage[100];

    private Map() {//Прописали синголтон
        for (int i = 0; i < 100; i++) {
            arr[i] = new Cage();
        }
    }

    public static Map getMap() {
        if (map == null) {
            map = new Map();
        }
        return map;
    }

    public void removeOnMap(Subject subject, int x1) {
        arr[x1].remove(subject);
    }//удаляем из ячейки

    public void addOnMap(Subject subject, int x2) {
        arr[x2].add(subject);
    }//добавляем в ячейку

    public void findShortieOnPoint(Shorties shorties, int x) {//ищем в ячйке
        for (int i = 0; i < arr[x].size(); i++) {
            if ((arr[x].get(i) instanceof Shorties) &&(!arr[x].get(i).equals(shorties))) {//Проверяем какие коротышки видят коротышку
                Meeting.meetShortie(shorties, arr[x].get(i));
            }
        }
    }
}


