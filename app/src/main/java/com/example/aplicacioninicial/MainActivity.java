package com.example.aplicacioninicial;
import static java.lang.Float.parseFloat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txNumeros;
    TextView txResultado;

    Button bt0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;

    Button btSuma;
    Button btResta;
    Button btMultiplicar;
    Button btDividir;
    Button btCos;
    Button btSin;
    Button btTan;
    Button btDeg;
    Button btRad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txNumeros = (TextView) findViewById(R.id.txNumeros);
        txResultado = (TextView) findViewById(R.id.txResultado);

        bt0 = (Button) findViewById(R.id.bt0);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);

        btSuma = (Button) findViewById(R.id.btSuma);
        btResta = (Button) findViewById(R.id.btResta);
        btMultiplicar = (Button) findViewById(R.id.btMultiplicar);
        btDividir = (Button) findViewById(R.id.btDividir);
        btCos =  (Button) findViewById(R.id.btCos);
        btSin =  (Button) findViewById(R.id.btSin);
        btTan =  (Button) findViewById(R.id.btTan);
        btDeg =  (Button) findViewById(R.id.btDeg);
        btRad =  (Button) findViewById(R.id.btRad);
    }
    public void onClickNumeros(View view){
        if (txResultado.getText().length()!=0){
            txNumeros.setText(null);
            txResultado.setText(null);
        }

        if (view.getId()==(btSuma.getId()))
            txNumeros.setText(txNumeros.getText()+" + ");

        if (view.getId()==(btResta.getId()))
            txNumeros.setText(txNumeros.getText()+" - ");

        if (view.getId()==(btMultiplicar.getId()))
            txNumeros.setText(txNumeros.getText()+" x ");

        if (view.getId()==(btDividir.getId()))
            txNumeros.setText(txNumeros.getText()+" / ");

        if (view.getId()==(btCos.getId()))
            txNumeros.setText(txNumeros.getText()+" cos ");

        if (view.getId()==(btSin.getId()))
            txNumeros.setText(txNumeros.getText()+" sin ");

        if (view.getId()==(btTan.getId()))
            txNumeros.setText(txNumeros.getText()+" tan ");

        if (view.getId()==(btDeg.getId()))
            txNumeros.setText(txNumeros.getText()+" deg ");

        if (view.getId()==(btRad.getId()))
            txNumeros.setText(txNumeros.getText()+" rad ");

        if (view.getId()==(bt0.getId()))
            txNumeros.setText(txNumeros.getText()+"0");

        if (view.getId()==(bt1.getId()))
            txNumeros.setText(txNumeros.getText()+"1");

        if (view.getId()==(bt2.getId()))
            txNumeros.setText(txNumeros.getText()+"2");

        if (view.getId()==(bt3.getId()))
            txNumeros.setText(txNumeros.getText()+"3");

        if (view.getId()==(bt4.getId()))
            txNumeros.setText(txNumeros.getText()+"4");

        if (view.getId()==(bt5.getId()))
            txNumeros.setText(txNumeros.getText()+"5");

        if (view.getId()==(bt6.getId()))
            txNumeros.setText(txNumeros.getText()+"6");

        if (view.getId()==(bt7.getId()))
            txNumeros.setText(txNumeros.getText()+"7");

        if (view.getId()==(bt8.getId()))
            txNumeros.setText(txNumeros.getText()+"8");

        if (view.getId()==(bt9.getId()))
            txNumeros.setText(txNumeros.getText()+"9");

    }

    public void onClickTrigo(View view){
        if (txNumeros.getText().length()==0)
            onClickNumeros(view);
    }

    public void calcularTrigo(String[] values){
        double angle = parseFloat(values[2]);
        double result = 0.0;

        if (values[3].equals("deg"))
            angle = Math.toRadians(parseFloat(values[2]));

        switch (values[1]){
            case "cos":
                result = Math.cos(angle);
                break;

            case "sin":
                result = Math.sin(angle);
                break;

            case "tan":
                result = Math.tan(angle);
                break;
        }
        txResultado.setText("= "+Double.toString(result));

    }


    public void onClickResultado(View view){
        String[] values = txNumeros.getText().toString().split(" ");

        if (values[1].equals("sin")||values[1].equals("cos")||values[1].equals("tan")){
            calcularTrigo(values);
        }

        else {
            float result = parseFloat(values[0]);

            for (int i = 1; i < values.length; i++) {
                if (values[i].equals("+"))
                    result = result + parseFloat(values[i + 1]);

                if (values[i].equals("-"))
                    result = result - parseFloat(values[i + 1]);

                if (values[i].equals("x"))
                    result = result * parseFloat(values[i + 1]);

                if (values[i].equals("/")) {
                    if (parseFloat(values[i + 1]) == 0.0)
                        txResultado.setText("ERROR DIVISION");
                    else
                        result = result / parseFloat(values[i + 1]);
                }
            }

            txResultado.setText("= " + Float.toString(result));
        }

    }

    public void onClickOperacion(View view){
        if (txNumeros.getText().length()==0);
        else {
            String[] values = txNumeros.getText().toString().split(" ");
            int i = values.length - 1;

            if (values[i].equals("+") || values[i].equals("-") || values[i].equals("x") || values[i].equals("/"));
            else
                onClickNumeros(view);
        }
    }

    public void onClickClear(View view){
        txNumeros.setText(null);
        txResultado.setText(null);
    }

}