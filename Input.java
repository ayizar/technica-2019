package conversions;

import conversions.Convert.*;

//returns the appropriate enumerator constant for the choice selected in the calculator window

public class Input {

	public static Prefix stringToPrefix(String prefix) {
		switch (prefix) {
		case "[no prefix]":
			return Prefix.DEFAULT;
		case "milli":
			return Prefix.MILLI;
		case "centi":
			return Prefix.CENTI;
		case "kilo":
			return Prefix.KILO;
		default:
			return Prefix.INVALID;
		}
	}

	public static Unit stringToUnit(String unit) {
		switch (unit) {
		case "inches":
			return Unit.IN;
		case "feet":
			return Unit.FT;
		case "yards":
			return Unit.YD;
		case "miles":
			return Unit.MI;
		case "nautical miles":
			return Unit.NM;
		case "fluid ounces":
			return Unit.FL_OZ;
		case "cups":
			return Unit.C;
		case "pints":
			return Unit.PT;
		case "quarts":
			return Unit.QT;
		case "gallons":
			return Unit.GAL;
		case "ounces":
			return Unit.OZ;
		case "pounds":
			return Unit.LB;
		case "tons":
			return Unit.T;
		case "meters":
			return Unit.METER;
		case "liters":
			return Unit.LITER;
		case "grams":
			return Unit.GRAM;
		default:
			return Unit.INVALID;
		}
	}
}
