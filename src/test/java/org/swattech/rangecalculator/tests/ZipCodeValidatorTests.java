package org.swattech.rangecalculator.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.swattech.rangecalculator.model.ZipCodeRange;
import org.swattech.rangecalculator.utils.ZipCodeValidator;

public class ZipCodeValidatorTests {

	@Test
	public void test_getValidZipRanges() {

		List<ZipCodeRange> rangeList = new LinkedList();
		rangeList.add(new ZipCodeRange(9413300, 94133));
		rangeList.add(new ZipCodeRange(94200, 94299));
		rangeList.add(new ZipCodeRange(94600, 94699));

		List<ZipCodeRange> validZipRanges = ZipCodeValidator.getValidZipRanges(rangeList);
		assertEquals(2, validZipRanges.size());
	}

	@Test
	public void test_validateZipCode() {
		Exception exception = assertThrows(Exception.class, () -> {
			ZipCodeValidator.validateZipCode(9413300, 1000000);
		});

		String actualMessage = "ZipCode must be 5 digits :[9413300,1000000]";
		assertTrue(actualMessage.contains(exception.getMessage()));

		exception = assertThrows(Exception.class, () -> {
			ZipCodeValidator.validateZipCode(9413300, 0000000);
		});

		System.out.println(exception.getMessage());
		actualMessage = "ZipCode must be non ZERO digit :[9413300,0]";
		assertTrue(actualMessage.contains(exception.getMessage()));
	}

	@Test
	public void test_parseAndCreateZipCodeRange() {

		ZipCodeRange zipCodeInputList = ZipCodeValidator
				.parseAndCreateZipCodeRange("[10000,20000] [20000,25000] [20000,30000] [10000,15000] [70000,70001]");

		assertNotNull(zipCodeInputList);

		boolean validateCommandLineArgs = ZipCodeValidator.validateCommandLineArgs("[10000,20000]");
		assertTrue(validateCommandLineArgs);

	}
}
