package org.swattech.rangecalculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.swattech.rangecalculator.model.ZipCodeRange;

/**
 * This class is to validate zipcodes -matching right format of 5 digits
 * 
 * @author swdixit
 *
 */
public class ZipCodeValidator {

	private static final String _00000 = "00000";
	private static Pattern pattern = null;
	static {
		String regex = "^[0-9]{5}";

		pattern = Pattern.compile(regex);
	}

	/**
	 * Method to validate Zipcodes of range provided
	 * 
	 * @param lowerbound - zipcode lowerbound
	 * @param upperbound - zipcode upperbound
	 * @throws Exception - new exception with custome message.
	 */
	public static void validateZipCode(int lowerbound, int upperbound) throws Exception {

		if (lowerbound == 0 || upperbound == 0) {
			throw new Exception("ZipCode must be non ZERO digit :[" + lowerbound + "," + upperbound + "]");
		}
		boolean lowerMatcher = pattern.matcher(String.valueOf(lowerbound)).matches();
		boolean upperMatcher = pattern.matcher(String.valueOf(upperbound)).matches();
		if (!lowerMatcher || !upperMatcher) {
			throw new Exception("ZipCode must be 5 digits :[" + lowerbound + "," + upperbound + "]");
		}

	}

	/**
	 * Method to validate Zipcodes of range provided
	 * 
	 * @param lowerbound - zipcode lowerbound
	 * @param upperbound - zipcode upperbound
	 * @throws Exception - new exception with custome message.
	 */
	public static void validateZipCode(String lowerbound, String upperbound) throws Exception {

		if (_00000.equals(lowerbound) || _00000.equals(lowerbound)) {
			throw new Exception("ZipCode must be non ZERO digit :[" + lowerbound + "," + upperbound + "]");
		}
		boolean lowerMatcher = pattern.matcher(lowerbound).matches();
		boolean upperMatcher = pattern.matcher(upperbound).matches();
		if (!lowerMatcher || !upperMatcher) {
			throw new Exception("ZipCode must be 5 digits :[" + lowerbound + "," + upperbound + "]");
		}

	}

	/**
	 * This method is to return valid {@link ZipCodeRange}
	 * 
	 * @param zipCoderanges - list of input {@link ZipCodeRange}
	 * @return - List of valid {@link ZipCodeRange}
	 */
	public static List<ZipCodeRange> getValidZipRanges(List<ZipCodeRange> zipCoderanges) {
		List<ZipCodeRange> validCodeRanges = new ArrayList();
		if (null == zipCoderanges && zipCoderanges.size() <= 0) {
			return null;
		}

		for (ZipCodeRange codeRange : zipCoderanges) {
			try {
				String lowerbound = String.format("%05d", codeRange.getLowerbound());
				String upperbound = String.format("%05d", codeRange.getUpperbound());
				validateZipCode(lowerbound, upperbound);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			validCodeRanges.add(new ZipCodeRange(codeRange.getLowerbound(), codeRange.getUpperbound()));
		}

		return validCodeRanges;

	}

	/**
	 * Method is to validate command line input arguments
	 * 
	 * @param inputRangeStr
	 * @return flag true or false if input args matches with pattern
	 */
	public static boolean validateCommandLineArgs(String inputRangeStr) {
		return inputRangeStr.matches("\\[[0-9]{5},[0-9]{5}\\]");
	}

	/**
	 * Method is to parse,split commandLine Input string and return ZipCodeRange
	 * Object
	 * 
	 * @param rangeString
	 * @return {@link ZipCodeRange}
	 */
	public static ZipCodeRange parseAndCreateZipCodeRange(String rangeString) {
		String[] valuesWithBracketsParsed = rangeString.split("[\\[\\]]");
		String lowAndHighValues[] = valuesWithBracketsParsed[1].split(",");
		int lowerbound = Integer.parseInt(lowAndHighValues[0]);
		int upperbound = Integer.parseInt(lowAndHighValues[1]);
		ZipCodeRange codeRange = new ZipCodeRange(lowerbound, upperbound);
		return codeRange;
	}

}
