package Demo.Android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {
    MQTTHelper mqttHelper;
    TextView txtTemp, txtHumi;
    private Button Login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        txtTemp = findViewById(R.id.txtTemperature);
//        txtHumi = findViewById(R.id.txtHumidity)
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        Login_button = (Button) findViewById(R.id.Button_login);


        //Login function
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Loginsuccess();
                } else {
                    Toast.makeText(MainActivity.this, "Login fail!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //startMQTT();
    }

    // Hàm chuyển trang sau khi đăng nhập thành công
    public void Loginsuccess() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

//    public void startMQTT(){
//        mqttHelper = new MQTTHelper(this    );
//        mqttHelper.setCallback(new MqttCallbackExtended() {
//            @Override
//            public void connectComplete(boolean reconnect, String serverURI) {
//
//            }
//
//            @Override
//            public void connectionLost(Throwable cause) {
//
//            }
//
//            @Override
//            public void messageArrived(String topic, MqttMessage message) throws Exception {
////                    Log.d("TEST",topic + "---" + message.toString());
////                    if(topic.contains("humi-info")){
////                        txtHumi.setText(message.toString()+"%");
////                    }
////                else if(topic.contains("temp-info")){
////                    txtTemp.setText(message.toString()+"°C");
////                }
//            }
//
//            @Override
//            public void deliveryComplete(IMqttDeliveryToken token) {
//
//            }
//        });
//    }
//}
}