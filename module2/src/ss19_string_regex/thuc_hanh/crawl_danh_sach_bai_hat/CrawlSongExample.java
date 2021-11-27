package ss19_string_regex.thuc_hanh.crawl_danh_sach_bai_hat;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            //open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            // close scanner
            scanner.close();

            content = content.replaceAll("\\n+", "");
            Pattern pattern = Pattern.compile("name_song\">(.*?)</a>");
            //Pattern pattern = Pattern.complie("name_some\">(C)(.*?)</a>");
            Matcher matcher = pattern.matcher(content);

            while(matcher.find()) {
                System.out.println(matcher.group(1));
                //System.out.println(matcher.group(1));
                //will return C
                //System.out.println(matcher.group(2));
                //will return the rest until a
            }
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
