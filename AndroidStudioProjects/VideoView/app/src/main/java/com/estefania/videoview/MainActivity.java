package com.estefania.videoview;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends Activity {

    private VideoView mVideoView;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.surface_view);

        /*if(new File("/storage/extSdCard/video.mp4").exists()){
            Toast.makeText(this,"Exists", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"No Exists", Toast.LENGTH_LONG).show();
        }*/

        mVideoView.setVideoPath("/storage/extSdCard/video.mp4");
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();
        mVideoView.requestFocus();
    }

    //guardamos los datos
    @Override
    protected void onSaveInstanceState(Bundle guardarEstado){

        super.onSaveInstanceState(guardarEstado);
        pos = mVideoView.getCurrentPosition();
        guardarEstado.putInt("posicion",pos);
    }

    @Override
    protected void onRestoreInstanceState(Bundle recEstado){

        super.onRestoreInstanceState(recEstado);
        pos = recEstado.getInt("posicion");
        mVideoView.seekTo(pos);
    }

}
