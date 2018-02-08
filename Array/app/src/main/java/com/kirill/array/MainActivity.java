package com.kirill.array;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity {
    TextView textViewCapacity;
    TextView textViewSize;
    TextView textViewResult;

    EditText editTextCapacity;
    EditText editTextIndex;
    EditText editTextValue;

    Button buttonCapacity;
    Button buttonExecute;

    ProgressBar progressBarCapacity;

    Array<String> array;

    RadioButton radioButtonAdd;
    RadioButton radioButtonDelete;
    RadioButton radioButtonChange;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCapacity = (TextView) findViewById(R.id.textViewCapacity);
        textViewSize = (TextView) findViewById(R.id.textViewSize);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        editTextCapacity = (EditText) findViewById(R.id.editTextCapacity);
        editTextIndex = (EditText) findViewById(R.id.editTextIndex);
        editTextValue = (EditText) findViewById(R.id.editTextValue);

        buttonCapacity = (Button) findViewById(R.id.buttonCapacity);
        buttonExecute = (Button) findViewById(R.id.buttonExecute);

        progressBarCapacity = (ProgressBar) findViewById(R.id.progressBarCapacity);


        radioButtonAdd = (RadioButton) findViewById(R.id.radioButtonAdd);
        radioButtonChange = (RadioButton) findViewById(R.id.radioButtonChange);
        radioButtonDelete = (RadioButton) findViewById(R.id.radioButtonDelete);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        array = new Array<>();

        update();

    }

    public void update() {
        textViewCapacity.setText(String.valueOf(array.getMemorySize()));
        textViewSize.setText(String.valueOf(array.getSize()));
        progressBarCapacity.setMax(array.getMemorySize());
        progressBarCapacity.setProgress(array.getSize());
    }


    public void add(View view) {
        String value = editTextValue.getText().toString();
        int index = 0;
        try {
            index = Integer.parseInt(editTextIndex.getText().toString());
            array.add(index, value);
            update();
            editTextIndex.setText(String.valueOf(index + 1));
            editTextValue.setText("");
            textViewResult.setTextColor(Color.GREEN);
            textViewResult.setText("Добавлено значение: " + value + "\nпо индексу: " + index);
        } catch (NumberFormatException e) {
            textViewResult.setTextColor(Color.RED);
            textViewResult.setText("Вы ввели неккоректный индекс");
        } catch (ArrayIndexOutOfBoundsException e) {
            textViewResult.setTextColor(Color.RED);
            textViewResult.setText("Вы вышли за границы массива");
        }

    }

    public void delete(View view) {
        try {
            int index = Integer.parseInt(editTextIndex.getText().toString());
            String value = array.delete(index);
            textViewResult.setTextColor(Color.GREEN);
            textViewResult.setText("Удалено значение: " + value + "\nпо индексу: " + index);
            update();
        } catch (NumberFormatException e) {
            textViewResult.setTextColor(Color.RED);
            textViewResult.setText("Вы ввели неккоректный индекс");
        } catch (ArrayIndexOutOfBoundsException e) {
            textViewResult.setTextColor(Color.RED);
            textViewResult.setText("Вы вышли за границы массива");
        }
    }

    public void show(View view){
        try {
            int index = Integer.parseInt(editTextIndex.getText().toString());
            String value = array.get(index);
            textViewResult.setTextColor(Color.GREEN);
            textViewResult.setText("значение: " + value + "\nпо индексу: " + index);
            update();
        } catch (NumberFormatException e) {
            textViewResult.setTextColor(Color.RED);
            textViewResult.setText("Вы ввели неккоректный индекс");
        } catch (ArrayIndexOutOfBoundsException e) {
            textViewResult.setTextColor(Color.RED);
            textViewResult.setText("Вы вышли за границы массива");
        }
    }

    public void dispatchOnClick(View view) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButtonAdd:
                add(view);
                break;
            case R.id.radioButtonDelete:
                delete(view);
                break;
            case R.id.radioButtonChange:
                show(view);
                break;
            default:
                break;
        }
    }
}
