package la.sweethouse.bingsu;

import android.app.Activity;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
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

    Activity activity;

    List<Bingsu> bingsuList;

    public MenuAdapter(Activity activity) {
        this.activity = activity;
        bingsuList = new ArrayList();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bingsu_list_item, viewGroup, false);

        final int position = i;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewGroup.getContext(), DetailActivity.class);

                intent.putExtra("bingsu", bingsuList.get(position));

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view.findViewById(R.id.list_item_image), "detail_image");

                viewGroup.getContext().startActivity(intent, options.toBundle());
            }
        });

        // set view height to 1/3 of screen height

//        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
//
//        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
//        Log.d("Height", "" + layoutParams.height);
//        layoutParams.height = displayMetrics.heightPixels / 3;
//        view.setLayoutParams(layoutParams);

        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Bingsu bingsu = bingsuList.get(i);

        MenuItemViewHolder holder = (MenuItemViewHolder) viewHolder;

        holder.tvTitle.setText(bingsu.getName());

//        holder.ivImage.setImageDrawable();
        Glide.with(viewHolder.itemView)
                .load(bingsu.getImage())
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return bingsuList.size();
    }

    // include get item view type for multiple view type recycler view


    public void setMenuItemList(List<Bingsu> bingsuList) {
        this.bingsuList = bingsuList;
    }

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
