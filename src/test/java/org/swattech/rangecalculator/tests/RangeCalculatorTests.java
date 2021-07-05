package org.swattech.rangecalculator.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.swattech.rangecalculator.algo.RangeCalculator;
import org.swattech.rangecalculator.model.ZipCodeRange;

/**
 * RangeCalculator Test with multiple combinations of @ZipCodeRange List
 * 
 * @author swdixit
 *
 */
public class RangeCalculatorTests {

	@Test
	public void test_rangeCalculator_1() {

		RangeCalculator rangeCalce = new RangeCalculator();
		List<ZipCodeRange> rangeList = new ArrayList();

		rangeList.add(new ZipCodeRange(94600, 94699));
		rangeList.add(new ZipCodeRange(76600, 84699));
		rangeList.add(new ZipCodeRange(64600, 64699));
		rangeList.add(new ZipCodeRange(64700, 64700));
		rangeList.add(new ZipCodeRange(77999, 78000));
		rangeList.add(new ZipCodeRange(94133, 98000));
		System.out.println("---- TESTCASE 1 ---- \nINPUT ZIPCODE RANGE : ");
		System.out.println(rangeList);
		List<ZipCodeRange> actualZipCodes = rangeCalce.calculateMinRange(rangeList);
		System.out.println("OUTPUT ZIPCODE RANGE : ");
		System.out.println(actualZipCodes + "\n");
		List<ZipCodeRange> expectedZipCodes = new ArrayList();
		expectedZipCodes.add(new ZipCodeRange(64600, 64700));
		expectedZipCodes.add(new ZipCodeRange(76600, 84699));
		expectedZipCodes.add(new ZipCodeRange(94133, 98000));
		assertEquals(expectedZipCodes, actualZipCodes);

	}

	@Test
	public void test_rangeCalculator_2() {

		RangeCalculator rangeCalce = new RangeCalculator();
		List<ZipCodeRange> rangeList = new ArrayList();

		rangeList.add(new ZipCodeRange(94600, 94699));
		rangeList.add(new ZipCodeRange(76600, 84699));
		rangeList.add(new ZipCodeRange(77999, 78000));
		rangeList.add(new ZipCodeRange(94133, 98000));

		System.out.println("---- TESTCASE 2 ---- \nINPUT ZIPCODE RANGE : ");
		System.out.println(rangeList);
		List<ZipCodeRange> actualZipCodes = rangeCalce.calculateMinRange(rangeList);
		System.out.println("OUTPUT ZIPCODE RANGE : ");
		System.out.println(actualZipCodes + "\n");
		List<ZipCodeRange> expectedZipCodes = new ArrayList();

		expectedZipCodes.add(new ZipCodeRange(76600, 84699));
		expectedZipCodes.add(new ZipCodeRange(94133, 98000));

		assertEquals(expectedZipCodes, actualZipCodes);

	}

	@Test
	public void test_rangeCalculator_3() {

		RangeCalculator rangeCalce = new RangeCalculator();
		List<ZipCodeRange> rangeList = new ArrayList();

		rangeList.add(new ZipCodeRange(00000, 11111));
		rangeList.add(new ZipCodeRange(76600, 84699));
		rangeList.add(new ZipCodeRange(35353, 35353));
		rangeList.add(new ZipCodeRange(94133, 98000));

		System.out.println("---- TESTCASE 3 ---- \nINPUT ZIPCODE RANGE : ");
		System.out.println(rangeList);
		List<ZipCodeRange> actualZipCodes = rangeCalce.calculateMinRange(rangeList);

		System.out.println("OUTPUT ZIPCODE RANGE : ");
		System.out.println(actualZipCodes + "\n");
		List<ZipCodeRange> expectedZipCodes = new ArrayList();
		expectedZipCodes.add(new ZipCodeRange(00000, 11111));
		expectedZipCodes.add(new ZipCodeRange(35353, 35353));
		expectedZipCodes.add(new ZipCodeRange(76600, 84699));
		expectedZipCodes.add(new ZipCodeRange(94133, 98000));

		assertEquals(expectedZipCodes, actualZipCodes);

	}

	@Test
	public void test_rangeCalculator_4() {

		RangeCalculator rangeCalce = new RangeCalculator();
		List<ZipCodeRange> rangeList = new ArrayList();

		rangeList.add(new ZipCodeRange(94133, 94133));
		rangeList.add(new ZipCodeRange(94200, 94299));
		rangeList.add(new ZipCodeRange(94600, 94699));

		System.out.println("---- TESTCASE 4 ---- \nINPUT ZIPCODE RANGE : ");
		System.out.println(rangeList);
		List<ZipCodeRange> actualZipCodes = rangeCalce.calculateMinRange(rangeList);

		System.out.println("OUTPUT ZIPCODE RANGE : ");
		System.out.println(actualZipCodes + "\n");
		List<ZipCodeRange> expectedZipCodes = new ArrayList();
		expectedZipCodes.add(new ZipCodeRange(94133, 94133));
		expectedZipCodes.add(new ZipCodeRange(94200, 94299));
		expectedZipCodes.add(new ZipCodeRange(94600, 94699));

		assertEquals(expectedZipCodes, actualZipCodes);

	}

	@Test
	public void test_rangeCalculator_5() {

		RangeCalculator rangeCalce = new RangeCalculator();
		List<ZipCodeRange> rangeList = new ArrayList();

		rangeList.add(new ZipCodeRange(12121, 12122));
		rangeList.add(new ZipCodeRange(12124, 12127));
		rangeList.add(new ZipCodeRange(12127, 12120));

		System.out.println("---- TESTCASE 5 ---- \nINPUT ZIPCODE RANGE : ");
		System.out.println(rangeList);
		List<ZipCodeRange> actualZipCodes = rangeCalce.calculateMinRange(rangeList);

		System.out.println("OUTPUT ZIPCODE RANGE : ");
		System.out.println(actualZipCodes + "\n");
		List<ZipCodeRange> expectedZipCodes = new ArrayList();
		expectedZipCodes.add(new ZipCodeRange(12120, 12127));

		assertEquals(expectedZipCodes, actualZipCodes);

	}

	@Test
	public void test_rangeCalculator_6() {

		RangeCalculator rangeCalce = new RangeCalculator();
		List<ZipCodeRange> rangeList = new ArrayList();

		rangeList.add(new ZipCodeRange(12121, 12122));
		rangeList.add(new ZipCodeRange(12124, 12127));
		rangeList.add(new ZipCodeRange(12127, 12130));

		System.out.println("---- TESTCASE 6 ---- \nINPUT ZIPCODE RANGE : ");
		System.out.println(rangeList);
		List<ZipCodeRange> actualZipCodes = rangeCalce.calculateMinRange(rangeList);

		System.out.println("OUTPUT ZIPCODE RANGE : ");
		System.out.println(actualZipCodes + "\n");
		List<ZipCodeRange> expectedZipCodes = new ArrayList();
		expectedZipCodes.add(new ZipCodeRange(12121, 12122));
		expectedZipCodes.add(new ZipCodeRange(12124, 12130));

		assertEquals(expectedZipCodes, actualZipCodes);

	}

}
