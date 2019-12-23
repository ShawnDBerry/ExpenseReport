package com.example.budgetexpenseapp.view;

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

public class DetailEditFragment extends Fragment implements Contract.ExpenseView {

    @BindView(R.id.expense_detail_title_edit_text)
    EditText detail_edit_expense_title;

    @BindView(R.id.expense_detail_price_edit_text)
    EditText detail_edit_expense_price;

    @BindView(R.id.expense_detail_limit_edit_text)
    EditText detail_edit_expense_limit;

    @BindView(R.id.delete_expense_button)
    Button deleteExpenseButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_edit, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.close_icon_imageview)
    public void closeFragment(View view) {
        getActivity().getSupportFragmentManager().popBackStack();
        Log.d("TAG_X", "detailed frag closed");
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
