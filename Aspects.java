package window;

import java.awt.*;
import javax.swing.*;

//sets the choices in the calculator window
public class Aspects {
	
	JComboBox<String> metric = new JComboBox<String>();
	JComboBox<String> prefix = new JComboBox<String>();
	JComboBox<String> mUnit = new JComboBox<String>();
	
	public static Choice setImperialUnits() {
		Choice imperial = new Choice();
		
		imperial.add("inches");
		imperial.add("feet");
		imperial.add("yards");
		imperial.add("miles");
		imperial.add("nautical miles");
		imperial.add("fluid ounces");
		imperial.add("cups");
		imperial.add("pints");
		imperial.add("quarts");
		imperial.add("gallons");
		imperial.add("ounces");
		imperial.add("pounds");
		imperial.add("tons");
		
		return imperial;
	}
	
	public static Choice setMetricPrefixes() {
		Choice metPrefixes = new Choice(); 
		
		metPrefixes.add("milli");
		metPrefixes.add("centi");
		metPrefixes.add("[no prefix]");
		metPrefixes.add("kilo");
		
		return metPrefixes;
	}
	
	public static Choice setMetricUnits() {
		Choice metUnits = new Choice();
		
		metUnits.add("meters");
		metUnits.add("liters");
		metUnits.add("grams");
		
		return metUnits;
	}
}
