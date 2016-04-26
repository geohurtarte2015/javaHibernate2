
import org.hibernate.Session;
 
import pojo.Student;
import pojo.Subject;
import pojo.Teacher;
 
 
public class DaoStudent {
     
    public static void main(String[] args) {
 
        Student student1 = new Student("Sam","Disilva");
        
        Teacher teacher1 = new Teacher("Melany");
        student1.setTeacher(teacher1);
        
        
        Subject subject1 = new Subject("Economics");
        Subject subject2 = new Subject("Politics");
         //Student1 have 3 subjects
        student1.getSubjects().add(subject1);
        student1.getSubjects().add(subject2);
        
     
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
        session.persist(teacher1);
        session.persist(subject1);
        session.persist(subject2);
        session.persist(student1);
        session.getTransaction().commit();
        session.close();
        
        
        
        
        
        
 
       

   
 
       
    }
 
}