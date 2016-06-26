package xyz.vinesh.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import xyz.vinesh.creditcardview.CreditCardView;

public class MainActivity extends AppCompatActivity {
    CreditCardView cardView;
    EditText number, name, expiry, cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cardView.setCardNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cardView.setCardHolderName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        expiry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cardView.setExpiry(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cvv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cardView.setCvv(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void init() {
        cardView = (CreditCardView) findViewById(R.id.cvCreditCardView);
        number = (EditText) findViewById(R.id.etCardNumber);
        name = (EditText) findViewById(R.id.etName);
        expiry = (EditText) findViewById(R.id.etExpiry);
        cvv = (EditText) findViewById(R.id.etCvv);
    }
}
