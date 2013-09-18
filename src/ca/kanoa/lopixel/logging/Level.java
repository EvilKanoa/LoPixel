package ca.kanoa.lopixel.logging;

public enum Level {

	STATS("Stats", 4),
	INFO("Info", 3),
	WARNING("Warning", 2),
	ERROR("Error", 1);
	
	private final String tag;
	private final int level;
	
	private Level(String tag, int level) {
		this.tag = tag;
		this.level = level;
	}
	
	/**
	 * Compares two logging levels to see which is higher
	 * @param l1 The first logging level
	 * @param l2 The second logging level
	 * @return 1 if l1 is higher, 0 if they're the same, -1 if l2 is higher
	 */
	public static int compare(Level l1, Level l2) {
		if (l1.getLevel() > l2.getLevel())
			return 1;
		else if (l2.getLevel() > l1.getLevel())
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return tag;
	}
	
	public int getLevel() {
		return level;
	}
	
}
