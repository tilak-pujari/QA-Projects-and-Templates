package op.genericLib;

import java.util.Random;

public class CommonUtility {
	
	public int getRandom(int range) {
		Random r=new Random();
		int value =r.nextInt(range);
		return value;
		
	}

}
