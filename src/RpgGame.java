public class RpgGame {

    private static void printStatistics(Hero heroes[], Boss boss) {
        System.out.println("-----------------");
        System.out.println("Boss health:" + boss.getHealth());
        for (Hero hero : heroes) {
            System.out.println(hero.getClass().getSimpleName()
                    + "current health:" + hero.getHealth());
        }
        System.out.println("------------");
    }

    private static void heroeshits(Hero heroes[], Boss boss) {
        for (Hero hero : heroes) {
            int heroDamage = hero.getDamage();
            boss.damage(heroDamage);
            System.out.println(hero.getClass().getSimpleName()
                    + " attack Boss -" + heroDamage);
        }
    }

    private static void bossHits(Hero heroes[], Boss boss) {
        for (Hero hero : heroes) {
            int BossDamage = boss.getDamage();
            short  bossDamage;
            hero.damage(bossDamage);
            System.out.println("Boss attack " + hero.getClass().getSimpleName()
                    + " - " + bossDamage);

        }
    }

    private static void isFinish(Hero heroes[], Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void round(Hero heroes[], Boss boss) {
        bossHits(heroes, boss);
        heroeshits(heroes, boss);
        printStatistics(heroes, boss);
    }

    public static Hero[] createHeroes() {
        Hero[] heroes = {};
        Hunter hunter = new Hunter(1200, 250);
        Magical magical = new Magical(1000, 300);
        Warrior warrior = new Warrior(1400, 350);
        Medic medic = new Medic(1500, 0);
        Hero[] heroes = {hunter, magical, warrior, medic};
        return heroes;

    }

    public static void startGame() {
        Hero[] heroes = createHeroes();
        Boss boss = new Boss(2000, 400);
        printStatistics(heroes, boss);
        while (!isFinish(heroes, boss)) {
            round(heroes, boss);
        }
    }

    public class RpgGame {

        private static int roundCounter = 1;

        private static void printStatistics(Hero heroes[], Boss boss) {
            System.out.println("-----------------");
            System.out.println("Round: " + roundCounter);
            System.out.println("Boss health: " + boss.getHealth());
            for (Hero hero : heroes) {
                System.out.println(hero.getClass().getSimpleName()
                        + " health: " + hero.getHealth());
            }
            System.out.println("-----------------");
        }

        private static void heroesHits(Hero heroes[], Boss boss) {
            for (Hero hero : heroes) {
                int heroDamage = hero.getDamage();
                if (hero.getHealth() > 0) {
                    boss.damage(heroDamage);
                    System.out.println(hero.getClass().getSimpleName()
                            + " attack Boss -" + heroDamage);
                }
            }
        }

        private static void bossHits(Hero heroes[], Boss boss) {
            for (Hero hero : heroes) {
                int bossDamage = boss.getDamage();
                hero.damage(bossDamage);
                System.out.println("Boss attack " + hero.getClass().getSimpleName()
                        + " - " + bossDamage);
            }
        }

        private static boolean isFinish(Hero heroes[], Boss boss) {
            if (boss.getHealth() <= 0) {
                System.out.println("Heroes won!!!");
                return true;
            }

            boolean allHeroesDead = true;
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    allHeroesDead = false;
                    break;
                }
            }

            if (allHeroesDead) {
                System.out.println("Boss won!!!");
            }

            return allHeroesDead;

        }

        private static void round(Hero heroes[], Boss boss) {
            if (boss.getHealth() > 0) {
                bossHits(heroes, boss);
            }
            heroesHits(heroes, boss);
            applyAbility(heroes, boss);
            printStatistics(heroes, boss);
        }

        private static void applyAbility(Hero heroes[], Boss boss) {
            for (Hero hero : heroes) {
                hero.useAbility(heroes, boss);
            }
            boss.useAbility(heroes, boss);
        }

        private static Hero[] createHeroes() {
            Hunter hunter = new Hunter(1600, 250);
            Magical magical = new Magical(1500, 300);
            Warrior warrior = new Warrior(1400, 300);
            Medic medic = new Medic(1500, 0);
            Hero[] heroes = {hunter, magical, warrior, medic};
            return heroes;
        }

        public static void startGame() {
            Hero[] heroes = createHeroes();
            Boss boss = new Boss(3000, 400);
            while (!isFinish(heroes, boss)) {
                round(heroes, boss);
                roundCounter++;
            }
        }
    }
}