package choubey.sanat.codeyourlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class subtopic extends AppCompatActivity {




    ListView listView;

    ArrayList<String> arrayList= new ArrayList<String>();
DatabaseReference myRef;

    TextView textView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);


getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView= findViewById(R.id.textView3);
        listView= findViewById(R.id.listview24);
        progressBar = findViewById(R.id.progressBar6);
    Bundle bundle = getIntent().getExtras();
   final String data = bundle.getString("Parent");




        progressBar.setVisibility(View.INVISIBLE);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList );
        listView.setAdapter(arrayAdapter);

myRef= FirebaseDatabase.getInstance().getReference(data);
myRef.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        String cols = dataSnapshot.getKey();
        arrayList.add(cols);
        arrayAdapter.notifyDataSetChanged();
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

                Intent intent =new Intent(subtopic.this,FullscreenActivity.class);
                intent.putExtra("Parent",data);
                intent.putExtra("child",value);

                startActivity(intent);


            }
        });










    }
}





