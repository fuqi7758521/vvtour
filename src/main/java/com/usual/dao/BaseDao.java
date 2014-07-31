package com.usual.dao;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.common.utils.Constants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.usual.entity.BaseEntity;


public abstract class BaseDao {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	
	/**
	 * @param query
	 * @param object
	 * @return
	 */
	protected <T extends BaseEntity> BaseEntity queryOne(Query query, T object){
		return mongoTemplate.findOne(query, object.getClass(), object.getCollectionName());
	}
	
	
	
	/**
	 * @param query
	 * @param object
	 * @return
	 */
	protected <T extends BaseEntity> List<? extends BaseEntity> queryList(Query query, T object){
		
		return mongoTemplate.find(query, object.getClass(), object.getCollectionName());
	}
	
	/**
	 * @param query
	 * @param object
	 * @return
	 */
	protected <T extends BaseEntity> long getCount(Query query, T object) {
		
		return mongoTemplate.count(query, object.getCollectionName());
	}
	
	protected <T extends BaseEntity> void saveBatch(List<? extends BaseEntity> objects){
		mongoTemplate.insert(objects, objects.get(0).getCollectionName());
	}
	
	/**
	 * @param object
	 */
	protected <T extends BaseEntity> void saveOne(T object){
		
		mongoTemplate.insert(object, object.getCollectionName());
	}
	
	/**
	 * @param object
	 */
	protected <T extends BaseEntity> void saveInnerObjOne(Query query, Update update,T object){
		
		mongoTemplate.upsert(query, update, object.getCollectionName());
	}
	
	/**
	 * @param object
	 */
	protected <T extends BaseEntity> boolean updateInnerObjOne(Query query, Update update,T object){
		try{
			mongoTemplate.updateFirst(query, update, object.getCollectionName());
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param object
	 */
	protected <T extends BaseEntity> void delOne(Query query,T object){
		
		mongoTemplate.remove(query, object.getCollectionName());
	}
	
	/**
	 * @param query
	 * @param update
	 * @param object
	 * @return
	 */
	protected <T extends BaseEntity> BaseEntity findAndModify(Query query, Update update, T object){
		
		return mongoTemplate.findAndModify(query, update, object.getClass(), object.getCollectionName());
	}
	
	/**
	 * @param query
	 * @param update
	 * @param object
	 * @return
	 */
	protected <T extends BaseEntity> boolean  updateBatch(Query query, Update update, T object) {

		WriteResult result = mongoTemplate.updateMulti(query, update, object.getCollectionName());
		if(result.getError() == null && result.getField(Constants.SIGN).equals(1.0)){
			return true;
		}
		return false;
	}
	
	protected void addPicture(byte [] bytes, String fileId, String fileName) {
		
		GridFSFile gridFSFile = getGridFS().createFile(bytes);
		
        gridFSFile.put(ImageField.imgId, fileId);
        
        gridFSFile.put(ImageField.imgName, fileName);
        
        gridFSFile.save();
	}
	
	protected byte []  getPicture(String fileId) {
		DBObject query = new BasicDBObject();
		query.put(ImageField.imgId, fileId);
		GridFSDBFile file = getGridFS().findOne(query);
		InputStream in = file.getInputStream();
		int dataLen = (int) file.getLength();
        byte[] bytes = new byte[dataLen];
        int pos = 0;
        try {
        	int len = in.read(bytes, pos, dataLen);
            while (len > 0) {
                pos += len;
                dataLen -= len;
                len = in.read(bytes, pos, dataLen);
            }
            return bytes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	 /**
     * 
     * @return GridFS
     */
	protected GridFS getGridFS() {

        GridFS gridFS = new GridFS(mongoTemplate.getDb());
        return gridFS;
    }
	
	class ImageField{
		public static final String imgId = "imgId";
		public static final String imgName = "imgName";
	}
}
