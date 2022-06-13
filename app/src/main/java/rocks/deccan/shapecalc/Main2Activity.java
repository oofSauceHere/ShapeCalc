package rocks.deccan.shapecalc;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.inputmethod.*;

public class Main2Activity extends AppCompatActivity {

    // RECTANGLE

    public void calculate(View view) {

        EditText lengthText = findViewById(R.id.length);
        EditText widthText = findViewById(R.id.width);

        String l = lengthText.getText().toString();
        String w = widthText.getText().toString();

        if(lengthText.getText().toString().matches("")) {
            l = "0";
        }
        if(widthText.getText().toString().matches("")) {
            w = "0";
        }

        double area = Double.parseDouble(l) * Double.parseDouble(w);
        double perimeter = 2 * (Double.parseDouble(l) + Double.parseDouble(w));

        if(w.matches("0") || l.matches("0")) {
            perimeter = 0;
        } else {

        }

        String stringArea = String.format("%.2f", area);
        String stringPerimeter = String.format("%.2f", perimeter);

        TextView calculation1 = findViewById(R.id.calculation1);
        TextView calculation2 = findViewById(R.id.calculation2);

        calculation1.setText(stringArea);
        calculation2.setText(stringPerimeter);

        lengthText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        widthText.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }
    
    public void clear(View view) {

        EditText lengthText = findViewById(R.id.length);
        EditText widthText = findViewById(R.id.width);

        lengthText.setText("");
        widthText.setText("");

        TextView calculation1 = findViewById(R.id.calculation1);
        TextView calculation2 = findViewById(R.id.calculation2);

        calculation1.setText("");
        calculation2.setText("");
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
}
