package conversions;

public class Metric extends Convert {
	
	public static double convertMetric(Prefix m1, Unit u1, double d, Prefix m2, Unit u2) {
		if(u1 == u2) {
			switch(m1) {
			case MILLI:
				switch(m2) {
				case MILLI: return d;
				case CENTI: return d / 10;
				case DEFAULT: return d / 1000;
				case KILO: return d / (1000 * 1000);
				default: return -1;
				}
			case CENTI:
				switch(m2) {
				case MILLI: return d * 10;
				case CENTI: return d;
				case DEFAULT: return d / 100;
				case KILO: return d / (100 * 1000);
				default: return -1;
				}
			case DEFAULT:
				switch(m2) {
				case MILLI: return d * 1000;
				case CENTI: return d * 100;
				case DEFAULT: return d;
				case KILO: return d / 1000;
				default: return -1;
				}
			case KILO:
				switch(m2) {
				case MILLI: return d * 1000 * 1000;
				case CENTI: return d * 100 * 1000;
				case DEFAULT: return d * 1000;
				case KILO: return d;
				default: return -1;
				}
			}
		} 
		return -1;
	}
}
