package com.example.zhiweijin.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoader {
	// String mUrl;
	// ImageView mImageView;
	LruCache<String, Bitmap> mLruCache;

	public ImageLoader() {

		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		int cachesize = maxMemory / 4;
		mLruCache = new LruCache<String, Bitmap>(cachesize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {

				// 每次存入缓存的时候调用
				return value.getByteCount();
			}
		};
	}

	/**
	 * 异步加载图片
	 *  @param imageview
	 *
	 * @param url
	 */

	public  void addImageFromURl(ImageView imageview, String url) {
		// mUrl=url;
		// mImageView=imageview;
		Bitmap bitmap=getCechaFromUrl(url);
		if (bitmap == null) {
			new mImageAsync(imageview, url).execute(url);
		} else {
imageview.setImageBitmap(bitmap);
//imageview.setBackgroundDrawable(new BitmapDrawable(bitmap));
//			imageview.setBackground(new Bitmap);
		}

	}

	private Bitmap getCechaFromUrl(String url) {
		// TODO Auto-generated method stub
		return mLruCache.get(url);
	}

	private class mImageAsync extends AsyncTask<String, Void, Bitmap> {
		ImageView mImageView;
		String mUrl;

		public mImageAsync(ImageView image, String urlst) {
			mImageView = image;
			mUrl = urlst;
		}

		@Override
		protected Bitmap doInBackground(String... params) {
			Bitmap dobitmap;
			// if(params[0].equals(mUrl)){
			// bitmap=mLruCache.get(mUrl);
			// }else{
			dobitmap = getBitmapFromURL(params[0]);
			
			if(getCechaFromUrl(params[0])==null){
				
				addCecha(params[0], dobitmap);
			}
			// }
			return dobitmap;
		
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Log.e("TAG的值", "_____" + (String) mImageView.getTag());
			Log.e("Url的值", "_____" + mUrl);
			if (mImageView.getTag().equals(mUrl)) {
				mImageView.setImageBitmap(result);
			}

		}
	}

	private Bitmap getBitmapFromURL(String urlString) {
		Bitmap bitmap = null;
		InputStream is = null;

		try {
//			String str= URLEncoder.encode(urlString,"UTF-8");
//				URL url = new URL(str);
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			is = new BufferedInputStream(connection.getInputStream());
			bitmap = BitmapFactory.decodeStream(is);
			connection.disconnect();
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
			return bitmap;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void addCecha(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		if (getCechaFromUrl(url) == null) {

			mLruCache.put(url, bitmap);
		}
	}

}
