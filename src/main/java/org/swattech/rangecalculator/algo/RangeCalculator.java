package org.swattech.rangecalculator.algo;

import java.util.Collections;
import java.util.List;

import org.swattech.rangecalculator.model.ZipCodeRange;
import org.swattech.rangecalculator.utils.ZipCodeValidator;

/**
 * This class has implementation(methods) logic to derive minimum ZipCode
 * ranges. - Method calculateMinRange : Accepts list of {@link ZipCodeRange}
 * 
 * @author swdixit
 *
 */
public class RangeCalculator {

	/**
	 * This method is to process input list request by validating input list then
	 * invoking calculatorMinRange algorithm
	 * 
	 * @param zipCodeRanges
	 * @return List of @ZipCodeRange
	 */
	public List<ZipCodeRange> processZipCodeInputList(List<ZipCodeRange> zipCodeRanges) {
		List<ZipCodeRange> validZipRanges = ZipCodeValidator.getValidZipRanges(zipCodeRanges);
		List<ZipCodeRange> finalZipCodeRanges = calculateMinRange(validZipRanges);
		return finalZipCodeRanges;

	}

	/**
	 * 
	 * @param zipCodeRanges List of {@link ZipCodeRange}
	 * @return
	 */
	private List<ZipCodeRange> calculateMinRange(List<ZipCodeRange> zipCodeRanges) {

		// Sorting has been used to place all ZipCodeRange in List in ascending order
		// only based on lowerbound.
		Collections.sort(zipCodeRanges);
		// isMinRangeAchieved flag is to track if lowerbound or upperbound falls in any
		// "if" conditions mentioned below for all iterations of @zipCodeRanges
		// This flag is helpful in recursive logic .If this flag remains false for all
		// iteration of zipCodeRanges, then final List of @ZipCodeRange can be returned
		// or else it will continue with recursive logic to derive minimum range of
		// ZipCodes.
		boolean isMinRangeAchieved = false;

		// Starting forloop from index of 1 so that control can be moved previous index
		// in list to get previous ZipCodeRange
		for (int i = 1; i < zipCodeRanges.size(); i++) {
			// Here now we have previous ZipCodeRange and current ZipCodeRange
			ZipCodeRange previous = zipCodeRanges.get(i - 1);
			ZipCodeRange current = zipCodeRanges.get(i);

			if (previous != null) {
				// if current's lowerbound (not upperbound) value falls in between range of
				// previous lowerbound and upperbound. And current's upperbound is higher than
				// previous upperbound, then we can add a ZipCodeRange object with previous
				// lowerbound and current's upperbound and then previous and current can be
				// removed zipCodeRanges input list.
				if (current.getLowerbound() <= previous.getUpperbound()
						&& current.getUpperbound() >= previous.getUpperbound()) {

					zipCodeRanges.add(new ZipCodeRange(previous.getLowerbound(), current.getUpperbound()));
					removeZipCodeRanges(zipCodeRanges, previous, current);
					isMinRangeAchieved = true;
				} // Here scenario where current's lowerbound and upperbound fall in range of
					// previous ZipCodeRange's lowerbound and upperbound
				else if ((current.getLowerbound() >= previous.getLowerbound()
						&& current.getLowerbound() <= previous.getUpperbound())
						&& (current.getUpperbound() >= previous.getLowerbound()
								&& current.getUpperbound() <= previous.getUpperbound())) {

					zipCodeRanges.add(new ZipCodeRange(previous.getLowerbound(), previous.getUpperbound()));
					removeZipCodeRanges(zipCodeRanges, previous, current);
					isMinRangeAchieved = true;

				} // Here scenario where current's lowerbound and previous's upperbound values are
					// adjacent for eg. previous = [1,10 ] current = [11,30] . So now 10 and 11 are
					// adjacent and output should be [1,30] since both 10 and 11 can not be shipped.
				else if ((current.getLowerbound() - previous.getUpperbound()) == 1) {

					zipCodeRanges.add(new ZipCodeRange(previous.getLowerbound(), current.getUpperbound()));
					removeZipCodeRanges(zipCodeRanges, previous, current);
					isMinRangeAchieved = true;
				}

			}

		}
		// As per explantion above, when isMinRangeAchieved flag remains false for all
		// iteration of @zipCodeRanges input list, then final list can be returned.
		if (!isMinRangeAchieved)
			return zipCodeRanges;

		return calculateMinRange(zipCodeRanges);
	}

	/**
	 * This method is to remove current and previous from input List of
	 * ZipCodeRanges
	 * 
	 * @param zipCodeRanges - Input list of ZipCodeRange provided
	 * @param previous      - {@link ZipCodeRange}
	 * @param current       - {@link ZipCodeRange}
	 */
	private void removeZipCodeRanges(List<ZipCodeRange> zipCodeRanges, ZipCodeRange previous, ZipCodeRange current) {
		// No null check or size check needed here, avoid extra if condition
		zipCodeRanges.remove(previous);
		zipCodeRanges.remove(current);
	}

}
