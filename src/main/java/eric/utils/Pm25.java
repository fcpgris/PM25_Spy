package eric.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pm25 {
	private static String pm25Value = "N/A";

	/**
	 * Get PM2.5 value from http://www.beijing-air.com/
	 * 
	 * @return String value of pm2.5, if not found, returns N/A
	 */
	public static String getPm25Value() {
		String strUrl = "http://www.beijing-air.com/";
		String html = WebPage.getWebPageSource(strUrl);
		if(html == null || html.isEmpty()){
			return "N/A";
		}

		// Create a Pattern object
		String pattern = "美国大使馆北京空气质量.*北京空气质量指数\\(AQI\\):(\\d+)</span>";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(html);
		if (m.find()) {
			pm25Value = m.group(1);
			if(pm25Value == null || pm25Value.isEmpty()){
				return "N/A";
			}
		}
		
		return pm25Value;
	}
	
}
