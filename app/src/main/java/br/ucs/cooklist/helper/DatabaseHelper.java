package br.ucs.cooklist.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.SplittableRandom;

public class DatabaseHelper extends SQLiteOpenHelper {

   public static final String DATABASE_NAME = "cookbook_ucs";

   public static final String TABLE1_NAME = "cookbook_recipe";
   public static final String COL1_T1 = "id";
   public static final String COL2_T1 = "nome";
   public static final String COL3_T1 = "ingredientes";
   public static final String COL4_T1 = "tempo_preparo";
   public static final String COL5_T1 = "des_img";

   public static final String TABLE2_NAME = "cookbook_ingredients";
   public static final String COL1_T2 = "id";
   public static final String COL2_T2 = "nome";
   public static final String COL3_T2 = "descricao";

   public DatabaseHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

   @Override
   public void onCreate (SQLiteDatabase db) {
      String createTable = "CREATE TABLE " + TABLE1_NAME + " ("
              + COL1_T1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
              + COL2_T1 + " TEXT,"
              + COL3_T1 + " TEXT,"
              + COL4_T1 + " TEXT,"
              + COL5_T1 + " TEXT );";

      String createTable2 = "CREATE TABLE " + TABLE2_NAME + " ("
              + COL1_T2 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
              + COL2_T2 + " TEXT,"
              + COL3_T2 + " TEXT );";

      db.execSQL(createTable);
      db.execSQL(createTable2);
   }

   @Override
   public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
      db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
      db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
      onCreate(db);
   }

   public boolean addDataTableRecipe (String nome, String ingredientes, String tempoPreparo, String desImage) {
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put(COL2_T1, nome);
      contentValues.put(COL3_T1, ingredientes);
      contentValues.put(COL4_T1, tempoPreparo);
      contentValues.put(COL5_T1, desImage);

      long result = db.insert(TABLE1_NAME, null, contentValues);

      if (result == - 1){
         return false;
      }  else {
         return true;
      }
   }

   public Cursor getListAllRecipes(){
      SQLiteDatabase db = this.getWritableDatabase();
      Cursor data = db.rawQuery("SELECT * FROM " + TABLE1_NAME, null);
      return data;
   }

   public void onDeleteAllRecipes (SQLiteDatabase db){
      db.execSQL("DELETE FROM " + TABLE1_NAME);
   }

   // Para fazer o update ele vai fazer o where com o nome antes da alteração (variável nomeAnterior que é recebida por parâmetro)
   public void alteraRecipe(String nomeAnterior, String nome, String ingredientes, String tempoPreparo, String desImage){
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues valores= new ContentValues();

      valores.put(COL2_T1, nome);
      valores.put(COL3_T1, ingredientes);
      valores.put(COL4_T1, tempoPreparo);
      valores.put(COL5_T1, desImage);

      db.update(TABLE1_NAME, valores, "nome=?", new String[]{nomeAnterior});
      db.close();
   }

   // Para fazer o delete de um registo ele vai fazer o where com o nome da receita (variável nome que é recebida por parâmetro)
   public void deleteOneRecipe(String nome) {
      SQLiteDatabase db = this.getWritableDatabase();

      db.delete(TABLE1_NAME, "nome=?", new String[]{nome});
      db.close();
   }

   public boolean addDataTableIngredient(String nome, String descricao){
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put(COL2_T2, nome);
      contentValues.put(COL3_T2, descricao);

      long result = db.insert(TABLE2_NAME, null, contentValues);

      if (result == - 1){
         return false;
      }  else {
         return true;
      }
   }

   public Cursor getListAllIngredients(){
      SQLiteDatabase db = this.getWritableDatabase();
      Cursor data = db.rawQuery("SELECT * FROM " + TABLE2_NAME, null);
      return data;
   }

   public void onDeleteIngredients (SQLiteDatabase db){
      db.execSQL("DELETE FROM " + TABLE2_NAME);
   }
}