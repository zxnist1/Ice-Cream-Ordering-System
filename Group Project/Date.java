public class Date
{
   private int day;
   private int month;
   private int year;
   
   public Date()
   {
       day=0;
       month=0;
       year=0;
   }
   public Date(int day,int month,int year)
   {
       this.day=day;
       this.month=month;
       this.year=year;
   }
   public void setDate(int day,int month,int year)
   {
       this.day=day;
       this.month=month;
       this.year=year;
   }
   public int getDay(){return day;}
   public int getMonth(){return month;}
   public int getYear(){return year;}
   public String display()
   {
       return day + "/" + month + "/" + year;
   }
}
