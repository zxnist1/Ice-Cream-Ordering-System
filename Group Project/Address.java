public class Address
{
   private String street;
   private String city;
   private String state;
   
   public Address()
   {
       street=null;
       city=null;
       state=null;
   }
   public Address(String street,String city,String state)
   {
       this.street=street;
       this.city=city;
       this.state=state;
   }
   public void setAddress(String newStreet,String newCity,String newState)
   {
       this.street=street;
       this.city=city;
       this.state=state;
   }
   public String getStreet(){return street;}
   public String getCity(){return city;}
   public String getState(){return state;}
   public String display()
   {
       return street + " , " + city + " , " + state;
   }
}
