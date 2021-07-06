package org.swattech.rangecalculator.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is to represent combination range of lowerbound and upperbound zip
 * codes. Each object of this class is Zip Code range.
 * 
 * @author swdixit
 *
 */
public class ZipCodeRange implements Comparable {

	private int lowerbound;
	private int upperbound;

	public ZipCodeRange(int lowerbound, int upperbound) {
		if (lowerbound > upperbound) {
			this.lowerbound = upperbound;
			this.upperbound = lowerbound;
		} else {
			this.lowerbound = lowerbound;
			this.upperbound = upperbound;
		}

	}

	public int getLowerbound() {
		return lowerbound;
	}

	public void setLowerbound(int lowerbound) {
		this.lowerbound = lowerbound;
	}

	public int getUpperbound() {
		return upperbound;
	}

	public void setUpperbound(int upperbound) {
		this.upperbound = upperbound;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lowerbound, upperbound);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeRange other = (ZipCodeRange) obj;
		return this.lowerbound == other.lowerbound && this.upperbound == other.upperbound;
	}

	@Override
	public String toString() {

		String lowerBound = String.format("%05d", lowerbound);
		String upperBound = String.format("%05d", upperbound);

		return "[" + lowerBound + "," + upperBound + "]";
	}

	@Override
	public int compareTo(Object o) {
		return lowerbound - ((ZipCodeRange) o).lowerbound;
	}

}
