package com.solidaryride.database;

public class ScriptDdl {

    public static String getCreateTableRide(){
        StringBuilder sql = new StringBuilder();

        sql.append("  CREATE TABLE IF NOT EXISTS RIDE (");
        sql.append("    CODIGO INTEGER  PRIMARY KEY  AUTOINCREMENT NOT NULL,");
        sql.append("    NAME VARCHAR(100) NOT NULL DEFAULT(''),");
        sql.append("    INIT VARCHAR(200) NOT NULL DEFAULT(''),");
        sql.append("    DESTINY VARCHAR(200) NOT NULL DEFAULT(''),");
        sql.append("    NEXTTO VARCHAR(200) NOT NULL DEFAULT(''),");
        sql.append("    NUMBER VARCHAR(20) NOT NULL DEFAULT('') )");
        return sql.toString();
    }
}
