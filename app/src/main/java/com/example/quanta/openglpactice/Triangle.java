package com.example.quanta.openglpactice;
import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * This class is an object representation of
 * a Triangle containing the vertex information
 * and drawing functionality, which is called
 * by the renderer.
 *
 * @author Savas Ziplies (nea/INsanityDesign)
 */
public class Triangle {

    /** The buffer holding the vertices */
    private FloatBuffer vertexBuffer;

    /** The initial vertex definition */
    private float vertices[] = {
            0.0f, 1.0f, 0.0f, 	//Top
            -1.0f, -1.0f, 0.0f, //Bottom Left
            1.0f, -1.0f, 0.0f 	//Bottom Right
    };

    /*float vertices[] = {
            // X, Y, Z
            -0.5f, -0.25f, 0,
            0.5f, -0.25f, 0,
            0.0f,  0.559016994f, 0
    };*/

    public Triangle() {
        ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuf.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void draw(GL10 gl) {
        //重畫背景顏色
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);// 設成GL_MODELVIEW轉換模式
        gl.glLoadIdentity(); //重置成I矩陣
        //當使用GL_MODELVIEW，必須設置視點(view point
        GLU.gluLookAt(gl, 0, 0, -5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        //旋轉mAngle
        gl.glRotatef(0, 0.0f, 0.0f, 1.0f);
        //畫三角形
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
    }
}
