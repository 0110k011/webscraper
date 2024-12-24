package com.k.webscraper.dtos;

import com.k.webscraper.enums.PaymentTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class NFParsedDto {

    private Set<ProductServiceDataDto> productServiceData = new HashSet<>();
    private BigDecimal approximateTaxAmount;
    private String corporateReason;
    private String name;
    private String cnpj;
    private PaymentTypeEnum paymentType;
    private LocalDateTime issueDate;

    public NFParsedDto() {
    }

    public NFParsedDto(Set<ProductServiceDataDto> productServiceData, BigDecimal taxes, String corporateReason, String name, String cnpj, PaymentTypeEnum paymentType, LocalDateTime issueDate) {
        this.productServiceData = productServiceData;
        this.approximateTaxAmount = taxes;
        this.corporateReason = corporateReason;
        this.name = name;
        this.cnpj = cnpj;
        this.paymentType = paymentType;
        this.issueDate = issueDate;
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

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }
}
