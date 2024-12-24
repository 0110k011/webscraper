package com.k.webscraper;

import com.k.webscraper.dtos.NFParsedDto;
import com.k.webscraper.dtos.ProductServiceDataDto;
import com.k.webscraper.enums.PaymentTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NFParser {

    public NFParsedDto getNFParsed(String html) {

        NFParsedDto nfParserDto = new NFParsedDto();

        String nf = getMatch(html, "#xml-nfe-container.*?(<.*?/html>)");
        if (nf == null) return null;

        nfParserDto.setProductServiceData(getProductServiceData(nf));
        nfParserDto.setApproximateTaxAmount(parseBigDecimal(getMatch(nf, "NFe<.*?os<.*?n>(.*?)<")));
        nfParserDto.setCorporateReason(getMatch(nf, "Dados\\sdo\\sEmitente.*?<span>(.*?)<"));
        nfParserDto.setName(getMatch(nf, "Fantasia.*?<span>(.*?)<"));
        nfParserDto.setCnpj(getMatch(nf, "CNPJ<.*?<span>(.*?)<"));

        String issueDate = getMatch(nf, "(\\d{2}\\D\\d{2}\\D\\d{4}\\s\\d{2}\\D\\d{2}\\D\\d{2})");
        if (issueDate != null) {
            nfParserDto.setIssueDate(LocalDateTime.parse(issueDate.replaceAll("[/:\\s]", ""), DateTimeFormatter.ofPattern("ddMMyyyyHHmmss")));
        }

        String paymentType = getMatch(nf, "Valor\\sdo\\sPagamento.*?40\\W{3}><span>(?:\\Wn\\s*|)(\\d.*?)[<|\\s]");
        if (paymentType != null) {
            nfParserDto.setPaymentType(PaymentTypeEnum.fromValue(Integer.parseInt(paymentType)));
        }

        return nfParserDto;
    }

    private String getMatch(String input, String regex) {
        Matcher matcher = Pattern.compile(regex, Pattern.DOTALL).matcher(input);
        return matcher.find() ? matcher.group(1).trim() : null;
    }

    private Set<ProductServiceDataDto> getProductServiceData (String nf) {
        Set<ProductServiceDataDto> productServiceDataList = new HashSet<>();
        Matcher matcher = Pattern.compile("ao\\D\"><span>(.*?)<.*?<span>(.*?)<.*?<span>(.*?)<.*?<span>(.*?)<", Pattern.DOTALL).matcher(nf);

        while (matcher.find()) {
            ProductServiceDataDto productServiceDataDto = new ProductServiceDataDto();
            productServiceDataDto.setDescription(matcher.group(1).trim());
            productServiceDataDto.setQuantity(parseBigDecimal(matcher.group(2)));
            productServiceDataDto.setUnity(matcher.group(3).trim());
            productServiceDataDto.setAmount(parseBigDecimal(matcher.group(4)));

            productServiceDataList.add(productServiceDataDto);
        }

        return productServiceDataList;
    }

    private BigDecimal parseBigDecimal(String value) {
        if (value == null || value.isEmpty()) return null;
        return new BigDecimal(value.trim().replace(',', '.'));
    }

}
