package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ObjectDto {

    private Integer id;
    private String county;
    private String district;
    private String address;
    private String type;
    private String status;
    private Double areaValue;
    private String areaMeasure;
    private String actualUser;
    private String owner;
    private List<AttachmentDto> attachments;
    private List<CustomFieldDTO> customFields;

}
