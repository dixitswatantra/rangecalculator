package org.swattech.rangecalculator;

import java.util.ArrayList;
import java.util.List;

import org.swattech.rangecalculator.algo.RangeCalculator;
import org.swattech.rangecalculator.model.ZipCodeRange;
import org.swattech.rangecalculator.utils.ZipCodeValidator;

public class CommandLineInput {

	public static void main(String[] args) {
		System.out.println("******************************");
		System.out.println("********RANGE CALCULATOR******");
		System.out.println("******************************\n");

		if (args.length == 0)
			System.err.println(
					"System expect pairs of ZIP codes in two square brackets. for e.g. [94133,94133] [94200,94299] [94600,94699]");

		List<ZipCodeRange> ranges = new ArrayList<ZipCodeRange>();
		for (String rangeString : args) {
			if (!ZipCodeValidator.validateCommandLineArgs(rangeString))
				System.err.println("Range string " + rangeString
						+ " is in an invalid format.  Must be 5 digit number [nnnnn,nnnnn]");
			else {
				ZipCodeRange codeRange = ZipCodeValidator.parseAndCreateZipCodeRange(rangeString);
				ranges.add(codeRange);
			}
		}

		// Once list is created , we can execute calculateMinRange method from
		// RangeCalculator class.
		System.out.println("---- TESTCASE ---- \nINPUT ZIPCODE RANGE : ");
		System.out.println(ranges);

		RangeCalculator calculator = new RangeCalculator();
		List<ZipCodeRange> actualZipCodes = calculator.processZipCodeInputList(ranges);

		System.out.println("OUTPUT ZIPCODE RANGE : ");
		System.out.println(actualZipCodes + "\n");

	}

}
