package com.siddheswarojha.codigoplatforma;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class AboutUsAdapter extends FirebaseRecyclerAdapter<AboutModel,AboutUsAdapter.viewHolder> {


    public AboutUsAdapter(@NonNull FirebaseRecyclerOptions<AboutModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull AboutModel model) {

        holder.txtNameMember.setText(model.getName());
        holder.txtThought.setText(model.getGithub());
        Glide.with(holder.imgCoordinator.getContext()).load(model.getImg()).into(holder.imgCoordinator);

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_aboutus, parent, false);

        return new AboutUsAdapter.viewHolder(view);
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView txtNameMember, txtThought;
      ImageView imgCoordinator;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameMember = itemView.findViewById(R.id.txtNameMember);
            imgCoordinator=itemView.findViewById(R.id.imgCoordinator);
            txtThought = itemView.findViewById(R.id.txtThought);
        }
    }

}
