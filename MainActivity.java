package com.example.danie.speedconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {




    Spinner distOne;
    Spinner distTwo;
    Spinner speedOne;
    Spinner speedTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        makeSpeedDropOne();
        makeSpeedDropTwo();
        makeDropOne();
        makeDropTwo();
    }
    public void dis(String result){
        TextView distSelect = (TextView) findViewById(R.id.distSelect);
        distSelect.setText("" + result);

    }
    public double getInput(){
        EditText userInput = (EditText) findViewById(R.id.inputDist);
        try{
            String strNum = userInput.getText().toString();
            double number = Double.parseDouble(strNum);
            return number;
        }catch(Exception e){
            double error = 0.0;
            return error;
        }

    }
    public void makeDropOne(){
        distOne = (Spinner) findViewById(R.id.distanceOne);
        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(this, R.array.distances, android.R.layout.simple_spinner_item);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distOne.setAdapter(adapterOne);
    }

    public void makeDropTwo(){
        distTwo = (Spinner) findViewById(R.id.distanceTwo);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this, R.array.distances, android.R.layout.simple_spinner_item);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distTwo.setAdapter(adapterTwo);
    }

    public void makeSpeedDropOne(){
        speedOne = (Spinner) findViewById(R.id.speedOne);
        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(this, R.array.speeds, android.R.layout.simple_spinner_item);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedOne.setAdapter(adapterOne);
    }

    public void makeSpeedDropTwo(){
        speedTwo = (Spinner) findViewById(R.id.speedTwo);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this, R.array.speeds, android.R.layout.simple_spinner_item);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedTwo.setAdapter(adapterTwo);
    }

    public void conversion(View view){
        String original = distOne.getSelectedItem().toString();
        String end = distTwo.getSelectedItem().toString();
        String endSpeed = speedTwo.getSelectedItem().toString();
        double speed = speedConverter(getInput());
        double result;
        String resultStr;
        switch(original){
            case "Feet":
                if (end.equals("Miles")){
                    result = speed / 5280;
                }else if(end.equals("Inches")){
                    result = speed * 12;
                }else if(end.equals("Yards")){
                    result = speed / 3;
                }else if(end.equals("Kilometers")){
                    result = speed * 0.0003048;
                }else if(end.equals("Meters")){
                    result = speed * 0.3048;
                }else{
                    result = speed;
                }
                resultStr = String.format("%.6f", result);
                resultStr += " " + end + " per " + endSpeed;
                dis(resultStr);
                break;
            case "Miles":
                if (end.equals("Feet")){
                    result = speed * 5280;
                }else if(end.equals("Inches")){
                    result = speed * 5280 * 12;
                }else if(end.equals("Yards")){
                    result = speed * 1760;
                }else if(end.equals("Kilometers")){
                    result = speed * 1.60935;
                }else if(end.equals("Meters")){
                    result = speed * 1609.35;
                }else{
                    result = speed;
                }
                resultStr = String.format("%.6f", result);
                resultStr += " " + end + " per " + endSpeed;
                dis(resultStr);
                break;

            case "Inches":
                if(end.equals("Miles")){
                    result = speed / 12 / 5280;
                }else if(end.equals("Feet")){
                    result = speed / 12;
                }else if(end.equals("Yards")){
                    result = speed / 12/3;
                }else if(end.equals("Kilometers")){
                    result = speed * 0.0000254;
                }else if(end.equals("Meters")){
                    result = speed * 0.0254;
                }else{
                    result = speed;
                }
                resultStr = String.format("%.6f", result);
                resultStr += " " + end + " per " + endSpeed;
                dis(resultStr);
                break;

            case "Yards":
                if(end.equals("Miles")){
                    result = speed / 1760;
                }else if(end.equals("Feet")){
                    result = speed * 3;
                }else if(end.equals("Inches")){
                    result = speed * 12 * 3;
                }else if(end.equals("Kilometers")){
                    result = speed * 0.0009144;
                }else if(end.equals("Meters")){
                    result = speed * 0.9144;
                }else{
                    result = speed;
                }
                resultStr = String.format("%.6f", result);
                resultStr += " " + end + " per " + endSpeed;
                dis(resultStr);
                break;

            case "Kilometers":
                if(end.equals("Miles")){
                    result = speed * 0.621;
                }else if(end.equals("Feet")){
                    result = speed * 3280.84;
                }else if(end.equals("Inches")){
                    result = speed * 39370.08;
                }else if(end.equals("Yards")){
                    result = speed * 1093.61;
                }else if(end.equals("Meters")){
                    result = speed * 1000;
                }else{
                    result = speed;
                }
                resultStr = String.format("%.6f", result);
                resultStr += " " + end + " per " + endSpeed;
                dis(resultStr);
                break;

            case "Meters":
                if(end.equals("Miles")){
                    result = speed * 0.00062;
                }else if(end.equals("Feet")){
                    result = speed * 3.28;
                }else if(end.equals("Inches")){
                    result = speed * 39.37;
                }else if(end.equals("Kilometers")){
                    result = speed * 0.001;
                }else if(end.equals("Yards")){
                    result = speed * 1.094;
                }else{
                    result = speed;
                }
                resultStr = String.format("%.6f", result);
                resultStr += " " + end + " per " + endSpeed;
                dis(resultStr);
                break;

            default:
                result = 0;
                resultStr = String.format("%.6f", result);
                resultStr += " " + end + " per " + endSpeed;
                dis(resultStr);
                break;


            //return resultStr;

        }


    }
    public double speedConverter(double num){
        /*
        In this part of the code , the time conversion
        must have opposite operators since in real speed conversion, the
        time is on the bottom, meaning it is divided.
         */
        String original = speedOne.getSelectedItem().toString();
        String end = speedTwo.getSelectedItem().toString();

        switch(original){
            case("Hours"):
                if(end.equals("Minutes")){
                    num /= 60;
                }else if(end.equals("Seconds")){
                    num /= 3600;
                }else{
                    num *= 1;
                }
                break;
            case("Minutes"):
                if(end.equals("Hours")){
                    num *= 60;
                }else if(end.equals("Seconds")){
                    num /= 60;
                }else{
                    num *= 1;
                }
                break;
            case("Seconds"):
                if(end.equals("Hours")){
                    num *= 3600;
                }else if(end.equals("Minutes")){
                    num *= 60;
                }else{
                    num *= 1;
                }
                break;
            default:
                num = 0.0;
                break;
        }
        return num;
    }






}
