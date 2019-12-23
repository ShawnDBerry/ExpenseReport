package com.example.budgetexpenseapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.budgetexpenseapp.R;
import com.example.budgetexpenseapp.database.ExpenseEntity;
import com.example.budgetexpenseapp.presenter.Contract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewExpenseFragement extends Fragment implements Contract.ExpenseView{

    public static final String NEW_EXPENSE_KEY = "new_expense";

    @BindView(R.id.new_expense_title_edit_text)
    EditText newExpenseTitleEditview;

    @BindView(R.id.new_expense_price_edit_text)
    EditText newExpensePriceEditview;

    @BindView(R.id.new_expense_limit_edit_text)
    EditText newExpenseLimitEditview;

    @BindView(R.id.save_new_expense_button)
    Button saveNewExpenseButton;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_expense, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.save_new_expense_button)
    public void saveExpense(View view){
        String expenseTitle = newExpenseTitleEditview.getText().toString().trim();
        String expensePrice = newExpensePriceEditview.getText().toString().trim();
        String expenseLimit = newExpenseLimitEditview.getText().toString().trim();
        String message = expenseTitle + "," + expensePrice + "," + expenseLimit;
        Intent intent = new Intent()

    }
    @OnClick(R.id.close_icon_imageview)
    public void closeFragment(View view) {
        getActivity().getSupportFragmentManager().popBackStack();
        Log.d("TAG_X", " new expense frag closed");
    }
    @Override
    public void displayAllExpenses(List<ExpenseEntity> expenseEntityList) {

    }

    @Override
    public void displayError(String errorString) {

    }

    @Override
    public void ExpenseListEmpty() {

    }

    @Override
    public void displayCost(double d) {

    }

    @Override
    public void insertExpenseSuccess() {

    }

    @Override
    public void insertSuccess() {

    }
}
