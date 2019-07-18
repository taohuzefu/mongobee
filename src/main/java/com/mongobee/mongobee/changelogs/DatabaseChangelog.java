package com.mongobee.mongobee.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongobee.mongobee.utils.JsonConverter;
import java.io.IOException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

@ChangeLog
public class DatabaseChangelog {

  @ChangeSet(order = "001", id = "firstScript", author = "taohuzefu")
  public void firstOne(Jongo jongo) throws IOException {
    StringBuffer sb = new StringBuffer();
    JsonConverter.readToBuffer(
        sb,
        "/Users/hzfuao/Downloads/mongobee/src/main/java/com/mongobee/mongobee/changelogs/test_script.json");
    MongoCollection mycollection = jongo.getCollection("mycollection");
    mycollection.insert(sb.toString());
  }
}
