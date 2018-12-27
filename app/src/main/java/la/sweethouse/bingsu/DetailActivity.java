package la.sweethouse.bingsu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acivity);

        String name = getIntent().getStringExtra("name");
        int imageResource = getIntent().getIntExtra("image", R.drawable.chocolate_bingsu);

        TextView tvName = findViewById(R.id.tv_name);

        tvName.setText(name);

        ImageView imageView = findViewById(R.id.imv_detail);

        imageView.setImageDrawable(getDrawable(imageResource));

    }
}
