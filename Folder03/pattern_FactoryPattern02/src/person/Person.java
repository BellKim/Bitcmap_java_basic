package person;

import bomb.bomb;
import types.AbstractItem;
import weapon.Weapon;

public class Person {
	
	private Weapon m_Weapon;
	private bomb m_bomb;
	
	public Weapon getM_Weapon() {
		return m_Weapon;
	}
	
	public bomb getM_bomb() {
		return m_bomb;
	}
	
	
	public void create(AbstractItem aw) {
		m_Weapon = aw.createWeapon();
		m_bomb = aw.createBoom();
		
	}
	


}//end class
