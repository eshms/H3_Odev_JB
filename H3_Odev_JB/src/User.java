import java.util.*;

public class User {
    String username;
    String email;
    int age;
    Profile profile;
    HashSet<User> friends;
    LinkedList<Post> posts;

    public User(String username, String email, int age, String profilePic, String bio) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.profile = new Profile(profilePic, bio);
        this.friends = new HashSet<>();
        this.posts = new LinkedList<>();
    }

    public void addFriend(User user) {
        if (user != this) {
            friends.add(user);
        }
    }

    public void addPost(String content) {
        posts.add(new Post(content, this.username));
    }

    static class Profile {
        String profilePic;
        String bio;

        public Profile(String profilePic, String bio) {
            this.profilePic = profilePic;
            this.bio = bio;
        }
    }
}