package anubhav.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class StandardCal extends AppCompatActivity {

    EditText e1,e2;
    private int count=0;

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
                if(count==0 && e2.length()!=0)
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
                operationClicked("+");
                break;

            case R.id.minus:
                operationClicked("-");
                break;

            case R.id.divide:
                operationClicked("/");
                break;

            case R.id.multiply:
                operationClicked("x");
                break;

            case R.id.sqrt:
                if(e2.length()!=0)
                {
                    e2.setText("√"+e2.getText());
                }
                break;

            case R.id.square:
                if(e2.length()!=0)
                {
                    e2.setText("sqr"+e2.getText());
                }
                break;

            case R.id.posneg:
                if(e2.length()!=0)
                {
                    String s=e2.getText().toString();
                    char arr[]=s.toCharArray();
                    if(arr[0]=='-')
                        e2.setText(s.substring(1,s.length()));
                    else
                        e2.setText("-"+s);
                }
                break;

            case R.id.equal:

                break;
        }
    }

    private void operationClicked(String op)
    {
        if(e2.length()!=0)
        {
            e1.setText(e1.getText() + e2.getText().toString()+op);
            e2.setText("");
        }
        else
        {
            String text=e1.getText().toString();
            if(text.length()>0)
            {
                String newText=text.substring(0,text.length()-1)+op;
                e1.setText(newText);
            }
        }
    }


}
