import java.lang.reflect.Array;
import java.util.ArrayList;

public class TicketSystem {
    private String title;
    private static TicketSystem ticketSystem;
    private ArrayList<User> users ;
    private ArrayList<Ticket> tickets;
    private ArrayList<UserTicket> userTickets ;
    private UI ui;

    public TicketSystem(String title){
        setTitle(title);
        this.ui = new UI(this);
        users = new ArrayList<>();
        tickets = new ArrayList<>();
        userTickets= new ArrayList<>();
    }

    public UI getUI() {
        return this.ui;
    }

    User login(String name,String password){
        for(User user:users){
            if(user.getPassword().equals(password) && user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }

        return null;
    }

    public static TicketSystem getInstance(String name) {
        if (ticketSystem == null) {
            ticketSystem = new TicketSystem(name);
        }
        return ticketSystem;
    }




    User createUser(String name,String password){
        User user = new User(name,password,this);
//        users.add(user);
        return user;
    }
    //relation with User class
    public void addUser(User a) {

        users.add(a);

        a.setSystem(this);
    }
    public void removeUser(User a) {

        users.remove(a);
//        deleted.add(a);

        a.setSystem(null);
    }

    Ticket createTicket(float price,User user){
        Ticket ticket = new Ticket(price,user,this);
//        tickets.add(ticket);
        return ticket;
    }

    ArrayList<UserTicket> getAllUserTicketsByUserId(int user_id){
        ArrayList<UserTicket> result = new ArrayList<>();

        for(UserTicket userTicket:userTickets){
            if(userTicket.getUser().getId()==user_id){
                result.add(userTicket);
            }
        }
        return result;
    }

    void printUserUserTickets(int user_id){
        ArrayList<UserTicket> list=getAllUserTicketsByUserId(user_id);
        System.out.println(list.toString());
    }

    Ticket getTicketByID(int ticket_id){
        for(Ticket ticket:tickets){
            if(ticket.getId() == ticket_id){
                return ticket;
            }
        }

        return null;
    }

    User getUserByID(int user_id){
        for(User user:users){
            if(user.getId() == user_id){
                return user;
            }
        }

        return null;
    }


    UserTicket createUserTicket(int user_id,int ticket_id){
        Ticket ticket = getTicketByID(ticket_id);
        User user = getUserByID(user_id);
        UserTicket userTicket = new UserTicket(user,ticket);
//        userTickets.add(userTicket);
        return userTicket;
    }

    //relation with Ticket class
    public void addTicket(Ticket a) {

        tickets.add(a);

        a.setSystem(this);
    }
    public void removeTicket(Ticket a) {

        tickets.remove(a);
//        deleted.add(a);

        a.setSystem(null);
    }

    //relation with Ticket class
    public void addUserTicket(UserTicket a) {

        userTickets.add(a);

        a.setSystem(this);
    }
    public void removeUserTicket(UserTicket a) {

        userTickets.remove(a);
//        deleted.add(a);

        a.setSystem(null);
    }

    void setTitle(String title){
        if(title.length()>0){
            this.title = title;
        }else{
            System.out.println("Invalid Input");
        }
    }

    String getTitle(){
        return this.title;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<UserTicket> getUserTickets() {
        return userTickets;
    }

    @Override
    public String toString() {
        return "TicketSystem{" +
                "title='" + title + '\'' +
                ", users=" + users +
                ", tickets=" + tickets +
                ", userTickets=" + userTickets +
                '}';
    }
}
