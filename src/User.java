public class User {
    private String name ;
    private TicketSystem ticketSystem;
    private String password;
    private static int users_num = 1;
    private int id;

     User(String name,String password,TicketSystem system){
        setName(name);
        setPassword(password);
        setSystem(system);
        setId(this.users_num++);
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }

    public void setSystem(TicketSystem newSystem) {
        if (ticketSystem != newSystem) {
            TicketSystem old = ticketSystem;
            ticketSystem = newSystem;
            if (newSystem != null) {
                newSystem.addUser(this);
            }
            if (old != null) {
                old.removeUser(this);
            }
        }
    }


    TicketSystem getTicketSystem(){
        return this.ticketSystem;
    }
    public void setName(String name) {
        if(name.length()>0){
            this.name = name;
        }else{
            System.out.println("Invalid Input");
            this.name = "";
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    @Override
    public String toString() {
        return "User{" +"ID='"+this.id+'\'' +
                "name='" + name + '\'' +
                ", ticketSystem=" + ticketSystem.getTitle() +
                ", password='" + password + '\'' +
                '}';
    }
}
