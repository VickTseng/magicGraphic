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

public class MainActivity extends Activity {

    private GLSurfaceView glSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        glSurface = new GLSurfaceView(this);
        glSurface.setRenderer(new GLRender());

        setContentView(glSurface);
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

}
