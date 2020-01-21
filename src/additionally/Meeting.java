package additionally;

import items.Shorties;
import items.Subject;

public class Meeting {
    public static void meetShortie(Shorties shortie1, Subject subject) {
        Shorties shortie2 = (Shorties) subject;
        System.out.println(shortie1+" увидел, перед собой "+ shortie2);
        shortie1.say(shortie2.getName());
        shortie2.say(shortie1.getName());
    }
}

