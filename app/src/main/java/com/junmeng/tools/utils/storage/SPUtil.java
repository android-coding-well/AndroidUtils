package com.junmeng.tools.utils.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

/**
 * Created by HWJ on 2017/1/8.
 */

public class SPUtil {
    /**
     * 1分钟
     */
    public static final int TIME_MINUTES = 60;
    /**
     * 半小时
     */
    public static final int TIME_HALF_HOUR = 60 * 30;
    /**
     * 1小时
     */
    public static final int TIME_HOUR = 60 * 60;
    /**
     * 1天
     */
    public static final int TIME_DAY = TIME_HOUR * 24;

    private final String SAVETIME = "_savetime";

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private static SPUtil instance;

    private SPUtil() {
    }

    /**
     * 首次获取实例后需要config后才可使用
     *
     * @return
     */
    public static SPUtil getInstance() {
        if (instance == null) {
            instance = new SPUtil();
        }
        return instance;
    }

    /**
     * 在getInstance后必须配置后才可使用其他方法
     *
     * @param context
     * @param name    指定名称
     */
    public void config(Context context, String name) {
        sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 在getInstance后必须配置后才可使用其他方法
     *
     * @param context
     */
    public void config(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        editor = sp.edit();

    }

    public SharedPreferences getSharedPreferences() {
        return sp;
    }

    /**
     * 清除所有保存的数据
     */
    public void clear() {
        editor.clear();
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * @param key
     * @param value
     * @param saveTime 保存时间 单位秒
     */
    public void putString(String key, String value, int saveTime) {
        editor.putString(key, value);
        editor.putLong(key + SAVETIME, System.currentTimeMillis() + saveTime * 1000);
        editor.commit();
    }

    public String getString(String key, String defaultValue) {
        long current = System.currentTimeMillis();
        long validity = sp.getLong(key + SAVETIME, Long.MAX_VALUE);
        if (validity > current) {
            return sp.getString(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putBoolean(String key, boolean value, int saveTime) {
        editor.putBoolean(key, value);
        editor.putLong(key + SAVETIME, System.currentTimeMillis() + saveTime * 1000);
        editor.commit();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        long current = System.currentTimeMillis();
        long validity = sp.getLong(key + SAVETIME, Long.MAX_VALUE);
        if (validity > current) {
            return sp.getBoolean(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public void putFloat(String key, float value, int saveTime) {
        editor.putFloat(key, value);
        editor.putLong(key + SAVETIME, System.currentTimeMillis() + saveTime * 1000);
        editor.commit();
    }

    public float getFloat(String key, float defaultValue) {
        long current = System.currentTimeMillis();
        long validity = sp.getLong(key + SAVETIME, Long.MAX_VALUE);
        if (validity > current) {
            return sp.getFloat(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public void putInt(String key, int value, int saveTime) {
        editor.putInt(key, value);
        editor.putLong(key + SAVETIME, System.currentTimeMillis() + saveTime * 1000);
        editor.commit();
    }

    public int getInt(String key, int defaultValue) {
        long current = System.currentTimeMillis();
        long validity = sp.getLong(key + SAVETIME, Long.MAX_VALUE);
        if (validity > current) {
            return sp.getInt(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public void putLong(String key, long value, int saveTime) {
        editor.putLong(key, value);
        editor.putLong(key + SAVETIME, System.currentTimeMillis() + saveTime * 1000);
        editor.commit();
    }

    public long getLong(String key, long defaultValue) {
        long current = System.currentTimeMillis();
        long validity = sp.getLong(key + SAVETIME, Long.MAX_VALUE);
        if (validity > current) {
            return sp.getLong(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    public void putStringSet(String key, Set<String> value) {
        editor.putStringSet(key, value);
        editor.commit();
    }

    public void putStringSet(String key, Set<String> value, int saveTime) {
        editor.putStringSet(key, value);
        editor.putLong(key + SAVETIME, System.currentTimeMillis() + saveTime * 1000);
        editor.commit();
    }

    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        long current = System.currentTimeMillis();
        long validity = sp.getLong(key + SAVETIME, Long.MAX_VALUE);
        if (validity > current) {
            return sp.getStringSet(key, defaultValue);
        } else {
            return defaultValue;
        }
    }
}
