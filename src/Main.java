import additionally.*;
import items.*;


public class Main {

    public static void main(String[] args) {

        Map map = Map.getMap();

        Shorties neznayka = new Shorties(GardenBed.STRAWBERRY, "Незнайка");

        map.addOnMap(neznayka, neznayka.getBed().getXg());//заносим коротышку в список
        System.out.println("На " + neznayka.getBed().getName()+" появился коротышка " + neznayka );

        Shorties clops = new Shorties(GardenBed.POTATO, "Клопс");
        map.addOnMap(clops, clops.getBed().getXg());//заносим коротышку в список
        System.out.println("На " + clops.getBed().getName()+" появился коротышка " + clops );

        Shorties fex = new Shorties(GardenBed.TOMATOES, "Фекс");
        map.addOnMap(fex, fex.getBed().getXg());//заносим коротышку в список
        System.out.println("На " + fex.getBed().getName()+" появился коротышка " + fex );

        Shorties fix = new Shorties(GardenBed.TOMATOES, "Фикс");
        map.addOnMap(fix, fix.getBed().getXg());//заносим коротышку в список
        System.out.println("На " + fix.getBed().getName()+" появился коротышка " + clops );

        Shorties milordik = new Shorties(GardenBed.CUCUMBERS, "Милордик");
        map.addOnMap(milordik, milordik.getBed().getXg());//заносим коротышку в список
        System.out.println("На " + milordik.getBed().getName()+" появился коротышка " + milordik);

        Shorties cezarino = new Shorties(GardenBed.POTATO, "Цезарино");
        map.addOnMap(cezarino, cezarino.getBed().getXg());//заносим коротышку в список
        System.out.println("На " + cezarino.getBed().getName()+" появился коротышка " + cezarino);

        Vegetables pomidors = new Vegetables(GardenBed.TOMATOES, "Помидоры", 15);
        map.addOnMap(pomidors, pomidors.getBed().getXg());//заносим овощ в список
        System.out.println("На грядке растет" + pomidors+ " в количестве " + pomidors.getQuantity() + " штук");

        Vegetables strawberry= new Vegetables(GardenBed.STRAWBERRY, "Клубника", 16);
        map.addOnMap(strawberry, strawberry.getBed().getXg());//заносим овощ в список
        System.out.println("На грядке растет" + strawberry+ " в количестве " + strawberry.getQuantity() + " штук");

        Vegetables cucumbers = new Vegetables(GardenBed.CUCUMBERS, "Огурцы", 18);
        map.addOnMap(cucumbers, cucumbers.getBed().getXg());//заносим овощ в список
        System.out.println("На грядке растет" + cucumbers+ " в количестве " + cucumbers.getQuantity() + " штук");

        Vegetables potato = new Vegetables(GardenBed.TOMATOES, "Картошка", 11);
        map.addOnMap(potato, potato.getBed().getXg());//заносим овощ в список
        System.out.println("На грядке растет" + potato+ " в количестве " + potato.getQuantity() + " штук");

        neznayka.think(GardenBed.TOMATOES );
        neznayka.work();//отправляем жителя на другую грядку
        neznayka.mix(neznayka,pomidors, GardenBed.STRAWBERRY );

        cezarino.think(GardenBed.CUCUMBERS);
        cezarino.setBedTwo(null);
        cezarino.work();//отправляем жителя на другую грядку

        fex.think(GardenBed.POTATO );
        fex.work();//отправляем жителя на другую грядку

        fix.think(GardenBed.STRAWBERRY );
        fix.work();//отправляем жителя на другую грядку
        fix.mix(fix,strawberry, GardenBed.POTATO );

        fex.run(fex, neznayka, fix, clops);

        clops.think(GardenBed.CUCUMBERS );
        clops.work();//отправляем жителя на другую грядку

        clops.run(clops, fix, fex, cezarino);

        milordik.work();//отправляем жителя на другую грядку

        fix.mix(fix,pomidors, GardenBed.TOMATOES );








    }
}