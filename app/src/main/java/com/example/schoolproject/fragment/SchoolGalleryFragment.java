package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.GalleryModel;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SchoolGalleryFragment extends BaseFragment {

    @BindView(R.id.rv_gallery)
    RecyclerView rv_gallery;

    List<GalleryModel> galleryList;
    private GalleryAdapter galleryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_school_gallery, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_gallery.setLayoutManager(layoutManager);
        rv_gallery.setHasFixedSize(true);

        galleryList = new ArrayList<>();

        galleryList.add(new GalleryModel(R.drawable.schoolimage1));
        galleryList.add(new GalleryModel(R.drawable.schoolimage2));
        galleryList.add(new GalleryModel(R.drawable.schoolimage3));
        galleryList.add(new GalleryModel(R.drawable.schoolimage4));
        galleryList.add(new GalleryModel(R.drawable.schoolimage5));
        galleryList.add(new GalleryModel(R.drawable.schoolimage6));
        galleryList.add(new GalleryModel(R.drawable.schoolimage7));
        galleryList.add(new GalleryModel(R.drawable.schoolimage8));
        galleryList.add(new GalleryModel(R.drawable.schoolimage9));
        galleryList.add(new GalleryModel(R.drawable.schoolimage10));
        galleryList.add(new GalleryModel(R.drawable.schoolimage5));
        galleryList.add(new GalleryModel(R.drawable.schoolimage6));
        galleryList.add(new GalleryModel(R.drawable.schoolimage7));
        galleryList.add(new GalleryModel(R.drawable.schoolimage8));
        galleryList.add(new GalleryModel(R.drawable.schoolimage9));
        galleryList.add(new GalleryModel(R.drawable.schoolimage10));

        galleryAdapter = new GalleryAdapter();
        rv_gallery.setAdapter(galleryAdapter);
    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ItemViewHolder> {

        @NonNull
        @Override
        public GalleryAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gallery, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GalleryAdapter.ItemViewHolder holder, int position) {
            GalleryModel galleryModel = galleryList.get(position);
            holder.img_gallery.setImageResource(galleryModel.getImage());
            holder.card_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadFragmentFull(new FullImageFragment(galleryList,position),"FullImageFragment");
                }
            });
        }

        @Override
        public int getItemCount() {
            return galleryList.size();
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.img_gallery)
            ImageView img_gallery;
            @BindView(R.id.card_img)
            CardView card_img;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }

}