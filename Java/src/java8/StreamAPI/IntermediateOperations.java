package java8.StreamAPI;

import java.util.List;

import collections.Util.Address;
import collections.Util.CollectionsUtitlity;
import collections.Util.Person;

public class IntermediateOperations {
	
	public static void main(String[] args) {
		
		// 1. filter

		List<Person> persons = CollectionsUtitlity.getPersonsList();

		// List<String> cities=persons.stream().map(f->f.getAddress().getCity()).toList();
		List<Address> cities=persons.stream().filter(d->d.getAddress().getCity().equals("Bangalore")).map(f->f.getAddress()).toList();


		System.out.println(cities);

		
	


	}

}
