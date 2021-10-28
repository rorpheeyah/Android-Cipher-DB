package com.rorpheeyah.androidcipherdb.pets;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rorpheeyah.androidcipherdb.R;
import com.rorpheeyah.androidcipherdb.databinding.LayoutItemBinding;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {
    private ArrayList<Pet> pets;

    public void setPets(@NonNull ArrayList<Pet> listOfPet){
        pets = listOfPet;
        notifyItemRangeInserted(0, pets.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pet pet = pets.get(holder.getAdapterPosition());
        holder.setBinding(pet);
    }

    @Override
    public int getItemCount() {
        return pets == null ? 0 : pets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemBinding binding;
        public ViewHolder(@NonNull LayoutItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void setBinding(@NonNull Pet pet){
            binding.setPet(pet);
            binding.executePendingBindings();
        }
    }
}
