package la.sweethouse.bingsu;

import android.app.Activity;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    AppCompatActivity activity;

    List<Bingsu> bingsuList;

    public MenuAdapter(AppCompatActivity activity, List<Bingsu> bingsuList) {
        this.activity = activity;
        this.bingsuList = bingsuList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bingsu_list_item, viewGroup, false);

        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {

        MenuItemViewHolder holder = (MenuItemViewHolder) viewHolder;

        Bingsu bingsu = bingsuList.get(viewHolder.getAdapterPosition());

        holder.tvTitle.setText(bingsu.getName());

//        holder.ivImage.setImageDrawable();
        Glide.with(activity)
                .load(bingsu.getImage())
                .into(holder.ivImage);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailActivity.class);

                intent.putExtra("bingsu", bingsuList.get(viewHolder.getAdapterPosition()));

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, ((MenuItemViewHolder) viewHolder).ivImage, "bingsu_image");

                activity.startActivity(intent, options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return bingsuList.size();
    }

    // include get item view type for multiple view type recycler view

    public class MenuItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivImage;
        public TextView tvTitle;

        public MenuItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            layoutParams.height = itemView.getContext().getResources().getDisplayMetrics().heightPixels / 3;
            itemView.setLayoutParams(layoutParams);

            ivImage = itemView.findViewById(R.id.list_item_image);
            tvTitle = itemView.findViewById(R.id.list_item_title);

        }
    }
}
