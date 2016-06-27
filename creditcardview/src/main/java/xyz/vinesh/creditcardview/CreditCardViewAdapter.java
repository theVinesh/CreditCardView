package xyz.vinesh.creditcardview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vineshraju on 26/6/16.
 */

public class CreditCardViewAdapter extends FragmentPagerAdapter {
    private Card card;
    private CreditCardView creditCardView;

    public CreditCardViewAdapter(CreditCardView creditCardView, FragmentManager fm, Card card) {
        super(fm);
        this.card = card;
        this.creditCardView = creditCardView;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CreditCardViewFront creditCardViewFront = CreditCardViewFront.newInstance(card);
                creditCardViewFront.setCreditCardView(creditCardView);
                return creditCardViewFront;
            case 1:
                CreditCardViewBack creditCardViewBack = CreditCardViewBack.newInstance(card);
                creditCardViewBack.setCreditCardView(creditCardView);
                return creditCardViewBack;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
