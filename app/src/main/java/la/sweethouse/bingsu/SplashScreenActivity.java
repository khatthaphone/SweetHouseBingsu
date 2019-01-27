package la.sweethouse.bingsu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_acivity);

        View rootView = findViewById(R.id.splash_screen_view);

        Thread timer = new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {

                }
            }
        };

        timer.start();


    }
}
