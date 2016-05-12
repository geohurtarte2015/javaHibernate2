package pojo;


 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "SUBJECT")
public class Subject {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SUBJECT_ID")
    private long id;
 
    @Column(name = "NAME")
    private String name;
     
     
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="subjects")
    private Set<Student> students = new HashSet<Student>(); 

    
     
    public Subject(){
         
    }
     
    public Subject(String name){
        this.name = name;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
 
    public Set<Student> getStudents() {
        return students;
    }
 
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
 
 
}