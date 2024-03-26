package zombie;

//보스인지 아닌지 구분해서 공격 

public class Hero extends Unit{
	private int heal;
	private int magic;
	private int power;
	
	public Hero(int pos, int hp, int max, int portion,int magic) {
		super(pos,hp,max);
		this.heal = heal;
		this.magic = magic;
	}
	
	@Override
	void attack(Unit enemy) {
		
		if(enemy instanceof Boss) {
			Boss boss = (Boss)enemy;
			power = r.nextInt(max)+1;
			if(boss.getShield() > 0) {
				int shield = boss.getShield()-power;
				if(shield >= 0)
					boss.setShield(boss.getShield()-power);
				else {
					boss.setShield(0);
					boss.setHp(boss.getHp() + shield);
					System.out.println("BOSS의 단단한 갑옷이 부셔졌다!");
				}
			}else
				boss.setHp(boss.getHp()-power);
			
			if(boss.getHp() <= 0)
				boss.setHp(0);
			
			System.out.printf("HERO가 %d의 피해를 입힘\nBOSS shield : %d\nBOSS hp : %d",
					power,boss.getShield(),boss.getHp());
			
			if(boss.getHp() == 0)
				System.out.println("HERO가 BOSS를 물리쳤다!");
			
		}else {
			
			power = r.nextInt(max)+1;
			enemy.setHp(enemy.getHp()-power);
			if(enemy.getHp()<= 0) 
				enemy.setHp(0);
			
			System.out.printf("HERO가 %d의 피해를 입힘\nZOMBIE hp : %d",power,enemy.getHp());
			
			if(enemy.getHp() == 0)
				System.out.println("HERO가 ZOMBIE를 물리쳤다!");
		}
	}
}
