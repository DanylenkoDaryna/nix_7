package ua.com.alevel.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "operations")
public class Operation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @Access(AccessType.PROPERTY)
    private OperationCategory category;

    @Column(nullable = false)
    private long money;

    @Column(name = "date_time")
    private Instant dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "count_id", referencedColumnName = "id")
    @Access(AccessType.PROPERTY)
    private Count count;

    public Operation(){
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public OperationCategory getCategory(){
        return category;
    }

    public void setCategory(OperationCategory category){
        this.category = category;
    }

    public long getMoney(){
        return money;
    }

    public void setMoney(long money){
        this.money = money;
    }

    public Instant getDateTime(){
        return dateTime;
    }

    public void setDateTime(Instant dateTime){
        this.dateTime = dateTime;
    }

    public Count getCount(){
        return count;
    }

    public void setCount(Count count){
        this.count = count;
    }
}
