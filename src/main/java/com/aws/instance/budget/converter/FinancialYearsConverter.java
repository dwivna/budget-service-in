package com.aws.instance.budget.converter;

import java.io.IOException;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.aws.instance.budget.vo.FinancialYear;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinancialYearsConverter implements DynamoDBTypeConverter<String, List<FinancialYear>> {

    @Override
    public String convert(List<FinancialYear> financialYears) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String objectsString = objectMapper.writeValueAsString(financialYears);
            return objectsString;
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException while converting", e);
        }
        return null;
    }

    @Override
    public List<FinancialYear> unconvert(String dataString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<FinancialYear> financialYears = objectMapper.readValue(dataString, new TypeReference<List<FinancialYear>>() {
            });
            return financialYears;
        } catch (JsonParseException e) {
            log.error("JsonParseException while unconverting", e);
        } catch (JsonMappingException e) {
            log.error("JsonMappingException while unconverting", e);
        } catch (IOException e) {
            log.error("IOException while unconverting", e);
        }
        return null;
    }

}
