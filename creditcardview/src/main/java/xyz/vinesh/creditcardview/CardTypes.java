package xyz.vinesh.creditcardview;

import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by vineshraju on 26/6/16.
 */
public class CardTypes {

    private ArrayList<PatternResourcePairs> cardTypes;

    public CardTypes() {

        cardTypes = new ArrayList();

        //master card pattern
        learn("^5[1-5][0-9]{14}$", R.drawable.ic_billing_mastercard_logo);

        //visa card pattern
        learn("^4[0-9]{12}(?:[0-9]{3})?$", R.drawable.visa_logo);

        //amex card pattern
        learn("^3[47][0-9]{13}$", R.drawable.ic_billing_amex_logo1);

    }

    public ArrayList<PatternResourcePairs> getCardTypes() {
        return cardTypes;
    }

    public void learn(String pattern, int logoResource) {
        cardTypes.add(new PatternResourcePairs(pattern, logoResource));
    }

    class PatternResourcePairs {
        private Pattern pattern;
        private int logoResource;

        public PatternResourcePairs(String pattern, int logoResource) {
            this.logoResource = logoResource;
            try {
                this.pattern = Pattern.compile(pattern);
            } catch (PatternSyntaxException e) {
                Log.e("INVALID PATTERN", e.getMessage());
            }
        }

        public int getLogoResource() {
            return logoResource;
        }

        public boolean matches(String s) {
            Pattern p = Pattern.compile(" ");
            Matcher m = p.matcher(s);
            String strippedString = m.replaceAll("");
            Matcher matcher = this.pattern.matcher(strippedString);
            return matcher.matches();
        }
    }

}
