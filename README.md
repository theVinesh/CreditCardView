# CreditCardView

[ ![Download](https://api.bintray.com/packages/vineshraju/maven/CreditCardView/images/download.svg) ](https://bintray.com/vineshraju/maven/CreditCardView/_latestVersion)

Intro
------

CreditCardView is a simple custom view for displaying Credit / Debit Cards with automatic card type identification and ability to learn user defined card types. 


Creating a CreditCardView
--------------------------
##### in XML
```xml
  <xyz.vinesh.creditcardview.CreditCardView     
  android:id="@+id/cvCreditCardView"     
  android:layout_width="wrap_content"    
  android:layout_height="wrap_content"     
  app:cardNumber="1234567891234567”     
  app:cardHolderName="VINESH RAJU"     
  app:expiry="06/16"
  app:cvv=“000” />

```

##### in Code

```java

   CreditCardView creditCardView = new CreditCardView(context);
   
   String name = “VINESH RAJU”;
   String cvv = “000”;
   String expiry = "06/16”;
   String cardNumber = "1234567891234567";

   creditCardView.setCvv(cvv);
   creditCardView.setName(name);
   creditCardView.setExpiry(expiry);
   creditCardView.setNumber(cardNumber);

```

Getting card info
---------------------

To get the information displayed on the card

```java
   String name = creditCardView.getName();
   String cvv = creditCardView.getCvv();
   String expiry = creditCardView.getExpiry();
   String cardNumber = creditCardView.getNumber();
```


Learning new Card Types
----------------------

CreditCardView automatically detects and displays appropriate logos for Visa,Master Card and American Express. In addition to these new types can be taught to CreditCardView by using the learn method

### Syntax

```java
	CardType.learn(String regEx,int logoResource);
```
where regEx is the regular expression defining the pattern for the new card

#### Example

```java
	CardType cardType=new CardType();
	cardType.learn("^3[47][0-9]{13}$", R.drawable.am_ex_logo);
	creditCardView.setCardTypes(cardType);
```

Adding to your project
------------------------

- Add the following configuration in your build.gradle file.

```gradle
dependencies {
    compile ‘xyz.vinesh.creditcardview:creditcardview:1.0’
}
```

Designed and Developed By
------------

* Vinesh Raju - <vineshraju@rocketmail.com>


License
--------
```
Copyright 2016 Vinesh Raju

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
