package la.sweethouse.bingsu;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    Bingsu[] bingsus = {
            new Bingsu("Chocolate", "", 29000, 39000, 50000, R.drawable.chocolate_bingsu),
            new Bingsu("Chocolate", "", 29000, 39000, 50000, R.drawable.adzuki_bean_bingsu),
            new Bingsu("Chocolate", "", 29000, 39000, 50000, R.drawable.black_bean_bingsu),
            new Bingsu("Cendal", "", 29000, 39000, 50000, R.drawable.cendal_bingsu),
            new Bingsu("Jumbo", "", 29000, 39000, 50000, R.drawable.jumbo_bingsu),
            new Bingsu("Matcha", "", 29000, 39000, 50000, R.drawable.matcha_bingsu),
            new Bingsu("Melon", "", 29000, 39000, 50000, R.drawable.melon_bingsu),
            new Bingsu("Durian", "", 29000, 39000, 50000, R.drawable.durian_bingsu),
            new Bingsu("Special", "", 29000, 39000, 50000, R.drawable.promotion_bingsu)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, bingsus));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MenuActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
