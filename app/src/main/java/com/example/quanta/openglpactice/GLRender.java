package com.example.quanta.openglpactice;
import android.opengl.GLSurfaceView;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by vick on 2016/5/5.
 */
public class GLRender implements GLSurfaceView.Renderer {
    private Triangle triangle;

    public GLRender(){
        triangle = new Triangle();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //Set the background color
        gl.glClearColor(0.0f, 0.6f, 0.0f, 1.0f);
        //Using point array
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        float ratio = (float)width/height; //set the ratio of the screen
        gl.glMatrixMode(GL10.GL_PROJECTION);//設成投影模式
        gl.glLoadIdentity(); //重置成I矩陣
        gl.glFrustumf(-ratio, ratio, -1, 1, 3, 7);//使用此投影矩陣
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        triangle.draw(gl);
    }
}
