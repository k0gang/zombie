package zombie;

//보스인지 아닌지 구분해서 공격 

public class Hero extends Unit{
	private int heal;
	private int power;
	
	public Hero(int pos, int hp, int max, int heal) {
		super(pos,hp,max);
		this.heal = heal;
	}
	
	@Override
	public String toString() {
		return String.format("pos : %d, hp : %d, max : %d, heal : %d",this.getPos(),this.getMax(),max,heal);
	}
	
	public void setHeal(int heal) {
		this.heal = heal;
	}
	
	public int getHeal() {
		return this.heal;
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
			
			System.out.printf("HERO가 %d의 피해를 입힘\nBOSS shield : %d\nBOSS hp : %d\n",
					power,boss.getShield(),boss.getHp());
		}else {
			
			power = r.nextInt(max)+1;
			enemy.setHp(enemy.getHp()-power);
			if(enemy.getHp()<= 0) 
				enemy.setHp(0);
			
			System.out.printf("HERO가 %d의 피해를 입힘\nZOMBIE hp : %d\n",power,enemy.getHp());
		}
	}
	
	public void heal() {
		if(heal > 0) {
			setHp(getHp() + 100);
			System.out.printf("HERO의 치유스킬로 체력회복\nHERO hp : %d",getHp());
			heal --;
		}else
			System.out.println("치유스킬을 모두 사용했습니다");
	}
}
