import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
        AddressBookManager addressBookManager = new AddressBookManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Choose:\n 1.Add person\n 2.Edit person\n 3.Delete person\n 4.Sort Alphabetically");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("How many people do you want to add? ");
                    int numberOfPeople = scanner.nextInt();
                    scanner.nextLine();
                    while(numberOfPeople != 0) {
                        addressBookManager.createPerson();
                        numberOfPeople--;
                    }
                    break;

                case 2:
                    addressBookManager.editPerson();
                    break;

                case 3:
                    addressBookManager.deletePerson();
                    break;

                case 4:
                    addressBookManager.sortAlphabetically();
                    break;

                default:
                    System.out.println("Invalid input");

            }

        }

    }

}
