import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TicketSystem system = TicketSystem.getInstance("Tazkarti");
        Scanner scan = new Scanner(System.in);

        while (true) {
            system.getUI().ShowMainMenu();
            System.out.println("Enter choose");
            char input = scan.next().charAt(0);
            User user;
            switch (input) {

                case ('A'):

                    while (true) {
                        System.out.println("Enter your Name");
                        String name = scan.next();
//                        System.out.println("Enter your Phone Number");
//                        String phone = scan.next();
//                        System.out.println("Enter your Email");
//                        String email = scan.next();
                        System.out.println("Enter your Password");
                        String pass = scan.next();
//                        System.out.println("Enter your National ID");
//                        String id = scan.next();
//                        System.out.println("Enter your Licence Number");
//                        String licence = scan.next();
                        user = system.login(name, pass);


                        if(user!=null){
                            System.out.println(user.getId()+" Logged Successfully !!");
                            break;
                        }

                        System.out.println("Not Found Want to Try Again ? (Y/N)");
                        char login_input = scan.next().charAt(0);
                        if (login_input=='N'){
                            break;
                        }

                    }
                    if(user==null){
                        break;
                    }
                    boolean logged = true;
                    while(logged) {
                        system.getUI().UserMainMenu();
                        System.out.println("Enter choose");
                        char user_input = scan.next().charAt(0);
                        switch (user_input) {
                            case ('A'):
                                Ticket ticket;
                                while (true) {
                                    System.out.println("Enter your price");
                                    float price = scan.nextFloat();
                                    ticket = system.createTicket(price, user);


                                    if (ticket != null) {
                                        break;
                                    }

                                }
                                System.out.println(ticket.getId() + " created Successfully !!");


                                break;
                            case ('B'):
                                UserTicket userTicket;
                                while (true) {
                                    System.out.println(system.getTickets());
                                    System.out.print("Enter Ticket ID : ");
                                    int ticket_id = scan.nextInt();
                                    userTicket = system.createUserTicket(user.getId(), ticket_id);


                                    if (userTicket != null) {
                                        break;
                                    }

                                }
                                System.out.println(userTicket.getId() + " created Successfully !!");
                                break;
                            case('C'):
                                system.printUserUserTickets(user.getId());
                                break;

                            case('D'):
                                logged = false;
                                break;
                        }
                    }

                break;


                case ('B'):
                    while (true) {
                        System.out.println("Enter your Name");
                        String name = scan.next();
//                        System.out.println("Enter your Phone Number");
//                        String phone = scan.next();
//                        System.out.println("Enter your Email");
//                        String email = scan.next();
                        System.out.println("Enter your Password");
                        String pass = scan.next();
//                        System.out.println("Enter your National ID");
//                        String id = scan.next();
//                        System.out.println("Enter your Licence Number");
//                        String licence = scan.next();
                        user = system.createUser(name, pass);
                        System.out.println(user.toString());

                        if(user!=null){
                            break;
                        }
//                        d.getAccount()
//                        if (system.createDriverAccount(name, phone, email, pass, id, licence) != null) {
//                            admin.approveDriver(d);
//                            d = system.getSpecificDriver(name, pass);
//                            System.out.println("Account created successfully");
//                            break;
//                        }
                    }
                    break;

                case ('C'):
                    String in = scan.nextLine();
                    if (in.equals("exit")) {
                        scan.close();
                        break;
                    }
            }
        }
    }
}