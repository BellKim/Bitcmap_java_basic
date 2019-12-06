package types;

import bomb.C4;
import bomb.bomb;
import weapon.Sword;
import weapon.Weapon;

public class Btype implements AbstractItem {

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new Sword();
	}

	@Override
	public bomb createBoom() {
		// TODO Auto-generated method stub
		return new C4();
	}

}//end class
