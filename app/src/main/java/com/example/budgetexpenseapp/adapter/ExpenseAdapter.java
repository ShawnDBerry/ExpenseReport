package com.example.budgetexpenseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.budgetexpenseapp.R;
import com.example.budgetexpenseapp.database.ExpenseEntity;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {
    private List<ExpenseEntity> expenseList;
    private ExpenseDelegate expenseDelegate;


    public ExpenseAdapter(List<ExpenseEntity> expenseList, ExpenseDelegate expenseDelegate) {
        this.expenseList = expenseList;
        this.expenseDelegate = expenseDelegate;
    }

    public interface ExpenseDelegate {
        void expenseSelected(ExpenseEntity expenseEntity);
    }


    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item_layout, parent, false);


        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        holder.expenseTitle.setText(expenseList.get(position).getExpenseTitle());
        holder.expensePrice.setText("$ " + expenseList.get(position).getExpensePrice());
        holder.expenseLimit.setText("$ " + expenseList.get(position).getExpenseLimit());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenseDelegate.expenseSelected(expenseList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView expenseTitle;
        TextView expensePrice;
        TextView expenseLimit;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            expenseTitle = itemView.findViewById(R.id.expense_item_title_text_view);
            expensePrice = itemView.findViewById(R.id.expense_item_price_text_view);
            expenseLimit = itemView.findViewById(R.id.expense_item_limit_text_view);
        }
    }

}
