package choubey.sanat.codeyourlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class topic extends AppCompatActivity {
ListView listView;

ArrayList<String> arrayList= new ArrayList<String>();


TextView textView;
ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

progressBar= findViewById(R.id.progressBar6);
listView = findViewById(R.id.listview24);
final ArrayAdapter<String>arrayAdapte = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
listView.setAdapter(arrayAdapte);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String cols = dataSnapshot.getKey();
                arrayList.add(cols);
                arrayAdapte.notifyDataSetChanged();
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = listView.getAdapter().getItem(i).toString();
                Intent intent =new Intent(topic.this,subtopic.class);
                intent.putExtra("Parent",value);



                startActivity(intent);


            }
        });








    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


      getMenuInflater().inflate(R.menu.main_menu,menu);
      return true;




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id== R.id.setting){
            FirebaseAuth.getInstance().signOut();
            Intent intents= new Intent(topic.this,auth.class);
            startActivity(intents);
            return  true;

        }

        if (id== R.id.bell){



            Intent intentss= new Intent(topic.this,notify.class);
            startActivity(intentss);

            return true;
        }



return true;
    }
}
