package rocks.deccan.shapecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.support.v7.app.ActionBar;

public class MainActivity extends AppCompatActivity {

    public void toRectangle(View view) {

        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);

    }

    public void toTriangle(View view) {

        Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
        startActivity(intent);

    }

    public void toCircle(View view) {

        Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
        startActivity(intent);

    }

    public void toRectangularPrism(View view) {

        Intent intent = new Intent(getApplicationContext(), Main5Activity.class);
        startActivity(intent);

    }

    public void toTriangularPrism(View view) {

        Intent intent = new Intent(getApplicationContext(), Main6Activity.class);
        startActivity(intent);

    }

    public void toSphere(View view) {

        Intent intent = new Intent(getApplicationContext(), Main7Activity.class);
        startActivity(intent);

    }

    public void toAbout(View view) {

        Intent intent = new Intent(getApplicationContext(), Main8Activity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
