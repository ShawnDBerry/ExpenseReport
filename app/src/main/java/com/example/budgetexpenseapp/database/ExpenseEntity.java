package com.example.budgetexpenseapp.database;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expenses")
public class ExpenseEntity implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int expenseId;

    @ColumnInfo(name = "expense_title")
    private String expenseTitle;

    @ColumnInfo(name = "expense_price")
    private double expensePrice;

    @ColumnInfo(name = "expense_limit")
    private double expenseLimit;

    @Ignore
    public ExpenseEntity(String expenseTitle, double expensePrice, double expenseLimit) {
        this.expenseTitle = expenseTitle;
        this.expensePrice = expensePrice;
        this.expenseLimit = expenseLimit;
    }

    public ExpenseEntity(int expenseId, String expenseTitle, double expensePrice, double expenseLimit) {
        this.expenseId = expenseId;
        this.expenseTitle = expenseTitle;
        this.expensePrice = expensePrice;
        this.expenseLimit = expenseLimit;
    }


    protected ExpenseEntity(Parcel in) {
        expenseId = in.readInt();
        expenseTitle = in.readString();
        expensePrice = in.readDouble();
        expenseLimit = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(expenseId);
        dest.writeString(expenseTitle);
        dest.writeDouble(expensePrice);
        dest.writeDouble(expenseLimit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ExpenseEntity> CREATOR = new Creator<ExpenseEntity>() {
        @Override
        public ExpenseEntity createFromParcel(Parcel in) {
            return new ExpenseEntity(in);
        }

        @Override
        public ExpenseEntity[] newArray(int size) {
            return new ExpenseEntity[size];
        }
    };

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
