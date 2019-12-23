package com.example.budgetexpenseapp.presenter;

import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.example.budgetexpenseapp.database.ExpenseDatabase;
import com.example.budgetexpenseapp.database.ExpenseEntity;
import com.example.budgetexpenseapp.view.ExpenseListActivity;

import java.util.ArrayList;
import java.util.List;

public class ExpensePresenter implements Contract.ExpensePresenter {

    private Contract.ExpenseView expenseView;
    private ExpenseDatabase expenseDatabase;
    List<ExpenseEntity> expenseEntityList = new ArrayList<>();
    double count = 0.00;


    public ExpensePresenter(Contract.ExpenseView expenseView) {
        this.expenseView = expenseView;

        try {
            new ASyncThreadInitialize().execute();

        } catch (Exception e) {

            expenseView.displayError("Failed to create database" + e.getMessage());
        }
    }


    @Override
    public void getAllExpenses() {
        if (expenseEntityList.isEmpty()) {
            expenseView.ExpenseListEmpty();
        } else {
            expenseView.displayAllExpenses(expenseEntityList);
        }

    }

    @Override
    public void getTotalCost() {

        if (expenseEntityList.isEmpty()) {
            expenseView.ExpenseListEmpty();
        } else {
            for(int i = 0; i < expenseEntityList.size(); i++){
               count += expenseEntityList.get(i).getExpensePrice();
            }

            expenseView.displayCost(count);
        }
    }

    @Override
    public void insertNewExpense(ExpenseEntity expenseEntity) {
        try {
            new ASyncThreadAddExpense().execute(expenseEntity);
            getTotalCost();
        } catch (Exception e) {
            expenseView.displayError("Failed to insert " + expenseEntity.getExpenseTitle() + e.getMessage());
        }

    }

    @Override
    public void updateExpense(ExpenseEntity expenseEntity) {
        try {
            new ASyncThreadUpdate().execute(expenseEntity);
            getTotalCost();
        } catch (Exception e) {
            expenseView.displayError("Failed to update " + expenseEntity.getExpenseTitle() + e.getMessage());
        }
    }

    @Override
    public void deleteExpense(ExpenseEntity expenseEntity) {

        try {
            new ASyncThreadDelete().execute(expenseEntity);
            getTotalCost();
        } catch (Exception e) {
            expenseView.displayError("Failed to delete " + expenseEntity.getExpenseTitle());
        }
    }

    class ASyncThreadInitialize extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            expenseDatabase = Room.databaseBuilder(((ExpenseListActivity) expenseView)
                            .getApplicationContext(),
                    ExpenseDatabase.class, "expense.db")
                    .build();
            expenseEntityList = expenseDatabase.expenseDAO().getAllExpenses();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("TAG_X", "wya? Get Expenses "+expenseEntityList.toString());
            getAllExpenses();
            getTotalCost();
        }
    }


    class ASyncThreadAddExpense extends AsyncTask<ExpenseEntity, Void, Void> {

        @Override
        protected Void doInBackground(ExpenseEntity... expenseEntities) {
            expenseDatabase.expenseDAO().insertNewExpense(expenseEntities[0]);
            expenseEntityList = expenseDatabase.expenseDAO().getAllExpenses();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("TAG_X", "Im in the insert PostExecute");
            getAllExpenses();
            getTotalCost();
        }
    }

    class ASyncThreadUpdate extends AsyncTask<ExpenseEntity, Void, Void> {

        @Override
        protected Void doInBackground(ExpenseEntity... expenseEntities) {
            expenseDatabase.expenseDAO().updateExpense(expenseEntities[0]);
            expenseEntityList = expenseDatabase.expenseDAO().getAllExpenses();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            getAllExpenses();
            getTotalCost();
        }
    }

    class ASyncThreadDelete extends AsyncTask<ExpenseEntity, Void, Void> {

        @Override
        protected Void doInBackground(ExpenseEntity... expenseEntities) {
            expenseDatabase.expenseDAO().deleteExpense(expenseEntities[0]);
            expenseEntityList = expenseDatabase.expenseDAO().getAllExpenses();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            getAllExpenses();
            getTotalCost();
        }
    }
}
