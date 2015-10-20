package com.example.assignment3;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
	
	EditText firstNumber;
	TextView addResult;
	Button btnAdd;

	int num1,num2,sum;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        firstNumber = (EditText)findViewById(R.id.txtNumber1);
        addResult = (TextView)findViewById(R.id.txtResult);
        btnAdd = (Button)findViewById(R.id.btnAdd);
       btnAdd.setOnClickListener(new OnClickListener()
        {
                 
                  @Override
                  public void onClick(View v)
                  {
                	  MagicSquare mq = new MagicSquare();
                	  String s = mq.getMagicSquare(Integer.parseInt(firstNumber.getText().toString()));
                	  
              	  
                   	  addResult.setText(s);
                   	
                  }
                 
            });
    }
}