//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        HashMap<String, LinkedList<Post>> postMap = new HashMap<>();
        TreeMap<Integer, String> popularityMap = new TreeMap<>(Collections.reverseOrder());

        // Kullanıcı oluştur
        User u1 = new User("yagmur", "yagmur@example.com", 20, "yagmur.jpg", "Merhaba ben yagmur");
        User u2 = new User("ayse", "ayse@example.com", 17, "ayse.png", "Sosyal medya sever");
        User u3 = new User("mehmet", "mehmet@example.com", 25, "mehmet.bmp", "Yazılımcı");

        // Kullanıcıları listeye ekle
        users.add(u1);
        users.add(u2);
        users.add(u3);

        // Arkadaş ekle
        u1.addFriend(u2);
        u1.addFriend(u3);
        u2.addFriend(u3);

        // Gönderi ekle
        u1.addPost("yaz gelsin artık");
        u2.addPost("moraller bozuk manitayla çatıştık");
        u3.addPost("babalar sözünü tutaaar");

        // Gönderileri map'e ekle
        postMap.put(u1.username, u1.posts);
        postMap.put(u2.username, u2.posts);
        postMap.put(u3.username, u3.posts);

        // Beğeni ekle
        u1.posts.get(0).like("ayse");
        u1.posts.get(0).like("mehmet");
        u2.posts.get(0).like("ali");
        u3.posts.get(0).like("ali");
        u3.posts.get(0).like("ayse");

        // Toplam beğenilere göre sıralama
        for (User u : users) {
            int totalLikes = 0;
            for (Post p : u.posts) {
                totalLikes += p.getLikeCount();
            }
            popularityMap.put(totalLikes, u.username);
        }

        // En popüler kullanıcı
        Map.Entry<Integer, String> topUser = popularityMap.firstEntry();
        System.out.println("En popüler kullanıcı: " + topUser.getValue() + " (" + topUser.getKey() + " beğeni)");

        // Iterator ile kullanıcı ve gönderilerini listele
        System.out.println("\nKullanıcılar ve Gönderiler");
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User u = userIterator.next();
            System.out.println("Kullanıcı: " + u.username);
            Iterator<Post> postIterator = u.posts.iterator();
            while (postIterator.hasNext()) {
                Post p = postIterator.next();
                System.out.println("  Gönderi: " + p.content + " (" + p.getLikeCount() + " beğeni)");
            }
        }

        // Bonus: Anonim sınıf ile 18 yaş altı kullanıcıları filtrele
        System.out.println("\n18 Yaş Altı Kullanıcılar");
        Filter ageFilter = new Filter() {
            public boolean test(User u) {
                return u.age < 18;
            }
        };
        for (User u : users) {
            if (ageFilter.test(u)) {
                System.out.println(u.username + " (" + u.age + " yaşında)");
            }
        }
    }

    interface Filter {
        boolean test(User u);
    }
}