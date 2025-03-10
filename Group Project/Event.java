
public class Event extends Customer
{
    private int type;
    private Address address;
    private Date date;
    public Event(String name,String phone,String member,int type,Address address,int d,int m,int y)
    {
        super(name,phone,member);
        this.type=type;
        this.address=address;
        date= new Date(d,m,y);
    }
    public void setEvent(String name,String phone,String member,int type,Address address,int d,int m,int y)
    {
        super.setCustomer(name,phone,member);
        this.type=type;
        this.address=address;
        date= new Date(d,m,y);
    }
    public int getType(){return type;}
    public Address getAddress(){return address;}
    public int getDateDay(){return date.getDay();}
    public int getDateMonth(){return date.getMonth();}
    public int getDateYear(){return date.getYear();}
    public String typeName()
    {
        String ename=null;
        if (type==1)
            ename="Scoop Stall ";
        else if (type==2)
            ename="Self-Scooping Station ";
        else 
            ename=null;
        return ename;
    }
    public double calcPrice()
    {
        double price = 0.00;
        if (type==1)
            price=650;
        else if (type==2)
            price=400;
        else
            price=0;    
        return price;
    }
    public String toString()
    {
        return super.toString()+ "Type of Event             : "+typeName()+ "\nEvent Address             : "+address.display()+"\nDate of Event             : "+date.display()+"\n";
    }
}

