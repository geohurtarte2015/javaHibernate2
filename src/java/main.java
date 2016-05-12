
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import pojo.Student;
import pojo.Subject;

 
public class main {
     
    public static void main(String[] args) {

        Student student1 = new Student("Sam", "Disilva");
        Student student2 = new Student("Jose", "Manuel");
       
        HashSet set2 = new HashSet();
        set2.add(new Subject("Algebra"));
        set2.add(new Subject("Geografia"));
        
        HashSet set1 = new HashSet();
        set1.add(new Subject("Economics"));
        set1.add(new Subject("Politics"));
        set1.add(new Subject("Foreign Affairs"));
        
        //Student1 have 3 subjects
        student1.setSubjects(set1);
        student2.setSubjects(set2);



        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(student1);
        session.persist(student2);

        session.getTransaction().commit();
        session.close();
  
        
        DaoStudent daoStudents = new DaoStudent();
        List<Student> students = daoStudents.listAll();
        System.out.println("\n");
        for (Iterator iterator1 = 
                           students.iterator(); iterator1.hasNext();){
            Student student = (Student) iterator1.next(); 
            System.out.print("Nombre: " + student.getFirstName()+" ");
            System.out.print("Apellido: " + student.getLastName()+"\n"); 
            
            Set subjects = student.getSubjects();
            for (Iterator iterator2 = 
                         subjects.iterator(); iterator2.hasNext();){
                  Subject subName = (Subject) iterator2.next(); 
                  System.out.println("SubjectName: " + subName.getName()); 
            }
            
            System.out.println("\n");
         }
        

    }
}