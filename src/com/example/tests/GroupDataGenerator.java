package com.example.tests;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class GroupDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length <3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remote it manually:" + file);
			return;
		}
		
		List<GroupParameters> groups = generateRandomGroups(amount);
		if ("csv".equals(format)) {
			saveGroupsToCsvFile(groups, file);
		} else if ("xml".equals(format)) {
			saveGroupsToXmlFile(groups, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveGroupsToXmlFile(List<GroupParameters> groups, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupParameters.class);
		String xml = xstream.toXML(groups);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<GroupParameters> loadGroupsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupParameters.class);
		return (List<GroupParameters>) xstream.fromXML(file);
	}

	private static void saveGroupsToCsvFile(List<GroupParameters> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (GroupParameters group : groups) {
			writer.write(group.getName() + "," + group.getHeader() + "," + group.getFooter() + ",!" + "\n");
		}
		writer.close();
		
	}
		
	public static List<GroupParameters> loadGroupsFromCsvFile(File file) throws IOException {
		List<GroupParameters> list = new ArrayList<GroupParameters>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			GroupParameters group = new GroupParameters()
			.withName(part[0])
			.withHeader(part[1])
			.withFooter(part[2]);
			list.add(group);
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return list;
	}

	public static List<GroupParameters> generateRandomGroups(int amount) {
		List<GroupParameters> list = new ArrayList<GroupParameters>();
		for (int i = 0; i < amount; i++ ) {
			GroupParameters group = new GroupParameters()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			list.add(group);
		}	
		return list;
	}
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0 ) {
			return "";
		} else {
			return "test" +rnd.nextInt();
		}
	}
	
}
