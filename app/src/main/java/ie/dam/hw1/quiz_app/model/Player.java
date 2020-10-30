package ie.dam.hw1.quiz_app.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Player implements Serializable {
    private String nickname;
    private Map<Integer, Boolean> answers;

    public Player() {
    }

    public Player(String nickname) {
        this.nickname = nickname;
        this.answers = new HashMap();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickname='" + nickname + '\'' +
                ", answers=" + answers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (nickname != null ? !nickname.equals(player.nickname) : player.nickname != null)
            return false;
        return answers != null ? answers.equals(player.answers) : player.answers == null;
    }

    @Override
    public int hashCode() {
        int result = nickname != null ? nickname.hashCode() : 0;
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        return result;
    }
}
