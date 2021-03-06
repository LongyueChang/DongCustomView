package com.admom.mygreendaotest;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.group.teamproject2.beans.TotalUser;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TOTAL_USER".
*/
public class TotalUserDao extends AbstractDao<TotalUser, Long> {

    public static final String TABLENAME = "TOTAL_USER";

    /**
     * Properties of entity TotalUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Years = new Property(1, String.class, "years", false, "years");
        public final static Property Month = new Property(2, String.class, "month", false, "month");
        public final static Property Day = new Property(3, String.class, "day", false, "day");
        public final static Property Week = new Property(4, String.class, "week", false, "week");
        public final static Property Pace = new Property(5, float.class, "pace", false, "pace");
        public final static Property Eight = new Property(6, float.class, "eight", false, "eight");
        public final static Property Sex = new Property(7, boolean.class, "sex", false, "sex");
        public final static Property Age = new Property(8, int.class, "age", false, "age");
        public final static Property DayTag = new Property(9, Long.class, "dayTag", false, "DAY_TAG");
    }

    private DaoSession daoSession;


    public TotalUserDao(DaoConfig config) {
        super(config);
    }
    
    public TotalUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TOTAL_USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"years\" TEXT," + // 1: years
                "\"month\" TEXT," + // 2: month
                "\"day\" TEXT," + // 3: day
                "\"week\" TEXT," + // 4: week
                "\"pace\" REAL NOT NULL ," + // 5: pace
                "\"eight\" REAL NOT NULL ," + // 6: eight
                "\"sex\" INTEGER NOT NULL ," + // 7: sex
                "\"age\" INTEGER NOT NULL ," + // 8: age
                "\"DAY_TAG\" INTEGER UNIQUE );"); // 9: dayTag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TOTAL_USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TotalUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String years = entity.getYears();
        if (years != null) {
            stmt.bindString(2, years);
        }
 
        String month = entity.getMonth();
        if (month != null) {
            stmt.bindString(3, month);
        }
 
        String day = entity.getDay();
        if (day != null) {
            stmt.bindString(4, day);
        }
 
        String week = entity.getWeek();
        if (week != null) {
            stmt.bindString(5, week);
        }
        stmt.bindDouble(6, entity.getPace());
        stmt.bindDouble(7, entity.getEight());
        stmt.bindLong(8, entity.getSex() ? 1L: 0L);
        stmt.bindLong(9, entity.getAge());
 
        Long dayTag = entity.getDayTag();
        if (dayTag != null) {
            stmt.bindLong(10, dayTag);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TotalUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String years = entity.getYears();
        if (years != null) {
            stmt.bindString(2, years);
        }
 
        String month = entity.getMonth();
        if (month != null) {
            stmt.bindString(3, month);
        }
 
        String day = entity.getDay();
        if (day != null) {
            stmt.bindString(4, day);
        }
 
        String week = entity.getWeek();
        if (week != null) {
            stmt.bindString(5, week);
        }
        stmt.bindDouble(6, entity.getPace());
        stmt.bindDouble(7, entity.getEight());
        stmt.bindLong(8, entity.getSex() ? 1L: 0L);
        stmt.bindLong(9, entity.getAge());
 
        Long dayTag = entity.getDayTag();
        if (dayTag != null) {
            stmt.bindLong(10, dayTag);
        }
    }

    @Override
    protected final void attachEntity(TotalUser entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TotalUser readEntity(Cursor cursor, int offset) {
        TotalUser entity = new TotalUser( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // years
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // month
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // day
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // week
            cursor.getFloat(offset + 5), // pace
            cursor.getFloat(offset + 6), // eight
            cursor.getShort(offset + 7) != 0, // sex
            cursor.getInt(offset + 8), // age
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9) // dayTag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TotalUser entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setYears(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMonth(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDay(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setWeek(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPace(cursor.getFloat(offset + 5));
        entity.setEight(cursor.getFloat(offset + 6));
        entity.setSex(cursor.getShort(offset + 7) != 0);
        entity.setAge(cursor.getInt(offset + 8));
        entity.setDayTag(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TotalUser entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TotalUser entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TotalUser entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
