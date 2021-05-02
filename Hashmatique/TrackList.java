import java.util.HashMap;
import java.util.Set;

public class TrackList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Thunderstruck", "You've been thunderstruck");
        trackList.put("Back In Black", "I'm back in black, yes, I'm back in black");
        trackList.put("Hells Bells", "You got me ringing Hell's Bells");
        trackList.put("T.N.T.", "Cause I'm T.N.T. I'm dynamite");

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println("Title: " + key);
            System.out.println("Lyrics: " + trackList.get(key));
        }
    }
}