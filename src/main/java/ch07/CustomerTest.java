package ch07;

import java.util.List;

public class CustomerTest {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		List<Customer> list = dao.getCustomers();
		for (Customer c : list) {
			System.out.println(c);
		}
	}

}
