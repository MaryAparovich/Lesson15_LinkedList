package by.htp.linkedlist;

public class MainApp {

	public static void main(String[] args) {

		MyLinkedList<Student> list = new MyLinkedList<>();

		Student std1 = new Student("Name1", "Surname1", 24);
		Student std2 = new Student("Name2", "Surname2", 23);
		Student std3 = new Student("Name3", "Surname3", 22);
		Student std4 = new Student("Name4", "Surname4", 23);
		Student std5 = new Student("Name5", "Surname5", 21);
		Student std6 = new Student("Name6", "Surname6", 23);

		list.add(std2);
		list.add(std3);
		list.add(std4);
		list.add(std5);
		list.printList();
		
		list.addFirst(std1);
		list.printList();
		 
		list.remove(1);
		list.printList();

		list.add(1, std2);
		list.printList();
		
		list.addLast(std6);
		list.printList();
		
		System.out.println(list.indexOf(std5));
	}
}
