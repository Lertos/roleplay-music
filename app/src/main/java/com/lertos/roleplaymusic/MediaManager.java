package com.lertos.roleplaymusic;

import android.content.Context;
import android.media.MediaPlayer;

public class MediaManager {

    private static MediaManager instance;
    private Context context;
    private MediaPlayer trackAmbient;
    private MediaPlayer trackSong;
    private float trackAmbientVolume;
    private float trackSongVolume;

    private MediaManager() {
    }

    public static MediaManager getInstance() {
        if (instance == null) {
            instance = new MediaManager();
        }
        return instance;
    }

    public void start(Context context) {
        this.context = context;
        this.trackAmbient = new MediaPlayer();
        this.trackSong = new MediaPlayer();

        this.trackAmbientVolume = 0.5f;
        this.trackSongVolume = 0.5f;
    }

    private void resetAmbientTrack() {
        if (trackAmbient == null)
            return;

        if (trackAmbient.isPlaying())
            trackAmbient.stop();

        trackAmbient.release();
        trackAmbient = null;
    }

    public void stopAmbient() {
        resetAmbientTrack();
    }

    public void pauseAmbient() {
        if (trackAmbient != null)
            trackAmbient.pause();
    }

    public void startAmbient() {
        if (trackAmbient != null) {
            if (!trackAmbient.isPlaying())
                trackAmbient.start();
        }
    }

    public void playAmbientTrack(int resId, boolean loopAmbient) {
        if (trackAmbient != null)
            resetAmbientTrack();

        trackAmbient = MediaPlayer.create(this.context, resId);

        trackAmbient.setVolume(trackAmbientVolume, trackAmbientVolume);
        trackAmbient.start();

        if (loopAmbient)
            trackAmbient.setLooping(true);
    }

    private void resetSongTrack() {
        if (trackSong == null)
            return;

        if (trackSong.isPlaying())
            trackSong.stop();

        trackSong.release();
        trackSong = null;
    }

    public void stopSong() {
        resetSongTrack();
    }

    public void pauseSong() {
        if (trackSong != null)
            trackSong.pause();
    }

    public void startSong() {
        if (trackSong != null) {
            if (!trackSong.isPlaying())
                trackSong.start();
        }
    }

    public void playSongTrack(int resId, boolean loopSong) {
        if (trackSong != null)
            resetSongTrack();

        trackSong = MediaPlayer.create(this.context, resId);

        trackSong.setVolume(trackSongVolume, trackSongVolume);
        trackSong.start();

        if (loopSong)
            trackSong.setLooping(true);
    }

    public void changeAmbientTrackVolume(float volume) {
        trackAmbientVolume = volume;
        trackAmbient.setVolume(volume, volume);
    }

    public void changeSongTrackVolume(float volume) {
        trackSongVolume = volume;
        trackSong.setVolume(volume, volume);
    }
}
