package com.google.android.exoplayer;

public class NoTimeMediaCodecAudioTrackRenderer extends MediaCodecAudioTrackRenderer {

    public NoTimeMediaCodecAudioTrackRenderer(SampleSource source) {
        super(source);
    }

    @Override
    protected boolean isTimeSource() {
        return false;
    }
}
