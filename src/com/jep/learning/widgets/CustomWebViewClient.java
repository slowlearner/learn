package com.jep.learning.widgets;

import com.jep.learning.VideoActivity;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public final class CustomWebViewClient extends WebViewClient{
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		Intent intent = new Intent();
		intent.setClass(view.getContext(), VideoActivity.class);
		intent.putExtra("video", url);
		view.getContext().startActivity(intent);
		return true;
	}
}
