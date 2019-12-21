package com.example.budgetexpenseapp.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.budgetexpenseapp.database.ExpenseEntity;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>{
    private List<ExpenseEntity> expenseList;
    private ExpenseDelegate expenseDelegate;

    public ExpenseAdapter(List<ExpenseEntity> expenseList, ExpenseDelegate expenseDelegate) {
        this.expenseList = expenseList;
        this.expenseDelegate = expenseDelegate;
    }

    public interface ExpenseDelegate{
        void expenseSelected(ExpenseEntity expenseEntity);
    }


    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ExpenseViewHolder extends RecyclerView.ViewHolder{

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
