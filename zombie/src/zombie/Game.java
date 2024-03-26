package zombie;

import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	Hero hero = new Hero(1, 200, 20, 5);
	Zombie zombie = new Zombie(5, 100, 10);
	Boss boss = new Boss(9, 300, 20, 100);
	
	
	private static Game instance = new Game();
	
	public static Game getInstance() {
		return instance;
	}
	
	private void printStatus() {
		System.out.println("현재 위치 : "+ hero.getPos());
	}
	
	private int inputNumber(String message) {
		int number = -1;
		System.out.print(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	private void move() {
		hero.setPos(hero.getPos()+1);
		
		if(hero.getPos() == zombie.getPos()) {
			System.out.println("야생의 ZOMBIE가 나타났다!");
			
			fight(zombie);
		}
		
		if(hero.getPos() == boss.getPos()) {
			System.out.println("BOSS 등장!");
			
			fight(boss);
		}
	}
	
	private void fight(Unit enemy) {
		while(true) {
			int sel = inputNumber("공격(1), 치유(2)");
			
			if(sel == 1) {
				enemy.attack(hero);
				
				hero.attack(enemy);
				
				if(enemy.getHp() == 0) {
					System.out.println("적을 쓰러트렸다!");
					break;
				}
				
				if(hero.getHp() == 0) {
					System.out.println("HERO가 쓰러졌다!");
					break;
				}
			}else if(sel == 2)
				hero.heal();
		}
	}
	
	private boolean isRun() {
		if(hero.getHp() == 0 || boss.getHp() == 0)
			return false;
		
		return true;
	}
	
	
	
	public void run() {
		while(isRun()) {
			printStatus();
			int sel = inputNumber("앞으로 이동 (1), 종료(2)");
			if(sel == 2)
				break;
			move();
		}
	}
}
