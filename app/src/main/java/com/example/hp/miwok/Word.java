package com.example.hp.miwok;

/**
 * Created by Hp on 8/29/2017.
 */

public class Word {
    String w1 = "";
    String w2 = "";
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    // private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String w1, String w2, int imageResourceId, int AudioResourceId) {
        this.w1 = w1;
        this.w2 = w2;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = AudioResourceId;

    }

    public Word(String w1, String w2, int AudioResourceId) {
        this.w1 = w1;
        this.w2 = w2;
        this.mAudioResourceId = AudioResourceId;

    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
