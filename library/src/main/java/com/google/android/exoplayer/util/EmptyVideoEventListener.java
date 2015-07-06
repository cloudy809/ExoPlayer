package com.google.android.exoplayer.util;

import android.media.MediaCodec;
import android.view.Surface;

import com.google.android.exoplayer.MediaCodecTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;

/**
 */
public class EmptyVideoEventListener implements MediaCodecVideoTrackRenderer.EventListener {
    @Override
    public void onDroppedFrames(int count, long elapsed) {

    }

    @Override
    public void onVideoSizeChanged(int width, int height, float pixelWidthHeightRatio) {

    }

    @Override
    public void onDrawnToSurface(Surface surface) {

    }

    @Override
    public void onDecoderInitializationError(MediaCodecTrackRenderer.DecoderInitializationException e) {

    }

    @Override
    public void onCryptoError(MediaCodec.CryptoException e) {

    }

    @Override
    public void onDecoderInitialized(String decoderName, long elapsedRealtimeMs, long initializationDurationMs) {

    }
}
