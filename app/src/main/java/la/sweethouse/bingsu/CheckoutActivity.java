package la.sweethouse.bingsu;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {

    final int SIZE_SMALL = 0;
    final int SIZE_MEDIUM = 1;
    final int SIZE_LARGE = 2;

    Button btnIncrease, btnDecrease;
    TextView tvAmount, tvPrice;

    Bingsu bingsu;
    String size = "small";
    int amount = 1;

    NumberFormat numberFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        numberFormat = NumberFormat.getInstance(Locale.FRANCE);

        bingsu = getIntent().getExtras().getParcelable("bingsu");
        size = getIntent().getExtras().getString("size");

        generateQr(bingsu, size, 1);

        btnIncrease = findViewById(R.id.btn_increase);
        btnDecrease = findViewById(R.id.btn_decrease);
        tvAmount = findViewById(R.id.tv_amount);
        tvPrice = findViewById(R.id.tv_price);

        String priceText =  "" + (size.equals("small") ? bingsu.getPriceS() * amount : ((size.equals("large") ? bingsu.getPriceL() * amount : bingsu.getPriceM() * amount)));

//        try {
//            priceText = numberFormat.parse(priceText).toString();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        tvPrice.setText(priceText);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    amount = Integer.parseInt(tvAmount.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                amount++;

                tvAmount.setText("" + amount);

                String priceText =  "" + (size.equals("small") ? bingsu.getPriceS() * amount : ((size.equals("large") ? bingsu.getPriceL() * amount : bingsu.getPriceM() * amount)));

//                try {
//                    priceText = numberFormat.parse(priceText).toString();
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
                tvPrice.setText(priceText);

                generateQr(bingsu, size, amount);
            }
        });
        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    amount = Integer.parseInt(tvAmount.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                if (amount > 1) {

                    amount--;

                    tvAmount.setText("" + amount);

                    String priceText =  "" + (size.equals("small") ? bingsu.getPriceS() * amount : ((size.equals("large") ? bingsu.getPriceL() * amount : bingsu.getPriceM() * amount)));
//
//                    try {
//                        priceText = numberFormat.parse(priceText).toString();
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
                    tvPrice.setText(priceText);

                    generateQr(bingsu, size, amount);
                }
            }
        });

    }

    private void generateQr(Bingsu bingsu, String size, int amount) {

        ImageView imvQr = findViewById(R.id.imv_qr);

        String text = "www.sweethouse.com/bingsu/order/" + bingsu.getName() + "?size=" + size + ";";

        text += "amount=" + amount + ";";

        text += "price=" + (size.equals("small") ? bingsu.getPriceS() * amount : ((size.equals("large") ? bingsu.getPriceL() * amount : bingsu.getPriceM() * amount)));

        MultiFormatWriter writer = new MultiFormatWriter();

        try {
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 300, 300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imvQr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
