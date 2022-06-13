package rocks.deccan.shapecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    // RECTANGULAR PRISM

    public void calculate(View view) {

        EditText lengthText = findViewById(R.id.length);
        EditText widthText = findViewById(R.id.width);
        EditText heightText = findViewById(R.id.height);

        String l = lengthText.getText().toString();
        String w = widthText.getText().toString();
        String h = heightText.getText().toString();

        if(lengthText.getText().toString().matches("")) {
            l = "0";
        }
        if(widthText.getText().toString().matches("")) {
            w = "0";
        }
        if(heightText.getText().toString().matches("")) {
            h = "0";
        }

        double volume = Double.parseDouble(l) * Double.parseDouble(w) * Double.parseDouble(h);
        double surfaceArea = 2 * ((Double.parseDouble(l) * Double.parseDouble(w)) + (Double.parseDouble(w) * Double.parseDouble(h)) + (Double.parseDouble(h) * Double.parseDouble(l)));

        if(w.matches("0") || l.matches("0") || h.matches("0")) {
            surfaceArea = 0;
        } else {

        }

        String stringVolume = String.format("%.2f", volume);
        String stringSurfaceArea = String.format("%.2f", surfaceArea);

        TextView calculation1 = (TextView) findViewById(R.id.calculation1);
        TextView calculation2 = (TextView) findViewById(R.id.calculation2);

        calculation1.setText(stringVolume);
        calculation2.setText(stringSurfaceArea);

        lengthText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        widthText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        heightText.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }

    public void clear(View view) {

        EditText lengthText = findViewById(R.id.length);
        EditText widthText = findViewById(R.id.width);
        EditText heightText = findViewById(R.id.height);

        lengthText.setText("");
        widthText.setText("");
        heightText.setText("");

        TextView calculation1 = findViewById(R.id.calculation1);
        TextView calculation2 = findViewById(R.id.calculation2);

        calculation1.setText("");
        calculation2.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
}
