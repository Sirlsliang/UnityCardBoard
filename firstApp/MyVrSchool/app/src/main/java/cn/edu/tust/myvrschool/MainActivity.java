package cn.edu.tust.myvrschool;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set up listeners for all the buttons
        View continueButton = findViewById(R.id.about_button);
        continueButton.setOnClickListener(this);
        View newButton  = findViewById(R.id.new_game_button);
        newButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.settings:
                startActivity(new Intent(this,Prefs.class));
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.about_button:
                Intent i = new Intent(this,About.class);
                startActivity(i);
                break;
            case R.id.new_game_button:
                openNewGameDialog();
                break;
            case R.id.exit_button:
                finish();
                break;
        }
    }

    private void openNewGameDialog(){
        new AlertDialog.Builder(this).setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startGame(i);
                            }
                        }).show();
    }
    private static final String TAG="Sudoku";
    private void startGame(int i){
        Log.d(TAG,"click on "+i);

    }
}
