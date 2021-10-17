package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "counts")
public class Count{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Access(AccessType.PROPERTY)
    private User user;

    @Column
    private long balance;

    @OneToMany(mappedBy = "count")
    private List<Operation> operations;

    public Count(){
        operations = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public long getBalance(){
        return balance;
    }

    public void setBalance(long balance){
        this.balance = balance;
    }

    public List<Operation> getOperations(){
        return operations;
    }

    public void setOperations(List<Operation> operations){
        this.operations = operations;
    }

    public void addOperation(Operation operation){
        operations.add(operation);
        operation.setCount(this);
    }
}
