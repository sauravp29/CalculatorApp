package anubhav.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class StandardCal extends AppCompatActivity {

    EditText e1,e2;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_cal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.num0:
                e2.setText(e2.getText()+"0");
                break;

            case R.id.num1:
                e2.setText(e2.getText()+"1");
                break;


            case R.id.num2:
                e2.setText(e2.getText()+"2");
                break;


            case R.id.num3:
                e2.setText(e2.getText()+"3");
                break;


            case R.id.num4:
                e2.setText(e2.getText()+"4");
                break;


            case R.id.num5:
                e2.setText(e2.getText()+"5");
                break;


            case R.id.num6:
                e2.setText(e2.getText()+"6");
                break;


            case R.id.num7:
                e2.setText(e2.getText()+"7");
                break;


            case R.id.num8:
                e2.setText(e2.getText()+"8");
                break;


            case R.id.num9:
                e2.setText(e2.getText()+"9");
                break;

            case R.id.dot:
                if(count==0)
                {
                    e2.setText(e2.getText()+".");
                    count++;
                }
                break;


            case R.id.clear:
                e1.setText("");
                e2.setText("");
                count=0;
                break;

            case R.id.backSpace:
                String text=e2.getText().toString();
                if(text.endsWith("."))
                    count=0;
                if(text.length()>0)
                {
                    String newText=text.substring(0,text.length()-1);
                    e2.setText(newText);
                }
                break;

            case R.id.plus:

                break;

            case R.id.minus:

                break;

            case R.id.divide:

                break;

            case R.id.multiply:

                break;

            case R.id.sqrt:

                break;

            case R.id.square:

                break;

            case R.id.posneg:

                break;

            case R.id.equal:

                break;
        }
    }


}
