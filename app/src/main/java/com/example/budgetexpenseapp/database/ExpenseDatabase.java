package com.example.budgetexpenseapp.database;

import androidx.room.RoomDatabase;

public abstract class ExpenseDatabase extends RoomDatabase {

    public abstract ExpenseDAO expenseDAO();
}
