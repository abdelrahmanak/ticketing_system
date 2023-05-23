public class UI {
    private TicketSystem ticketSystem;

    UI(TicketSystem system){
        this.ticketSystem=system;
    }

    void ShowMainMenu(){
        System.out.println("A:Login");
        System.out.println("B:SignUp");
    }

    void UserMainMenu(){
        System.out.println("A:Create Ticket");
        System.out.println("B:Book Ticket");
        System.out.println("C:Show My Tickets");
        System.out.println("D:Logout");

    }
}
