import java.util.Random;

public class Boss extends GameEntity implements IAbility {

    public Boss(int health, int damage) {
        super(health, damage);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        int isAvailable = new Random().nextInt(2);
        if (isAvailable == 1){
            final int min = 100;
            final int max = 250;
            final int randomDamage = new Random().nextInt((max - min) + 1) + min;
            setDamage(getDamage() + randomDamage);
            System.out.println("*****************");
            System.out.println("Boss boosted his damage on - " + randomDamage + "(" + getDamage() + ")");
            System.out.println("*****************");
        } else {

        }
    }
}
