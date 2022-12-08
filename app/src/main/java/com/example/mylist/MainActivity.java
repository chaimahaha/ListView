package com.example.mylist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView maListView;
    /** Calledwhen the activityis first created. */
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Récupération de la listview créée dans le fichier main.xml
        maListView=(ListView) findViewById(R.id.listview);
        //Création de la ArrayList qui nous permettra de remplir la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

    //On déclare la HashMap qui contiendra les informations pour un item
    HashMap<String, String> map;
    //Création d'une HashMap pour insérer les informations du premier item de notre listView
            map= new HashMap<String, String>();
    //on insère un élément titre que l'on récupérera dans le textView titre créé dans le fichier affichageitem.xml
    map.put("titre", "Word");
    //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier affichageitem.xml
    map.put("description", "Editeur de texte");
    //on insère la référence à l'image (converti en String car normalement c'est unint) que l'on récupérera dans l'imageView créé dans le fichier affichageitem.xml
    map.put("img", String.valueOf(R.drawable.word));
    //enfin on ajoute cette hashMap dans la arrayList
    listItem.add(map);
    //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
    map=new HashMap<String, String>();
    map.put("titre", "Excel");
    map.put("description", "Tableur");
    map.put("img", String.valueOf(R.drawable.excel));
    listItem.add(map);
    map=new HashMap<String, String>();
    map.put("titre", "Power Point");
    map.put("description", "Logiciel de présentation");
    map.put("img", String.valueOf(R.drawable.powerpoint));
    listItem.add(map);
    map=new HashMap<String, String>();
    map.put("titre", "Outlook");
    map.put("description", "Client de courrier électronique");
    map.put("img", String.valueOf(R.drawable.outlook));
    listItem.add(map);
    //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue affichageitem
    SimpleAdapter myAdapter= new SimpleAdapter(this.getBaseContext(), listItem, R.layout.affichageitem,
            new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
    //On attribue à notre listView l'adapter que l'on vient de créer
    maListView.setAdapter(myAdapter);
    //Enfin on met un écouteur d'évènement sur notre listView
    maListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @SuppressWarnings("unchecked")
        public void onItemClick(AdapterView<?> a, View v, int position, long id) {
        //on récupère la HashMap contenant les infos de notre item (titre, description, img)
        HashMap<String, String> map = (HashMap<String, String>)
                maListView.getItemAtPosition(position);
        //on créé une boite de dialogue
        AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
        //on attribue un titre à notre boite de dialogue
        adb.setTitle("Sélection Item");
        //on insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
        adb.setMessage("Votre choix : "+map.get("titre"));
        //on indique que l'on veut le bouton ok à notre boite de dialogue
        adb.setPositiveButton("Ok", null);
        //on affiche la boite de dialogue
        adb.show();
    }
});
    }

}