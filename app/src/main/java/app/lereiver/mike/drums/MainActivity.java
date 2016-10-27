package app.lereiver.mike.drums;

/**
 * An android app that creates a rudimentary drum machine. Offers language support for Italian and Japanese.
 *
 *@author Michael.LeReiver
 *@version 2016.02.19
 */


import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Sets content view and shows toast upon create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timedHideBar();
        Toast toast = Toast.makeText(this, "TAP THE BUTTONS TO PLAY THE DRUMS!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, 150);
        toast.show();
    }

    // Subclass for creating menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Subclass for creating menu items
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
    // Creates image view for image ids

    public void setDrum(View button) {
        int buttonId = button.getId();
        ImageView drum = (ImageView) findViewById(R.id.display_image);

        // Triggers drum sound when button clicked
        if(buttonId == R.id.kick_button) {
            MediaPlayer player = MediaPlayer.create(this, R.raw.kick);
            player.start();
            drum.setImageResource(R.drawable.kick);
        }


        // Triggers drum sound when button clicked
        if(buttonId == R.id.snare_button) {
            MediaPlayer player = MediaPlayer.create(this, R.raw.snare);
            player.start();
            drum.setImageResource(R.drawable.snare);
        }


        // Triggers drum sound when button clicked
        if(buttonId == R.id.hihat_open_button) {
            MediaPlayer player = MediaPlayer.create(this, R.raw.hihat_open);
            player.start();
            drum.setImageResource(R.drawable.hihat);
        }

        // Triggers drum sound when button clicked
        if(buttonId == R.id.crash_button) {
            MediaPlayer player = MediaPlayer.create(this, R.raw.crash);
            player.start();
            drum.setImageResource(R.drawable.crash);
        }


        // Triggers drum sound when button clicked
        if(buttonId == R.id.tom_button) {
            MediaPlayer player = MediaPlayer.create(this, R.raw.tom);
            player.start();
            drum.setImageResource(R.drawable.tom);
        }


        // Triggers drum sound when button clicked
        if(buttonId == R.id.hihat_closed_button) {
            MediaPlayer player = MediaPlayer.create(this, R.raw.hihat_closed);
            player.start();
            drum.setImageResource(R.drawable.hihat_closed);
        }
    }

    // Hides the action bar
    public void hideBar() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ActionBar bar = getSupportActionBar();
                bar.hide();
            }
        });

    }

    // Sets sleep time for action bar
    public void timedHideBar() {
        Thread timer = new Thread (new Runnable() {
            public void run() {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                hideBar();

            }
        });
        timer.start();
    }

    // Shows the action bar
    public void showBar(View image) {
        ActionBar bar = getSupportActionBar();
        bar.show();
        timedHideBar();

    }

    // Creates toast image
    public void showToast(View image) {
        Toast toast = Toast.makeText(this, "TAP THE BUTTONS TO PLAY THE DRUMS!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, 150);
        toast.show();
    }
}
