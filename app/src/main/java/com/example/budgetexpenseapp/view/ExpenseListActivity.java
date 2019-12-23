package com.example.budgetexpenseapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.budgetexpenseapp.R;
import com.example.budgetexpenseapp.adapter.ExpenseAdapter;
import com.example.budgetexpenseapp.database.ExpenseEntity;
import com.example.budgetexpenseapp.presenter.Contract;
import com.example.budgetexpenseapp.presenter.ExpensePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpenseListActivity extends AppCompatActivity implements Contract.ExpenseView, ExpenseAdapter.ExpenseDelegate {

    private Contract.ExpensePresenter expensePresenter;


    private DetailEditFragment detailEditFragment = new DetailEditFragment();
    private NewExpenseFragement newExpenseFragement = new NewExpenseFragement();

    @BindView(R.id.expense_recycler_view)
    RecyclerView expenseRecyclerView;

    @BindView(R.id.expense_list_text_view)
    public TextView expenseListTextView;

    @BindView(R.id.expense_list_total_cost_text_view)
    public TextView expenseListTotalCostTextView;

    @BindView(R.id.new_expense_button)
    public Button newExpenseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);

        ButterKnife.bind(this);

        expensePresenter = new ExpensePresenter(this);

       BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
           @Override
           public void onReceive(Context context, Intent intent) {

           }
       };

        //expensePresenter.insertNewExpense(new ExpenseEntity("Dinner", 50.00, 1000.00));

        expensePresenter.getAllExpenses();
        expensePresenter.getTotalCost();

        newExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(newExpenseFragement.getTag())
                        .add(R.id.new_expense_frame_layout, newExpenseFragement)
                        .commit();
            }
        });
    }

    @Override
    public void expenseSelected(ExpenseEntity expenseEntity) {
        Log.d("TAG_X", "expenseSelected: in here");
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(detailEditFragment.getTag())
                .add(R.id.new_expense_frame_layout, detailEditFragment)
                .commit();
    }

    @Override
    public void displayAllExpenses(List<ExpenseEntity> expenseEntityList) {
        ExpenseAdapter expenseAdapter = new ExpenseAdapter(expenseEntityList, this);
        Log.d("TAG_X", "wya? Expense Activity");
        expenseRecyclerView.setAdapter(expenseAdapter);
        expenseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        expenseRecyclerView.addItemDecoration(decoration);
    }

    @Override
    public void displayError(String errorString) {
        expenseListTextView.setText(getString(R.string.error_text, errorString));
    }

    @Override
    public void ExpenseListEmpty() {
        expenseListTextView.setText(getString(R.string.error_text, "No Saved Receipts"));
    }

    @Override
    public void displayCost(double totalCost) {
        expenseListTotalCostTextView.setText(getString(R.string.total_text, "" + totalCost));
    }

    @Override
    public void insertExpenseSuccess() {
        Toast.makeText(this, "Update Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void insertSuccess() {
        Toast.makeText(this, "Insert Successful", Toast.LENGTH_SHORT).show();
    }
}
