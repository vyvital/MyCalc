package vyvital.mycalc;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class CalcActivity extends Activity {



    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    Operation currentOperation;
    String rightValueStr = "";
    String leftValueStr = "";
    String runningNumber = "0";
    TextView res ;
    long result = 0;
    Dialog MyDialog;
    final private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_calc);

        Button clearBtn = findViewById(R.id.clearBtn);
        Button zeroBtn = findViewById(R.id.button0);
        Button oneBtn = findViewById(R.id.button1);
        Button twoBtn = findViewById(R.id.button2);
        Button threeBtn = findViewById(R.id.button3);
        Button fourBtn = findViewById(R.id.button4);
        Button fiveBtn = findViewById(R.id.button5);
        Button sixBtn = findViewById(R.id.button6);
        Button sevenBtn = findViewById(R.id.button7);
        Button eightBtn = findViewById(R.id.button8);
        Button nineBtn = findViewById(R.id.button9);

        ImageButton subBtn = findViewById(R.id.minus);
        ImageButton addBtn = findViewById(R.id.add);
        ImageButton mulBtn = findViewById(R.id.mul);
        ImageButton divBtn = findViewById(R.id.div);
        ImageButton calcBtn = findViewById(R.id.calcBtn);

        res = findViewById(R.id.resultText);



        res.setText("0");
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
                v.startAnimation(buttonClick);
            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
                v.startAnimation(buttonClick);
            }
        });
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);
                v.startAnimation(buttonClick);
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
                v.startAnimation(buttonClick);
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);

            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });
        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                currentOperation = null;
                runningNumber = "0";
                res.setText("0");
            }
        });
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });
    }
    void processOperation(Operation operation){
        if (currentOperation != null){
            if (!"".equals(runningNumber)){
                rightValueStr = runningNumber;
                runningNumber = "";
                switch (currentOperation){
                    case ADD:
                        result = Long.parseLong(leftValueStr)+Long.parseLong(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Long.parseLong(leftValueStr)-Long.parseLong(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Long.parseLong(leftValueStr)*Long.parseLong(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Long.parseLong(leftValueStr)/Long.parseLong(rightValueStr);
                        break;
                }
                leftValueStr = String.valueOf(result);
                res.setText(leftValueStr);
            }
        } else {
            leftValueStr = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
    }

    void numberPressed(long number){
        runningNumber += String.valueOf(number);
        if (runningNumber.startsWith("0") && runningNumber.length()>1){
            runningNumber = runningNumber.substring(1);
        }
        res.setText(runningNumber);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_paint){
            MyCustomAlertDialog();
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void MyCustomAlertDialog(){

        MyDialog = new Dialog(CalcActivity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.paint_dialog);
        Button orange = MyDialog.findViewById(R.id.orange);
        Button pink = MyDialog.findViewById(R.id.pink);
        Button red = MyDialog.findViewById(R.id.red);
        Button lime = MyDialog.findViewById(R.id.lime);
        Button green = MyDialog.findViewById(R.id.green);
        Button teal = MyDialog.findViewById(R.id.teal);
        Button blue = MyDialog.findViewById(R.id.blue);
        Button purple = MyDialog.findViewById(R.id.purple);
        Button dark = MyDialog.findViewById(R.id.dark);
        MyDialog.show();

        orange.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();

                Utils.changeToTheme(CalcActivity.this,Utils.ORANGE);
            }
        });
        pink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.PINK);
            }
        });
        red.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.RED);
            }
        });
        lime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.LIME);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.GREEN);
            }
        });
        teal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.TEAL);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.BLUE);
            }
        });
        purple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.PURPLE);
            }
        });
        dark.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                Utils.changeToTheme(CalcActivity.this,Utils.DARK);
            }
        });
    }

    public void MyCustomAlertDialog2(){
        MyDialog = new Dialog(CalcActivity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.second_dialog);
        MyDialog.show();
    }

}
