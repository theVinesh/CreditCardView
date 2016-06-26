package xyz.vinesh.creditcardview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vineshraju on 26/6/16.
 */

public class CreditCardViewAdapter extends FragmentPagerAdapter implements CardUpdateListener {
    Card card;
    CreditCardViewFront creditCardViewFront;
    CreditCardViewBack creditCardViewBack;

    public CreditCardViewAdapter(CreditCardView creditCardView, FragmentManager fm, Card card) {
        super(fm);
        this.card = card;
        creditCardView.setListener(this);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                creditCardViewFront = CreditCardViewFront.newInstance(card);
                return creditCardViewFront;
            case 1:
                creditCardViewBack = CreditCardViewBack.newInstance(card);
                return creditCardViewBack;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public void updateCard(Card card) {
        creditCardViewFront.updateCard(card);
        creditCardViewBack.updateCard(card);
    }
}
