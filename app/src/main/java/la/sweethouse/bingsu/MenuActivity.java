package la.sweethouse.bingsu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    RecyclerView rvMenu;
    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        List<Bingsu> bingsuList = new ArrayList<>();

        bingsuList.add(new Bingsu("ຊັອກໂກແລັດ", "", 29000, 39000, 50000, R.drawable.chocolate_bingsu));
        bingsuList.add(new Bingsu("ໂອຣິໂອ", "", 29000, 39000, 50000, R.drawable.adzuki_bean_bingsu));
        bingsuList.add(new Bingsu("ຖົ່ວແດງ", "", 29000, 39000, 50000, R.drawable.black_bean_bingsu));
        bingsuList.add(new Bingsu("ລອດຊ່ອງ", "", 29000, 39000, 50000, R.drawable.cendal_bingsu));
        bingsuList.add(new Bingsu("ໝາກໄມ້ລວມ", "", 29000, 39000, 50000, R.drawable.jumbo_bingsu));
        bingsuList.add(new Bingsu("ຊາຂຽວ", "", 29000, 39000, 50000, R.drawable.matcha_bingsu));
        bingsuList.add(new Bingsu("ແຄນຕາລຸກ", "", 29000, 39000, 50000, R.drawable.melon_bingsu));
        bingsuList.add(new Bingsu("ຖົ່ວລຽນ", "", 29000, 39000, 50000, R.drawable.durian_bingsu));

        menuAdapter = new MenuAdapter(this, bingsuList);

        rvMenu = findViewById(R.id.recycler_view_menu);

        rvMenu.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        rvMenu.setAdapter(menuAdapter);

    }
}
