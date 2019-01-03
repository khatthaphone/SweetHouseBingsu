package la.sweethouse.bingsu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acivity);

        Bingsu bingsu = getIntent().getParcelableExtra("bingsu");

        TextView tvName = findViewById(R.id.tv_name);

        tvName.setText(bingsu.getName());

        ImageView imageView = findViewById(R.id.imv_detail);

        imageView.setImageDrawable(getDrawable(bingsu.getImage()));

        Log.d("Bingsu", bingsu.getName());

    }

}
