package pojo;


 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "STUDENT")
public class Student {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private long id;
 
    @Column(name = "FIRST_NAME")
    private String firstName;
 
    @Column(name = "LAST_NAME")
    private String lastName;
 
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_SUBJECT", 
        joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "SUBJECT_ID") })
    private Set<Subject> subjects = new HashSet<Subject>();
 
    public Student() {
    }
 
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public Set<Subject> getSubjects() {
        return subjects;
    }
 
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
 
     
   
 
}