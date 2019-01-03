package la.sweethouse.bingsu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMenu, btnContact;

    public static final String SHARED_PREF = "Bingsu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btn_menu);
        btnContact = findViewById(R.id.btn_contact);
//
//        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
//
//        boolean firstTime = sharedPref.getBoolean("first_time", true);
//
//        if (firstTime) {
//
//            sharedPref.edit().putBoolean("first_time", false);

            Intent intent = new Intent(MainActivity.this, PromoActivity.class);
            startActivity(intent);
//        }

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });


    }
}
