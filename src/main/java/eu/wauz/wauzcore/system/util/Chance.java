package eu.wauz.wauzcore.system.util;

import java.util.Random;

/**
 * An util class for getting values for rng stuff.
 * 
 * @author Wauzmons
 */
public class Chance {
	
	/**
	 * A random instance to randomize the results.
	 */
	private static Random random = new Random();
	
	/**
	 * @param chance The x value.
	 * 
	 * @return True with a chnace of one to x.
	 */
	public static boolean oneIn(int chance) {
		return random.nextInt(chance) == 0;
	}
	
	/**
	 * @param chance The x value.
	 * 
	 * @return True with a chance of x percent.
	 */
	public static boolean percent(int chance) {
		return random.nextInt(100) < chance;
	}
	
	/**
	 * @param minimum The minimum possible value.
	 * @param maximum The maximum possible value.
	 * 
	 * @return A value between inclusive min and max values.
	 */
	public static int minMax(int minimum, int maximum) {
		return random.nextInt(maximum - minimum + 1) + minimum;
	}
	
	/**
	 * @param maximum The x value.
	 * 
	 * @return A value between plus and minus x.
	 */
	public static float negativePositive(float maximum) {
		return negativePositive((int) (maximum * 100)) / 100;
	}
	
	/**
	 * @param maximum The x value.
	 * 
	 * @return A value between plus and minus x.
	 */
	private static float negativePositive(int maximum) {
		return (float) ((float) (random.nextInt(maximum * 200 + 1) / (float) 100) - maximum);
	}
	
}
