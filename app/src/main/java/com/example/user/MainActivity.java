package com.example.user;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText id;
    private EditText password;
    private ImageView idimage;
    private ImageView passimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        id = findViewById(R.id.ed_id);
        password = findViewById(R.id.ed_password);
        idimage = findViewById(R.id.idresult);
        passimage = findViewById(R.id.passresult);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void enter(View view){
        int idd = Integer.parseInt(id.getText().toString());
        int pass = Integer.parseInt(password.getText().toString());
        idimage.setVisibility(View.VISIBLE);
        idimage.setAlpha(1.0f);
        passimage.setVisibility(View.VISIBLE);
        passimage.setAlpha(1.0f);
        if (idd < 100000 ){
            idimage.setImageResource(R.drawable.no);
            Toast.makeText(MainActivity.this, "ID more then 6 words",Toast.LENGTH_LONG).show();
        }else if(idd > 99999999){
            idimage.setImageResource(R.drawable.no);
            Toast.makeText(MainActivity.this, "ID less then 8 words",Toast.LENGTH_LONG).show();
        }else {
            idimage.setImageResource(R.drawable.ok);
        }
        if(pass < 10000000 ){
            passimage.setImageResource(R.drawable.no);
            Toast.makeText(MainActivity.this, "PASSWORD more then 8 words",Toast.LENGTH_LONG).show();
        }else if(pass >999999999){
            passimage.setImageResource(R.drawable.no);
            Toast.makeText(MainActivity.this, "PASSWORD less then 8 words",Toast.LENGTH_LONG).show();
        }else {
            passimage.setImageResource(R.drawable.ok);
        }
        if(idd>100000 && idd<999999999 && pass > 10000000 && pass <999999999){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("成功")
                    .setMessage("歡迎登入")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
