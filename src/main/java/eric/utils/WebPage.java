package eric.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WebPage {

	/**
	 * Get the HTML source of a web page 
	 * 
	 * @param strUrl the URL of web page you want to get
	 * @return the HTML source of the web page
	 */
	public static String getWebPageSource(String strUrl) {
		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;
		StringBuilder strBuilder = new StringBuilder();

		try {
			url = new URL(strUrl);
			is = url.openStream();
//			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				strBuilder.append(line);
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		
		return strBuilder.toString();
	}
}
