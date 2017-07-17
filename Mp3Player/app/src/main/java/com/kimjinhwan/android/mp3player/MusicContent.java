package com.kimjinhwan.android.mp3player;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPS on 2017-06-22.
 */

public class MusicContent {

    static List<ConItem> conItemList = new ArrayList<>();

    public void setItem(Context context){

        Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        ContentResolver contentResolver = context.getContentResolver();

        String information[] = { MediaStore.Audio.Media._ID,
                                 MediaStore.Audio.Media.TITLE,
                                 MediaStore.Audio.Media.ARTIST,
                                 MediaStore.Audio.Media.ALBUM_ID };


        Cursor cursor = contentResolver.query(contentUri, information, null, null, null);



        if(cursor != null){
            while(cursor.moveToNext()){
            ConItem conItem = new ConItem();
                int index = cursor.getColumnIndex(information[0]);
                conItem.id = cursor.getString(index);

                int index1 = cursor.getColumnIndex(information[1]);
                conItem.title = cursor.getString(index1);

                int index2 = cursor.getColumnIndex(information[2]);
                conItem.artist = cursor.getString(index2);

                int index3 = cursor.getColumnIndex(information[3]);
                conItem.albumId = cursor.getString(index3);

                conItem.musicUri = makeMusicUri(conItem.albumId);


                conItemList.add(conItem);
            }
        }
        cursor.close();
    }




    public class ConItem {

        String id;
        String title;
        String artist;
        String albumArt;
        String albumId;

        Uri musicUri;



    }

    private Uri makeMusicUri (String albumId){
        Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        return Uri.withAppendedPath(contentUri, albumId);
    }

}
