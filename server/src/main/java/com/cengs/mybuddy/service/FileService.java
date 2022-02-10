package com.cengs.mybuddy.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations gridFsOperations;


    public ObjectId uploadFile(MultipartFile file) throws IOException {
        DBObject object = new BasicDBObject();
        object.put("fileName", file.getName());
        object.put("contentType",file.getContentType());
        object.put("size",file.getSize());
        return gridFsTemplate.store(file.getInputStream(),file.getOriginalFilename(),object);
    }

    public GridFsResource getFile(String id) throws IOException {
        GridFSFile fsfl =  gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        return gridFsOperations.getResource(fsfl);

    }
}