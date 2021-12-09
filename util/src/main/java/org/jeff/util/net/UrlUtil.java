package org.jeff.util.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * URL 工具类
 *
 * @author jeff
 * @since 1.0.0
 */
public class UrlUtil {

    /**
     * 读取、下载对应的 URL 资源
     *
     * @param resourceUrl URL资源路径
     * @param targetUrl   输出路径
     */
    public static void readUrlResource(String resourceUrl, String targetUrl) {

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            URL url = new URL(resourceUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            // 获取输入流数据
            inputStream = urlConnection.getInputStream();
            outputStream = new FileOutputStream(targetUrl);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            System.out.println("download success");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
