package com.intel.deferredgles;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import android.content.res.AssetManager;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class DeferredGLES extends Activity
{
    private AssetManager _asset_manager;
    private GLSurfaceView _view;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _view = new GLSurfaceView(this);
        _view.setEGLContextClientVersion(2);
        _view.setRenderer(new Renderer());
        setContentView(_view);

        /* Load asset manager */
        _asset_manager = getAssets();
        JNIWrapper.init_asset_manager(_asset_manager);
    }

    @Override protected void onPause()
    {
        super.onPause();
        _view.onPause();
    }

    @Override protected void onResume()
    {
        super.onResume();
        _view.onResume();
    }

    /** Renderer interface
     */
    private static class Renderer implements GLSurfaceView.Renderer
    {
        public void onSurfaceCreated(GL10 gl, EGLConfig config)
        {
        }
        public void onSurfaceChanged(GL10 gl, int width, int height)
        {
            JNIWrapper.init(width, height);
        }
        public void onDrawFrame(GL10 gl)
        {
            JNIWrapper.frame();
        }
    }
}
