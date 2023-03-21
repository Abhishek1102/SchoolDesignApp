package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.FeesDueModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeesDueFragment extends BaseFragment {

    @BindView(R.id.rv_feesdue)
    RecyclerView rv_feesdue;

    FeesDueAdapter feesDueAdapter;

    List<FeesDueModel> feesDueList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fees_due, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        feesDueList = new ArrayList<>();

        feesDueList.add(new FeesDueModel("#98761","October","10 Oct 20",null,null,null,"Pay Now",R.drawable.right_arrow));
        feesDueList.add(new FeesDueModel("#98431","September","10 Sep 20","Cash on Counter",null,"\u20b9999","Download",R.drawable.download_icon));

        feesDueAdapter = new FeesDueAdapter();
        rv_feesdue.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        rv_feesdue.setAdapter(feesDueAdapter);

    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    class FeesDueAdapter extends RecyclerView.Adapter<FeesDueAdapter.FeesDueViewHolder>{

        @NonNull
        @Override
        public FeesDueAdapter.FeesDueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feesdue,parent,false);
            return new FeesDueViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FeesDueAdapter.FeesDueViewHolder holder, int position) {
            FeesDueModel feesDueModel = feesDueList.get(position);
            holder.tv_receiptNo.setText(feesDueModel.getReceiptNo());
            holder.tv_month.setText(feesDueModel.getMonth());
            holder.tv_paymentDate.setText(feesDueModel.getPaymentDate());
            holder.tv_pendingAmount.setText(feesDueModel.getTotalPendingAmount());
            holder.tv_amount.setText(feesDueModel.getTotalamount());
            holder.tv_payDownload.setText(feesDueModel.getPayDownload());
            holder.iv_feesdue.setImageResource(feesDueModel.getIv_feesdue());

            holder.lv_bottom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadFragmentFull(new PayOnlineFragment(),"PayOnlineFragment");
                }
            });
        }

        @Override
        public int getItemCount() {
            return feesDueList.size();
        }

        public class FeesDueViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_receiptNo)
            TextView tv_receiptNo;
            @BindView(R.id.tv_month)
            TextView tv_month;
            @BindView(R.id.tv_paymentDate)
            TextView tv_paymentDate;
            @BindView(R.id.tv_pendingAmount)
            TextView tv_pendingAmount;
            @BindView(R.id.tv_amount)
            TextView tv_amount;
            @BindView(R.id.tv_payDownload)
            TextView tv_payDownload;
            @BindView(R.id.iv_feesdue)
            ImageView iv_feesdue;
            @BindView(R.id.lv_bottom)
            LinearLayout lv_bottom;

            public FeesDueViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}