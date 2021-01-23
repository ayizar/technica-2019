package window;

import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import window.Aspects;
import conversions.*;

//sets the dimensions and functionalities for the calculator window and calls the
//other classes and methods to convert the user's request
//returns an error if an incompatible conversion is requested (ex: inches to cups)
public class Window {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Unit Conversions");
		JButton iToI = new JButton("Imperial to Imperial");
		JButton mToM = new JButton("Metric to Metric");
		JButton iToM = new JButton("Imperial to Metric");
		JButton mToI = new JButton("Metric to Imperial");
		DecimalFormat formatter = new DecimalFormat("#.######");

		iToI.setBounds(50, 150, 145, 30);
		mToM.setBounds(250, 150, 145, 30);
		iToM.setBounds(450, 150, 145, 30);
		mToI.setBounds(650, 150, 145, 30);

		frame.add(iToI);
		frame.add(mToM);
		frame.add(iToM);
		frame.add(mToI);

		frame.setSize(900, 400);
		frame.setLayout(null);
		frame.setVisible(true);

		iToI.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFrame impToImp = new JFrame("Imperial to Imperial");
				JTextField unit1 = new JTextField();
				JTextField unit2 = new JTextField();
				Choice imperialUnits1 = Aspects.setImperialUnits();
				Choice imperialUnits2 = Aspects.setImperialUnits();

				unit1.setBounds(90, 100, 60, 25);
				unit2.setBounds(390, 100, 60, 25);
				imperialUnits1.setBounds(150, 100, 100, 200);
				imperialUnits2.setBounds(450, 100, 100, 200);

				unit1.setEditable(true);
				unit2.setEditable(true);

				impToImp.add(unit1);
				impToImp.add(unit2);
				impToImp.add(imperialUnits1);
				impToImp.add(imperialUnits2);

				impToImp.setSize(700, 300);
				impToImp.setLayout(null);
				impToImp.setVisible(true);

				unit1.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						String input, output;
						double unitNum;

						input = unit1.getText();

						try {
							unitNum = Double.parseDouble(input);
							output = formatter.format(Convert.convert(Input.stringToUnit(imperialUnits1.getSelectedItem()), unitNum,
									Input.stringToUnit(imperialUnits2.getSelectedItem())));
							
							if (output.compareTo("-1") == 0)
								unit2.setText("ERR");
							else
								unit2.setText(output);
						} catch (Exception e) {
							unit2.setText("ERR");
						}
					}
				});
			}
		});

		mToM.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFrame metToMet = new JFrame("Metric to Metric");
				JTextField unit1 = new JTextField();
				JTextField unit2 = new JTextField();
				Choice metricPrefixes1 = Aspects.setMetricPrefixes();
				Choice metricPrefixes2 = Aspects.setMetricPrefixes();
				Choice metricUnits1 = Aspects.setMetricUnits();
				Choice metricUnits2 = Aspects.setMetricUnits();
				DecimalFormat formatter = new DecimalFormat("#.######");

				unit1.setBounds(60, 100, 60, 25);
				unit2.setBounds(360, 100, 60, 25);

				metricPrefixes1.setBounds(120, 100, 100, 200);
				metricPrefixes2.setBounds(420, 100, 100, 200);

				metricUnits1.setBounds(220, 100, 100, 200);
				metricUnits2.setBounds(520, 100, 100, 200);

				metToMet.add(unit1);
				metToMet.add(unit2);
				metToMet.add(metricPrefixes1);
				metToMet.add(metricPrefixes2);
				metToMet.add(metricUnits1);
				metToMet.add(metricUnits2);

				metToMet.setSize(700, 300);
				metToMet.setLayout(null);
				metToMet.setVisible(true);

				unit1.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						String input, output;
						double unitNum;

						input = unit1.getText();
						
						try {
							unitNum = Double.parseDouble(input);
							output = formatter.format(Convert.convert(Input.stringToPrefix(metricPrefixes1.getSelectedItem()),
									Input.stringToUnit(metricUnits1.getSelectedItem()), unitNum,
									Input.stringToPrefix(metricPrefixes2.getSelectedItem()),
									Input.stringToUnit(metricUnits2.getSelectedItem())));
							
							if (output.compareTo("-1") == 0)
								unit2.setText("ERR");
							else
								unit2.setText(output);
						} catch (Exception e) {
							unit2.setText("ERR");
						}
					}
				});
			}
		});

		iToM.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFrame impToMet = new JFrame("Imperial to Metric");
				JTextField unit1 = new JTextField();
				JTextField unit2 = new JTextField();
				Choice imperialUnits = Aspects.setImperialUnits();
				Choice metricPrefixes = Aspects.setMetricPrefixes();
				Choice metricUnits = Aspects.setMetricUnits();

				unit1.setBounds(90, 100, 60, 25);
				unit2.setBounds(350, 100, 60, 25);
				imperialUnits.setBounds(150, 100, 100, 200);
				metricPrefixes.setBounds(410, 100, 100, 200);
				metricUnits.setBounds(510, 100, 100, 200);

				impToMet.add(unit1);
				impToMet.add(unit2);
				impToMet.add(imperialUnits);
				impToMet.add(metricPrefixes);
				impToMet.add(metricUnits);

				impToMet.setSize(700, 300);
				impToMet.setLayout(null);
				impToMet.setVisible(true);

				unit1.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						String input, output;
						double unitNum;
						
						input = unit1.getText();
						
						try {
						unitNum = Double.parseDouble(input);
						output = formatter.format(Convert.convert(Input.stringToUnit(imperialUnits.getSelectedItem()), unitNum,
								Input.stringToPrefix(metricPrefixes.getSelectedItem()),
								Input.stringToUnit(metricUnits.getSelectedItem())));
						
						if (output.compareTo("-1") == 0)
							unit2.setText("ERR");
						else
							unit2.setText(output);
						} catch (Exception e) {
							unit2.setText("ERR");
						}
					}
				});
			}
		});

		mToI.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFrame impToMet = new JFrame("Metric to Imperial");
				JTextField unit1 = new JTextField();
				JTextField unit2 = new JTextField();
				Choice metricPrefixes = Aspects.setMetricPrefixes();
				Choice metricUnits = Aspects.setMetricUnits();
				Choice imperialUnits = Aspects.setImperialUnits();

				unit1.setBounds(90, 100, 60, 25);
				unit2.setBounds(450, 100, 60, 25);
				metricPrefixes.setBounds(150, 100, 100, 200);
				metricUnits.setBounds(250, 100, 100, 200);
				imperialUnits.setBounds(510, 100, 100, 200);

				impToMet.add(unit1);
				impToMet.add(unit2);
				impToMet.add(metricPrefixes);
				impToMet.add(metricUnits);
				impToMet.add(imperialUnits);

				impToMet.setSize(700, 300);
				impToMet.setLayout(null);
				impToMet.setVisible(true);

				unit1.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						String input, output;
						double unitNum;

						input = unit1.getText();
						
						try {
						unitNum = Double.parseDouble(input);
						output = formatter.format(Convert.convert(Input.stringToPrefix(metricPrefixes.getSelectedItem()),
								Input.stringToUnit(metricUnits.getSelectedItem()), unitNum,
								Input.stringToUnit(imperialUnits.getSelectedItem())));
						
						if (output.compareTo("-1") == 0)
							unit2.setText("ERR");
						else
							unit2.setText(output);
						} catch (Exception e) {
							unit2.setText("ERR");
						}
					}
				});
			}
		});
	}

}
