package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import collections.Util.CollectionsUtitlity;
import collections.Util.Person;

public class LinkedList2 {
    public static void main(String[] args) {
        List<Person> ll=new LinkedList<Person>();
        List<Person> al=new ArrayList<Person>();
        ll.addAll(CollectionsUtitlity.getPersonsList());
        al.addAll(CollectionsUtitlity.getPersonsList());
        System.out.println(ll);
        System.out.println(al);
    }
}
