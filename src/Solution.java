import java.util.HashMap;

public class Solution {
	public String getHint(String secret, String guess) {
        HashMap<Character, Integer> m = new HashMap<Character,Integer>();
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < secret.length(); i++){
        	if(secret.charAt(i) == guess.charAt(i))
        		bulls++;
        	else{
        		if(!m.containsKey(secret.charAt(i)))
        			m.put(secret.charAt(i), 0);
        		if(m.get(secret.charAt(i)) < 0){
        			cows++;
        		}
        		m.replace(secret.charAt(i), m.get(secret.charAt(i)) + 1);
        		if(!m.containsKey(guess.charAt(i)))
        			m.put(guess.charAt(i), 0);
        		if(m.get(guess.charAt(i)) > 0)
        			cows++;
        		m.replace(guess.charAt(i), m.get(guess.charAt(i)) - 1);
        	}
        }
        
        return Integer.toString(bulls) + 'A' + Integer.toString(cows) + 'B';
    }
}
