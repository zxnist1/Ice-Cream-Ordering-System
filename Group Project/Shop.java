
public class Shop extends Customer
{
    private char type;
    private int flavour;
    private int qty;
    public Shop()
    {
        super();
        type=' ';
        flavour=0;
        qty=0;
    }
    public Shop(String name,String phone,String member,char type,int flavour,int qty)
    {
        super(name,phone,member);
        this.type=type;
        this.flavour = flavour;
        this.qty=qty;
    }
    public void setShop(String name,String phone,String member,char type,int flavour,int qty)
    {
        super.setCustomer(name,phone,member);
        this.type=type;
        this.flavour = flavour;
        this.qty=qty;
    }
    public char getType(){return type;}
    public int getFlavour(){return flavour;}
    public int getQty(){return qty;}
    public String typeName()
    {
        String tname=null;
        switch(type)
        {
            case 'a','A':
                tname="Cake";
                break;
            case 'b','B':
                tname="Cone";
                break;
            case 'c','C':
                tname="Cup";
                break;
            default:
                tname=null;
                break;
        }
        return tname;
    }
    public double calcPrice()
    {
        double price=0;
        if (type=='a'||type=='A')
            if (flavour==1)
                price=145;
            else if (flavour==2)
                price=160;
            else if (flavour==3)
                price=150;
            else 
                price=0;
        else if (type=='b'||type=='B')
            price=7;
        else if (type=='c'||type=='C')
            if (flavour==1)
                price=8.5;
            else if (flavour==2)
                price=7.5;
            else if (flavour==3)
                price=8;
            else 
                price=0;
        else 
            price=0;
        price = price * qty; 
        return price;
    }
    public String flavName()
    {
        String tname=null;
        if (type=='a'||type=='A')
            if (flavour==1)
                tname="Red Velvet";
            else if (flavour==2)
                tname="Chocolate Lava";
            else if (flavour==3)
                tname="Cookies & Cream";
            else 
                tname=null;
        else if (type=='b'||type=='B')
            if (flavour==1)
                tname="Chocolate";
            else if (flavour==2)
                tname="Vanila";
            else if (flavour==3)
                tname="Strawberry";
            else 
                tname=null;
        else if (type=='c'||type=='C')
            if (flavour==1)
                tname="Choco Mint ";
            else if (flavour==2)
                tname="Pistachio ";
            else if (flavour==3)
                tname="Sweet Potato ";
            else 
                tname=null;
        else
            tname=null;
        return tname;
    }
    public String toString()
    {
        return super.toString()+"Type of Ice Cream         : "+ typeName()+"\nFlavour Chosen            : "+flavName()+"\nQuantity(s)               : "+qty+"\n";
    }
}

