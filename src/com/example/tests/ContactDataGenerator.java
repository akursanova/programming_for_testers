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

public class ContactDataGenerator {

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
		
		List<ContactParameters> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactParameters> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactParameters.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactParameters> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactParameters.class);
		return (List<ContactParameters>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactParameters> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactParameters contact : contacts) {
		writer.write(contact.getFirstname() + "," +
		contact.getLastname() + "," +
		contact.getAddress() + "," +
		contact.getHomePhone() + "," +
		contact.getMobile() + "," +
		contact.getWork() + "," +
		contact.getSecond_home() + "," +
		contact.getEmail() + "," +
		contact.getEmail2() + "," +
		contact.getBirthday() + "," +
		contact.getBmonth() + "," +
		contact.getByear() + "," +
		contact.getAddress2() + "," +
		contact.getPhone2() + "," + ",!" + "\n");
		}
		writer.close();
		
	}
		
	public static List<ContactParameters> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactParameters> list = new ArrayList<ContactParameters>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactParameters contact = new ContactParameters()
			.withFirstname(part[0])
			.withLastname(part[1])
			.withAddress(part[2])
			.withHomePhone(part[3])
			.withMobile(part[4])
			.withWork(part[5])
			.withSecond_home(part[6])
			.withEmail(part[7])
			.withEmail2(part[8])
			.withBirthday(part[9])
			.withBmonth(part[10])
			.withByear(part[11])
			.withAddress2(part[12])
			.withPhone2(part[13]);
			
			list.add(contact);
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return list;
	}

	public static List<ContactParameters> generateRandomContacts(int amount) {
		
		
		List<ContactParameters> list = new ArrayList<ContactParameters>();
		for (int i = 0; i < amount; i++ ) {
			ContactParameters contact = new ContactParameters()

			.withFirstname(generateRandomString())
			.withLastname(generateRandomString())
			.withAddress(generateRandomString())
			.withHomePhone(generateRandomString())
			.withMobile(generateRandomString())
			.withWork(generateRandomString())
			.withSecond_home(generateRandomString())
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
			.withBirthday(generateRandomString())
			.withBmonth(generateRandomString())
			.withByear(generateRandomString())
			.withAddress2(generateRandomString())
			.withPhone2(generateRandomString());
			list.add(contact);
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
