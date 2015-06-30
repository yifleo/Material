package com.github.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.Header;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedVignetteBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * 有关图片工具类
 *
 * @author Administrator
 */
public class ImageUtils {

    private static Bitmap createBitmap;
    public static String CACHEBITMAP = getSDPath() + "/gongyou/cache.png";

    /**
     * UIL展示控件图片
     *
     * @param uri       图片地址
     * @param imageView 控件
     * @param context
     */
    public static void displayImage(String uri, ImageView imageView,
                                    Context context) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                // .showImageOnLoading(R.drawable.ic_stub)//加载时显示
                // .showImageForEmptyUri(R.drawable.ic_empty)//没数据时显示
                // .showImageOnFail(R.drawable.ic_error)//加载失败时显示
                .resetViewBeforeLoading(true)
                        // 图片加载好后渐入的动画时间
                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();

        ImageLoader.getInstance().displayImage(uri, imageView, options);

    }

    /**
     * UIL展示控件图片
     *
     * @param uri       图片地址
     * @param imageView 控件
     * @param contxt
     */
    public static void displayImage(String uri, ImageView imageView,
                                    Context context, ImageLoadingListener imageLoadingListener) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                // .showImageOnLoading(R.drawable.ic_stub)//加载时显示
                // .showImageForEmptyUri(R.drawable.ic_empty)//没数据时显示
                // .showImageOnFail(R.drawable.ic_error)//加载失败时显示
                // 图片加载好后渐入的动画时间
                .cacheInMemory(true).displayer(new FadeInBitmapDisplayer(1000))
                .resetViewBeforeLoading(true).cacheOnDisk(true)
                .considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        ImageLoader.getInstance().displayImage(uri, imageView, options,
                imageLoadingListener);

    }

    /**
     * @param uri
     * @param imageLoadingListener
     */
    public static void loadImage(String uri,
                                 ImageLoadingListener imageLoadingListener) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                // .showImageOnLoading(R.drawable.ic_stub)//加载时显示
                // .showImageForEmptyUri(R.drawable.ic_empty)//没数据时显示
                // .showImageOnFail(R.drawable.ic_error)//加载失败时显示
                // 这个一定要设置，不设置的话会导致图片不能够铺满整个控件，这个是设置圆角效果的，如果大家不喜欢圆角可以设置为1几乎没有什么效果
                .displayer(new RoundedBitmapDisplayer(1))
                        // 图片加载好后渐入的动画时间
                .displayer(new SimpleBitmapDisplayer()).cacheInMemory(true)
                .cacheOnDisk(true).considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        ImageLoader.getInstance().loadImage(uri, options, imageLoadingListener);
    }

    /**
     * UIL加载图片，返回bitmap
     *
     * @param uri
     * @return
     */

    public static Bitmap loadImageSync(String uri) {

        return ImageLoader.getInstance().loadImageSync(uri);
    }

    // 获取sd路径
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();
        }
        return sdDir.getAbsolutePath();
    }


    /**
     * @param bitmap
     * @return
     */
    public static Bitmap scaleBitmap(Bitmap bitmap, Context context) {
        float originalHeight = bitmap.getHeight();
        float originalWidth = bitmap.getWidth();
        if (originalHeight > 300 || originalWidth > 300) {// 小于300不作处理

            if (originalHeight > originalWidth) {// 高度大于宽度， 高度设置300
                // ，宽度随着原始大小调整
                /*	System.out.println("高大于宽 处理前" + "------宽：" + originalWidth + "高："
                            + originalHeight);*/

                Matrix matrix = new Matrix();
                float newHeight = DisplayUtils.dp2px(context, 200);
                float newWidth = newHeight / (originalHeight / originalWidth);

                float scaleHeight = newHeight / originalHeight;
                float scaleWidth = newWidth / originalWidth;
                // 缩放图片动作
                matrix.postScale(scaleWidth, scaleHeight);

                Bitmap newBitmap = Bitmap
                        .createBitmap(bitmap, 0, 0, (int) originalWidth,
                                (int) originalHeight, matrix, true);

				/*	System.out.println("高大于宽 处理后" + "------宽：" + newBitmap.getWidth()
                            + "高：" + newBitmap.getHeight());*/
                return newBitmap;

            } else if (originalHeight < originalWidth) {// 宽度大于高度 ，宽度设置300
                // ，高度随着原始大小调整
                /*System.out.println("宽大于高 处理前" + "------宽：" + originalWidth + "高："
                        + originalHeight);*/

                Matrix matrix = new Matrix();

                float newWidth = DisplayUtils.dp2px(context, 200);
                float newHeight = newWidth / (originalWidth / originalHeight);

                float scaleHeight = newHeight / originalHeight;
                float scaleWidth = newWidth / originalWidth;
                // 缩放图片动作
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap newBitmap = Bitmap
                        .createBitmap(bitmap, 0, 0, (int) originalWidth,
                                (int) originalHeight, matrix, true);
                /*	System.out.println("宽大于高 处理后" + "------宽：" + newBitmap.getWidth()
                            + "高：" + newBitmap.getHeight());*/
                return newBitmap;
            } else {// 宽度和高度相等，都设置为300

                Matrix matrix = new Matrix();

                float newWidth = DisplayUtils.dp2px(context, 200);
                float newHeight = DisplayUtils.dp2px(context, 200);

                float scaleHeight = newHeight / originalHeight;
                float scaleWidth = newWidth / originalWidth;
                // 缩放图片动作
                matrix.postScale(scaleWidth, scaleHeight);
                Bitmap newBitmap = Bitmap
                        .createBitmap(bitmap, 0, 0, (int) originalWidth,
                                (int) originalHeight, matrix, true);
                return newBitmap;
            }
        } else {
            return bitmap;
        }
    }

}
