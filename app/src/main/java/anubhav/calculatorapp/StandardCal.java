package anubhav.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class StandardCal extends AppCompatActivity {

    EditText e1,e2;
    private int count=0;
    private String expression="";
    private int len=0;

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
                expression="";
                break;

            case R.id.backSpace:
                String text=e2.getText().toString();
                if(text.endsWith("."))
                {
                    count=0;
                }
                if(text.length()>0)
                {
                    String newText=text.substring(0,text.length()-1);
                    //if e2 edit text contains only sqr or root or - sign then clear the edit text e2
                    if(!(newText.contains("0") || newText.contains("1") || newText.contains("2")|| newText.contains("3")
                            || newText.contains("4")|| newText.contains("5")|| newText.contains("6")|| newText.contains("7")
                            || newText.contains("8")|| newText.contains("9")))
                    {
                        newText="";
                        expression=expression.substring(0,len);
                    }
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
                    text=e2.getText().toString();
                    len=expression.length();
                    expression+=Math.sqrt(Double.parseDouble(text));
                    e2.setText("√" + text);
                }
                break;

            case R.id.square:
                if(e2.length()!=0)
                {
                    text=e2.getText().toString();
                    len=expression.length();
                    expression+=Math.pow(Double.parseDouble(text), 2.0);
                    e2.setText("sqr"+text);
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
                /*for more knowledge on DoubleEvaluator and its tutorial got to the below link
                http://javaluator.sourceforge.net/en/home/*/
                text=e2.getText().toString();
                expression+=text;
                e1.setText("");
                DoubleEvaluator evaluator = new DoubleEvaluator();
                Double result = evaluator.evaluate(expression);
                e2.setText(result+"");
                break;
        }
    }

    private void operationClicked(String op)
    {
        if(e2.length()!=0)
        {
            String text=e2.getText().toString();
            e1.setText(e1.getText() + text+op);

            if(!(text.contains("sqr") || text.contains("√")))
            {
                expression+=text+op;
            }

            e2.setText("");
            count=0;
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
