import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        int isAvailable = new Random().nextInt(2);
        if (isAvailable == 1){
            int criticalDamage = 500;
            if (getHealth() <= 300){
                if (getDamage() >= 600 && getDamage() <= 1000){

                } else {
                    setDamage(getDamage() + criticalDamage);
                    System.out.println("Warrior used his last hit for " + getDamage());
                }
            }
        } else {

        }
    }
}

