package com.astudillo.test_navigation_drawer;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment
{
	final private String TAG = this.getClass().getName();
	private WebView wbvNavegador;

	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;


	public VideoFragment()
	{
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param nombre Parameter 1.
	 * @param apellido Parameter 2.
	 * @return A new instance of fragment VideoFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static VideoFragment newInstance(String nombre, String apellido)
	{
		VideoFragment fragment = new VideoFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, nombre);
		args.putString(ARG_PARAM2, apellido);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (getArguments() != null)
		{
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState)
	{
		View inflatedView = inflater.inflate(R.layout.fragment_video, container, false);

		wbvNavegador = (WebView) inflatedView.findViewById(R.id.wbvNavegador);

		wbvNavegador.getSettings().setJavaScriptEnabled(true);

		final ProgressDialog progreso = ProgressDialog.show(getContext() , "Webview", "Cargando ...");

		wbvNavegador.setWebViewClient(new WebViewClient()
		{
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				Log.i("WebView","Webview url click");
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url)
			{
				Log.i("WebView","Termino de cargar la URL");
				if(progreso.isShowing())
					progreso.dismiss();
			}
		});

		wbvNavegador.loadUrl("https://www.google.com");

		return inflatedView;
	}

}