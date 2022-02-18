package service;

import java.util.HashMap;
import java.util.Map;

public class EnglishServiceilmp implements EnglishService{
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("table", "ban hoc");
        map.put("book", "sach");
        map.put("pencil", "but chi");
    }

    @Override
    public String findByEnglish(String wordEnglish) {
        String wordVN = map.get(wordEnglish);
        if (wordVN == null) {
            return null;
        } else {
            return wordVN;
        }
    }
}
