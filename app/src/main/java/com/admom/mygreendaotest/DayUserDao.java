package com.admom.mygreendaotest;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.example.group.teamproject2.beans.DayUser;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DAY_USER".
*/
public class DayUserDao extends AbstractDao<DayUser, Long> {

    public static final String TABLENAME = "DAY_USER";

    /**
     * Properties of entity DayUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Current = new Property(1, String.class, "current", false, "current");
        public final static Property Duration = new Property(2, float.class, "duration", false, "duration");
        public final static Property Distance = new Property(3, float.class, "distance", false, "distance");
        public final static Property TotalUserTag = new Property(4, Long.class, "totalUserTag", false, "TOTAL_USER_TAG");
    }

    private Query<DayUser> totalUser_DayListQuery;

    public DayUserDao(DaoConfig config) {
        super(config);
    }
    
    public DayUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAY_USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"current\" TEXT," + // 1: current
                "\"duration\" REAL NOT NULL ," + // 2: duration
                "\"distance\" REAL NOT NULL ," + // 3: distance
                "\"TOTAL_USER_TAG\" INTEGER NOT NULL );"); // 4: totalUserTag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAY_USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DayUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String current = entity.getCurrent();
        if (current != null) {
            stmt.bindString(2, current);
        }
        stmt.bindDouble(3, entity.getDuration());
        stmt.bindDouble(4, entity.getDistance());
        stmt.bindLong(5, entity.getTotalUserTag());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DayUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String current = entity.getCurrent();
        if (current != null) {
            stmt.bindString(2, current);
        }
        stmt.bindDouble(3, entity.getDuration());
        stmt.bindDouble(4, entity.getDistance());
        stmt.bindLong(5, entity.getTotalUserTag());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DayUser readEntity(Cursor cursor, int offset) {
        DayUser entity = new DayUser( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // current
            cursor.getFloat(offset + 2), // duration
            cursor.getFloat(offset + 3), // distance
            cursor.getLong(offset + 4) // totalUserTag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DayUser entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCurrent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDuration(cursor.getFloat(offset + 2));
        entity.setDistance(cursor.getFloat(offset + 3));
        entity.setTotalUserTag(cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DayUser entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DayUser entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DayUser entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "dayList" to-many relationship of TotalUser. */
    public List<DayUser> _queryTotalUser_DayList(Long totalUserTag) {
        synchronized (this) {
            if (totalUser_DayListQuery == null) {
                QueryBuilder<DayUser> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.TotalUserTag.eq(null));
                queryBuilder.orderRaw("T.'current' ASC");
                totalUser_DayListQuery = queryBuilder.build();
            }
        }
        Query<DayUser> query = totalUser_DayListQuery.forCurrentThread();
        query.setParameter(0, totalUserTag);
        return query.list();
    }

}