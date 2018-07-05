package com.longforus.utils;

import android.app.Activity;

import java.util.LinkedList;

public class ActivityStack {
    private static final String TAG = "ActivityStack";
    private static LinkedList<Activity> activityStack;

    private static ActivityStack instance;

    private String tag = "";

    /**
     * <单例方法>
     * <功能详细描述>
     *
     * @return 该对象的实例
     * @see [类、类#方法、类#成员]
     */
    public static ActivityStack getInstance() {
        if (instance == null) {
            instance = new ActivityStack();
        }
        return instance;
    }

    /**
     * <将Activity入栈>
     * <功能详细描述>
     *
     * @see [类、类#方法、类#成员]
     */
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new LinkedList<>();
        }
        LogUtils.v(TAG,"push stack activity:" + activity.getClass().getSimpleName());
        activityStack.addLast(activity);
    }

    /**
     * 将制定activity从栈中移除
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            ActivityStack.activityStack.remove(activity);
        }
    }

    /**
     * <退出栈中所有Activity,当前的activity除外>
     * <功能详细描述>
     *
     * @see [类、类#方法、类#成员]
     */
    public void popAllActivityExceptMain(Class cls) {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }

            popActivity(activity);
        }
    }

    /**
     * <获取当前栈顶Activity>
     * <功能详细描述>
     *
     * @see [类、类#方法、类#成员]
     */
    public Activity currentActivity() {
        if (activityStack == null || activityStack.size() == 0) {
            return null;
        }
        Activity activity = activityStack.peekLast();

        LogUtils.v(TAG,"get current activity:" + activity.getClass().getSimpleName());
        return activity;
    }

    /**
     * <退出栈顶Activity>
     * <功能详细描述>
     *
     * @see [类、类#方法、类#成员]
     */
    public void popActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            LogUtils.v(TAG,"remove current activity:" + activity.getClass().getSimpleName());
            activityStack.remove(activity);
            activity = null;
        }
    }

    public void popAllActivity(String relogin) {
        instance.tag = relogin;
        popAllActivity();
    }

    public void popAllActivity() {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            popActivity(activity);
        }
    }

    public String getTag() {
        return tag;
    }

    /**
     * 如果栈顶是这个 class 就finish掉
     */
    public void popActivity(Class<? extends Activity> activityClass) {
        Activity activity = currentActivity();
        if (activity != null && activity.getClass().getName().equals(activityClass.getName())) {
            popActivity(activity);
        }
    }

    public void gotoActivity(Class<? extends Activity> aClass) {
        while (getSize() > 1 && currentActivity().getClass() != aClass) {
            popCurrentActivity();
        }
    }

    public int getSize() {
        if (activityStack != null) {
            return activityStack.size();
        } else {
            return 0;
        }
    }

    /**
     * <获取当前栈顶Activity>
     * <功能详细描述>
     *
     * @see [类、类#方法、类#成员]
     */
    public void popCurrentActivity() {
        popActivity(currentActivity());
    }

    /**
     * pop指导剩余的数量
     *
     * @param remainSize 栈中剩余的数量
     */
    public void popActivityRemain(int remainSize) {
        while (remainSize < getSize()) {
            popCurrentActivity();
        }
    }
}
