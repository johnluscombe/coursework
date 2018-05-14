package layout;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyService extends IntentService {
    private static final String TAG = "JokeService";

    private String[] jokes = {
            "I saw an ad in a shop window that said 'Television for Sale - $1 - Volume Stuck On" +
                    " Full'. I thought: 'I can't turn that down'.",
            "My dog used to chase people on a bike a lot. It got so bad, I eventually had to" +
                    " take his bike off him.",
            "Shout out to my grandma, that's the only way she can hear.",
            "There are 10 types of people: those who understand binary, and those who don't.",
            "Today's top fact: 50% of Canada is A.",
            "I love sniffing my F1 key...don't worry though, I'm trying to get help.",
            "What do you get if you stand between two llamas? Llamanated.",
            "Feeling cold? Go stand in a corner for a bit. They are usually around 90 degrees.",
            "Bad at golf? Join the club.",
            "RIP boiled water. You will be mist."
    };

    public MyService() {
        super("MyService");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        startJokeStream();
    }

    private void startJokeStream() {
        for(String joke : jokes) {
            Log.d(TAG, joke);
            try { Thread.sleep(3000); }
            catch(InterruptedException e) { }
        }
    }
}
