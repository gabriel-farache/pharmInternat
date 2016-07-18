package com.gabi.pharminternat.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gabi.pharminternat.model.PharmaFile;
import com.gabi.pharminternat.model.PharmaSection;
import com.example.gabi.main.R;
import com.gabi.pharminternat.utils.Constant;
import com.gabi.pharminternat.utils.Utils;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by gabi on 14/07/16.
 */
public class DAO extends SQLiteOpenHelper {
    public String DB_PATH = null;
    public static String DB_NAME; //take note this is in your asset folder
    private static final int DB_VERSION = 1;
    private SQLiteDatabase myDatabase;
    private Context myContext = null;
    private static DAO dao = null;

    private DAO(Context context) {
        super(context, context.getString(R.string.db_name), null, DB_VERSION);
        this.myContext = context;
        DAO.DB_NAME = context.getString(R.string.db_name);
        this.DB_PATH = "/storage/emulated/0/data/";
        DAO.dao = this;
        this.openDatabase();

    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     * */
    public void createDataBase(SQLiteDatabase db) {
        try {
            db.execSQL(Constant.DAO_QUERY_DROP_PHARMASECTION);
            db.execSQL(Constant.DAO_QUERY_DROP_PHARMAFILE);
            db.execSQL(Constant.DAO_QUERY_CREATE_TABLE_PHARMASECTION);
            db.execSQL(Constant.DAO_QUERY_CREATE_TABLE_PHARMAFILE);
            this.populatePharmaSection(db);
            this.populatePharmaFiles(db);
        } catch (android.database.SQLException e) {
            e.printStackTrace();
        }
    }

    private void populatePharmaSection(SQLiteDatabase db){
        for(int i = 0; i < Constant.DAO_QUERY_INSERTS_PHARMASECTION.length; i++){
            db.execSQL(Constant.DAO_QUERY_INSERTS_PHARMASECTION[i]);
        }
    }

    private void populatePharmaFiles(SQLiteDatabase db){
        for(String[] pharmaFilesSectionQueries : Constant.DAO_QUERY_INSERTS_PHARMAFILES){
            for(String query : pharmaFilesSectionQueries) {
                db.execSQL(query);
            }
        }
    }

    /**
     * Opens Database . Method is synhcronized
     * @throws SQLException
     */
    public synchronized void openDatabase() throws SQLException {
        String dbPath = this.DB_PATH + DAO.DB_NAME;

        try
        {
            this.myDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);

        } catch (Exception e)
        {
            String databasePath =  dbPath;
            File dbDirectory = new File(this.DB_PATH);
            dbDirectory.mkdirs();
            File databaseFile = new File(databasePath);
            System.out.println(databaseFile.getAbsolutePath());
            this.myDatabase = SQLiteDatabase.openOrCreateDatabase(databaseFile, null);

        }
    }

    /**
     * Closes database.
     * Method is synchronized for protection
     */
    @Override
    public synchronized void close() {
        if (myDatabase != null) {
            myDatabase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            this.createDataBase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<PharmaSection> getPharamaSections(){
        ArrayList<PharmaSection> pharmaSections = new ArrayList<PharmaSection>();
        String [] whereClausesArgs = {};
        Cursor cursor = this.myDatabase.rawQuery(Constant.DAO_QUERY_SELECT_PHARMASECTIONS, whereClausesArgs);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            try {
                int sectionColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaSectionSectionColumn);
                int titleColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaSectionSectionTitleColumn);
                PharmaSection pharmaSection = new PharmaSection(cursor.getInt(sectionColumnIndex),
                        cursor.getString(titleColumnIndex));
                pharmaSections.add(pharmaSection);
            }catch(IllegalArgumentException iae){
                //log error
                iae.printStackTrace();
            } catch(Exception e){
                //log error
                e.printStackTrace();
            }finally {
                cursor.moveToNext();
            }

        }
        cursor.close();

        return pharmaSections;
    }

    public PharmaSection getPharamaSection(Integer section){
        PharmaSection pharmaSection = null;

        String [] whereClausesArgs = {section.toString()};
        Cursor cursor = this.myDatabase.rawQuery(Constant.DAO_QUERY_SELECT_PHARMASECTION, whereClausesArgs);
        cursor.moveToFirst();

        try {
            int sectionColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaSectionSectionColumn);
            int titleColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaSectionSectionTitleColumn);
            pharmaSection = new PharmaSection(cursor.getInt(sectionColumnIndex),
                    cursor.getString(titleColumnIndex));
        }catch(IllegalArgumentException iae){
            //log error
            iae.printStackTrace();
        }catch(Exception e){
            //log error
            e.printStackTrace();
        }

        cursor.close();

        return pharmaSection;
    }

    public ArrayList<PharmaFile> getSectionPharamaFiles(Integer section){
        ArrayList<PharmaFile> sectionPharmaFiles = new ArrayList<PharmaFile>();
        String [] whereClausesArgs = {section.toString()};
        Cursor cursor = this.myDatabase.rawQuery(Constant.DAO_QUERY_SELECT_PHARMAFILES, whereClausesArgs);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            try {
                int idColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaFileIdColumn);
                int sectionColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaFileSectionColumn);
                int displayOrderColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaFileDisplayOrderColumn);
                int fileTitleColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaFileFileTitleColumn);
                int reviewCounterColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaFileReviewCounterColumn);
                int lastReviewColumnIndex = cursor.getColumnIndexOrThrow(Constant.pharmaFileLastReviewColumn);


                PharmaFile pharmaFile = new PharmaFile(cursor.getInt(idColumnIndex),
                        cursor.getInt(sectionColumnIndex),
                        cursor.getDouble(displayOrderColumnIndex),
                        cursor.getString(fileTitleColumnIndex),
                        cursor.getInt(reviewCounterColumnIndex),
                        Utils.getDateTimeFromString(cursor.getString(lastReviewColumnIndex)));
                sectionPharmaFiles.add(pharmaFile);
            }catch(IllegalArgumentException iae){
                //log error
                iae.printStackTrace();
            }catch(ParseException pe){
                //log error
                pe.printStackTrace();
            }catch(Exception e){
                //log error
                e.printStackTrace();
            } finally {
                cursor.moveToNext();
            }

        }
        cursor.close();

        return sectionPharmaFiles;
    }

    public void incrementReviewCounter(Integer id){
        String [] whereClausesArgs = {id.toString()};
        try {
            this.myDatabase.execSQL(Constant.DAO_QUERY_UPDATE_REVIEW_COUNTER, whereClausesArgs);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setReviewDate(Integer id){
        String [] whereClausesArgs = {Utils.getDateTime(), id.toString()};
        try {
            this.myDatabase.execSQL(Constant.DAO_QUERY_UPDATE_LAST_REVIEW_DATE, whereClausesArgs);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DAO getInstance(Context context){
        if(DAO.dao == null){
            DAO.dao = new DAO(context);
            dao.openDatabase();
        }
        return DAO.dao;
    }
}
