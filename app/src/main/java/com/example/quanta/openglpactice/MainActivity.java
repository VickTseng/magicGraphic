package com.example.quanta.openglpactice;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/* To specify to GLSurface field range*/
enum surfaceType {
    FULL_SCERRN,
    PARTIAL_SRUFACE
}

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurface;
    surfaceType surfacetype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(surfacetype.PARTIAL_SRUFACE);
    }

    /**
     * Remember to resume the glSurface
     */
    @Override
    protected void onResume() {
        super.onResume();
        glSurface.onResume();
    }

    /**
     * Also pause the glSurface
     */
    @Override
    protected void onPause() {
        super.onPause();
        glSurface.onPause();
    }

    private void initView(surfaceType surType){
        switch(surType){
            case FULL_SCERRN:
                glSurface = new GLSurfaceView(this);
                glSurface.setRenderer(new GLRender());
                setContentView(glSurface);
                break;
            case PARTIAL_SRUFACE:
                setContentView(R.layout.activity_main);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                glSurface = (GLSurfaceView) findViewById(R.id.surfaceView);
                glSurface.setRenderer(new GLRender());
                break;
        }
    }
}
