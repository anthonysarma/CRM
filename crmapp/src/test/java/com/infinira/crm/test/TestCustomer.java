package com.infinira.crm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.junit.Test;

import com.infinira.crm.model.Customer;
import com.infinira.crm.service.CustomerService;
import com.infinira.crm.util.CustomerUtil;

public class TestCustomer {

	private static final String MOBILE_NUMBER = "mobileNumber";
	private static final String PHONE_NUMBER = "phoneNumber";
	private static final String PAN_NUMBER = "panNumber";
	private static final String AADHAR_NUMBER = "aadharNumber";
	
	public static void createCustomer() {

		Customer customer = new Customer("Anthony", CustomerUtil.getGender("m"));
		customer.setMiddleName("sharma");
		customer.setLastName("P");
		customer.setEmailId("shadarch2@gmail.com");

		Map<String, String> contacts = new HashMap<String, String>();
		contacts.put(MOBILE_NUMBER, "+91 8940209868");
		contacts.put(PHONE_NUMBER, "04153 237310");

		customer.setContacts(contacts);

		Map<String, String> identities = new HashMap<String, String>();
		identities.put(PAN_NUMBER, "123 456 789");
		identities.put(AADHAR_NUMBER, "1234 5678 9123");

		customer.setIdentities(identities);

		List<String> comment = new ArrayList<>();
		comment.add("your product is good");

		customer.setComment(comment);

		// calling the Customer Service
		CustomerService.getInstance().createCustomer(customer);
		// System.out.println(customer.getCustomerId());
	}

	
	public static void updateCustomer() {

		Customer customer = new Customer(1, "Anthony ", CustomerUtil.getGender("m"));
		customer.setMiddleName("Sarma");
		customer.setLastName("P");
		customer.setEmailId("shadarch2@gmail.com");

		Map<String, String> contacts = new HashMap<>();
		contacts.put(MOBILE_NUMBER, "8940209868");
		contacts.put(PHONE_NUMBER, "04153 237310");

		customer.setContacts(contacts);

		Map<String, String> identities = new HashMap<>();
		identities.put(PAN_NUMBER, "123 456 789");
		identities.put(AADHAR_NUMBER, "1234 5678 9123");

		customer.setIdentities(identities);

		List<String> comment = new ArrayList<String>();
		comment.add("your product is good");

		customer.setComment(comment);

		// calling CustomerService
		CustomerService.getInstance().updateCustomer(customer);
	}

	
	public static void deleteCustomer() {
		Customer customer = new Customer(1);
		int customerId = customer.getCustomerId();
		CustomerService.getInstance().deleteCustomer(customerId);
	}

	
	public static void getCustomer() {

		Customer customer = CustomerService.getInstance().getCustomer(1);
		List<String> comments = customer.getComment();

		System.out.println(customer.getCustomerId() + "\t");
		System.out.print(customer.getFirstName() + "\t");
		System.out.print(customer.getMiddleName() + "\t");
		System.out.println(customer.getLastName() + "\t");
		System.out.println(customer.getGender().toString() + "\t");
		System.out.println(customer.getEmailId() + "\t");
		System.out.println(customer.getContacts().get(MOBILE_NUMBER) + "\t");
		System.out.println(customer.getContacts().get(PHONE_NUMBER) + "\t");
		System.out.println(customer.getIdentities().get(PAN_NUMBER) + "\t");
		System.out.println(customer.getIdentities().get(AADHAR_NUMBER) + "\t");

		comments.forEach(comment -> System.out.println(comment));
	}

	//@Test
	public static void getCustomers() {
		System.out.println("First Name");
		System.out.println("-------------");

		// Display The Male customers Name
		CustomerService.getInstance().getCustomers().stream()
				.filter(customer -> customer.getGender().toString().equalsIgnoreCase("M"))
				.map(customer -> customer.getFirstName()).forEach(firstName -> {
					System.out.println(firstName);
				});
	}

	public static void main(String arg[]) {
		 //createCustomer();
		// updateCustomer();
		// deleteCustomer();
		// getCustomer();
		getCustomers();
	}
}
