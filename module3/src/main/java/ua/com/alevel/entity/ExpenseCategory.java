package ua.com.alevel.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("expense")
public class ExpenseCategory extends OperationCategory{
}
