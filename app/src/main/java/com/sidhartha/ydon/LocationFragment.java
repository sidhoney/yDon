package com.sidhartha.ydon;

import com.sidhartha.ydon.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LocationFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_location, container, false);
		WebView mainWebView = (WebView) rootView.findViewById(R.id.mainWebView);

        WebSettings webSettings = mainWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
        mainWebView.setWebViewClient(new MyCustomWebViewClient());
        mainWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mainWebView.loadUrl("http://www.google.ca/maps/place/Lambton+College/@42.9757498,-82.3475311,16z/data=!3m1!4b1!4m2!3m1!1s0x8825830ada06f7cb:0x8f33c2e6a2ccfad1");
		
		return rootView;
	}
	

	
	private class MyCustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
	}
}
