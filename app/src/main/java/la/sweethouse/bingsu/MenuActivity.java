package la.sweethouse.bingsu;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    RecyclerView rvMenu;
    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        List<Bingsu> bingsuList = new ArrayList<>();

        bingsuList.add(new Bingsu("Chocolate", "", 29000, 39000, 50000, R.drawable.chocolate_bingsu));
        bingsuList.add(new Bingsu("Chocolate", "", 29000, 39000, 50000, R.drawable.adzuki_bean_bingsu));
        bingsuList.add(new Bingsu("Chocolate", "", 29000, 39000, 50000, R.drawable.black_bean_bingsu));
        bingsuList.add(new Bingsu("Cendal", "", 29000, 39000, 50000, R.drawable.cendal_bingsu));
        bingsuList.add(new Bingsu("Jumbo", "", 29000, 39000, 50000, R.drawable.jumbo_bingsu));
        bingsuList.add(new Bingsu("Matcha", "", 29000, 39000, 50000, R.drawable.matcha_bingsu));
        bingsuList.add(new Bingsu("Melon", "", 29000, 39000, 50000, R.drawable.melon_bingsu));
        bingsuList.add(new Bingsu("Durian", "", 29000, 39000, 50000, R.drawable.durian_bingsu));
        bingsuList.add(new Bingsu("Special", "", 29000, 39000, 50000, R.drawable.promotion_bingsu));

        menuAdapter = new MenuAdapter(this, bingsuList);

        rvMenu = findViewById(R.id.recycler_view_menu);

        rvMenu.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        rvMenu.setAdapter(menuAdapter);

    }
}
