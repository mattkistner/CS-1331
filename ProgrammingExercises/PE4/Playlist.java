import java.util.Scanner;

public class Playlist {
    public static void addPlaylistInfo(Scanner scan) {
        System.out.print("Enter number of songs in playlist: ");
        int numSongs = scan.nextInt(); //Reads the users input of number of songs
        scan.nextLine(); //Ensures the second scanner occurs
        System.out.print("Enter a playlist name: ");
        String playlistName = scan.nextLine(); //Reads an entire line of a playlist name
        System.out.printf("Playlist created successfully. Here are the details:\nNumber of Songs: %d\nName: %s\n",
            numSongs, playlistName);
    }
    public static int[] genreTally(String[] genreArray, String[] genres) {
        System.out.println("The following types of genres are in your playlist:");
        int[] tally = new int[genres.length];
        for (int i = 0; i < genres.length; i++) {
            int t = 0;
            for (int i2 = 0; i2 < genreArray.length; i2++) {
                if (genreArray[i2].equals(genres[i])) {
                    ++t;
                }
            }
            System.out.println(genres[i] + " " + t);
            tally[i] = t;
        }
        return tally;
    }
    public static void playlistScores(String[] playlist1, String[] playlist2, String[] genres) {
        int[] p1GenreTally = genreTally(playlist1, genres);
        int[] p2GenreTally = genreTally(playlist2, genres);
        int p1Score = 0;
        int p2Score = 0;
        for (int i = 0; i < p1GenreTally.length; i++) {
            p1Score += i * p1GenreTally[i];
        }
        for (int j = 0; j < p2GenreTally.length; j++) {
            p2Score += j * p2GenreTally[j];
        }
        if (p1Score > p2Score) {
            System.out.print("The first playlist is likely to have mroe listeners than the second.");
        } else if (p2Score > p1Score) {
            System.out.print("The second playlist is likely to have more listeners than the first.");
        } else if (p1Score == p2Score) {
            System.out.print("The two playlists are predicted to perform equally well.");
        }
    }
    public static void main(String[] args) {
        String[] genres = {"Rap", "Pop", "Classical", "Hip Hop", "Rock", "Lo Fi"};
        String[] playlist1 = {"Pop", "Pop", "Hip Hop", "Lo Fi", "Rock", "Pop", "Classical"};
        String[] playlist2 = {"Rap", "Rock", "Rap", "Rap", "Hip Hop", "Lo Fi", "Lo Fi"};
        Scanner scan = new Scanner(System.in); // Creates a Scanner Object
        Playlist.addPlaylistInfo(scan);
        Playlist.genreTally(playlist1, genres);
        Playlist.genreTally(playlist2, genres);
        Playlist.playlistScores(playlist1, playlist2, genres);
    }
}