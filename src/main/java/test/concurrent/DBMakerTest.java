package test.concurrent;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class DBMakerTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DB db = DBMaker.fileDB(new File("testdb")).closeOnJvmShutdown().make();

        // open existing an collection (or create new)
        ConcurrentNavigableMap map = db.get("collectionName");

        map.put(1, "one");
        map.put(2, "two");
        // map.keySet() is now [1,2]

        db.commit(); //persist changes into disk

        map.put(3, "three");
        // map.keySet() is now [1,2,3]
        db.rollback(); //revert recent changes
        // map.keySet() is now [1,2]

        db.close();
    }

}
