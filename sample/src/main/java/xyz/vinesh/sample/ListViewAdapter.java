package xyz.vinesh.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.vinesh.creditcardview.Card;
import xyz.vinesh.creditcardview.CreditCardView;

/**
 * Created by vineshraju on 26/6/16.
 */

public class ListViewAdapter extends RecyclerView.Adapter<CardHolder> {
    ArrayList<Card> cards;

    public ListViewAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_layout, parent, false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        Card card = cards.get(position);
        CreditCardView creditCardView = holder.getCreditCardView();
        creditCardView.setCardHolderName(card.getCardHolderName());
        creditCardView.setCardNumber(card.getCardNumber());
        creditCardView.setCvv(card.getCvv());
        creditCardView.setExpiry(card.getExpiry());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
