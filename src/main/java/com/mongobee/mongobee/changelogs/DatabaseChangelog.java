package com.mongobee.mongobee.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@ChangeLog
public class DatabaseChangelog {

  @ChangeSet(order = "001", id = "someChangeId2", author = "testAuthor")
  public void importantWorkToDo(DB db) {
    DBCollection mycollection = db.getCollection("mycollection");
    BasicDBObject doc = new BasicDBObject().append("test", "2");
    mycollection.insert(doc);
  }
  @ChangeSet(order = "000", id = "someChangeId1", author = "testAuthor")
  public void importantWorkToDo1(DB db) {
    DBCollection mycollection = db.getCollection("mycollection");
    BasicDBObject doc = new BasicDBObject().append("test", "1");
    mycollection.insert(doc);
  }
}
