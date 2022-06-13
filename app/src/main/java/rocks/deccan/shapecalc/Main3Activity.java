package rocks.deccan.shapecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    // TRIANGLE

    public void calculate(View view) {

        EditText baseText = findViewById(R.id.base);
        EditText side1Text = findViewById(R.id.side1);
        EditText side2Text = findViewById(R.id.side2);
        EditText heightText = findViewById(R.id.height);
        
        String b = baseText.getText().toString();
        String s1 = side1Text.getText().toString();
        String s2 = side2Text.getText().toString();
        String h = heightText.getText().toString();

        TextView incorrectSides = findViewById(R.id.incorrectSides);
        TextView incorrectHeight = findViewById(R.id.incorrectHeight);

        incorrectSides.setText("");
        incorrectHeight.setText("");

        if(baseText.getText().toString().matches("")) {
            b = "0";
        }
        if(side1Text.getText().toString().matches("")) {
            s1 = "0";
        }
        if(side2Text.getText().toString().matches("")) {
            s2 = "0";
        }
        if(heightText.getText().toString().matches("")) {
            h = "0";
        }

        double area = (Double.parseDouble(b) * Double.parseDouble(h)) / 2;
        double perimeter = Double.parseDouble(b) + Double.parseDouble(s1) + Double.parseDouble(s2);

        String stringArea = String.format("%.2f", area);
        String stringPerimeter = String.format("%.2f", perimeter);

        TextView calculation1 = findViewById(R.id.calculation1);
        TextView calculation2 = findViewById(R.id.calculation2);

        if(Integer.parseInt(b) + Integer.parseInt(s1) <= Integer.parseInt(s2)) {
            calculation2.setText("");
            incorrectSides.setText("Invalid triangle: base + side 1 must be > side 2");
        } else if(Integer.parseInt(s1) + Integer.parseInt(s2) <= Integer.parseInt(b)) {
            calculation2.setText("");
            incorrectSides.setText("Invalid triangle: side 1 + side 2 must be > base");
        } else if(Integer.parseInt(s2) + Integer.parseInt(b) <= Integer.parseInt(s1)) {
            calculation2.setText("");
            incorrectSides.setText("Invalid triangle: side 2 + base must be > side 1");
        } else {
            calculation2.setText(stringPerimeter);
        }

        if((!(heightText.getText().toString().matches("") || heightText.getText().toString().matches("0")) && !(side1Text.getText().toString().matches("") || side1Text.getText().toString().matches("0"))) || (!(heightText.getText().toString().matches("") || heightText.getText().toString().matches("0")) && !(side2Text.getText().toString().matches("") || side2Text.getText().toString().matches("0")))) {
            if(Integer.parseInt(h) > Integer.parseInt(s1) && Integer.parseInt(h) > Integer.parseInt(s2)) {
                calculation1.setText("");
                incorrectHeight.setText("Invalid triangle: height must be < or = side 1 and < or = side 2");
            }  else if(Integer.parseInt(h) > Integer.parseInt(s1)) {
                calculation1.setText("");
                incorrectHeight.setText("Invalid triangle: height must be < or = side 1");
            } else if (Integer.parseInt(h) > Integer.parseInt(s2)) {
                calculation1.setText("");
                incorrectHeight.setText("Invalid triangle: height must be < or = side 2");
            } else {
                calculation1.setText(stringArea);
            }
        } else {
            calculation1.setText(stringArea);
        }

        if(b.matches("0") || s1.matches("0") || s2.matches("0")) {
            perimeter = 0;
            String zeroPerimeter = String.format("%.2f", perimeter);
            incorrectSides.setText("");
            calculation2.setText(zeroPerimeter);
        }

        baseText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        side1Text.onEditorAction(EditorInfo.IME_ACTION_DONE);
        side2Text.onEditorAction(EditorInfo.IME_ACTION_DONE);
        heightText.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }

    public void clear(View view) {

        EditText baseText = findViewById(R.id.base);
        EditText side1Text = findViewById(R.id.side1);
        EditText side2Text = findViewById(R.id.side2);
        EditText heightText = findViewById(R.id.height);

        baseText.setText("");
        side1Text.setText("");
        side2Text.setText("");
        heightText.setText("");

        TextView calculation1 = findViewById(R.id.calculation1);
        TextView calculation2 = findViewById(R.id.calculation2);

        calculation1.setText("");
        calculation2.setText("");

        TextView incorrectSides = findViewById(R.id.incorrectSides);
        TextView incorrectHeight = findViewById(R.id.incorrectHeight);

        incorrectSides.setText("");
        incorrectHeight.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}
