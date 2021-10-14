import java.util.*;
import java.io.*;

public class TestSubject_Task1
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);
    TestSubject_Task1.read_file("data.txt");
    int choice;
    do
    {
      show_menu();
      choice = reader.nextInt();
      reader.nextLine();
      switch(choice)
      {
        case 1: TestSubject_Task1.add_subject();
        break;
        case 2: TestSubject_Task1.view_subject();
        break;
        case 3:   TestSubject_Task1.save_subject();
        break;
      }
      
    }while(choice!=3);
  }
  private static ArrayList<Subject_Task1> list;
  public static void read_file(String filename)
  {
    list = new ArrayList<Subject_Task1>();
    try
    {
      Scanner reader = new Scanner(new File(filename));
      while(reader.hasNext())
      {
        String line = reader.nextLine();
        String[] split = line.split(" ", 0);
        list.add(new Subject_Task1(split[0], split[1]));
      }
      reader.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e);
    }
  }
  
  public static void show_menu()
  {
    System.out.println("1. Add subject.");
    System.out.println("2. View Subjects.");
    System.out.println("3. Exit.");
    System.out.println("Enter your choice");
  }
  public static void add_subject()
  {
    Scanner reader = new Scanner(System.in);
    String[] disp = Subject_Task1.allDisciplines(list);
    System.out.println("Disciplines of existing subjects");
    for(int i=0; i<disp.length; i++)
      System.out.println(disp[i]);
    System.out.println("Enter subject Name");
    String name = reader.nextLine();
    System.out.println("Enter subject code");
    String code = reader.nextLine();
    if(Subject_Task1.isValidCode(code))
    {
      if(!Subject_Task1.codeExists(list, code))
      {
        list.add(new Subject_Task1(name, code));
        System.out.println("subject code added Successfully.");
      }
      else
      {
        System.out.println("subject code already exists.");
      }
    }
    else
    {
      System.out.println("Invalid subject code");
    }
  }
  
  public static void view_subject()
  {
    Subject_Task1.sortDisciplines(list);
    for(int i=0; i<list.size(); i++)
      System.out.println(list.get(i));
  }
  
  public static void save_subject()
  {
    try
    {
      FileWriter writer = new FileWriter("data.txt");
      for(int i=0; i<list.size(); i++)
      {
        writer.write(list.get(i).getName());
        writer.write(" ");
        writer.write(list.get(i).getSubjectCode());
        writer.write("\n");
      }
      writer.close();  
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}