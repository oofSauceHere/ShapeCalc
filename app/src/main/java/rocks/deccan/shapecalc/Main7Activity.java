package rocks.deccan.shapecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {

    // SPHERE

    public void calculate(View view) {

        EditText radiusText = findViewById(R.id.radius);

        String r = radiusText.getText().toString();

        if(radiusText.getText().toString().matches("")) {
            r = "0";
        }

        double volume = (4 * Math.PI * Double.parseDouble(r) * Double.parseDouble(r) * Double.parseDouble(r)) / 3;
        double surfaceArea = 4 * Double.parseDouble(r) * Double.parseDouble(r) * Math.PI;

        String stringVolume = String.format("%.2f", volume);
        String stringSurfaceArea = String.format("%.2f", surfaceArea);

        TextView calculation1 = (TextView) findViewById(R.id.calculation1);
        TextView calculation2 = (TextView) findViewById(R.id.calculation2);

        calculation1.setText(stringVolume);
        calculation2.setText(stringSurfaceArea);

        radiusText.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }

    public void clear(View view) {

        EditText radiusText = findViewById(R.id.radius);

        radiusText.setText("");

        TextView calculation1 = findViewById(R.id.calculation1);
        TextView calculation2 = findViewById(R.id.calculation2);

        calculation1.setText("");
        calculation2.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }
}
