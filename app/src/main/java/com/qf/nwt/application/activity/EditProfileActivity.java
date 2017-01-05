package com.qf.nwt.application.activity;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.qf.nwt.application.R;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back;
    private CircleImageView img_head;
    private static final int CHOOSE_PHOTO = 1;
    private static final int TAKE_PHOTO = 2;
    private String imgPath;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        findViewId();
        initListener();
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        img_back.setOnClickListener(this);
        img_head.setOnClickListener(this);
    }

    /**
     * 找id
     */
    private void findViewId() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_head = (CircleImageView) findViewById(R.id.img_head);

    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_head:
                changePortrait();
                break;
        }
    }

    /**
     * 修改头像
     */
    private void changePortrait() {
        //创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置相关属性
        builder.setTitle("修改头像");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("");
        //编写确认和取消的事件
        builder.setPositiveButton("打开相册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                startActivityForResult(intent, CHOOSE_PHOTO);//打开相册
            }
        });
        builder.setNegativeButton("打开相机", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //设置拍照的行为
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = getStorageFile();
                //设置多媒体的输出路径 ，参数2:MediaStore是Provider类提供，给出的地址必须是Uri,自己存储的是文件，所以文件和Uri转化
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    //判断手机系统版本号
                    if (Build.VERSION.SDK_INT >= 19) {
                        //4.4及以上系统使用这个方法处理图片
                        handleImageOnKitKat(data);
                    } else {
                        //4.4以下系统使用这个方法处理图片
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                   /* //原图
                    Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
                    img_head.setImageBitmap(bmp);
                    Log.e("=====","===原图的宽===="+bmp.getWidth());
                    Log.e("=====","===原图的高===="+bmp.getHeight());
                    Log.e("=====","===原图的占用的内存字节数===="+bmp.getByteCount());*/


                    //缩小之的图
                    Bitmap bmp1 = bmp2(file.getAbsolutePath(),0,0);
                    Log.e("=====","===缩小之后的图的宽===="+bmp1.getWidth());
                    Log.e("=====","===缩小之后的图的高===="+bmp1.getHeight());
                    Log.e("=====","===缩小之后的图的占用的内存字节数===="+bmp1.getByteCount());
                    img_head.setImageBitmap(bmp1);

                }
                break;
        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this,uri)) {
            //如果是document类型的Uri,则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];//解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                imagePath = getImagePath(contentUri,null);
            }else if ("content".equalsIgnoreCase(uri.getScheme())) {
                //如果不是document类型的Uri，则使用普通方式处理
                imagePath = getImagePath(uri,null);
            }
            displayImage(imagePath);//根据图片路径显示图片
        }
    }


    /**
     * 显示图片
     * @param imagePath
     */
    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            img_head.setImageBitmap(bitmap);
        }else {
            Toast.makeText(this,"打开相册失败",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获得图片路径
     * @param uri
     * @param selection
     * @return
     */
    private String getImagePath(Uri uri, String selection) {
        imgPath = null;
        //通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                imgPath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        Log.i("@@@","==="+ imgPath);
        return imgPath;
    }

    /**
     * 图片二次采样(缩小图片)
     *
     * @param imgPath:原图片地址
     * @param w:显示图片的宽度
     * @param h:显示图片的高度
     * @return :缩小之后的图片
     */
    public Bitmap bmp2(String imgPath, int w, int h) {
        //存储图片缩放的比例
        int sampleSize = 1;

        //1.准备工作，得到图片解码进行再次配置的类
        BitmapFactory.Options options = new BitmapFactory.Options();
        //2.第一次：只得到原图的宽和高,但是原图不加载到内存当中(只加载图片的边界区域)
        options.inJustDecodeBounds = true;
        //返回值为null(no bitmap)
        BitmapFactory.decodeFile(imgPath, options);
        //得到原图的外边缘的宽和高
        int w1 = options.outWidth;
        int h2 = options.outHeight;


        //2(3),4(5,6,7),8()

        //3.根据原图的宽和高以及给出显示的宽和高计算一个缩放比例
        //假设的条件(真实情况,以后根据公司自己需求指定条件限定)
        //if (w1 > 200) {
        //缩放为原图的1/2
        sampleSize = 8;
        // }

        //给options配置缩放比例
        options.inSampleSize = sampleSize;

        //4.第二次：根据缩放比例得到缩小之后的图片进行加载；
        //加载图的内容
        options.inJustDecodeBounds = false;
        Bitmap bmp1 = BitmapFactory.decodeFile(imgPath, options);
        return bmp1;
    }


    //创建存储图片的文件
    public File getStorageFile() {
        File imgPath = null;
        //判断sd卡存在
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File root = Environment.getExternalStorageDirectory();
            //创建目录
            File directory = new File(root, "myCamera");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            //创建文件
            imgPath = new File(directory, System.currentTimeMillis() + ".jpg");
        } else {
            //内部缓存目录
            //getCacheDir();
            Toast.makeText(this, "请检查sd卡是否挂载", Toast.LENGTH_LONG).show();
        }
        return imgPath;
    }
}
