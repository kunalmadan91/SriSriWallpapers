package com.madan.kunal.srisriwallpapers;

import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.FileDescriptor;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

/**
 * A placeholder fragment containing a simple view.
 */
public class WallpaperActivityFragment extends Fragment  {
    //private AdView mAdView;
    private AdView mAdView;
    final int PIC_CROP = 1;
    View rootView;
    public WallpaperActivityFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         rootView = inflater.inflate(R.layout.fragment_wallpaper, container, false);

        ImageView view = (ImageView) rootView.findViewById(R.id.detail_wallpaper);

        Intent intent = getActivity().getIntent();

        getActivity().setTitle("With Love Sri Sri");
        final int id = intent.getIntExtra("KEY",R.drawable.img);

        final Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + getResources().getResourcePackageName(id)
                + '/' + getResources().getResourceTypeName(id) + '/' + getResources().getResourceEntryName(id) );


        Glide.with(getActivity()).load(id).into(view);

        Button button = (Button) rootView.findViewById(R.id.setwall);

       // Bitmap cropped = cropImageView.getCroppedImage();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCrop(imageUri);

            }

        });

        RelativeLayout adViewContainer = (RelativeLayout) rootView.findViewById(R.id.adViewContainer);

        /*adView = new AdView(getActivity(), "326817451028391_326871724356297", AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();*/
        mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        return rootView;
    }

    private void performCrop(Uri picUri) {
        CropImage.activity(picUri)
                .start(getContext(), this);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getActivity());
                Uri resultUri = result.getUri();

                try {
                    ParcelFileDescriptor parcelFileDescriptor =
                            getActivity().getContentResolver().openFileDescriptor(resultUri, "r");
                    FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                    Bitmap imageb = BitmapFactory.decodeFileDescriptor(fileDescriptor);

                    myWallpaperManager.setBitmap(imageb);
                    Snackbar.make(rootView, "Your Wallpaper has been changed successfully!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    //System.out.println("bitmap "+imageb);
                    parcelFileDescriptor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


}
