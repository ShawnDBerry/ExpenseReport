package com.example.budgetexpenseapp.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDAO {

    @Query("SELECT * FROM expenses")
    public List<ExpenseEntity> getAllExpenses();

    @Insert
    void insertNewExpense(ExpenseEntity expenseEntity);

    @Delete
    void deleteExpense(ExpenseEntity expenseEntity);

    @Update
    void modifyExpense(ExpenseEntity expenseEntity);

    @Query("SELECT SUM(expense_price) FROM expenses")
    double getTotalCost();
}
