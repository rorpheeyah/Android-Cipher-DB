package com.rorpheeyah.androidcipherdb.pets;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.rorpheeyah.androidcipherdb.R;

public class PetBindingAdapter {

    @BindingAdapter({"app:setImageViewResource"})
    public static void setImageViewResource(@NonNull AppCompatImageView imageView, String imgUrl) {
        if(TextUtils.isEmpty(imgUrl)){
            Glide.with(imageView.getContext()).load(ContextCompat.getDrawable(imageView.getContext(), R.drawable.placeholder)).into(imageView);
        }else{
            Glide.with(imageView.getContext()).load(ContextCompat.getDrawable(imageView.getContext(), R.drawable.loading)).into(imageView);
            Glide.with(imageView.getContext())
                    .load(imgUrl)
                    .placeholder(ContextCompat.getDrawable(imageView.getContext(), R.drawable.loading))
                    .into(imageView);
        }
    }
}
