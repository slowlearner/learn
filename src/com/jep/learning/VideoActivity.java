package com.jep.learning;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		VideoView video = (VideoView) findViewById(R.id.videoView1);
		String uripath = "android.resource://"+ getPackageName()+ "/raw/" + getIntent().getStringExtra("video");
		
		Log.e("app", "path " + uripath);
		Uri uri = Uri.parse(uripath);
		
		MediaController controller = new MediaController(this);
		video.setMediaController(controller);
		video.setVideoURI(uri);
		video.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video, menu);
		return true;
	}

}
