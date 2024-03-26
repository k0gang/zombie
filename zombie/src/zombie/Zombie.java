package zombie;

public class Zombie extends Unit{
	private int power;
	
	public Zombie(int pos, int hp, int max) {
		super(pos, hp, max);
	}
	
	@Override
	public void attack(Unit hero) {
		power = r.nextInt(max)+1;
		
		hero.setHp(hero.getHp()-power);
		
		if(hero.getHp() <= 0)
			hero.setHp(0);
		
		this.setHp(this.getHp()+power/2);
		
		System.out.printf("ZOMBIE가 %d의 피해를 입히고 %d만큼 회복\nHero hp : %d"
				+ "\nZombie hp : %d\n",power,power/2,hero.getHp(),this.getHp());
	}
}
