package additionally;

import items.*;
import static java.lang.Math.*;

public class Move {
    private static Map map = Map.getMap();
    private static Shorties shorties;
    private static GardenBed bed2;
    private static int x1;
    private static int x2;
    private static int x;
    private static boolean b = true;



    public Move(Shorties shorties, GardenBed bed2) {
        this.shorties = shorties;
        this.bed2 = bed2;
        x1 = shorties.getBed().getXg();
        x2 = bed2.getXg();
        x = x1;
        b=true;
    }

    public static void go() {
        while (x != x2 && b) {
            map.removeOnMap(shorties, x);
            x += signum(x2 - x1);//шагает по x
            map.addOnMap(shorties, x);
            coordinates();
        }
    }

    private static void coordinates() {
        if (x == x2) {
            System.out.println(shorties.getName() + " пришел на " + bed2.getName());
            shorties.setBed(bed2);
            map.findShortieOnPoint(shorties, x);
            b = false;
        }
    }
}



