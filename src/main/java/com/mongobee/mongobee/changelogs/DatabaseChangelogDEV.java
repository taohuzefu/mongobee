package com.mongobee.mongobee.changelogs;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongobee.mongobee.utils.JsonConverter;
import java.io.IOException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@ChangeLog
public class DatabaseChangelogDEV {

  @ChangeSet(order = "002", id = "SecondScript", author = "taohuzefu")
  public void secondOne(Jongo jongo) throws IOException {
    StringBuffer sb = new StringBuffer();
    JsonConverter.readToBuffer(
        sb,
        "/Users/hzfuao/Downloads/mongobee/src/main/java/com/mongobee/mongobee/changelogs/test_script.json");
    MongoCollection mycollection = jongo.getCollection("mycollection");
    mycollection.insert(sb.toString());
  }

  @ChangeSet(order = "002", id = "thri", author = "taohuzefu")
  public void secondOn3e(Jongo jongo) throws IOException {
    StringBuffer sb = new StringBuffer();
    JsonConverter.readToBuffer(
        sb,
        "/Users/hzfuao/Downloads/mongobee/src/main/java/com/mongobee/mongobee/changelogs/test_script.json");
    MongoCollection mycollection = jongo.getCollection("mycollection");
    mycollection.insert(sb.toString());
  }
}
