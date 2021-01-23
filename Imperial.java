package conversions;

public class Imperial extends Convert{
	//length
	private static double IN_FT = 12, FT_YD = 3, YD_MI = 1760, YD_NM = 2025.4;
	
	//capacity
	private static double FLOZ_C = 8, C_PT = 2, PT_QT = 2, QT_GAL = 4;
	
	//mass
	private static double OZ_LB = 16, LB_T = 2000;
	
	public static double convertImperial(Unit u1, double d, Unit u2) {
		switch(u1) {
		case IN:
			switch(u2) {
			case IN: return d;
			case FT: return smallerLarger(d, IN_FT);
			case YD: return smallerLarger(d, FT_YD * IN_FT);
			case MI: return smallerLarger(d, YD_MI * FT_YD * IN_FT);
			case NM: return smallerLarger(d, YD_NM * FT_YD * IN_FT);
			default: return -1;
			}
		case FT:
			switch(u2) {
			case IN: return largerSmaller(d, IN_FT);
			case FT: return d;
			case YD: return smallerLarger(d, FT_YD);
			case MI: return smallerLarger(d, YD_MI * FT_YD);
			case NM: return smallerLarger(d, YD_NM * FT_YD);
			default: return -1;
			}
		case YD: 
			switch(u2) {
			case IN: return largerSmaller(d, FT_YD * IN_FT);
			case FT: return largerSmaller(d, FT_YD);
			case YD: return d;
			case MI: return smallerLarger(d, YD_MI);
			case NM: return smallerLarger(d, YD_NM);
			default: return -1;
			}
		case MI:
			switch(u2) {
			case IN: return largerSmaller(d, YD_MI * FT_YD * IN_FT);
			case FT: return largerSmaller(d, YD_MI * FT_YD);
			case YD: return largerSmaller(d, YD_MI);
			case MI: return d;
			default: return -1;
			}
		case NM:
			switch(u2) {
			case IN: return largerSmaller(d, YD_NM * FT_YD * IN_FT);
			case FT: return largerSmaller(d, YD_NM * FT_YD);
			case YD: return largerSmaller(d, YD_NM);
			case NM: return d;
			default: return -1;
			}
		case FL_OZ:
			switch(u2) {
			case FL_OZ: return d;
			case C: return smallerLarger(d, FLOZ_C);
			case PT: return smallerLarger(d, FLOZ_C * C_PT);
			case QT: return smallerLarger(d, FLOZ_C * C_PT * PT_QT);
			case GAL: return smallerLarger(d, FLOZ_C * C_PT * PT_QT * QT_GAL);
			default: return -1;
			}
		case C:
			switch(u2) {
			case FL_OZ: return largerSmaller(d, FLOZ_C);
			case C: return d;
			case PT: return smallerLarger(d, C_PT);
			case QT: return smallerLarger(d, C_PT * PT_QT);
			case GAL: return smallerLarger(d, C_PT * PT_QT * QT_GAL);
			default: return -1;
			}
		case PT:
			switch(u2) {
			case FL_OZ: return largerSmaller(d, FLOZ_C * C_PT);
			case C: return largerSmaller(d, C_PT);
			case PT: return d;
			case QT: return smallerLarger(d, PT_QT);
			case GAL: return smallerLarger(d, PT_QT * QT_GAL);
			default: return -1;
			}
		case QT:
			switch(u2) {
			case FL_OZ: return largerSmaller(d, FLOZ_C * C_PT * PT_QT);
			case C: return largerSmaller(d, C_PT * PT_QT);
			case PT: return largerSmaller(d, PT_QT);
			case QT: return d;
			case GAL: return smallerLarger(d, QT_GAL);
			default: return -1;
			}
		case GAL:
			switch(u2) {
			case FL_OZ: return largerSmaller(d, FLOZ_C * C_PT * PT_QT * QT_GAL);
			case C: return largerSmaller(d, C_PT * PT_QT * QT_GAL);
			case PT: return largerSmaller(d, PT_QT * QT_GAL);
			case QT: return largerSmaller(d, QT_GAL);
			case GAL: return d;
			default: return -1;
			}
		case OZ:
			switch(u2) {
			case OZ: return d;
			case LB: return smallerLarger(d, OZ_LB);
			case T: return smallerLarger(d, LB_T * OZ_LB);
			default: return -1;
			}
		case LB:
			switch(u2) {
			case OZ: return largerSmaller(d, OZ_LB);
			case LB: return d;
			case T: return smallerLarger(d, LB_T);
			default: return -1;
			}
		case T:
			switch(u2) {
			case OZ: return largerSmaller(d, LB_T * OZ_LB);
			case LB: return largerSmaller(d, LB_T);
			case T: return d;
			default: return -1;
			}
		default: return -1;
		}
	}
	
	private static double smallerLarger(double num, double conversion) {
		return num/conversion;
	}
	private static double largerSmaller(double num, double conversion) {
		return num*conversion;
	}

}
