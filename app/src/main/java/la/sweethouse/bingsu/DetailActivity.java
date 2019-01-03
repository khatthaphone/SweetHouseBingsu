package la.sweethouse.bingsu;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acivity);

        Bingsu bingsu = getIntent().getExtras().getParcelable("bingsu");

        TextView tvName = findViewById(R.id.tv_name);

        tvName.setText(bingsu.getName());

        ImageView imageView = findViewById(R.id.imv_detail);

//        supportPostponeEnterTransition();

        Glide.with(this)
                .load(bingsu.getImage())
                .apply((new RequestOptions()).centerCrop().dontAnimate())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        supportPostponeEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        supportPostponeEnterTransition();
                        return false;
                    }
                })
                .into(imageView);
//
//        Glide.with(this)
//                .load(bingsu.getImage())
//                .into(imageView);

        Log.d("Bingsu", bingsu.getName());

    }

}
