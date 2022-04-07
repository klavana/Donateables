package com.example.a4g_ksd;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.CompoundButton;
        import android.widget.TextView;

public class UserOffers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_offers);
        Intent intent = getIntent();
        final Controller aController = (Controller) getApplicationContext();
        String UserOffer = intent.getStringExtra(aController.getUser().getMyItemsList());
        String CompOffer = intent.getStringExtra("key3");
        TextView textViewUserReqTester = findViewById(R.id.textViewUserReqTester);
        textViewUserReqTester.setText(UserOffer);
        TextView compOffers = findViewById(R.id.compOffers);
        compOffers.setText(CompOffer);

    }
}
