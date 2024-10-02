
public abstract class Customer
{
    private String name;
    private String phone;
    private String member;
    
    public Customer ()
    {
        name=null;
        phone=null;
        member=null;
    }
    public Customer (String name,String phone,String member)
    {
        this.name=name;
        this.phone=phone;
        this.member=member;
    }
    public void setCustomer(String name,String phone,String member)
    {
        this.name=name;
        this.phone=phone;
        this.member=member;
    }
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public String getMember(){return member ;}
    public abstract String typeName();
    public abstract double calcPrice();
    public String toString()
    {
        return "Customer's Name           : "+ name +"\nPhone Number              : " + phone + "\nMembership                : " + member+ "\n";
    }
}
