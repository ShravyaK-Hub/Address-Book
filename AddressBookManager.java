import java.util.*;

public class AddressBookManager implements IAddressBook {

    String firstName, lastName, address, city, state, zip, phoneNumber;
    ArrayList<Person> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Person personInfo;
    int choice;
    HashMap<Person, String> CityPersonMap = new HashMap<>();
    HashMap<Person, String> StatePersonMap = new HashMap<>();
    Set<Person> keys = new HashSet<>();

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
        CityPersonMap.put(personInfo, city);
        StatePersonMap.put(personInfo, state);
        System.out.println("Contact added!");
    }

    public void editPerson() {

        boolean personExists = false;
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();

        for (Person editPersonInfo : contacts) {

            if (firstName.equals(editPersonInfo.firstName) && lastName.equals(editPersonInfo.lastName)) {

                System.out.println("Edit:\n 1.Address\n 2.City\n 3.State\n 4.Zip\n 5.Phone number ");
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Enter new address: ");
                        scanner.nextLine();
                        address = scanner.nextLine();
                        editPersonInfo.address = address;
                        personExists = true;
                        System.out.println("Contact updated");
                        break;

                    case 2:
                        System.out.println("Enter new city: ");
                        scanner.nextLine();
                        city = scanner.nextLine();
                        editPersonInfo.city = city;
                        personExists = true;
                        System.out.println("Contact updated");
                        break;

                    case 3:
                        System.out.println("Enter new state: ");
                        scanner.nextLine();
                        state = scanner.nextLine();
                        editPersonInfo.state = state;
                        personExists = true;
                        System.out.println("Contact updated");
                        break;

                    case 4:
                        System.out.println("Enter new zip: ");
                        scanner.nextLine();
                        zip = scanner.nextLine();
                        editPersonInfo.zip = zip;
                        personExists = true;
                        System.out.println("Contact updated");
                        break;

                    case 5:
                        System.out.println("Enter new phone number: ");
                        scanner.nextLine();
                        phoneNumber = scanner.nextLine();
                        editPersonInfo.phoneNumber = phoneNumber;
                        personExists = true;
                        System.out.println("Contact updated");
                        break;

                    default:
                        System.out.println("Invalid input");

                }

            }

        }

        if(!personExists) {
            System.out.println("Contact does not exist");
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

    public void sortAlphabetically() {

        Collections.sort(contacts, new SortByName());

        for (Person person : contacts) {

            person.display();

        }

    }

    public void sortByCityStateZip() {

        System.out.println("Sort by:\n 1.City\n 2.State\n 3.Zip ");
        int choice = scanner.nextInt();

        switch(choice) {

            case 1:
                Collections.sort(contacts, new SortByCity());
                break;

            case 2:
                Collections.sort(contacts, new SortByState());
                break;

            case 3:
                Collections.sort(contacts, new SortByZip());
                break;

            default:
                System.out.println("Invalid input");

        }

        for (Person person : contacts) {

            person.display();

        }

    }

    public void viewPersonByCityState() {
        System.out.println("Choose:\n 1.city\n 2.State ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {

            case 1:
                System.out.println("Enter first name: ");
                firstName = scanner.nextLine();
                System.out.println("Enter last name: ");
                lastName = scanner.nextLine();
                System.out.println("Enter city: ");
                city = scanner.nextLine();
                for (Map.Entry<Person, String> person : CityPersonMap.entrySet()) {
                    if (Objects.equals(city, person.getValue())) {
                        keys.add(person.getKey());
                    }
                }
                for (Person personData : keys) {
                    if (firstName.equals(personData.firstName) && lastName.equals(personData.lastName) && city.equals(personData.city)) {
                        personData.display();
                    }
                    break;
                }
                if(keys.size() == 0) {
                    System.out.println("Contact does not exist");
                }
                break;

            case 2:
                System.out.println("Enter first name: ");
                firstName = scanner.nextLine();
                System.out.println("Enter last name: ");
                lastName = scanner.nextLine();
                System.out.println("Enter state: ");
                state = scanner.nextLine();
                for (Map.Entry<Person, String> person : StatePersonMap.entrySet()) {
                    if (Objects.equals(state, person.getValue())) {
                        keys.add(person.getKey());
                    }
                }
                for (Person personData : keys) {
                    if (firstName.equals(personData.firstName) && lastName.equals(personData.lastName) && state.equals(personData.state)) {
                        personData.display();
                    }
                    break;
                }
                if(keys.size() == 0) {
                    System.out.println("Contact does not exist");
                }
                break;

            default:
                System.out.println("Invalid input");

        }

    }

}