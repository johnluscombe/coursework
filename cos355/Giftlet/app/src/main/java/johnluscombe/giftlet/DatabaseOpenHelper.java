package johnluscombe.giftlet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private final String DATABASENAME;
    private final String TABLENAME;

    public DatabaseOpenHelper(Context context, String dbname, String tableName) {
        super(context, dbname, null, 1);
        DATABASENAME = dbname;
        TABLENAME = tableName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (giftletdb vchar(32));", TABLENAME));
        db.execSQL(String.format("ALTER TABLE %s ADD COLUMN recipients;", TABLENAME));
        db.execSQL(String.format("ALTER TABLE %s ADD COLUMN recipient_gifts;", TABLENAME));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
