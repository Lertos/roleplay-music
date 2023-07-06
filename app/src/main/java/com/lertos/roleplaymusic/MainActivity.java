package com.lertos.roleplaymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    private Slider sliderMusicVolume;
    private Slider sliderAmbientVolume;

    private Button btnBeginnerRoomAmbient;
    private Button btnHalfOrcRoomUpbeat;
    private Button btnGnomeRoomMagical;
    private Button btnGnomeRoomPanic;
    private Button btnHalfElfRoomAmbient;
    private Button btnHalfElfRoomCombat;
    private Button btnDragonbornRoomAmbient;
    private Button btnDragonbornRoomCombat;
    private Button btnHumanRoomAmbient;
    private Button btnHumanRoomPanic;
    private Button btnBossRoomAmbient;
    private Button btnBossRoomCombat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MediaManager.getInstance().start(this);

        setContentView(R.layout.activity_main);

        sliderMusicVolume = findViewById(R.id.sliderMusicVolume);
        sliderAmbientVolume = findViewById(R.id.sliderAmbientVolume);

        btnBeginnerRoomAmbient = findViewById(R.id.btnBeginnerRoomAmbient);
        btnHalfOrcRoomUpbeat = findViewById(R.id.btnHalfOrcRoomUpbeat);
        btnGnomeRoomMagical = findViewById(R.id.btnGnomeRoomMagical);
        btnGnomeRoomPanic = findViewById(R.id.btnGnomeRoomPanic);
        btnHalfElfRoomAmbient = findViewById(R.id.btnHalfElfRoomAmbient);
        btnHalfElfRoomCombat = findViewById(R.id.btnHalfElfRoomCombat);
        btnDragonbornRoomAmbient = findViewById(R.id.btnDragonbornRoomAmbient);
        btnDragonbornRoomCombat = findViewById(R.id.btnDragonbornRoomCombat);
        btnHumanRoomAmbient = findViewById(R.id.btnHumanRoomAmbient);
        btnHumanRoomPanic = findViewById(R.id.btnHumanRoomPanic);
        btnBossRoomAmbient = findViewById(R.id.btnBossRoomAmbient);
        btnBossRoomCombat = findViewById(R.id.btnBossRoomCombat);

        setSliderListeners();
        setButtonListeners();
    }

    private void setSliderListeners() {
        sliderMusicVolume.addOnChangeListener((slider, value, fromUser) -> MediaManager.getInstance().changeSongTrackVolume(value));
        sliderAmbientVolume.addOnChangeListener((slider, value, fromUser) -> MediaManager.getInstance().changeAmbientTrackVolume(value));
    }

    private void setButtonListeners() {
        btnBeginnerRoomAmbient.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.ambient_dripping, true));
        btnHalfOrcRoomUpbeat.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.half_orc_upbeat, true));
        btnGnomeRoomMagical.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.gnome_mysterious, true));
        btnGnomeRoomPanic.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.gnome_panic, true));
        btnHalfElfRoomAmbient.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.ambient_before_fight_1, true));
        btnHalfElfRoomCombat.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.half_elf_combat, true));
        btnDragonbornRoomAmbient.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.ambient_before_fight_2, true));
        btnDragonbornRoomCombat.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.dragonborn_combat, true));
        btnHumanRoomAmbient.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.ambient_before_fight_1, true));
        btnHumanRoomPanic.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.human_panic, true));
        btnBossRoomAmbient.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.ambient_before_fight_2, true));
        btnBossRoomCombat.setOnClickListener(event -> MediaManager.getInstance().playAmbientTrack(R.raw.boss_combat, true));
    }
}