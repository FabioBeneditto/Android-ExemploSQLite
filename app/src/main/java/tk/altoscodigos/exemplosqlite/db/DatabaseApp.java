package tk.altoscodigos.exemplosqlite.db;

/**
 * Created by fabio on 21/03/15.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseApp extends SQLiteOpenHelper {

    public static final String NM_DATABASE = "DiarioViagem";
    public static final int VERSAO_DATABASE = 3;

    public DatabaseApp(Context context) {
        super(context, NM_DATABASE, null, VERSAO_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder cmd = new StringBuilder();
        cmd.append("create table Locais ( ");
        cmd.append("idLocal integer not null, ");
        cmd.append("dsLocal varchar(120) not null, ");
        cmd.append("dtVisita timestamp, ");
        cmd.append("dsObservacao varchar, ");
        cmd.append("imagem bytea, ");
        cmd.append("latitude real, ");
        cmd.append("longitude real, ");
        cmd.append("dtEnvioFB timestamp, ");
        cmd.append("primary key (idLocal) ");
        cmd.append(" );");

        db.execSQL(cmd.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                upgradeParaV2(db);
            case 2:
                upgradeParaV3(db);
        }
    }

    private void upgradeParaV2(SQLiteDatabase db) {
        db.execSQL("alter table Locais add column dtEnvioFB timestamp;");
    }

    private void upgradeParaV3(SQLiteDatabase db) {
        db.execSQL("alter table Locais add column latitude real;");
        db.execSQL("alter table Locais add column longitude real;");
    }
}
