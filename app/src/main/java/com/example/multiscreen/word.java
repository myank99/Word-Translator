package com.example.multiscreen;

import android.graphics.drawable.Drawable;

public class word {
    private String mDefaultTranslation;//default traslation of word
    private String mHindiTranslation;//hindi translation of word
    private int mImageResourceId;
    private int mAudioId;
    public word(String defaultTranslation , String hindiTranslation,int audioId)
    {
        mDefaultTranslation = defaultTranslation;
        mHindiTranslation = hindiTranslation;
        mAudioId= audioId;

    }
    public word(String defaultTranslation , String hindiTranslation,int imageResourceId,int audioId)
    {
        mDefaultTranslation = defaultTranslation;
        mHindiTranslation = hindiTranslation;
        mImageResourceId = imageResourceId;
        mAudioId= audioId;
    }

    public String getDefaultTranslation(){//get default translation of word
        return mDefaultTranslation;
    }
    public String getHindiTranslation(){//get hindi translation of word
        return mHindiTranslation;
    }

    public int getImageResourceId(){return mImageResourceId;}
    public int getmAudioId(){return mAudioId;}
    
}
