package org.lyon_yan.app.android.lib.epay.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yanni on 2016/2/14.
 */
public class KeyUtils {
    /**
     * 获取key从文件中
     *
     * @param path
     * @return
     */
    public String getKey(String path) {
        return getKey(new File(path));
    }

    /**
     * 获取key从文件中
     *
     * @param file
     * @return
     */
    public String getKey(File file) {
        if (!file.exists() || file.isFile()) {
            return null;
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder r = new StringBuilder();
            while (bufferedReader.ready()) {
                String t = bufferedReader.readLine();
                /**
                 * 去除注释部分
                 */
                if (!t.contains("-----"))
                    r.append(bufferedReader.readLine());
            }
            bufferedReader.close();
            return r.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * aBc to a_bc
     *
     * @param k
     * @return
     */
    public static String getLowerCaseKey(String k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k.length(); i++) {
            char c = k.charAt(i);
            if (Character.isUpperCase(c)) {
                stringBuilder.append(("_" + c).toLowerCase());
            } else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
