package zombie;

import java.util.Random;

abstract public class Unit {
	private int pos;
	private int hp;
	
	private int max;
	private Random r;
	
	public Unit(int pos, int hp, int max) {
		this.pos = pos;
		this.hp = hp;
		this.max = max;
		r = new Random();
	}
	
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public int getPos() {
		return this.pos;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getMax() {
		return max;
	}
	
	public void move() {
		if(pos <= 10) {
			pos ++;
			System.out.println("오른쪽으로 이동. 현재위치 : " + pos);
		}
	}
	abstract void attack(Unit unit);
}
