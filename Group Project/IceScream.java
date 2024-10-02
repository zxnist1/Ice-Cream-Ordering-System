import java.util.*;
import java.text.*;
import java.io.*;
import javax.swing.*;

public class IceScream
{
    File inFile = new File("Customer.txt");

    public static void main(String args[])throws IOException
    {
       Scanner sc = new Scanner(System.in);
       DecimalFormat df = new DecimalFormat ("0.00");
       
       FileReader fr = new FileReader("Customer.txt");
       BufferedReader br = new BufferedReader(fr);
       
       FileWriter fw = new FileWriter("CustOut.txt");
       BufferedWriter bw = new BufferedWriter(fw);
       PrintWriter pw = new PrintWriter(bw);
       
       
       Customer is[] = new Customer [30];
       String inData = null; 
       String name,phone,member,option,street,city,state;
       int typeE,flavour,qty,day,month,year,many=1,i=0;
       char typeS;
       double total,discount=0.00,highest=0,lowest=999999;
       
       pw.println("================= ICE-SCREAM =================");
       pw.println("> Your favourite home-base ice-cream store!! <");
       pw.print("\n");
       pw.println("                 Sales Report                 ");
       pw.print("\n");
       
       while ((inData = br.readLine()) != null)
       {
           StringTokenizer st = new StringTokenizer(inData,":");
           name = st.nextToken();
           phone = st.nextToken();
           member = st.nextToken();
           option = st.nextToken();
           if(option.equalsIgnoreCase("shop"))
           {
               typeS = st.nextToken().charAt(0);
               flavour = Integer.parseInt(st.nextToken());
               qty = Integer.parseInt(st.nextToken());
               
               is[i] = new Shop(name,phone,member,typeS,flavour,qty);
               
               pw.println("Customer " + many + " (Shop)");
               pw.println("---------------------------------------------------");
               pw.print(is[i].toString()+"Subtotal                  : RM "+df.format(is[i].calcPrice()));
               if(is[i].getMember().charAt(0)=='M')
               {
                   discount= is[i].calcPrice()*0.9;
                   pw.print("\nMember Discount (-10%)    : RM "+df.format(discount));
                   total= discount*1.06;
                   pw.print("\nTotal (Tax 6%)            : RM "+df.format(total));
                   if ( total > highest)
                       highest=total;
                   if ( total < lowest)
                       lowest=total;
               }
               else
               {
                   total= is[i].calcPrice()*1.06;
                   pw.print("\nTotal (Tax 6%)            : RM "+df.format(total)); 
                   if ( total > highest)
                       highest=total;
                   if ( total < lowest)
                       lowest=total;
               }
           }
           else if(option.equalsIgnoreCase("event"))
           {
               typeE = Integer.parseInt(st.nextToken());
               street = st.nextToken();
               city = st.nextToken();
               state = st.nextToken();
               day = Integer.parseInt(st.nextToken());
               month = Integer.parseInt(st.nextToken());
               year = Integer.parseInt(st.nextToken());
               
               Address add = new Address(street,city,state);
               is[i] = new Event(name,phone,member,typeE,add,day,month,year);
               
               pw.println("Customer " + many + " (Event)");
               pw.println("---------------------------------------------------");
               pw.print(is[i].toString()+"Subtotal                  : RM "+df.format(is[i].calcPrice()));
               if(is[i].getMember().charAt(0)=='M')
               {
                   discount= is[i].calcPrice()*0.9;
                   pw.print("\nMember Discount (-10%)    : RM "+df.format(discount));
                   total= discount*1.06;
                   pw.print("\nTotal (Tax 6%)            : RM "+df.format(total));
                   if ( total > highest)
                       highest=total;
                   if ( total < lowest)
                       lowest=total;
               }
               else
               {
                   total= is[i].calcPrice()*1.06;
                   pw.print("\nTotal (Tax 6%)            : RM "+df.format(total)); 
                   if ( total > highest)
                       highest=total;
                   if ( total < lowest)
                       lowest=total;
               }
           }
           
           pw.println("\n");
           many++;
           i++;
       }
       //lowest highest
       pw.println("===================================================");
       pw.println("HIGHEST AND LOWEST SALES");
       pw.println("Lowest Sales              : RM " + df.format(lowest));
       pw.println("Highest Sales             : RM " + df.format(highest));
       
       pw.print("\n");
       pw.println("===================================================");
       //member count
       int count = 0;
       for (i=0;i<is.length;i++)
       {
           if(is[i] instanceof Customer)
           {
                if(is[i].getMember().charAt(0)=='M')
                    count++;
           }
           else if(is[i] instanceof Event)
           {
                if(is[i].getMember().charAt(0)=='M')
                    count++;
           }
       }
       pw.println("TOTAL MEMBER(S) THAT MAKE A PURCHASE");
       pw.println("Total                     : " + count);
               
       pw.print("\n");
       pw.println("===================================================");
       pw.print("\n");
       //total income
       double income = 0;
       double taxed = 0;
       for (i=0;i<is.length;i++)
       {
           if(is[i] instanceof Customer)
           {
               if(is[i].getMember().charAt(0)=='M')
               {
                   income = income + (is[i].calcPrice()*0.9);
               }
               else
               {
                   income = income + is[i].calcPrice();
               }
           }
           else if(is[i] instanceof Event)
           {
               if(is[i].getMember().charAt(0)=='M')
               {
                   income = income + (is[i].calcPrice()*0.9);
               }
               else
               {
                   income = income + is[i].calcPrice();
               }
           }
       }
       for (i=0;i<is.length;i++)
       {
           if(is[i] instanceof Customer)
           {
               if(is[i].getMember().charAt(0)=='M')
               {
                   taxed = taxed + ((is[i].calcPrice()*0.9)*1.06);
               }
               else
               {
                   taxed = taxed + (is[i].calcPrice()*1.06);
               }
           }
           else if(is[i] instanceof Event)
           {
               if(is[i].getMember().charAt(0)=='M')
               {
                   taxed = taxed + ((is[i].calcPrice()*0.9)*1.06);
               }
               else
               {
                   taxed = taxed + (is[i].calcPrice()*1.06);
               }
           }
       }
       pw.println("TOTAL CLEAN INCOME AND TAXED INCOME");
       pw.println("Clean Income              : RM " + df.format(income));
       pw.println("Taxed Income              : RM " + df.format(taxed));
                
       pw.print("\n");
       pw.println("===================================================");
       pw.print("\n");
       //nearest event
       int nearestday=0,nearestmonth=0,nearestyear=0,stored=0;
       for (i=0;i<is.length;i++)
       {
           if(is[i] instanceof Event)
           {
               Event ev = (Event) is[i];
               while (nearestyear== 0)
               {
                   nearestday=ev.getDateDay();
                   nearestmonth=ev.getDateMonth();
                   nearestyear=ev.getDateYear();
               }
               if (ev.getDateYear()<=nearestyear)
               {
                   nearestyear=ev.getDateYear();
                   if (ev.getDateMonth()<=nearestmonth)
                   {
                       nearestmonth=ev.getDateMonth();
                       stored=ev.getDateDay();
                       if(ev.getDateMonth()<=nearestday)
                       {
                           nearestday=stored;
                       }
                       else if (ev.getDateMonth()>nearestday)
                       {
                           nearestday=ev.getDateDay();
                       }
                   }
               }
           }    
       }
       pw.println("NEAREST EVENT DATE");
       pw.println("Date                      : " +nearestday+ "/" + nearestmonth + "/" + nearestyear);
       
       pw.print("\n");
       pw.println("===================================================");
       pw.print("\n");
       //search customer
       String searchNo = sc.next();
       searchNo = JOptionPane.showInputDialog("Enter phone number to be searched");
       boolean found = false;
       int x=0;
       double taxedSearch = 0,discountedSearch=0;
       String choose="",newphone="";
       
       while(x<is.length && !found)
       {
           if(is[x] instanceof Customer)
           {
                if(is[x].getPhone().equalsIgnoreCase(searchNo))
                    found=true;
                else
                {
                    x++;
                }   
           }
           else if(is[i] instanceof Event)
           {
                if(is[x].getPhone().equalsIgnoreCase(searchNo))
                    found=true;
                else
                {
                    x++;
                }
           }
           else
               found=false;
       }
       pw.println("Number entered            : "+searchNo);
       pw.print("\n");
       if (!found)
       {
           pw.println("SORRY, THERE IS NO CUSTOMER WITH THIS PHONE NUMBER");
       }
       else
       {
           pw.println("SEARCHED CUSTOMER INFORMATION ");
           pw.println("---------------------------------------------------");
           System.out.print("UPDATE PHONE NUMBER? (YES|NO) : ");
           choose= sc.next();
           System.out.print("Update Phone Number : ");
           newphone= sc.next();
           

           
           if (choose.equalsIgnoreCase("yes"))
           {
               pw.println("INFORMATION UPDATED ");
               pw.println("Name                      : "+ is[x].getName());
               pw.println("Old Phone Number          : "+ is[x].getPhone());
               pw.println("New Phone Number          : "+ newphone);
               pw.println("Membership                : "+ is[x].getMember());
               
               if(is[x] instanceof Shop)
               {
                   Shop sp = (Shop) is[x];
                   
                   pw.println("Type of Ice Cream         : "+ sp.typeName());
                   pw.println("Flavour                   : "+ sp.flavName());
                   pw.println("Quantity(s)               : "+ sp.getQty());
               }
               else if(is[x] instanceof Event)
               {
                   Event ev1 = (Event) is[x];
                   
                   pw.println("Type of Ice Cream         : "+ ev1.typeName());
                   pw.println("Address                   : "+ ev1.getAddress());
                   pw.println("Date                      : "+ ev1.getDateDay() + "/" + ev1.getDateMonth() + "/" + ev1.getDateYear());
               }
               
               pw.print("Subtotal                  : RM "+df.format(is[x].calcPrice()));
               if(is[x].getMember().charAt(0)=='M')
               {
                    discountedSearch= is[x].calcPrice()*0.9;
                    pw.print("\nMember Discount (-10%)    : RM "+df.format(discount));
                    taxedSearch= discountedSearch*1.06;
                    pw.print("\nTotal (Tax 6%)            : RM "+df.format(taxedSearch));
               }
               else
               {
                    taxedSearch= is[x].calcPrice()*1.06;
                    pw.print("\nTotal (Tax 6%)            : RM "+df.format(taxedSearch));
               }
           }
           else 
           { 
              pw.print(is[x].toString()+"Subtotal                  : RM "+df.format(is[x].calcPrice()));
              if(is[x].getMember().charAt(0)=='M')
              {
                    discountedSearch= is[x].calcPrice()*0.9;
                    pw.print("\nMember Discount (-10%)    : RM "+df.format(discount));
                    taxedSearch= discountedSearch*1.06;
                    pw.print("\nTotal (Tax 6%)            : RM "+df.format(taxedSearch));
              }
              else
              {
                    taxedSearch= is[x].calcPrice()*1.06;
                    pw.print("\nTotal (Tax 6%)            : RM "+df.format(taxedSearch));
              } 
           }
       }
       
       br.close();
       pw.close();
    
    }
}
