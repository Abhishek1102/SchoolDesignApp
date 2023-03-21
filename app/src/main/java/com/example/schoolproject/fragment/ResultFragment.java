package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.ResultModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultFragment extends BaseFragment {

    @BindView(R.id.rv_result)
    RecyclerView rv_result;

    List<ResultModel> resultList;

    ResultAdapter resultAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        resultList = new ArrayList<>();

        resultList.add(new ResultModel("English","84-B"));
        resultList.add(new ResultModel("Hindi","64-C"));
        resultList.add(new ResultModel("Science","94-A"));
        resultList.add(new ResultModel("History","84-B"));
        resultList.add(new ResultModel("Maths","54-D"));
        resultList.add(new ResultModel("Hindi","60-C"));
        resultList.add(new ResultModel("Chemistry","80-B"));
        resultList.add(new ResultModel("Gujarati","90-A"));

        resultAdapter = new ResultAdapter();
        rv_result.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        rv_result.setAdapter(resultAdapter);

    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    @OnClick(R.id.lv_downloadpdf)
    void lv_downloadpdfClick(){
        Toast.makeText(activity, "Pdf downloaded", Toast.LENGTH_SHORT).show();
        getParentFragmentManager().popBackStack();
    }

    public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ItemViewHolder>{

        @NonNull
        @Override
        public ResultAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_result,parent,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ResultAdapter.ItemViewHolder holder, int position) {
            ResultModel resultModel = resultList.get(position);
            holder.tv_resultSubjectName.setText(resultModel.getSubject());
            holder.tv_resultSubjectMark.setText(resultModel.getMark());
        }

        @Override
        public int getItemCount() {
            return resultList.size();
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_resultSubjectName)
            TextView tv_resultSubjectName;
            @BindView(R.id.tv_resultSubjectMark)
            TextView tv_resultSubjectMark;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}