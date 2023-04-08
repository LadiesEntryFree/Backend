package ru.ladies.objects.ladiesentryfree.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ObjectDTO {

    private Integer id;
    private String county;
    private String district;
    private String address;
    private String type;
    private String status;
    private Double area;
    private String actualUser;
    private String owner;
    private List<AttachmentDTO> attachments;
    private List<CustomFieldDTO> customFields;

}
