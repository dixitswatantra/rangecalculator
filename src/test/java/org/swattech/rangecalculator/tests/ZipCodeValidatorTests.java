package org.swattech.rangecalculator.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
