package xyz.vinesh.creditcardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by vineshraju on 24/6/16.
 */
public class CreditCardView extends CardView implements ViewPager.OnPageChangeListener {

    private Context context;
    private Card card;
    private ViewPager cardsPager;
    private CreditCardViewAdapter adapter;
    private AppCompatActivity activity;
    private int currentPage = 0;
    private CardUpdateListener frontListener = null, backListener = null;

    public CreditCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
        initFromXML(attrs);
        if (!this.isInEditMode())
            setUpCards();
    }

    public CreditCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
        initFromXML(attrs);
        if (!this.isInEditMode())
            setUpCards();

    }

    public CreditCardView(Context context) {
        super(context);
        this.context = context;
        initView();
        if (!this.isInEditMode())
            setUpCards();
    }

    private void setUpCards() {
        adapter = new CreditCardViewAdapter(this, activity.getSupportFragmentManager(), card);

        cardsPager.setAdapter(adapter);
        cardsPager.setPageTransformer(true, new FlipAnimation());
        cardsPager.addOnPageChangeListener(this);
    }

    public void setFrontListener(CardUpdateListener frontListener) {
        this.frontListener = frontListener;
    }

    public void setBackListener(CardUpdateListener backListener) {
        this.backListener = backListener;
    }

    public String getCardHolderName() {
        return this.card.getCardHolderName();
    }

    public void setCardHolderName(String cardHolderName) {
        this.card.setCardHolderName(cardHolderName);
        if (frontListener != null) {
            if (currentPage != 0) cardsPager.setCurrentItem(0);
            frontListener.updateCard(card);
        }
    }


    public String getCardNumber() {
        return this.card.getCardNumber();
    }

    public void setCardNumber(String cardNumber) {
        this.card.setCardNumber(cardNumber);
        if (frontListener != null) {
            if (currentPage != 0) cardsPager.setCurrentItem(0);
            frontListener.updateCard(card);
        }
    }

    public String getCvv() {
        return this.card.getCvv();
    }

    public void setCvv(String cvv) {
        this.card.setCvv(cvv);
        if (backListener != null) {
            if (currentPage != 1) cardsPager.setCurrentItem(1);
            backListener.updateCard(card);
        }
    }

    public String getExpiry() {
        return this.card.getExpiry();
    }

    public void setExpiry(String expiry) {
        this.card.setExpiry(expiry);
        if (frontListener != null) {
            if (currentPage != 0) cardsPager.setCurrentItem(0);
            frontListener.updateCard(card);
        }
    }

    private void initFromXML(AttributeSet attrs) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CreditCardView,
                0, 0);

        try {

            String sName = attributes.getString(R.styleable.CreditCardView_cardHolderName) != null ? attributes.getString(R.styleable.CreditCardView_cardHolderName) : "XXXXXX XXXX";
            String sNumber = attributes.getString(R.styleable.CreditCardView_cardNumber) != null ? attributes.getString(R.styleable.CreditCardView_cardNumber) : "XXXXXXXXXXXXXXXX";
            String sExpiry = attributes.getString(R.styleable.CreditCardView_expiry) != null ? attributes.getString(R.styleable.CreditCardView_expiry) : "MM/YY";
            String sCvv = attributes.getString(R.styleable.CreditCardView_cvv) != null ? attributes.getString(R.styleable.CreditCardView_cvv) : "XXX";
            int color = attributes.getColor(R.styleable.CreditCardView_cardForegroundColor, context.getResources().getColor(android.R.color.background_light));
            card = new Card(sName, sNumber, sCvv, sExpiry, color);


        } finally {
            attributes.recycle();
        }
    }

    private void initView() {
        if (!this.isInEditMode()) {
            card = new Card("XXXXXX XXXX", "XXXXXXXXXXXXXXXX", "XXX", "MM/YY", context.getResources().getColor(android.R.color.background_light));
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.credit_card_view, this, true);

            try {
                activity = (AppCompatActivity) context;
            } catch (Exception e) {
                e.printStackTrace();
            }

            cardsPager = (ViewPager) view.findViewById(R.id.vpCardsPager);
        } else {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.credit_card_view_front, this, true);
        }
    }

    public void setCardTypes(CardTypes cardTypes) {
        frontListener.updateCardTypes(cardTypes);
        backListener.updateCardTypes(cardTypes);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPage = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
