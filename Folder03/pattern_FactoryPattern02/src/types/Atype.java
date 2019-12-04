package types;

import bomb.Dynamite;
import bomb.bomb;
import weapon.Gun;
import weapon.Weapon;

public class Atype implements AbstractItem {

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new Gun();
	}

	@Override
	public bomb createBoom() {
		// TODO Auto-generated method stub
		return new Dynamite();
	}

}
