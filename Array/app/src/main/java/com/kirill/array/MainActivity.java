package com.kirill.array;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewCapacity = (TextView) findViewById(R.id.textViewCapacity);
    TextView textViewSize = (TextView) findViewById(R.id.textViewSize);
    TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
    EditText editTextCapacity = (EditText) findViewById(R.id.editTextCapacity);
    EditText editTextIndex = (EditText) findViewById(R.id.editTextIndex);
    EditText editTextValue = (EditText) findViewById(R.id.editTextValue);
    Button buttonCapacity = (Button) findViewById(R.id.buttonCapacity);
    Button buttonExecute = (Button) findViewById(R.id.buttonExecute);
    Array<String> array = new Array<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCapacity = (TextView) findViewById(R.id.textViewCapacity);
        textViewSize = (TextView) findViewById(R.id.textViewSize);
        editTextCapacity = (EditText) findViewById(R.id.editTextCapacity);
        editTextIndex = (EditText) findViewById(R.id.editTextIndex);
        editTextValue = (EditText) findViewById(R.id.editTextValue);
        buttonCapacity = (Button) findViewById(R.id.buttonCapacity);
        buttonExecute = (Button) findViewById(R.id.buttonExecute);
        array = new Array<>();
        textViewSize.setText(array.getSize());
        textViewCapacity.setText(array.getMemorySize());
    }

    public void buttonExecuteOnClick(View view) {
        int index = Integer.parseInt(editTextIndex.getText().toString());
        String value = editTextValue.getText().toString();
        array.add(index, value);
        textViewCapacity.setText(array.getMemorySize());
        textViewSize.setText(array.getSize());
        editTextIndex.setText(index + 1);
        editTextValue.setText("");
       // textViewResult.setText("Добавлено значение: " + value + "\nпо индексу: " + value);
    }
}
