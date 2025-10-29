package project.majorProjects;
import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String name;
    int rNo;
    String course;
    String email;
    String section;

    Student(String name,int rNo,String course,String email,String section){
        this.name=name;
        this.rNo=rNo;
        this.course=course;
        this.email=email;
        this.section=section;
    }

}

class Marks{
    int maths;
    int science;
    int hindi;
    int english;

    Marks(int maths,int science,int hindi,int english){
        this.maths=maths;
        this.science=science;
        this.hindi=hindi;
        this.english=english;
    }

    public int getMathsMarks(){
        return maths;
    }

    public int getScienceMarks(){
        return science;
    }

    public int getHindiMarks(){
        return hindi;
    }

    public int getEnglishMarks(){
        return english;
    }

    public int getTotal(){
        return maths+science+hindi+english;
    }

    public double getPercentage(){
        return getTotal()/4.0;
    }

    public Character getGrades(){
        double per=getPercentage();

        if(per>=90) return 'A';
        else if(per>=80 && per<90) return 'B';
        else if(per<80 && per>=70) return 'C';
        else if(per<70 && per>=60) return 'D';
        else if(per<60 && per>=50) return 'E';
        return 'F';
    }
}

class StudentInfo{
    Student stu;
    Marks mark;

    StudentInfo(Student s,Marks m){
        this.stu=s;
        this.mark=m;
    }

    public void displayStudentInfo(){
        System.out.println("Student Report card :");
        System.out.println();
        System.out.println("Student name : "+stu.name);
        System.out.println("Roll Number : "+stu.rNo);
        System.out.println("Course : "+stu.course);
        System.out.println("Email : "+stu.email);
        System.out.println("Section : "+stu.section);
        System.out.println("Student Marks :");
        System.out.println("MATHS marks : "+mark.getMathsMarks());
        System.out.println("SCIENCE marks : "+mark.getScienceMarks());
        System.out.println("HINDI marks : "+mark.getHindiMarks());
        System.out.println("ENGLISH marks : "+mark.getEnglishMarks());
        System.out.println();
        System.out.println("Total is : "+mark.getTotal());
        System.out.println("your Percentage is : "+mark.getPercentage()+"%");
        System.out.println("your Grade is : "+mark.getGrades());
    }
}

class database{
    static Scanner sc=new Scanner(System.in);
    public static ArrayList<StudentInfo> reportCards = new ArrayList<>();
    
    public static void storage(StudentInfo s){
        reportCards.add(s);
        System.out.println("student added sucessesfully!");
        
    }

    public static void displayAllStudent(){
        System.out.println("All students are :");
        System.out.println();
        
        if(!reportCards.isEmpty()){
            for (StudentInfo s : reportCards) {
                System.out.println();
                s.displayStudentInfo(); // call method to print details
                System.out.println("______________________");
                System.out.println();
            }
        }
        else{
            System.out.println("there are no student in the list");
        }

    }

    public static void removeStudent(){
        System.out.println("Enter the rollnumber of the student, you want to delete");
        int rno=sc.nextInt();
        for(int i=0;i<reportCards.size();i++){
            if(reportCards.get(i).stu.rNo==rno){
                reportCards.remove(i);
                System.out.println("Student deleted sucessfully!");
            }
            else{
                System.out.println();
                System.out.println("Student not found!");
                break;
            }
        }
        System.out.println();
        database.displayAllStudent();
        
    }

}

class AddStudent{

    public static void enterInfo(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your name :");
        String name=sc.nextLine();

        System.out.println("Enter roll Number");
        int rno=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Email :");
        String email=sc.nextLine();

        System.out.println("Enter course :");
        String course=sc.nextLine();

        System.out.println("Enter section");
        String section=sc.nextLine();

        Student st=new Student(name,rno,course,email,section);
        
        System.out.println("Enter marks:");
        System.out.println();
        System.out.println("Enter maths marks");
        int maths=sc.nextInt();

        System.out.println("Enter science marks :");
        int science=sc.nextInt();

        System.out.println("Enter hindi marks :");
        int hindi=sc.nextInt();

        System.out.println("Enter english marks :");
        int eng=sc.nextInt();

        Marks m=new Marks(maths, science, hindi, eng);

        StudentInfo stinfo=new StudentInfo(st, m);

        database.storage(stinfo);
        //sc.close();
    }
}

class EnterChoice{
    public static void enterChoice(){
        System.out.println("Enter your choice :");

        System.out.println("1. Add student");
        System.out.println("2. View report card");
        System.out.println("3. Remove student");
        System.out.println("4. Exit!");
        System.out.println();

    }
}

public class studentReportCardSystem {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        
        System.out.println("STUDENT REPORT-CARD SYSTEM :-");
        System.out.println();
        EnterChoice.enterChoice();

        int opt=sc.nextInt();

        while(opt!=4){
            switch(opt){

                case 1:
                    System.out.println("Adding Student");
                    System.out.println();
                    AddStudent.enterInfo();
                    EnterChoice.enterChoice();
                    opt=sc.nextInt();
                    break;

                case 2:
                    System.out.println();
                    database.displayAllStudent();
                    EnterChoice.enterChoice();
                    opt=sc.nextInt();
                    break;

                case 3:
                    System.out.println("Removing student!");
                    database.removeStudent();
                    EnterChoice.enterChoice();
                    opt=sc.nextInt();
                    break;
            }
        }
        System.out.println();
        System.out.println("Exiting from student report-card system!");

        sc.close();
    }
}
