package com.k.webscraper;

import com.k.webscraper.contants.SefazConstants;
import com.k.webscraper.dtos.NFParsedDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class WebScraperParser {

    private CookieManager cookieManager;

    public WebScraperParser() {
        cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
    }

    public String getWebData(String urlString, Boolean isRead) throws IOException {

        URL url = new URL(urlString);

        HttpURLConnection connection = getHttpURLConnection(url);

        if (Boolean.FALSE.equals(isRead)) return null;

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            content.append(line).append("\n");
        }
        in.close();

        return content.toString();
    }

    public NFParsedDto getNFData(String code, String recaptcha) throws IOException {

        this.getWebData(String.format("%s%s?chaveAcesso=%s&g-recaptcha-response=%s", SefazConstants.SEFAZ_DOMAIN, SefazConstants.SEFAZ_IDENTIFICATION,code, recaptcha), false);
        this.getWebData(String.format("%s%s?chaveAcesso=%s&g-recaptcha-response=%s", SefazConstants.SEFAZ_DOMAIN, SefazConstants.SEFAZ_CONSULT, code, recaptcha), false);
        String html = this.getWebData(String.format("%s%s?chNFe=%s", SefazConstants.SEFAZ_DOMAIN, SefazConstants.SEFAZ_RENDER, code), true);

        return new NFParser().getNFParsed(html);

    }

    private static HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
        connection.setRequestProperty("Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        connection.setRequestProperty("Connection", "keep-alive");
        return connection;
    }

}
