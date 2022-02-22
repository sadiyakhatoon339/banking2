package Application;

import java.io.IOException;
import java.io.*;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;


class Bank{

    String Name;
    String Branch_name;
    double R_O_I;

    enum type{
        SAVING,CURRENT;
    }
}


class InsufficientAmountException extends Exception{

    InsufficientAmountException(){
        super("Insufficient Balance to withdraw this amount");
    }

}



class SBI extends Bank{
    void getDetails(String name,String B_name,double roi){

        Name=name;
        Branch_name=B_name;
        R_O_I=roi;


    }


    void printDetails(String name,String B_name,double roi)
    {
        System.out.println("Name of the bank is : "+name  +"  Branch name is: "+B_name +"  It provides the Rate of Interest of "+roi +"%" );
    }

    void account(int acc_no,double amt,double amt_withdrawn ){
        int k=0;
        try{

            if(amt<amt_withdrawn){
                throw new InsufficientAmountException();
            }

        }
        catch(InsufficientAmountException e){
            k=-1;
            System.out.println(e.getMessage());

        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();


        try{
            FileWriter my=new FileWriter("TransactionDetailsBOI.txt");
            my.write("The account number is:"+acc_no +"\n");
            my.write("The amount in the account :"+amt+"\n");
            my.write("The amount withdrawn is :"+amt_withdrawn+"\n");
            if(k==0){
                my.write("The available amount in the account is :"+(amt-amt_withdrawn)+"\n");
                my.write("Transaction successful"+"\n");
                my.write("Transaction time  and date:"+now+"\n");


            }
            else
                my.write("Transaction cancelled");
               my.close();

        }
        catch(IOException e){
            System.out.println("An error occured");
        }

    }

}







class BOI extends Bank{
    void getDetails(String name,String B_name,double roi){

        Name=name;
        Branch_name=B_name;
        R_O_I=roi;


    }

    void printDetails(String name,String B_name,double roi)
    {
        System.out.println("Name of the bank is : "+name  +"  Branch name is: "+B_name +"  It provides the Rate of Interest of "+roi +"%" );
    }

    void account(int acc_no,double amt,double amt_withdrawn ){
        int k=0;
        try{

            if(amt<amt_withdrawn){
                throw new InsufficientAmountException();
            }

        }
        catch(InsufficientAmountException e){
            k=-1;
            System.out.println(e.getMessage());

        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try{
            FileWriter my=new FileWriter("TransactionDetailsSBI.txt");
            my.write("The account number is:"+acc_no +"\n");
            my.write("The amount in the account :"+amt+"\n");
            my.write("The amount withdran is :"+amt_withdrawn+"\n");
            if(k==0){
                my.write("The available amount in the account is :"+(amt-amt_withdrawn)+"\n");
                my.write("Transaction successful"+"\n");
                my.write("Transaction time  and date:"+now+"\n");


            }
            else
                my.write("Transaction cancelled");
                     my.close();


        }
        catch(IOException e){
            System.out.println("An error occured");
        }



    }

}

class ICICI extends Bank{

    void getDetails(String name,String B_name,double roi){

        Name=name;
        Branch_name=B_name;
        R_O_I=roi;


    }

    void printDetails(String name,String B_name,double roi)
    {
        System.out.println("Name of the bank is : "+name  +".  Branch name is: "+B_name +".  It provides the Rate of Interest of "+roi +"%" );
    }



    void account(int acc_no,double amt,double amt_withdrawn ){
        int k=0;
        try{

            if(amt<amt_withdrawn){
                throw new InsufficientAmountException();
            }

        }
        catch(InsufficientAmountException e){
            k=-1;
            System.out.println(e.getMessage());

        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try{
            FileWriter my=new FileWriter("TransactionDetailsICICI.txt");
            my.write("The account number is:"+acc_no +"\n");
            my.write("The amount in the account :"+amt+"\n");
            my.write("The amount withdran is :"+amt_withdrawn+"\n");
            if(k==0){
                my.write("The available amount in the account is :"+(amt-amt_withdrawn)+"\n");
                my.write("Transaction successful"+"\n");
                my.write("Transaction time  and date:"+now+"\n");


            }
            else
                my.write("Transaction cancelled");

            my.close();
        }
        catch(IOException e){
            System.out.println("An error occured");
        }
    }
}

public class Banking_Application {
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        SBI ob=new SBI();
        BOI ob1=new BOI();
        ICICI ob2=new ICICI();

        ob.getDetails("SBI","lucknowbranch",6);
        ob.printDetails("SBI","lucknowbranch",6);
        ob.account(1800101001,1800,80);

        ob1.getDetails("BOI","bombayBranch",8);
        ob1.printDetails("BOI","bombayBranch",8);
        ob1.account(1400101001,1800,180000);

        ob2.getDetails("ICICI","hyderabadbranch",7);
        ob2.printDetails("ICICI","hyderabadbranch",7);
        ob2.account(1300302001,500,70);




    }
}

