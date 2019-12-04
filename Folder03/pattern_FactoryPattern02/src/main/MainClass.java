package main;

import person.Person;
import types.Atype;
import types.Btype;

public class MainClass {

	public static void main(String[] args) {
		
		Person human1 = new Person();
		
		human1.create(new Atype());
//		human1.m_Weapon.drawWeapon();
//		human1.m_bomb.drawBomb();
		
		
		
		Person human2 = new Person();
		
		human2.create(new Btype());
//		human2.m_Weapon.drawWeapon();
//		human2.m_bomb.drawBomb();
		
		
		
		
		System.out.println("333");
		
		Person human3 = new Person();
		human3.create(new Btype());
		human3.getM_bomb().drawBomb();
		human3.getM_Weapon().drawWeapon();
		
		
	}

}
