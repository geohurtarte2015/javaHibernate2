


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Student;
import pojo.Subject;



public class DaoSubject {
    
     private Session sesion;
    private Transaction tx;
    
    public void save(Subject subject ) throws HibernateException {
  
    try{     
        
        initOperation();
        sesion.persist(subject);        
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
    
    public List<Subject> listAll(){
       
       List<Subject> subjects = null;
       
       try{
           initOperation();
           subjects= sesion.createQuery("from Student").list();           
       } finally
       {
        sesion.close();
       }
       
       return subjects;
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
