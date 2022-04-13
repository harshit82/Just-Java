package com.example.android.jj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/* @param unitPrice is the price of a single item
*/
    int quantity = 0, unitPrice = 5;

    public void increment(View view) {
        if(quantity==100) {
            Toast.makeText(this,"You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity==1) {
            Toast.makeText(this,"You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    private int calculatePrice() {
        return quantity * unitPrice;
    }

    /*To create order summary
     *
     * @param name of the customer
     * @param addChocolate is whether the customer has asked for Chocolate to be added
     * @param addWhippedCream is whether the customer has asked for Whipped Cream to be added
     * @param price is the price of the ordered product
     * @return text summary
     * */

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String WhippedCream,Chocolate;
        if(addWhippedCream)
            WhippedCream="Yes";
        else
            WhippedCream="No";
        if(addChocolate)
            Chocolate="Yes";
        else
            Chocolate="No";

        String priceMessage = "Name: " + name;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal Rs. " + price;
        priceMessage += "\nAdd Whipped Cream? " + WhippedCream;
        priceMessage += "\nAdd Chocolate? " + Chocolate;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.Chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText nameField = (EditText) findViewById(R.id.name);
        String name = nameField.getText().toString();

        int totalPrice = calculatePrice();
        String priceMessage = createOrderSummary(totalPrice, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);
    }

    public void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }

    public void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}