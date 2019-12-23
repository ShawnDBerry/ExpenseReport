package com.example.budgetexpenseapp.presenter;

import com.example.budgetexpenseapp.database.ExpenseEntity;

import java.util.List;

public interface Contract {

    interface ExpensePresenter {
        void getAllExpenses();

        void insertNewExpense(ExpenseEntity expenseEntity);

        void updateExpense(ExpenseEntity expenseEntity);

        void deleteExpense(ExpenseEntity expenseEntity);

        void getTotalCost();
    }

    interface ExpenseView {
        void displayAllExpenses(List<ExpenseEntity> expenseEntityList);

        void displayError(String errorString);

        void ExpenseListEmpty();

        void displayCost(double d);

        void insertExpenseSuccess();

        void insertSuccess();
    }
}
