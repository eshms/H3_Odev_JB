import java.util.*;

public class Post {
    String content;
    String owner;
    HashSet<String> likes;

    public Post(String content, String owner) {
        this.content = content;
        this.owner = owner;
        this.likes = new HashSet<>();
    }

    public void like(String username) {
        likes.add(username);
    }

    public int getLikeCount() {
        return likes.size();
    }
}