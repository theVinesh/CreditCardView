package xyz.vinesh.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import xyz.vinesh.creditcardview.CreditCardView;

/**
 * Created by vineshraju on 26/6/16.
 */

public class CardHolder extends RecyclerView.ViewHolder {
    private CreditCardView creditCardView;

    public CardHolder(View itemView) {
        super(itemView);
        creditCardView = (CreditCardView) itemView.findViewById(R.id.ccvCardView);
    }

    public CreditCardView getCreditCardView() {
        return creditCardView;
    }
}
