import java.util.*;
import java.io.*;


class Subject_Task1
{
  private String name;
  private String subject_code;
  public Subject_Task1(String name, String subject_code)
  {
    if(subject_code.length() != 6)
      throw new IllegalArgumentException("Subject code must be of 6 characters.");
    this.name = name;
    this.subject_code = subject_code;
  }
  public String getName(){ return name; }
  public String getSubjectCode(){ return subject_code; }
  public String getDiscipline()
  {
    return name + subject_code.substring(3);
  }
  public boolean codeMatches(String code)
  {
    return subject_code.equals(code);
  }
  public String toString()
  {
    return "name: "+name + ", subject code: " + subject_code;
  }
  
  public static String[] allDisciplines(ArrayList<Subject_Task1> array)
  {
    String[] narray = new String[array.size()];
    for(int i=0; i<array.size(); i++)
      narray[i] = array.get(i).getSubjectCode().substring(0,3);
    for(int i = 0; i<array.size()-1; i++) {
      for (int j = i+1; j<array.size(); j++) {
        if(narray[i].compareTo(narray[j])>0) {
          String temp = narray[i];
          narray[i] = narray[j];
          narray[j] = temp;
        }
      }
    }
    return narray;
  }
  
  public static ArrayList<Subject_Task1> codesPerDiscipline(ArrayList<Subject_Task1> array, String disp)
  {
    ArrayList<Subject_Task1> list = new ArrayList<Subject_Task1>();
    for(int i=0; i<array.size(); i++)
    {
      if(array.get(i).getSubjectCode().substring(0,3).equals(disp))
        list.add(array.get(i));
    }
    return list;
  }
  public static boolean isValidCode(String code)
  {
    return code.matches("[a-zA-Z][a-zA-Z][a-zA-Z][a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]");
  }
  
  public static boolean codeExists(ArrayList<Subject_Task1> array, String code)
  {
    for(int i=0; i<array.size(); i++)
    {
      if(array.get(i).getSubjectCode().equals(code)) return true;
    }
    return false;
  }
  public static void sortDisciplines(ArrayList<Subject_Task1> array)
  {
    for(int i = 0; i<array.size()-1; i++) {
      for (int j = i+1; j<array.size(); j++) {
        if(array.get(i).getSubjectCode().compareTo(array.get(j).getSubjectCode())>0) {
          Subject_Task1 temp = array.get(i);
          array.set(i, array.get(j));  
          array.set(j, temp);
        }
      }
    }
  }
  
}