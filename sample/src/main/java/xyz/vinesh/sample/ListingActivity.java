package xyz.vinesh.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import xyz.vinesh.creditcardview.Card;

public class ListingActivity extends AppCompatActivity {
    RecyclerView listingView;
    ListViewAdapter adapter;
    ArrayList<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        populate();
        listingView = (RecyclerView) findViewById(R.id.rvListView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ListViewAdapter(cards);

        listingView.setLayoutManager(layoutManager);
        listingView.setAdapter(adapter);
    }

    private void populate() {
        cards = new ArrayList<>();
        cards.add(new Card("Vinesh Raju R", "4123456789123456", "000", "06/26", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Tony Stark", "5433456789127856", "010", "09/18", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Wade Wilson", "3433456748139456", "015", "10/28", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Peter Parker", "1233456748139456", "675", "11/16", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Vinesh Raju R", "4123456789123456", "000", "06/26", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Tony Stark", "5433456789127856", "010", "09/18", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Wade Wilson", "3433456748139456", "015", "10/28", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Peter Parker", "1233456748139456", "675", "11/16", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Vinesh Raju R", "4123456789123456", "000", "06/26", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Tony Stark", "5433456789127856", "010", "09/18", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Wade Wilson", "3433456748139456", "015", "10/28", getResources().getColor(android.R.color.white)));
        cards.add(new Card("Peter Parker", "1233456748139456", "675", "11/16", getResources().getColor(android.R.color.white)));
    }
}
