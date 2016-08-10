package com.razor.shoshiinterview.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Youtube Util
 */
public class YoutubeUtil {
    /**
     * Extract youtube id by youtube URL
     * @param ytUrl
     * @return
     */
    public static String extractYTId(String ytUrl) {
        String ytID = "";
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(ytUrl);

        if(matcher.find()){
            ytID = matcher.group();
        }
        return ytID;
    }
}
