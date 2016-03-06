package anubhav.calculatorapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class UnitTemperature extends AppCompatActivity {

    EditText e1,e2;
    int count1=0,count2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_temperature);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        e1=(EditText)findViewById(R.id.item1);
        e2=(EditText)findViewById(R.id.item2);
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.num0:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"0");
                else
                    e2.setText(e2.getText()+"0");
                break;

            case R.id.num1:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"1");
                else
                    e2.setText(e2.getText()+"1");
                break;

            case R.id.num2:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"2");
                else
                    e2.setText(e2.getText()+"2");
                break;

            case R.id.num3:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"3");
                else
                    e2.setText(e2.getText()+"3");
                break;

            case R.id.num4:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"4");
                else
                    e2.setText(e2.getText()+"4");
                break;

            case R.id.num5:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"5");
                else
                    e2.setText(e2.getText()+"5");
                break;

            case R.id.num6:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"6");
                else
                    e2.setText(e2.getText()+"6");
                break;

            case R.id.num7:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"7");
                else
                    e2.setText(e2.getText()+"7");
                break;

            case R.id.num8:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"8");
                else
                    e2.setText(e2.getText()+"8");
                break;

            case R.id.num9:
                if(e1.isFocused())
                    e1.setText(e1.getText()+"9");
                else
                    e2.setText(e2.getText()+"9");
                break;

            case R.id.dot:
                if(e1.isFocused())
                {
                    if (count1==0)
                    {
                        e1.setText(e1.getText()+".");
                        count1++;
                    }
                }
                else
                {
                    if(count2==0)
                    {
                        e2.setText(e2.getText()+".");
                        count2++;
                    }
                }
                break;

            case R.id.clear:
                e1.setText("");
                e2.setText("");
                count1=count2=0;
                break;

            case R.id.backSpace:
                if(e1.isFocused())
                {
                    String text=e1.getText().toString();
                    if(text.endsWith("."))
                        count1=0;
                    if(text.length()>0)
                    {
                        String newText=text.substring(0,text.length()-1);
                        e1.setText(newText);
                    }
                }
                else
                {
                    String text=e2.getText().toString();
                    if(text.endsWith("."))
                        count2=0;
                    if(text.length()>0)
                    {
                        String newText=text.substring(0,text.length()-1);
                        e2.setText(newText);
                    }
                }
                break;
        }
    }
}
