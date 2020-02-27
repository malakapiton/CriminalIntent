package com.bignerdranch.android.criminalintent.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bignerdranch.android.criminalintent.util.PictureUtils;
import com.bignerdranch.android.criminalintent.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PhotoFragment extends DialogFragment {

    private static final String ARG_PHOTO = "photo";

    private ImageView mPhotoView;

    public static PhotoFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, path);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);
        String photoPath = (String) getArguments().getSerializable(ARG_PHOTO);

        mPhotoView = v.findViewById(R.id.big_crime_photo);

        if (photoPath != null) {
            Bitmap bitmap = PictureUtils.getScaledBitmap(photoPath, getActivity());
            mPhotoView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(getActivity(), "You need to create photo", Toast.LENGTH_SHORT).show();
        }

        return new AlertDialog.Builder(getActivity())
                .setTitle("Full size photo:")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setView(v)
                .create();
    }
}
