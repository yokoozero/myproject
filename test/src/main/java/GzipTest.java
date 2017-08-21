import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by wb.zhengcheng on 2017/8/11.
 */
public class GzipTest {
    public static void main(String[] args) {
        System.out.println(gzip(""));
    }


        /**
         * 使用gzip进行压缩，并用base64编码
         */
        public static String gzip(String primStr) {
            if (primStr == null || primStr.length() == 0) {
                return primStr;
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            GZIPOutputStream gzip = null;
            try {
                gzip = new GZIPOutputStream(out);
                gzip.write(primStr.getBytes("GBK"));
            } catch (Exception e) {
            } finally {
                if (gzip != null) {
                    try {
                        gzip.close();
                    } catch (Exception e) {
                    }
                }
            }

            return new sun.misc.BASE64Encoder().encode(out.toByteArray());
        }

        /**
         * 使用base64进行解码，并使用gzip进行解压缩
         *
         * @param compressedStr
         * @return
         */
        public static String gunzip(String compressedStr) {
            if (compressedStr == null || compressedStr.length() == 0) {
                return compressedStr;
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = null;
            GZIPInputStream ginzip = null;
            byte[] compressed = null;
            String decompressed = null;
            try {
                compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
                in = new ByteArrayInputStream(compressed);
                ginzip = new GZIPInputStream(in);

                byte[] buffer = new byte[1024];
                int offset = -1;
                while ((offset = ginzip.read(buffer)) != -1) {
                    out.write(buffer, 0, offset);
                }
                byte[] tmp = out.toByteArray();
                decompressed = new String(tmp, "GBK");//out.toString();
            } catch (Exception e) {
            } finally {
                if (ginzip != null) {
                    try {
                        ginzip.close();
                    } catch (Exception e) {
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (Exception e) {
                    }
                }
            }

            return decompressed;
        }

}
