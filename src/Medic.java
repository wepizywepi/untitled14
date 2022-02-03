import java.util.Random;

public class Medic extends Hero {

    public Medic(int health, int damage) {
        super(health, damage);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        int isAvailable = new Random().nextInt(2);
        if (isAvailable == 1){
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getClass().getSimpleName() != "Medic"){
                    int randomHero = new Random().nextInt(heroes.length);
                    final int min = 100;
                    final int max = 250;
                    final int randomHealth = new Random().nextInt((max - min) + 1) + min;
                    heroes[randomHero].setHealth(heroes[randomHero].getHealth() + randomHealth);
                    System.out.println("Medic healed " + heroes[randomHero].getClass().getSimpleName() + " on " + randomHealth);
                    break;
                }
            }
        } else {

        }
    }
}
