package com.kimjinhwan.android.mediaplayer.domain;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by XPS on 2017-06-15.
 */

public class MusicLoader {
    private static MusicLoader instance = null;
    private Set<MusicItem> musicItems = null;   //Set은 중복타입을 걸러줌. List는 중복타입을 걸러주지 않음. 그러나 그냥 해주지는 않음.

    private MusicLoader() {
        musicItems = new HashSet<>();
    }

    public static MusicLoader getInstance(){
        if(instance == null)
            instance = new MusicLoader();
        return instance;
    }

    public Set<MusicItem> getMusicItems() {
        return musicItems;  //로더를 통해서 데이터를 모두 담은 후 데이터가 꺼내지면 getItems함수를 통해 생성된 데이터를 그대로 가져다 쓸 수 있다.
    }

    public void getMusic(Context context) {
        musicItems.clear(); //<-데이터가 계속 쌓이는 것을 방지한다. 그러나 이짓을 계속했다간... 리소스가 남아나지 않겠지...

        ContentResolver contentResolver = context.getContentResolver();
        //음악데이터를 가져오기 위해 쿼리를 날려봅니다.

        //1. 테이블 명을 정의함.
        Uri Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;


        //2. 가져올 컬럼명을 정의함.
        String content[] = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ALBUM_ID,    //앨범아트 조회
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST
        };
        //3. 쿼리
        Cursor cursor = contentResolver.query(Uri, content, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                MusicItem item = new MusicItem();
                item.id = getValue(cursor, content[0]);
                item.albumId = getValue(cursor, content[1]);
                item.title = getValue(cursor, content[2]);
                item.artist = getValue(cursor, content[3]);
                //꺼내온건 완료이나, 아직 담지는 않은 상태이므로 담아둘 저장소를 만든다.

                item.musicUri = makeMusicUri(item.id);
                item.albumCover = makeAlbumUri(item.albumId);

                musicItems.add(item);
            }

        }
    }

    private String getValue(Cursor cursor, String str){
        int index = cursor.getColumnIndex(str);
        return cursor.getString(index);
    }


    public class MusicItem {
        public String id;
        public String albumId;
        public String title;
        public String artist;


        Uri musicUri;
        Uri albumCover;

         }

        //Set이 정상적으로 중복값을 허용하지 않도록 어떤 함수를 오버라이드 해서 구현하세요!

        private Uri makeAlbumUri(String albumId) {
        String albumUri = "content://media/external/audio/albumart/";
        return Uri.parse(albumUri + albumId);
        }



        private Uri makeMusicUri(String musicId) {
            Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            return Uri.withAppendedPath(contentUri, musicId);

        }



    }

