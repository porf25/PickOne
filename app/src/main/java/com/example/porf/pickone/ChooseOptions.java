package com.example.porf.pickone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ChooseOptions extends ActionBarActivity {

    ArrayList<String> Lista = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_options);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addToList(View ListAddView){


        EditText getInputText = (EditText) findViewById(R.id.enterItem);
        String input = getInputText.getText().toString().trim();

        TextView inputBox =(TextView) findViewById(R.id.enterItem);

        if(input.isEmpty()){
            System.out.println("we made it to the if statement with  " + input);

            String errorText = "Cannot add a blank item to the list, please add something and try again!";
            Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();

            InputMethodManager imm = (InputMethodManager)getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getInputText.getWindowToken(), 0);

        }
        else{
           Lista.add(input);
           System.out.println("this is what was added to the list " + input);
           inputBox.setText("");

            String addedText = input + " added to the list!";
            Toast.makeText(this, addedText, Toast.LENGTH_SHORT).show();


            InputMethodManager imm = (InputMethodManager)getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getInputText.getWindowToken(), 0);

           for(String s: Lista){
               System.out.println("Lista has item " + s);
           }
        }

    }

    public void seeList(View view) {

        Intent seeListIntent = new Intent(this, SeeList.class);

        seeListIntent.putStringArrayListExtra("The List", Lista);

        startActivity(seeListIntent);

    }
}
