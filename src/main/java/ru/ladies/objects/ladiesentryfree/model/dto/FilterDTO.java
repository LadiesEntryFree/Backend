package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;

@Data
public class FilterDTO {
    private String county;
    private String district;
    private String address;
    private String type;
    private String status;
    private Double areaValue;
    private String actualUser;
    private String owner;
}
