public class Ticket {

    private float price;
    private TicketSystem ticketSystem;
    private User user;
    private static int tickets_num = 1;
    private int id;

    public Ticket(float price,User user,TicketSystem system){
        setPrice(price);
        setSystem(system);
        this.user = user;
        setId(this.tickets_num++);
    }

    public void setSystem(TicketSystem newSystem) {
        if (ticketSystem != newSystem) {
            TicketSystem old = ticketSystem;
            ticketSystem = newSystem;
            if (newSystem != null) {
                newSystem.addTicket(this);
            }
            if (old != null) {
                old.removeTicket(this);
            }
        }
    }
    public void setPrice(float price) {
        if(price>0){
            this.price = price;
        }else{
            System.out.println("Invalid Input");
            this.price = 0f;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", ticketSystem=" + ticketSystem.getTitle() +
                ", user=" + user.getId() +
                ", id=" + id +
                '}';
    }
}
