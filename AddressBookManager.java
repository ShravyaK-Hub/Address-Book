import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookManager implements IAddressBook {

    String firstName, lastName, address, city, state, zip, phoneNumber;
    ArrayList<Person> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Person personInfo;

    public void createPerson() {
        System.out.println("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter address : ");
        address = scanner.nextLine();
        System.out.println("Enter city: ");
        city = scanner.nextLine();
        System.out.println("Enter state: ");
        state = scanner.nextLine();
        System.out.println("Enter zip: ");
        zip = scanner.nextLine();
        System.out.println("Enter phone number: ");
        phoneNumber = scanner.nextLine();
        if(contacts.size() > 0) {
            for (int index = 0; index < contacts.size(); index++) {

                personInfo = contacts.get(index);

                if (firstName.equals(personInfo.firstName) && lastName.equals(personInfo.lastName)) {

                    System.out.println("Person already exists");
                    break;

                } else {
                    addPersonToContacts();
                    break;

                }

            }
        } else {
            addPersonToContacts();
        }
    }

    public void addPersonToContacts() {
        personInfo = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        contacts.add(personInfo);
        System.out.println("Contact added!");
    }

    public void editPerson() {

        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();

        for (Person editPersonInfo : contacts) {

            if (firstName.equals(editPersonInfo.firstName) && lastName.equals(editPersonInfo.lastName)) {

                System.out.println("Edit:\n 1.Address\n 2.City\n 3.State\n 4.Zip\n 5.Phone number ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Enter new address: ");
                        scanner.nextLine();
                        address = scanner.nextLine();
                        editPersonInfo.address = address;
                        System.out.println("Contact updated");
                        break;

                    case 2:
                        System.out.println("Enter new city: ");
                        scanner.nextLine();
                        city = scanner.nextLine();
                        editPersonInfo.city = city;
                        System.out.println("Contact updated");
                        break;

                    case 3:
                        System.out.println("Enter new state: ");
                        scanner.nextLine();
                        state = scanner.nextLine();
                        editPersonInfo.state = state;
                        System.out.println("Contact updated");
                        break;

                    case 4:
                        System.out.println("Enter new zip: ");
                        scanner.nextLine();
                        zip = scanner.nextLine();
                        editPersonInfo.zip = zip;
                        System.out.println("Contact updated");
                        break;

                    case 5:
                        System.out.println("Enter new phone number: ");
                        scanner.nextLine();
                        phoneNumber = scanner.nextLine();
                        editPersonInfo.phoneNumber = phoneNumber;
                        System.out.println("Contact updated");
                        break;

                    default:
                        System.out.println("Invalid input");

                }

            } else {
                System.out.println("Contact does not exist");
            }

        }

    }

    public void deletePerson() {
        for (int i = 0; i < contacts.size(); i++) {

            personInfo = contacts.get(i);
            System.out.println("Enter first name: ");
            firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            lastName = scanner.nextLine();

            if (firstName.equals(personInfo.firstName) && lastName.equals(personInfo.lastName)) {

                contacts.remove(i);
                System.out.println("Contact deleted");

            } else {
                System.out.println("Contact does not exist");
            }

        }

    }

}