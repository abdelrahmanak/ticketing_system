public class UserTicket {

    private static int usertickets_num =1;
    private int id;
    private TicketSystem ticketSystem;
    private User user;
    private Ticket ticket;

    public UserTicket(User user,Ticket ticket){

        setUser(user);
        setSystem(getUser().getTicketSystem());
        setTicket(ticket);
        setId(this.usertickets_num++);
    }
    public void setSystem(TicketSystem newSystem) {
        if (ticketSystem != newSystem) {
            TicketSystem old = ticketSystem;
            ticketSystem = newSystem;
            if (newSystem != null) {
                newSystem.addUserTicket(this);
            }
            if (old != null) {
                old.removeUserTicket(this);
            }
        }
    }
    public void setUser(User user) {
        if(user !=null) {
            this.user = user;
        }else{
            System.out.println("Invalid Input");
            this.user=null;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public void setTicket(Ticket ticket) {
        if (ticket != null) {
            this.ticket = ticket;
        }else{
            System.out.println("Invalid Input");
            this.ticket=null;
        }
    }

    @Override
    public String toString() {
        return "UserTicket{ID=#'"+this.id+'\''+
                ", user=#" + user.getId() +
                ", ticket=#" + ticket.getId() +
                '}';
    }
}



