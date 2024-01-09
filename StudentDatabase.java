import java.io.*;                   //importing packages
import java.util.*;
class Project 
{
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String name[], sec[];                   //instance variables
    int roll[], scien[], comp[], eng[], math[], p;
    String seat[][];
    Project()                       //constructor 
    {
        name = new String[100];
        sec = new String[100];
        roll = new int[100];
        scien = new int[100];           //initialising variables
        comp = new int[100];
        eng = new int[100];
        math = new int[100]; 
        seat = new String[5][5];
        p=0;
    }
    void write() throws IOException
    {
        FileWriter fw = new FileWriter("Project.txt",true);     //creating
        BufferedWriter bw = new BufferedWriter(fw);             //files
        PrintWriter pw = new PrintWriter(bw);
        
        String fname, fsection;
        int froll, fsc, fcomp, feng, fmath, fseat;   //initialising variables
        while(true)
        {
            System.out.println("Enter name, class, roll and marks"+
            " in 4 subjects: ");
            fname = sc.readLine();
            for(int i=0;i<p;i++)
                if(fname.equals(name[i]))
                {
                    System.out.println("Student already exists");
                    System.out.println("Enter new name: ");
                    fname = sc.readLine();
                    i=0;
                }
            fsection = sc.readLine();
            froll = Integer.parseInt(sc.readLine());
            fsc = Integer.parseInt(sc.readLine());      //accepting values
            fcomp = Integer.parseInt(sc.readLine());        //from user
            feng = Integer.parseInt(sc.readLine());
            fmath = Integer.parseInt(sc.readLine());
            System.out.println("\nEnter row no. and column no. of the"+
            " student's seat: ");
            fseat = Integer.parseInt(sc.readLine());
            while(true)
            {
                if(seat[(fseat/10)-1][(fseat%10)-1]!=null)
                {
                    System.out.println("Seat already taken");
                    System.out.println("Please enter new seat no.");
                    fseat = Integer.parseInt(sc.readLine());
                }   
                else
                    break;
            }
            pw.println(fname);
            pw.println(fsection);
            pw.println(froll);                           //storing values
            pw.println(fsc);
            pw.println(fcomp);
            pw.println(feng);
            pw.println(fmath);
            pw.println(fseat);
            System.out.println("\nStudent Successfully added\nAdd"+
            " another student?");
            String res = sc.readLine();
            if(res.equals("No"))
                break;
        }
        pw.close();                     //closing object
    }
    void store() throws IOException
    {
        FileReader fw = new FileReader("Project.txt");      //reading file
        BufferedReader bw = new BufferedReader(fw); p=0;
        while((name[p]=bw.readLine())!=null)
        {
            sec[p] = bw.readLine();
            roll[p] = Integer.parseInt(bw.readLine());    //storing values
            scien[p] = Integer.parseInt(bw.readLine());     //in array
            comp[p] = Integer.parseInt(bw.readLine());
            eng[p] = Integer.parseInt(bw.readLine());
            math[p] = Integer.parseInt(bw.readLine()); 
            int num = Integer.parseInt(bw.readLine());
            seat[(num/10)-1][(num%10)-1] = name[p];
            p++;
        }
    }    
    void main() throws IOException
    {
        store();
        System.out.println("\nEnter 1 to search within database"+
        "\nEnter 2 to add student to database\nEnter 3 to exit");
        int ch = Integer.parseInt(sc.readLine());       //accepting choice
        if(ch==1)
            student();                
        else if(ch==2)
            write();
        else if(ch==3)
            return;
        else
            System.out.println("Wrong input!!");
        main();               
    }
    void student() throws IOException
    {
        System.out.println("\nEnter 1 to display report card of student"+
        "\nEnter 2 to display entire database \nEnter 3 for Academic"
        +" Statistics \nEnter 4 for seating arrangement");
        int choice = Integer.parseInt(sc.readLine());   //accepting choice
        switch(choice)          //menu-driven
        {
            case 1:     //displaying report card
            System.out.println("\nEnter name: ");
            String n = sc.readLine(); int f=0;          //accepting name
            System.out.println("\n"+n+"'s Report Card:-");
            for(int i=0;i<p;i++)
                if(name[i].equals(n))
                {
                    System.out.println("\nClass: "+sec[i]+"\nRoll no: "+
                    roll[i]+"\n\nSubject\t\tMarks\n");
                    System.out.println("Science\t\t"+scien[i]+"\nComputer\t"
                    +comp[i]+"\nEnglish\t\t"+eng[i]+"\nMaths\t\t"+math[i]);
                    double average = (eng[i]+scien[i]+comp[i]+math[i])/4;
                    System.out.println("\nAverage Marks: "+average);
                    char ch = grade(average);
                    System.out.println("Grade received: "+ch); f=1;
                    break;
                }
            if(f==0)
                System.out.println("Student does not exist!!");
            break;
            case 2:                 //printing entire database
            System.out.println("\t\tSTUDENT DATABASE\n");
            System.out.println("Name\t\tClass\tRoll\tAverage Marks\n");
            for(int i=0;i<p;i++)
            {
                System.out.println(name[i]+"\t"+sec[i]+"\t"+roll[i]+"\t"
                +((eng[i]+scien[i]+comp[i]+math[i])/4.0));
            }
            break;
            case 3:                 //printing academic statistics
            System.out.println("\t\tSTATISTICS\n");
            System.out.println("Subject\t Highest Marks\tObtained by\n");
            int pos = max(scien);
            System.out.println("Science\t\t"+scien[pos]+"\t"+name[pos]);
            pos = max(comp);
            System.out.println("Computers\t"+comp[pos]+"\t"+name[pos]);
            pos = max(eng);
            System.out.println("English\t\t"+eng[pos]+"\t"+name[pos]);
            pos = max(math);
            System.out.println("Maths\t\t"+math[pos]+"\t"+name[pos]);
            break;
            case 4:                 //printing seating arrangement
            System.out.println("\t\t\t\t  SEATING ARRANGEMENT\n\n");
            for(int k=1;k<90;k++)
                    System.out.print("-");
            System.out.println();       
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    String pri = print(seat[i][j]);
                    System.out.print(pri+" | ");                    
                }  
                System.out.println();
                for(int k=1;k<90;k++)
                    System.out.print("-");
                System.out.println();
            }            
            System.out.println();            
            break;
            default:                    //default case
            System.out.println("Wrong choice entered!!");
        }       
    }
    String print(String n)      //function to adjust spacing in 
    {                                //seating arrangement
        if(n!=null)
            for(int i=n.length();i<15;i++)
                n+=" ";
        else
        {
            n="";
            for(int i=0;i<15;i++)
                n+=" ";
        }
        return n;
    }
    char grade(double avg)      //function to print grade according to avg
    {
        if(avg>=90)
            return 'A';
        else if(avg>=80)
            return 'B';
        else if(avg>=60)
            return 'C';
        else if(avg>=40)
            return 'D';
        else
            return 'F';
    }
    int max(int a[])            //function to return max marks
    {
        int max=0, pos=0;
        for(int i=0;i<p;i++)
            if(a[i]>max)
            {
                pos = i;
                max = a[i];
            }
        return pos;
    }
}
