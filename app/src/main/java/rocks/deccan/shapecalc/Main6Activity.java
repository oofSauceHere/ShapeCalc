package rocks.deccan.shapecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    // TRIANGULAR PRISM

    public void calculate(View view) {

        EditText baseText = findViewById(R.id.base);
        EditText side1Text = findViewById(R.id.side1);
        EditText side2Text = findViewById(R.id.side2);
        EditText heightText = findViewById(R.id.height);
        EditText lengthText = findViewById(R.id.length);
        
        String b = baseText.getText().toString();
        String s1 = side1Text.getText().toString();
        String s2 = side2Text.getText().toString();
        String h = heightText.getText().toString();
        String l = lengthText.getText().toString();

        TextView incorrectSides = (TextView) findViewById(R.id.incorrectSides);
        TextView incorrectHeight = (TextView) findViewById(R.id.incorrectHeight);

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
        if(lengthText.getText().toString().matches("")) {
            l = "0";
        }

        double Volume = (Double.parseDouble(b) * Double.parseDouble(h) / 2) * Double.parseDouble(l);
        double SurfaceArea = (Double.parseDouble(b) * Double.parseDouble(h)) + (Double.parseDouble(s1) * Double.parseDouble(s2)) + (Double.parseDouble(s2) * Double.parseDouble(b)) + (Double.parseDouble(b) * Double.parseDouble(s1));

        String stringVolume = String.format("%.2f", Volume);
        String stringSurfaceArea = String.format("%.2f", SurfaceArea);

        TextView calculation1 = (TextView) findViewById(R.id.calculation1);
        TextView calculation2 = (TextView) findViewById(R.id.calculation2);

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
            calculation2.setText(stringSurfaceArea);
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
                calculation1.setText(stringVolume);
            }
        } else {
            calculation1.setText(stringVolume);
        }

        if(b.matches("0") || s1.matches("0") || s2.matches("0") || l.matches("0")) {
            SurfaceArea = 0;
            Volume = 0;
            String zeroSurfaceArea = String.format("%.2f", SurfaceArea);
            incorrectSides.setText("");
            calculation2.setText(zeroSurfaceArea);
        }

        baseText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        side1Text.onEditorAction(EditorInfo.IME_ACTION_DONE);
        side2Text.onEditorAction(EditorInfo.IME_ACTION_DONE);
        heightText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        lengthText.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }

    public void clear(View view) {

        EditText baseText = findViewById(R.id.base);
        EditText side1Text = findViewById(R.id.side1);
        EditText side2Text = findViewById(R.id.side2);
        EditText heightText = findViewById(R.id.height);
        EditText lengthText = findViewById(R.id.length);

        baseText.setText("");
        side1Text.setText("");
        side2Text.setText("");
        heightText.setText("");
        lengthText.setText("");

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
        setContentView(R.layout.activity_main6);
    }
}