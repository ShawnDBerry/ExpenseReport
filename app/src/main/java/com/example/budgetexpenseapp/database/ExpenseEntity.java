package com.example.budgetexpenseapp.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expenses")
public class ExpenseEntity {

    @PrimaryKey(autoGenerate = true)
    private int expenseId;

    @ColumnInfo(name = "expense_title")
    private String expenseTitle;

    @ColumnInfo(name = "expense_price")
    private double expensePrice;

    @ColumnInfo(name = "expense_limit")
    private double expenseLimit;


    public ExpenseEntity(String expenseTitle, double expensePrice, double expenseLimit) {
        this.expenseTitle = expenseTitle;
        this.expensePrice = expensePrice;
        this.expenseLimit = expenseLimit;
    }

    @Ignore
    public ExpenseEntity(int expenseId, String expenseTitle, double expensePrice, double expenseLimit) {
        this.expenseId = expenseId;
        this.expenseTitle = expenseTitle;
        this.expensePrice = expensePrice;
        this.expenseLimit = expenseLimit;
    }


    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public double getExpensePrice() {
        return expensePrice;
    }

    public void setExpensePrice(double expensePrice) {
        this.expensePrice = expensePrice;
    }

    public double getExpenseLimit() {
        return expenseLimit;
    }

    public void setExpenseLimit(double expenseLimit) {
        this.expenseLimit = expenseLimit;
    }

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "expenseId=" + expenseId +
                ", expenseTitle='" + expenseTitle + '\'' +
                ", expensePrice=" + expensePrice +
                ", expenseLimit=" + expenseLimit +
                '}';
    }
}
