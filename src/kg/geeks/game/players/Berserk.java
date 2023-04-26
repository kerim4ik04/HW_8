package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Berserk extends Hero {
    private int blockedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BLOCK_DAMAGE_AND_REVERT);
    }

    @Override
    public int applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getDamage() != 0) {
            setBlockedDamage(RPG_Game.random.nextInt(boss.getDamage() + 1));
            if (boss.getHealth() > 0 && this.getHealth() > 0) {
                this.setHealth(boss.getHealth() - blockedDamage);
                boss.setHealth(boss.getHealth() - blockedDamage + this.getDamage());
                System.out.println("берсерк ударил боса");
            }
        }
        return 0;

    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}
