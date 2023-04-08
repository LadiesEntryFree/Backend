package ru.ladies.objects.ladiesentryfree.service;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.repository.FileRepository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@AllArgsConstructor
@EnableScheduling
public class FileService {

    private final FileRepository fileRepository;

    public File getFile(String id) throws IOException {
        ObjectId objectId = new ObjectId(id);
        GridFsResource gridFsResource = fileRepository.getResource(objectId);
        return getFile(gridFsResource);
    }

    private File getFile(GridFsResource gridFsResource) throws IOException {
        byte[] fileData = getFileData(gridFsResource);
        String fileName = gridFsResource.getFilename();
        File file = File.createTempFile("temp-", fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(fileData);
        fileOutputStream.close();
        return file;
    }

    private byte[] getFileData(GridFsResource gridFsResource) throws IOException {
        InputStream inputStream = gridFsResource.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int bytesRead;
        byte[] buffer = new byte[4096];

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        byte[] fileData = outputStream.toByteArray();
        outputStream.close();
        inputStream.close();

        return fileData;
    }
}
