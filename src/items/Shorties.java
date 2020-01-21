package items;

import additionally.*;

import static java.lang.Math.signum;

public class Shorties extends Subject implements Say, Think, Run, Mix, Help, Ambulance {
    private GardenBed bed;
    private GardenBed bedTwo;

    public Shorties(GardenBed bed, String name) {
        this.bed = bed;
        setName(name);
    }

    public void setBed(GardenBed bed) {
        this.bed = bed;
    }

    public GardenBed getBed() {
        return this.bed;
    }

    public void work() {
        if (bedTwo==null) {
            System.out.println("\n"+getName()+ " остался работать на " + bed.getName());
       }
        else {
                System.out.println(getName() + " отправился из " + bed.getName() + " на " + bedTwo.getName());
                Move move = new Move(this, bedTwo);
                Move.go();//определяем текущий город и отправляем в указвнный
                bedTwo = null;
        }
    }


    public void setBedTwo(GardenBed bedTwo) {
        this.bedTwo = bedTwo;
    }

    @Override//Основной
    public void say(String somebody) {
        System.out.println(getName() + " говорит: привет " + somebody);
    }

    @Override
    public void think(GardenBed bedTwo) {
        System.out.println("\n" + getName() + " подумал отправиться на " + bedTwo.getName());
        this.bedTwo = bedTwo;
    }
    @Override
    public void run(Shorties shortie1, Shorties shortie2,Shorties shortie3,Shorties shortie4){
        Map map = Map.getMap();
        boolean b = true;
        int x = shortie1.getBed().getXg();
        System.out.println(shortie1.getName() + " бросился догонять " + shortie2.getName());
        while (x != shortie2.getBed().getXg() && b) {// для каждого x строим соответствующий у
            map.removeOnMap(shortie1, x);
            x += signum(shortie2.getBed().getXg() - shortie1.getBed().getXg());//шагает по x
            map.addOnMap(shortie1, x);
            if (x == shortie2.getBed().getXg()) {
                System.out.println(shortie1.getName() + " догнал " + shortie2.getName());
                shortie1.setBed(shortie2.getBed());
                b = false;
            }
            if(x == GardenBed.TRAP.getXg()){
                System.out.println(shortie1 + " попал в капкан - минус нога и позвал на помощь "+ shortie3+" и "+shortie4);
                shortie1.setBed(GardenBed.TRAP);
                help(shortie1, shortie3, shortie4);
                break;

            }
        }
    }
    @Override
    public void help(Shorties shortie1, Shorties shortie3, Shorties shortie4){
        Map map = Map.getMap();
        boolean shortie1InTrap = true;
        int xs = shortie1.getBed().getXg();
        int xs3 = shortie3.getBed().getXg();
        int xs4 = shortie4.getBed().getXg();
        while ( ((xs3!=xs)||(xs4!=xs))&&shortie1InTrap){
            map.removeOnMap(shortie3, xs3);
            map.removeOnMap(shortie4, xs4);
            xs3 += signum(xs - xs3);
            xs4 += signum(xs - xs4);//шагает по x
            map.addOnMap(shortie3, xs3);
            map.addOnMap(shortie4, xs4);
            if ((xs3 == xs)&&(xs4==xs)) {
                System.out.println(shortie3+ " и " +shortie4 + " пришли на помощь " + shortie1 + " и освободили его из  " + shortie1.getBed().getName());
                shortie1InTrap = false;
                shortie3.setBed(shortie1.getBed());
                shortie4.setBed(shortie1.getBed());
                GardenBed bed= GardenBed.HOUSE;
                System.out.println(shortie3 +" и "+ shortie4+ " понесли пострадавшего "+ shortie1+ " в "+ GardenBed.HOUSE.getName());
                ambulance(shortie1, shortie3,shortie4,bed);

            }
        }
    }
    @Override
    public void ambulance(Shorties shortie1,Shorties shortie3,Shorties shortie4, GardenBed bed){
        Map map = Map.getMap();
        boolean b = true;
        int xw=bed.getXg();
        int xs = shortie1.getBed().getXg();
        int xs3 = shortie3.getBed().getXg();
        int xs4 = shortie4.getBed().getXg();
        while ( ((xs!=xw)||(xs3!=xw)||(xs4!=xw))&&b){
            map.removeOnMap(shortie1, xs);
            map.removeOnMap(shortie3, xs3);
            map.removeOnMap(shortie4, xs4);
            xs += signum(xw - xs);
            xs3 += signum(xw - xs3);
            xs4 += signum(xw - xs4);//шагает по x
            map.addOnMap(shortie1, xs);
            map.addOnMap(shortie3, xs3);
            map.addOnMap(shortie4, xs4);
            if ((xs==xw)&&(xs3 == xw)&&(xs4==xw)) {
                System.out.println(shortie3+ " и "+shortie4+" принесли пострадавшего "+shortie1+" в "+ bed.getName());
                shortie1.setBed(bed);
                shortie3.setBed(bed);
                shortie4.setBed(bed);
                b=false;
            }
        }
    }

    @Override
    public void mix(Shorties shortie1, Vegetables vegetable, GardenBed bed){
        Map map = Map.getMap();
        boolean b = true;
        int x = shortie1.getBed().getXg();
        if(x == vegetable.getBed().getXg()) {
        System.out.println(shortie1.getName() + " взял с собой" + vegetable + " и понес на " +bed.getName());
            while (x != bed.getXg() && b) {// для каждого x строим соответствующий у
                map.removeOnMap(shortie1, x);
                map.removeOnMap(vegetable, x);
                x += signum(bed.getXg() - shortie1.getBed().getXg());//шагает по x
                map.addOnMap(shortie1, x);
                map.addOnMap(vegetable, x);
                if (x == bed.getXg()) {
                    map.findShortieOnPoint(shortie1, x);
                    System.out.println(shortie1.getName() + " вывалил " + vegetable + " на " + bed.getName());
                    shortie1.setBed(bed);
                    vegetable.setBed(bed);
                    b = false;
                }
            }
        }
        else{
            System.out.println(shortie1 + " хотел собрать урожай, но на "+ shortie1.getBed().getName()+ " нет" + vegetable);
        }
    }


    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shorties)) return false;

        Shorties shorties = (Shorties) o;

        if (getBed() != shorties.getBed()) return false;
        return getName() == shorties.getName();
    }

    @Override
    public int hashCode() {
        return getBed().hashCode() +  getName().hashCode();
    }
}

