package com.k.webscraper.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class NFParsedDto {

    private Set<ProductServiceDataDto> productServiceData = new HashSet<>();
    private BigDecimal approximateTaxAmount;
    private String corporateReason;
    private String name;
    private String cnpj;
    private String paymentType;

    public NFParsedDto() {
    }

    public NFParsedDto(Set<ProductServiceDataDto> productServiceData, BigDecimal taxes, String corporateReason, String name, String cnpj, String paymentType) {
        this.productServiceData = productServiceData;
        this.approximateTaxAmount = taxes;
        this.corporateReason = corporateReason;
        this.name = name;
        this.cnpj = cnpj;
        this.paymentType = paymentType;
    }

    public Set<ProductServiceDataDto> getProductServiceData() {
        return productServiceData;
    }

    public void setProductServiceData(Set<ProductServiceDataDto> productServiceData) {
        this.productServiceData = productServiceData;
    }

    public BigDecimal getApproximateTaxAmount() {
        return approximateTaxAmount;
    }

    public void setApproximateTaxAmount(BigDecimal approximateTaxAmount) {
        this.approximateTaxAmount = approximateTaxAmount;
    }

    public String getCorporateReason() {
        return corporateReason;
    }

    public void setCorporateReason(String corporateReason) {
        this.corporateReason = corporateReason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
