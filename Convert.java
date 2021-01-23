package conversions;

public class Convert {
	private static double MM_IN = 25.4, ML_FLOZ = 29.5735, MG_OZ = 28349.5;
	
	enum Unit {
		IN, FT, YD, MI, NM, FL_OZ, C, PT, QT, GAL, OZ, LB, T, METER, LITER, GRAM, INVALID
	}
	enum Prefix {
		DEFAULT, MILLI, CENTI, KILO, INVALID
	}
	
	// converts imperial to imperial
	public static double convert(Unit u1, double d, Unit u2) {
		return Imperial.convertImperial(u1, d, u2);
	}
	
	// converts metric to metric
	public static double convert(Prefix m1, Unit u1, double d, Prefix m2, Unit u2) {
		return Metric.convertMetric(m1, u1, d, m2, u2);
	}
	
	// converts imperial to metric
	public static double convert(Unit u1, double d, Prefix m, Unit u2) {
		switch(u1) {
		case IN:
		case FT: 
		case YD: 
		case MI: 
		case NM: 
			d = Imperial.convertImperial(u1, d, Unit.IN); 
			d *= MM_IN;
			break;
		case FL_OZ:
		case C:
		case PT:
		case QT:
		case GAL:
			d = Imperial.convertImperial(u1, d, Unit.FL_OZ);
			d *= ML_FLOZ;
			break;
		case OZ:
		case LB:
		case T: 
			d = Imperial.convertImperial(u1, d, Unit.OZ);
			d *= MG_OZ;
			break;
		default: return -1;
		}
		
		switch(u2) {
		case METER: 
		case LITER: 
		case GRAM: return Metric.convertMetric(Prefix.MILLI, u2, d, m, u2);
		default: return -1;
		}
	}
	
	// converts metric to imperial
	public static double convert(Prefix m, Unit u1, double d, Unit u2) {
		switch(u1) {
		case METER: 
			d = Metric.convertMetric(m, u1, d, Prefix.MILLI, u1); 
			d /= MM_IN;
			break;
		case LITER:
			d = Metric.convertMetric(m, u1, d, Prefix.MILLI, u1); 
			d /= ML_FLOZ;
			break;
		case GRAM: 
			d = Metric.convertMetric(m, u1, d, Prefix.MILLI, u1); 
			d /= MG_OZ;
			break;
		default: return -1;
		}
		
		switch(u2) {
		case IN:
		case FT:
		case YD:
		case MI:
		case NM: return Imperial.convertImperial(Unit.IN, d, u2);
		case FL_OZ:
		case C:
		case PT:
		case QT:
		case GAL: return Imperial.convertImperial(Unit.FL_OZ, d, u2);
		case OZ:
		case LB:
		case T: return Imperial.convertImperial(Unit.OZ, d, u2);
		default: return -1;
		}
	}
}
