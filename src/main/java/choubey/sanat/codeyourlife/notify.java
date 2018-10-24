package choubey.sanat.codeyourlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class notify extends AppCompatActivity {
TextView textView;

MultiAutoCompleteTextView multiAutoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_notify);
textView = findViewById(R.id.textView4);
        multiAutoCompleteTextView= findViewById(R.id.multiAutoCompleteTextView);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("HTML");

        myRef.child("not").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String not = dataSnapshot.getValue(String.class);
                multiAutoCompleteTextView.setText(not);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







    }
}
