package com.pinger.widget.imagepreview;

import android.content.Context;
import android.graphics.Rect;
import android.widget.ImageView;

import com.pinger.widget.R;

import java.io.Serializable;
import java.util.List;

public abstract class ImagePreviewAdapter implements Serializable {

    protected Context context;
    private List<ImageEntity> imageEntities;

    public ImagePreviewAdapter(Context context, List<ImageEntity> imageEntities) {
        this.context = context;
        this.imageEntities = imageEntities;
    }

    /**
     * 如果要实现图片点击的逻辑，重写此方法即可
     *  @param context      上下文
     * @param nineGridView 九宫格控件
     * @param index        当前点击图片的的索引
     * @param imageInfo    图片地址的数据集合
     * @param imageRects
     */
    protected void onImageItemClick(Context context, ImagePreview nineGridView, int index, List<ImageEntity> imageInfo, List<Rect> imageRects) {
    }

    /**
     * 生成ImageView容器的方式，默认使用NineGridImageViewWrapper类，即点击图片后，图片会有蒙板效果
     * 如果需要自定义图片展示效果，重写此方法即可
     *
     * @param context 上下文
     * @return 生成的 ImageView
     */
    protected ImageView generateImageView(Context context) {
        ImagePreviewWrapper imageView = new ImagePreviewWrapper(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ic_default_color);
        return imageView;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }
}