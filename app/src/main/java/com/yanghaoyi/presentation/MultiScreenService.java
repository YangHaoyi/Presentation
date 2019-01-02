package com.yanghaoyi.presentation;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.WindowManager;

import com.yanghaoyi.presentation.view.presentation.SearchPresentation;

/**
 * @author : YangHaoYi on 2019/1/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2019/1/2.
 *         Version : V 1.0
 */
public class MultiScreenService extends Service{

    /**  屏幕管理器 **/
    private DisplayManager mDisplayManager;
    /**  屏幕数组 **/
    private Display[] displays;
    /**  第二块屏 **/
    private SearchPresentation presentation;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MultiScreenBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initPresentation();
    }

    private void initPresentation(){
        if(null==presentation){
            mDisplayManager = (DisplayManager) this.getSystemService(Context.DISPLAY_SERVICE);
            displays = mDisplayManager.getDisplays();
            if(displays.length > 1){
                // displays[1]是副屏
                presentation = new SearchPresentation(this, displays[1]);
                presentation.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

            }
        }
    }

    public void showSearchPresentation(){
        presentation.show();
    }


    public class MultiScreenBinder extends Binder{
        public MultiScreenService getService(){
            return MultiScreenService.this;
        }
    }

}
