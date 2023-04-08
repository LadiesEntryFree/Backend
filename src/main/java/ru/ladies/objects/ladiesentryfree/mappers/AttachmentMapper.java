package ru.ladies.objects.ladiesentryfree.mappers;

import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.AttachmentDto;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Attachment;

@Component
public class AttachmentMapper {

    public AttachmentDto map(Attachment attachment) {
        AttachmentDto dto = new AttachmentDto();
        dto.setFilename(attachment.getFileName());
        dto.setId(attachment.getId());
        return dto;
    }

    public Attachment map(AttachmentDto dto) {
        Attachment attachment = new Attachment();
        attachment.setDocumentID(dto.getId());
        attachment.setFileName(dto.getFilename());
        return attachment;
    }
}
