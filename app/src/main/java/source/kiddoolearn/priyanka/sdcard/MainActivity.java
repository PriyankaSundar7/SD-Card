package source.kiddoolearn.priyanka.sdcard;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
EditText e1;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    File root = Environment.getExternalStorageDirectory();
                    File directory = new File(root.getAbsolutePath() + "/prink");
                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    File f = new File(directory, "mydoc.txt");
                    String data = e1.getText().toString();
                    try {
                        FileOutputStream fo = new FileOutputStream(f);
                        fo.write(data.getBytes());

                        fo.flush();
                        fo.close();
                        Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "FILE NOT FOUND", Toast.LENGTH_SHORT).show();

                }

            }
            });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e1.requestFocus();
            }
        });
    }
}
