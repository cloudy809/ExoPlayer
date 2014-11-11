package com.google.android.exoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/**
 */
public class VideoTextureView extends TextureView {
    /**
     * The surface view will not resize itself if the fractional difference between its default
     * aspect ratio and the aspect ratio of the video falls below this threshold.
     * <p/>
     * This tolerance is useful for fullscreen playbacks, since it ensures that the surface will
     * occupy the whole of the screen when playing content that has the same (or virtually the same)
     * aspect ratio as the device. This typically reduces the number of view layers that need to be
     * composited by the underlying system, which can help to reduce power consumption.
     */
    private static final float MAX_ASPECT_RATIO_DEFORMATION_PERCENT = 0.01f;

    private float videoAspectRatio;

    public VideoTextureView(Context context) {
        super(context);
    }

    public VideoTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Set the aspect ratio that this {@link VideoTextureView} should satisfy.
     *
     * @param widthHeightRatio The width to height ratio.
     */
    public void setVideoWidthHeightRatio(float widthHeightRatio) {
        if (this.videoAspectRatio != widthHeightRatio) {
            this.videoAspectRatio = widthHeightRatio;
            requestLayout();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (videoAspectRatio != 0) {
            float viewAspectRatio = (float) width / height;
            float aspectDeformation = videoAspectRatio / viewAspectRatio - 1;
            if (aspectDeformation > MAX_ASPECT_RATIO_DEFORMATION_PERCENT) {
                height = (int) (width / videoAspectRatio);
            } else if (aspectDeformation < -MAX_ASPECT_RATIO_DEFORMATION_PERCENT) {
                width = (int) (height * videoAspectRatio);
            }
        }
        setMeasuredDimension(width, height);
    }
}
