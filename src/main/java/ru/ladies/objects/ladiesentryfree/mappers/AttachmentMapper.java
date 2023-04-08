package ru.ladies.objects.ladiesentryfree.mappers;

import org.springframework.stereotype.Component;
import ru.ladies.objects.ladiesentryfree.model.dto.AttachmentDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.objectRelated.Attachment;

@Component
public class AttachmentMapper {

    public AttachmentDTO map(Attachment attachment) {
        AttachmentDTO dto = new AttachmentDTO();
        dto.setFilename(attachment.getFileName());
        dto.setId(attachment.getId());
        return dto;
    }

    public Attachment map(AttachmentDTO dto) {
        Attachment attachment = new Attachment();
        attachment.setDocumentID(dto.getId());
        attachment.setFileName(dto.getFilename());
        return attachment;
    }
}
