package com.dogssoundsanddetails;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;


class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    List<Object> dogArrayList;
    //ArrayList<Models_Dog> images;
    //ArrayList<Models_Dog> dog_titles;
    Context context;
    //ArrayList<Models_Dog> sound_list;
    //ArrayList<Models_Dog> dog_detalis;
    private MediaPlayer mMediaPlayer;
    private static final int CONTENT_TYPE = 0;
    private static final int AD_TYPE = 1;
    private int[] viewTypes;



  /*  public RecyclerAdapter(Context context, ArrayList<Models_Dog> images, ArrayList<Models_Dog> dog_names,ArrayList<Models_Dog> dog_detalis,ArrayList<Models_Dog> sound_list) {
        this.context=context;
        this.images=images;
        this.dog_titles=dog_names;
        this.dog_detalis=dog_detalis;
        this.sound_list=sound_list;
    }*/

    public RecyclerAdapter(Context context , List<Object> dog_names_id) {
        this.context=context;
        this.dogArrayList=dog_names_id;

    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

                View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout,viewGroup,false);
                return new ImageViewHolder(view);



        }


    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {

        //final Models_Dog image_id=images.get(i);
     /*   final Models_Dog name_id=dog_titles.get(i);
        final Models_Dog modelsDog =images.get(i);
        final Models_Dog sounds_dog=sound_list.get(i);*/


             final Models_Dog models_dog = (Models_Dog) dogArrayList.get(i);


             imageViewHolder.dog_album.setImageResource(models_dog.getDog_photo_Id());

             imageViewHolder.dog_names.setText(models_dog.getDog_names_id());


             imageViewHolder.dog_album.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     //MediaPlayer
/*
              mMediaPlayer=MediaPlayer.create(context,models_dog.getSoundId());
              mMediaPlayer.start();*/


                     //code for new intent
                     Intent intent = new Intent(context, Detalis_Dog.class);

                     intent.putExtra("image_url", models_dog.getDog_photo_Id());
                     intent.putExtra("image_names", models_dog.getDog_names_id());
                     intent.putExtra("details", models_dog.getDog_details_id());
                     intent.putExtra("sound", models_dog.getSoundId());

                     context.startActivity(intent);
                 }
             });


    }

    @Override
    public int getItemCount() {

        return dogArrayList.size() ;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView dog_album;
        TextView dog_names;
         AdView mAdView;
        int HOLDER;
       // RelativeLayout parentLayout;




        public ImageViewHolder( View itemView) {
            super(itemView);

                dog_album = itemView.findViewById(R.id.dogs_album_id);
                dog_names = itemView.findViewById(R.id.dogs_title_id);

        }
    }

}
