package types;

import bomb.bomb;
import weapon.Weapon;

public interface AbstractItem {
	public Weapon createWeapon();
	public bomb createBoom();
	
}
