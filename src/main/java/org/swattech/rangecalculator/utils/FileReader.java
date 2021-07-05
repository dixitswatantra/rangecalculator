package org.swattech.rangecalculator.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.swattech.rangecalculator.model.ZipCodeRange;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * This class is mainly to read input data from json files to test
 * functionalities.
 * 
 * @author swdixit
 *
 */
public class FileReader {

	/**
	 * 
	 * @return
	 */
	public static List<ZipCodeRange> buildInputListFromFile(String filePath) {
		List<ZipCodeRange> codeRanges = new ArrayList<ZipCodeRange>();

		try {
			byte[] mapData = Files.readAllBytes(Paths.get(filePath));
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(mapData);
			System.out.println(rootNode);
			JsonNode path = rootNode.path("records");
			System.out.println(path);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codeRanges;

	}

	public static void main(String[] args) {
		System.out.println(buildInputListFromFile("inputfiles/zipcodefile.json"));
	}
}
