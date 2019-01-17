package la.sweethouse.bingsu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    Bingsu bingsu;

    View vSizeSmall, vSizeMedium, vSizeLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acivity);

        bingsu = getIntent().getExtras().getParcelable("bingsu");

        TextView tvName = findViewById(R.id.tv_name);

        tvName.setText(bingsu.getName());

        ImageView imageView = findViewById(R.id.imv_detail);

        Glide.with(this)
                .load(bingsu.getImage())
//                .apply((new RequestOptions()).centerCrop().dontAnimate())
                .apply((new RequestOptions()).centerCrop())
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

        vSizeSmall = findViewById(R.id.size_small);
        vSizeMedium = findViewById(R.id.size_medium);
        vSizeLarge = findViewById(R.id.size_large);

        vSizeSmall.setOnClickListener(this);
        vSizeMedium.setOnClickListener(this);
        vSizeLarge.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(DetailActivity.this, CheckoutActivity.class);
        intent.putExtra("bingsu", bingsu);

        switch (v.getId()) {
            case R.id.size_small:
                intent.putExtra("size", "small");
                break;
            case R.id.size_medium:
                intent.putExtra("size", "medium");
                break;
            case R.id.size_large:
                intent.putExtra("size", "large");
                break;
        }

        startActivity(intent);
    }
}
