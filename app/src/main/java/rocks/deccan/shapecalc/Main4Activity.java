package rocks.deccan.shapecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    // CIRCLE

    public void calculate(View view) {

        EditText radiusText = findViewById(R.id.radius);
        
        String r = radiusText.getText().toString();

        if(radiusText.getText().toString().matches("")) {
            r = "0";
        }

        double area = Double.parseDouble(r) * Double.parseDouble(r) * Math.PI;
        double circumference = 2 * Double.parseDouble(r) * Math.PI;

        String stringArea = String.format("%.2f", area);
        String stringCircumference = String.format("%.2f", circumference);

        TextView calculation1 = findViewById(R.id.calculation1);
        TextView calculation2 = findViewById(R.id.calculation2);

        calculation1.setText(stringArea);
        calculation2.setText(stringCircumference);

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
        setContentView(R.layout.activity_main4);
    }
}
