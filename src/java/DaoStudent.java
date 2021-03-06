


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Student;



public class DaoStudent {
    
     private Session sesion;
    private Transaction tx;
    
    public void save(Student student ) throws HibernateException {
  
    try{     
        
        initOperation();
        sesion.persist(student);        
        tx.commit();
        
    
    }catch(HibernateException he)
    {
        
        trueExcepcion(he); 
        throw he; 
    
    
    } finally
    {
                
        sesion.close();
    
    }
    
    

}
    
    public List<Student> listAll(){
       
       List<Student> students = null;
       
       try{
           initOperation();
           students= sesion.createQuery("from Student").list();           
       } finally
       {
        sesion.close();
       }
       
       return students;
   }   
    
    public Student getByIdObject(int idStudent){
       Student student = null;
       try{
           
           initOperation();
           student = (Student) sesion.get(Student.class, idStudent);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return student;
   }
   


    private void initOperation() throws HibernateException 

    {
    
    sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    
}

    private void trueExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    }
    
    
}
